package net.hackermdch.mixin;

import com.google.common.collect.ImmutableSet;
import net.hackermdch.CustomUtils;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.neoforge.common.extensions.IItemStackExtension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements DataComponentHolder, IItemStackExtension, MutableDataComponentHolder {
    @Unique
    private static Set<Item> items;

    @Inject(method = "inventoryTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;inventoryTick(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/Entity;IZ)V"))
    private void inventoryTick(Level level, Entity entity, int inventorySlot, boolean isCurrentItem, CallbackInfo ci) {
        if (items == null)
            items = CustomUtils.enableInventoryAttribute.stream().map(s -> BuiltInRegistries.ITEM.getHolder(ResourceLocation.parse(s)).orElseThrow().value()).collect(ImmutableSet.toImmutableSet());
        if (items.contains(getItem()) && entity instanceof Player player) {
            getAttributeModifiers().modifiers().forEach(m -> {
                if (m.slot() == EquipmentSlotGroup.ANY) {
                    var attr = player.getAttributes();
                    if (!attr.hasModifier(m.attribute(), m.modifier().id())) {
                        var ins = attr.getInstance(m.attribute());
                        assert ins != null;
                        ins.addTransientModifier(m.modifier());
                    }
                }
            });
        }
    }

    @Shadow
    public abstract Item getItem();
}
