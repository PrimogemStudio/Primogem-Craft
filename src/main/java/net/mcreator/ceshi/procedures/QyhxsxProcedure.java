package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QyhxsxProcedure {
	public static String execute(ItemStack itemstack) {
		itemstack.setDamageValue((int) (itemstack.getMaxDamage() - (itemstack.getOrCreateTag().getDouble("qyhx_cishu") + 1)));
		return itemstack.getItem() == PrimogemcraftModItems.QYHX.get()
				? "\u00A75\u53F3\u952E\u79FB\u9664\u00A7b1\u00A75\u526F\u624B\u7269\u54C1\u6362\u53D6\u7948\u613F\u503C\uFF0C\u00A76\u5DE6\u952E\u00A75\u67E5\u770B\u526F\u624B\u7269\u54C1\u63D0\u4F9B\u7684\u7948\u613F\u503C\uFF0C\u00A76\u6F5C\u884C+\u53F3\u952E\u00A75\u63D0\u4EA4\u81F3\u6700\u5927\u503C \u00A7\u00A7"
						+ "\u00A77\u5F53\u524D\u7948\u613F\u503C:\u00A7b" + new java.text.DecimalFormat("").format(itemstack.getOrCreateTag().getDouble("Prayers_strengthen")) + "\u00A78\u51FA\u7D2B\u6982\u7387\u589E\u52A0:\u00A7d"
						+ itemstack.getOrCreateTag().getDouble("Prayers_strengthen") / 5 + "%" + "\u00A78\u51FA\u91D1\u6982\u7387\u589E\u52A0:\u00A76" + itemstack.getOrCreateTag().getDouble("Prayers_strengthen") / 10 + "%"
				: "\u00A75\u53F3\u952E\u79FB\u9664\u00A7b1\u00A75\u526F\u624B\u7269\u54C1\u6362\u53D6\u7948\u613F\u503C\uFF0C\u00A76\u5DE6\u952E\u00A75\u67E5\u770B\u526F\u624B\u7269\u54C1\u63D0\u4F9B\u7684\u7948\u613F\u503C\uFF0C\u00A76\u6F5C\u884C+\u53F3\u952E\u00A75\u63D0\u4EA4\u81F3\u6700\u5927\u503C \u00A7\u00A7"
						+ "\u00A77\u5F53\u524D\u7948\u613F\u503C:\u00A7b" + new java.text.DecimalFormat("").format(itemstack.getOrCreateTag().getDouble("Prayers_strengthen")) + "\u00A78\u51FA\u7D2B\u6982\u7387\u6BCF\u4E2A\u589E\u52A0:\u00A7d"
						+ (itemstack.getOrCreateTag().getDouble("Prayers_strengthen") / 5) / 10 + "%" + "\u00A78\u51FA\u91D1\u6982\u7387\u6BCF\u4E2A\u589E\u52A0:\u00A76" + (itemstack.getOrCreateTag().getDouble("Prayers_strengthen") / 10) / 10 + "%";
	}
}
