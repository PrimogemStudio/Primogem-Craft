
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QiwuchongwangItem extends Item {
	public QiwuchongwangItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7e\u00A7l\u653B\u51FB\u751F\u7269\u65F6\uFF0C\u83B7\u5F97\u00A7d\u00A7l\u5BC4\u751F\u00A7r\u00A7e\u00A7l\u72B6\u6001"));
		list.add(Component.literal("\u00A75\u5904\u4E8E\u00A7d\u00A7l\u5BC4\u751F\u00A7r\u00A75\u72B6\u6001\u65F6:"));
		list.add(Component.literal("\u00A76 \u00A7l\u57FA\u7840\u653B\u51FB\u529B\u989D\u5916\u589E\u52A050%"));
		list.add(Component.literal("\u00A76 \u00A7l\u6740\u6B7B\u751F\u7269\u540E\u5BF9\u81EA\u8EAB\u9020\u6210\u4E00\u6B21\u5F53"));
		list.add(Component.literal("\u00A76 \u00A7l\u524D\u751F\u547D\u503C20%\u7684\u771F\u5B9E\u4F24\u5BB3"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A79\u5BF9\u4E8E[\u5BC4\u751F]\u6548\u679C\u6BCF\u7EA7\uFF1A"));
		list.add(Component.literal("\u00A79 +50%\u989D\u5916\u57FA\u7840\u653B\u51FB\u529B"));
		list.add(Component.literal("\u00A7c -20%\u5F53\u524D\u751F\u547D\u503C"));
		list.add(Component.literal("\u00A78\u6301\u6709\u5BC4\u751F\u6548\u679C\u6B7B\u4EA1\u540E\u4E3A\u9644\u8FD1\u6CA1"));
		list.add(Component.literal("\u00A78\u6709\u5BC4\u751F\u6548\u679C\u7684\u73A9\u5BB6\u8D4B\u4E88\u00A79\u5BC4\u751F"));
	}
}
