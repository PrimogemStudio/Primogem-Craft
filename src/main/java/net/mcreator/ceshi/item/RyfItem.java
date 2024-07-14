
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.RyfsxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;

public class RyfItem extends AxeItem {
	public RyfItem() {
		super(new Tier() {
			public int getUses() {
				return 1561;
			}

			public float getSpeed() {
				return 10f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 15;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PrimogemcraftModItems.YUANSHI.get()), new ItemStack(PrimogemcraftModItems.RANYUANSUIXIE.get()));
			}
		}, 1, -3f, new Item.Properties().fireResistant());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		RyfsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A7d\u624B\u6301\u53F3\u952E\u65F6\uFF1A"));
		list.add(Component.literal("\u00A77 - \u83B7\u5F97\u4E00\u4E2A\u77ED\u6682\u6062\u590D\u6548\u679C"));
		list.add(Component.literal("\u00A77 \u6548\u679C\u671F\u95F4\uFF0C\u6BCF\u53D7\u5230\u71C3\u70E7\u4F24\u5BB3\u6062\u590D2\u70B9\u751F\u547D\u503C"));
		list.add(Component.literal("\u00A77 \u53D7\u5230\u7194\u5CA9\u4F24\u5BB3\u6062\u590D\u6700\u5927\u751F\u547D\u503C15%\u751F\u547D\u503C"));
		list.add(Component.literal("\u00A77 - \u5904\u4E8E\u9632\u706B\u72B6\u6001\u65F6\uFF0C\u7ACB\u523B\u63D0\u4F9B\u751F\u547D\u6062\u590D"));
	}
}
