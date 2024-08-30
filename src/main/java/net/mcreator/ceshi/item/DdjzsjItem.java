
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.DjjsxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;

public class DdjzsjItem extends SwordItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 1561;
		}

		@Override
		public float getSpeed() {
			return 8f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 15;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(PrimogemcraftModItems.DIJINGSUIXIE.get()), new ItemStack(Items.DIAMOND));
		}
	};

	public DdjzsjItem() {
		super(TOOL_TIER, new Item.Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 4f, -2.8f)).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		DjjsxProcedure.execute(entity, sourceentity, itemstack);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7d\u653B\u51FB\u76EE\u6807\u65F6\uFF1A"));
		list.add(Component.literal("\u00A77 - \u670910%\u6982\u7387\u5BF9\u81EA\u8EAB\u65BD\u52A0\u4E00\u4E2A\u6CE1\u6CE1\u589E\u76CA"));
		list.add(Component.literal("\u00A77 - \u6301\u7EED10\u79D2"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A72\u589E\u76CA\u671F\u95F4\uFF1A"));
		list.add(Component.literal("\u00A77 - \u6BCF2\u79D2\u6062\u590D\u81EA\u8EAB(2+5%\u6700\u5927\u751F\u547D\u503C)\u7684\u751F\u547D\u503C"));
		list.add(Component.literal("\u00A72\u7ED3\u675F\u65F6\uFF1A"));
		list.add(Component.literal("\u00A77 \u5BF9\u534A\u5F84\u4E3A4\u7684\u751F\u7269"));
		list.add(Component.literal("\u00A77 - \u9020\u6210\u81EA\u8EAB\u6700\u5927\u751F\u547D\u503C40%\u771F\u5B9E\u4F24\u5BB3"));
		list.add(Component.literal("\u00A77 - \u5BF9\u961F\u53CB\u751F\u7269\u8FDB\u884C\u81EA\u8EAB\u6700\u5927\u751F\u547D\u503C40%\u751F\u547D\u503C\u6062\u590D"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A7d\u4F7F\u7528\u6469\u62C9\u00A76[SHIFT+\u53F3\u952E]\u00A7d\u751F\u7269\u53EF\u6DFB\u52A0\u6216\u5220\u9664\u961F\u53CB"));
	}
}
