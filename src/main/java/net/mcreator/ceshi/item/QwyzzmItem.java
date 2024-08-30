
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.YzzmsxProcedure;

import java.util.List;

public class QwyzzmItem extends Item {
	public QwyzzmItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u53F3\u952E\u4F7F\u7528\u540E\u5BF9\u526F\u624B\u5DF2\u9644\u9B54\u7269\u54C1\u9020\u6210\u4E0B\u5217"));
		list.add(Component.literal("\u00A77\u6548\u679C\u5176\u4E2D\u4E00\u79CD\uFF1A"));
		list.add(Component.literal("\u00A7c \u2022 \u6C38\u4E0D\u6CAE\u4E27"));
		list.add(Component.literal("\u00A78 \u8FDB\u884C\u4E00\u6B2130\u7ECF\u9A8C\u7B49\u7EA7\u7684\u9644\u9B54\u6DFB\u52A0"));
		list.add(Component.literal("\u00A7c \u2022 \u6C38\u4E0D\u6B3A\u9A97"));
		list.add(Component.literal("\u00A78 \u590D\u5236\u51FA\u76F8\u540C\u9644\u9B54\u7684\u4E00\u672C\u201C\u9644\u9B54\u4E66\u201D"));
		list.add(Component.literal("\u00A7c \u2022 \u6C38\u4E0D\u629B\u5F03"));
		list.add(Component.literal("\u00A78 \u6DFB\u52A0\u4E00\u7EA7 \u611A\u8005\u4E4B\u6012 \u7684\u9644\u9B54\u8BC5\u5492"));
		list.add(Component.literal("\u00A7c \u2022 \u6C38\u4E0D\u4F24\u5BB3"));
		list.add(Component.literal("\u00A78 \u9020\u6210\u4E00\u6B21\u6700\u5927\u8010\u4E45\u5EA6 -1 \u7684\u635F\u574F"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		YzzmsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
