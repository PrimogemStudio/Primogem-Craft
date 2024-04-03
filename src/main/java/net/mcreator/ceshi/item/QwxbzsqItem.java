
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwxbzsqItem extends Item {
	public QwxbzsqItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u6740\u6B7B\u4EA1\u7075\u751F\u7269\u6216\u8282\u80A2\u52A8\u7269\u67091%\u6982\u7387\u4E3A\u4E3B"));
		list.add(Component.literal("\u00A77\u624B\u7269\u54C1\u6DFB\u52A0\u4E00\u4E2A\u4F4E\u7EA7\u968F\u673A\u9644\u9B54"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A78\u5355\u4E00\u88C5\u5907\u91CD\u590D\u89E6\u53D1\u6982\u7387\u5C06\u9010\u6E10\u9012\u51CF"));
		list.add(Component.literal("\u00A78\u51CF\u503C\u4E3A\u5F53\u524D\u6982\u7387\u768410%"));
	}
}
