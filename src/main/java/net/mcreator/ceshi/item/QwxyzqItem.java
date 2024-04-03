
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwxyzqItem extends Item {
	public QwxyzqItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u5728\u9ED1\u5854\u5546\u5E97\u4E2D\u4F7F\u7528\u5B87\u5B99\u788E\u7247\u65F6"));
		list.add(Component.literal("\u00A77\u51CF\u5C1120%\u5B87\u5B99\u788E\u7247\u6D88\u8017"));
	}
}
