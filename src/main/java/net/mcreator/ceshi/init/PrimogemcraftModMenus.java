
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.ceshi.world.inventory.ZhangquanzhezhinangguiMenu;
import net.mcreator.ceshi.world.inventory.YinhangMenu;
import net.mcreator.ceshi.world.inventory.YibangrenzhinangguiMenu;
import net.mcreator.ceshi.world.inventory.TaozhuangchakanMenu;
import net.mcreator.ceshi.world.inventory.SuijiqiwuMenu;
import net.mcreator.ceshi.world.inventory.MolalajitongMenu;
import net.mcreator.ceshi.world.inventory.MaoxianjiazhinangguiMenu;
import net.mcreator.ceshi.world.inventory.LiulangzhezhinangguiMenu;
import net.mcreator.ceshi.world.inventory.HeitayindaoyongguiMenu;
import net.mcreator.ceshi.world.inventory.GuiheitaxinyindaoMenu;
import net.mcreator.ceshi.world.inventory.GanjinglajitongMenu;
import net.mcreator.ceshi.world.inventory.GUIqiwuxuanzeMenu;
import net.mcreator.ceshi.world.inventory.GUImoladuiMenu;
import net.mcreator.ceshi.world.inventory.CunzheshezhiMenu;
import net.mcreator.ceshi.world.inventory.CeshishijianxuanzejiemianMenu;
import net.mcreator.ceshi.world.inventory.CeshiguiMenu;
import net.mcreator.ceshi.world.inventory.CeshifumoguiMenu;
import net.mcreator.ceshi.world.inventory.BwdyinhangMenu;
import net.mcreator.ceshi.PrimogemcraftMod;

public class PrimogemcraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PrimogemcraftMod.MODID);
	public static final RegistryObject<MenuType<CeshiguiMenu>> CESHIGUI = REGISTRY.register("ceshigui", () -> IForgeMenuType.create(CeshiguiMenu::new));
	public static final RegistryObject<MenuType<GanjinglajitongMenu>> GANJINGLAJITONG = REGISTRY.register("ganjinglajitong", () -> IForgeMenuType.create(GanjinglajitongMenu::new));
	public static final RegistryObject<MenuType<MolalajitongMenu>> MOLALAJITONG = REGISTRY.register("molalajitong", () -> IForgeMenuType.create(MolalajitongMenu::new));
	public static final RegistryObject<MenuType<LiulangzhezhinangguiMenu>> LIULANGZHEZHINANGGUI = REGISTRY.register("liulangzhezhinanggui", () -> IForgeMenuType.create(LiulangzhezhinangguiMenu::new));
	public static final RegistryObject<MenuType<MaoxianjiazhinangguiMenu>> MAOXIANJIAZHINANGGUI = REGISTRY.register("maoxianjiazhinanggui", () -> IForgeMenuType.create(MaoxianjiazhinangguiMenu::new));
	public static final RegistryObject<MenuType<ZhangquanzhezhinangguiMenu>> ZHANGQUANZHEZHINANGGUI = REGISTRY.register("zhangquanzhezhinanggui", () -> IForgeMenuType.create(ZhangquanzhezhinangguiMenu::new));
	public static final RegistryObject<MenuType<YibangrenzhinangguiMenu>> YIBANGRENZHINANGGUI = REGISTRY.register("yibangrenzhinanggui", () -> IForgeMenuType.create(YibangrenzhinangguiMenu::new));
	public static final RegistryObject<MenuType<CeshishijianxuanzejiemianMenu>> CESHISHIJIANXUANZEJIEMIAN = REGISTRY.register("ceshishijianxuanzejiemian", () -> IForgeMenuType.create(CeshishijianxuanzejiemianMenu::new));
	public static final RegistryObject<MenuType<SuijiqiwuMenu>> SUIJIQIWU = REGISTRY.register("suijiqiwu", () -> IForgeMenuType.create(SuijiqiwuMenu::new));
	public static final RegistryObject<MenuType<CeshifumoguiMenu>> CESHIFUMOGUI = REGISTRY.register("ceshifumogui", () -> IForgeMenuType.create(CeshifumoguiMenu::new));
	public static final RegistryObject<MenuType<HeitayindaoyongguiMenu>> HEITAYINDAOYONGGUI = REGISTRY.register("heitayindaoyonggui", () -> IForgeMenuType.create(HeitayindaoyongguiMenu::new));
	public static final RegistryObject<MenuType<GUImoladuiMenu>> GU_IMOLADUI = REGISTRY.register("gu_imoladui", () -> IForgeMenuType.create(GUImoladuiMenu::new));
	public static final RegistryObject<MenuType<YinhangMenu>> YINHANG = REGISTRY.register("yinhang", () -> IForgeMenuType.create(YinhangMenu::new));
	public static final RegistryObject<MenuType<BwdyinhangMenu>> BWDYINHANG = REGISTRY.register("bwdyinhang", () -> IForgeMenuType.create(BwdyinhangMenu::new));
	public static final RegistryObject<MenuType<CunzheshezhiMenu>> CUNZHESHEZHI = REGISTRY.register("cunzheshezhi", () -> IForgeMenuType.create(CunzheshezhiMenu::new));
	public static final RegistryObject<MenuType<TaozhuangchakanMenu>> TAOZHUANGCHAKAN = REGISTRY.register("taozhuangchakan", () -> IForgeMenuType.create(TaozhuangchakanMenu::new));
	public static final RegistryObject<MenuType<GUIqiwuxuanzeMenu>> GU_IQIWUXUANZE = REGISTRY.register("gu_iqiwuxuanze", () -> IForgeMenuType.create(GUIqiwuxuanzeMenu::new));
	public static final RegistryObject<MenuType<GuiheitaxinyindaoMenu>> GUIHEITAXINYINDAO = REGISTRY.register("guiheitaxinyindao", () -> IForgeMenuType.create(GuiheitaxinyindaoMenu::new));
}
