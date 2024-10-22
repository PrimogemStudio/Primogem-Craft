package net.hackermdch.mixin;

import com.google.common.collect.ImmutableSet;
import com.llamalad7.mixinextras.sugar.Local;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.hackermdch.CustomUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(Inventory.class)
public abstract class InventoryMixin implements Container, Nameable {
    @Shadow
    @Final
    public Player player;
    @Unique
    private static Set<Item> items;
    @Unique
    private final Set<ItemStack> set = new ObjectArraySet<>(), set1 = new ObjectArraySet<>();

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;inventoryTick(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/Entity;IZ)V"))
    private void inventoryTick(CallbackInfo ci, @Local(ordinal = 1) int i, @Local NonNullList<ItemStack> stacks) {
        if (items == null)
            items = CustomUtils.enableInventoryAttribute.stream().map(s -> BuiltInRegistries.ITEM.getHolder(ResourceLocation.parse(s)).orElseThrow().value()).collect(ImmutableSet.toImmutableSet());
        var item = stacks.get(i);
        if (items.contains(item.getItem())) {
            var flag = false;
            for (var m : item.getAttributeModifiers().modifiers()) {
                if (m.slot() == EquipmentSlotGroup.ANY) {
                    var attr = player.getAttributes();
                    if (!attr.hasModifier(m.attribute(), m.modifier().id())) {
                        var ins = attr.getInstance(m.attribute());
                        assert ins != null;
                        ins.addTransientModifier(m.modifier());
                        flag = true;
                    }
                }
            }
            var copy = item.copy();
            if (flag) set.add(copy);
            set1.add(copy);
        }
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void tick(CallbackInfo ci) {
        var remove = new ObjectArraySet<ItemStack>();
        for (var item : set) {
            var flag = false;
            for (var item1 : set1) {
                if (ItemStack.isSameItemSameComponents(item, item1)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                item.getAttributeModifiers().modifiers().forEach(m -> {
                    if (m.slot() == EquipmentSlotGroup.ANY) {
                        var attr = player.getAttributes();
                        if (attr.hasModifier(m.attribute(), m.modifier().id())) {
                            var ins = attr.getInstance(m.attribute());
                            assert ins != null;
                            ins.removeModifier(m.modifier());
                        }
                    }
                });
                remove.add(item);
            }
        }
        set.removeAll(remove);
        set1.clear();
    }
}
