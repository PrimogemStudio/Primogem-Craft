package net.hackermdch;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.mcreator.ceshi.GlobalAttributeModifier;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;

import java.util.Set;
import java.util.function.BiConsumer;

public final class CustomUtils {
    public static final Set<String> enableInventoryAttribute = new ObjectArraySet<>();

    public static void enableForInventory(String item) {
        enableInventoryAttribute.add(item);
    }

    public static class CuriosCompat {
        public static void onCurioAttributeModifier(CurioAttributeModifierEvent event) {
            GlobalAttributeModifier.handle(new AttributeModifierEventWrapper(event::addModifier, event.getItemStack()));
        }
    }

    public static class AttributeModifierEventWrapper {
        public interface Handler {
            void handle(Holder<Attribute> attribute, AttributeModifier modifier, EquipmentSlotGroup slot);
        }

        private final Handler handler;
        private final BiConsumer<Holder<Attribute>, AttributeModifier> consumer;
        public final ItemStack item;

        public AttributeModifierEventWrapper(Handler handler, ItemStack itemstack) {
            this.handler = handler;
            consumer = null;
            item = itemstack;
        }

        public AttributeModifierEventWrapper(BiConsumer<Holder<Attribute>, AttributeModifier> consumer, ItemStack itemstack) {
            this.consumer = consumer;
            handler = null;
            item = itemstack;
        }

        public void set(Holder<Attribute> attribute, AttributeModifier modifier, EquipmentSlotGroup slot) {
            if (handler != null) handler.handle(attribute, modifier, slot);
        }

        public void set(Holder<Attribute> attribute, AttributeModifier modifier) {
            if (consumer != null) consumer.accept(attribute, modifier);
        }
    }
}
