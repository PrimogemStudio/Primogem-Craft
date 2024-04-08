
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class JlbjItem extends Item {
	public JlbjItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u6740\u6B7B\u4EA1\u7075\u751F\u7269\u6216\u8282\u80A2\u751F\u7269\u540E\uFF0C\u5C06\u6709"));
		list.add(Component.literal("\u00A77\u5C0F\u6982\u7387\u6389\u843D\u5B87\u5B99\u788E\u7247"));
	}
}
