
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QiwuheisenlinggzItem extends Item {
	public QiwuheisenlinggzItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A7d\u6548\u679C\u671F\u95F4\uFF1A"));
		list.add(Component.literal("\u00A7f\u3013\u00A77\u4F60\u5C06\u6210\u4E3A\u6240\u6709\u5B9E\u4F53\u7684\u653B\u51FB\u76EE\u6807\uFF0C\u4F46\u53CB\u597D\u751F\u4E0D\u4F1A"));
		list.add(Component.literal("\u00A78\u3013\u00A77\u653B\u51FB\u4F60\uFF0C\u5373\u4F7F\u5B83\u4ECD\u7136\u89C6\u4F60\u4E3A\u653B\u51FB\u76EE\u6807"));
		list.add(Component.literal("\u00A7f\u3013\u00A77\u653B\u51FB\u89C6\u4F60\u4E3A\u653B\u51FB\u76EE\u6807\u4E14\u6700\u5927\u751F\u547D\u5C0F\u6216\u7B49\u4E8E\u81EA\u8EAB"));
		list.add(Component.literal("\u00A78\u3013\u00A77\u6700\u5927\u751F\u547D\u503C\u7684\u5B9E\u4F53\u65F6\u5C06\u670910%\u6982\u7387\u751F\u6210\u4E09\u53EA\u4E0D"));
		list.add(Component.literal("\u00A78\u3013\u00A77\u540C\u7684\u4EA1\u7075\u751F\u7269"));
	}
}
