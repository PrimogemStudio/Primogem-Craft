
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.ceshi.world.features.Zhzhongguanzi01FeatureFeature;
import net.mcreator.ceshi.world.features.YuanshikuangshiFeatureFeature;
import net.mcreator.ceshi.world.features.Xxiaoguanzi02FeatureFeature;
import net.mcreator.ceshi.world.features.Xxiaoguanzi01FeatureFeature;
import net.mcreator.ceshi.world.features.ShenbanyanyuanshikuangshiFeatureFeature;
import net.mcreator.ceshi.world.features.Molayiji01FeatureFeature;
import net.mcreator.ceshi.world.features.Disuikuai1FeatureFeature;
import net.mcreator.ceshi.world.features.Dibiaomola01FeatureFeature;
import net.mcreator.ceshi.world.features.Ddaguanzi01FeatureFeature;
import net.mcreator.ceshi.PrimogemcraftMod;

@Mod.EventBusSubscriber
public class PrimogemcraftModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, PrimogemcraftMod.MODID);
	public static final RegistryObject<Feature<?>> YUANSHIKUANGSHI_FEATURE = REGISTRY.register("yuanshikuangshi_feature", YuanshikuangshiFeatureFeature::new);
	public static final RegistryObject<Feature<?>> MOLAYIJI_01_FEATURE = REGISTRY.register("molayiji_01_feature", Molayiji01FeatureFeature::new);
	public static final RegistryObject<Feature<?>> DIBIAOMOLA_01_FEATURE = REGISTRY.register("dibiaomola_01_feature", Dibiaomola01FeatureFeature::new);
	public static final RegistryObject<Feature<?>> XXIAOGUANZI_01_FEATURE = REGISTRY.register("xxiaoguanzi_01_feature", Xxiaoguanzi01FeatureFeature::new);
	public static final RegistryObject<Feature<?>> XXIAOGUANZI_02_FEATURE = REGISTRY.register("xxiaoguanzi_02_feature", Xxiaoguanzi02FeatureFeature::new);
	public static final RegistryObject<Feature<?>> ZHZHONGGUANZI_01_FEATURE = REGISTRY.register("zhzhongguanzi_01_feature", Zhzhongguanzi01FeatureFeature::new);
	public static final RegistryObject<Feature<?>> DDAGUANZI_01_FEATURE = REGISTRY.register("ddaguanzi_01_feature", Ddaguanzi01FeatureFeature::new);
	public static final RegistryObject<Feature<?>> DISUIKUAI_1_FEATURE = REGISTRY.register("disuikuai_1_feature", Disuikuai1FeatureFeature::new);
	public static final RegistryObject<Feature<?>> SHENBANYANYUANSHIKUANGSHI_FEATURE = REGISTRY.register("shenbanyanyuanshikuangshi_feature", ShenbanyanyuanshikuangshiFeatureFeature::new);
}
