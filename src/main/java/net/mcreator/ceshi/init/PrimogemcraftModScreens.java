
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.ceshi.client.gui.ZhangquanzhezhinangguiScreen;
import net.mcreator.ceshi.client.gui.YinhangScreen;
import net.mcreator.ceshi.client.gui.YibangrenzhinangguiScreen;
import net.mcreator.ceshi.client.gui.TaozhuangchakanScreen;
import net.mcreator.ceshi.client.gui.SuijiqiwuScreen;
import net.mcreator.ceshi.client.gui.MolalajitongScreen;
import net.mcreator.ceshi.client.gui.MaoxianjiazhinangguiScreen;
import net.mcreator.ceshi.client.gui.LiulangzhezhinangguiScreen;
import net.mcreator.ceshi.client.gui.HeitayindaoyongguiScreen;
import net.mcreator.ceshi.client.gui.GuiheitaxinyindaoScreen;
import net.mcreator.ceshi.client.gui.GanjinglajitongScreen;
import net.mcreator.ceshi.client.gui.GUIqiwuxuanzeScreen;
import net.mcreator.ceshi.client.gui.GUImoladuiScreen;
import net.mcreator.ceshi.client.gui.CunzheshezhiScreen;
import net.mcreator.ceshi.client.gui.CeshishijianxuanzejiemianScreen;
import net.mcreator.ceshi.client.gui.CeshiguiScreen;
import net.mcreator.ceshi.client.gui.CeshifumoguiScreen;
import net.mcreator.ceshi.client.gui.BwdyinhangScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PrimogemcraftModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(PrimogemcraftModMenus.CESHIGUI.get(), CeshiguiScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.GANJINGLAJITONG.get(), GanjinglajitongScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.MOLALAJITONG.get(), MolalajitongScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.LIULANGZHEZHINANGGUI.get(), LiulangzhezhinangguiScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.MAOXIANJIAZHINANGGUI.get(), MaoxianjiazhinangguiScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.ZHANGQUANZHEZHINANGGUI.get(), ZhangquanzhezhinangguiScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.YIBANGRENZHINANGGUI.get(), YibangrenzhinangguiScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.CESHISHIJIANXUANZEJIEMIAN.get(), CeshishijianxuanzejiemianScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.SUIJIQIWU.get(), SuijiqiwuScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.CESHIFUMOGUI.get(), CeshifumoguiScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.HEITAYINDAOYONGGUI.get(), HeitayindaoyongguiScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.GU_IMOLADUI.get(), GUImoladuiScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.YINHANG.get(), YinhangScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.BWDYINHANG.get(), BwdyinhangScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.CUNZHESHEZHI.get(), CunzheshezhiScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.TAOZHUANGCHAKAN.get(), TaozhuangchakanScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.GU_IQIWUXUANZE.get(), GUIqiwuxuanzeScreen::new);
			MenuScreens.register(PrimogemcraftModMenus.GUIHEITAXINYINDAO.get(), GuiheitaxinyindaoScreen::new);
		});
	}
}
