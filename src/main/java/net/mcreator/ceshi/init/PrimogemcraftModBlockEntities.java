
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.ceshi.block.entity.XjhpyhfhBlockEntity;
import net.mcreator.ceshi.block.entity.Moladui02BlockEntity;
import net.mcreator.ceshi.block.entity.MmolazhilajitongBlockEntity;
import net.mcreator.ceshi.block.entity.Mlxdml03BlockEntity;
import net.mcreator.ceshi.block.entity.Mlxdml02BlockEntity;
import net.mcreator.ceshi.block.entity.Mlxdml01BlockEntity;
import net.mcreator.ceshi.block.entity.LajitongBlockEntity;
import net.mcreator.ceshi.block.entity.GanjinglajitongxiangziBlockEntity;
import net.mcreator.ceshi.block.entity.DangaoliyueBlockEntity;
import net.mcreator.ceshi.block.entity.ChuangzaoxiaodengfasheqiBlockEntity;
import net.mcreator.ceshi.block.entity.CeshixiaodengfasheqiBlockEntity;
import net.mcreator.ceshi.block.entity.BwdxjhpyhfhBlockEntity;
import net.mcreator.ceshi.PrimogemcraftMod;

public class PrimogemcraftModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PrimogemcraftMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> MOLADUI_02 = register("moladui_02", PrimogemcraftModBlocks.MOLADUI_02, Moladui02BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CESHIXIAODENGFASHEQI = register("ceshixiaodengfasheqi", PrimogemcraftModBlocks.CESHIXIAODENGFASHEQI, CeshixiaodengfasheqiBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHUANGZAOXIAODENGFASHEQI = register("chuangzaoxiaodengfasheqi", PrimogemcraftModBlocks.CHUANGZAOXIAODENGFASHEQI, ChuangzaoxiaodengfasheqiBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LAJITONG = register("lajitong", PrimogemcraftModBlocks.LAJITONG, LajitongBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GANJINGLAJITONGXIANGZI = register("ganjinglajitongxiangzi", PrimogemcraftModBlocks.GANJINGLAJITONGXIANGZI, GanjinglajitongxiangziBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MMOLAZHILAJITONG = register("mmolazhilajitong", PrimogemcraftModBlocks.MMOLAZHILAJITONG, MmolazhilajitongBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MLXDML_01 = register("mlxdml_01", PrimogemcraftModBlocks.MLXDML_01, Mlxdml01BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MLXDML_02 = register("mlxdml_02", PrimogemcraftModBlocks.MLXDML_02, Mlxdml02BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MLXDML_03 = register("mlxdml_03", PrimogemcraftModBlocks.MLXDML_03, Mlxdml03BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DANGAOLIYUE = register("dangaoliyue", PrimogemcraftModBlocks.DANGAOLIYUE, DangaoliyueBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> XJHPYHFH = register("xjhpyhfh", PrimogemcraftModBlocks.XJHPYHFH, XjhpyhfhBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BWDXJHPYHFH = register("bwdxjhpyhfh", PrimogemcraftModBlocks.BWDXJHPYHFH, BwdxjhpyhfhBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
