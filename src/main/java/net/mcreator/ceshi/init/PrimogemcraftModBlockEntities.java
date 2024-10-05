
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.ceshi.block.entity.XjhpyhfhBlockEntity;
import net.mcreator.ceshi.block.entity.ShenmiwanouBlockEntity;
import net.mcreator.ceshi.block.entity.Moladui02BlockEntity;
import net.mcreator.ceshi.block.entity.MmolazhilajitongBlockEntity;
import net.mcreator.ceshi.block.entity.Mlxdml03BlockEntity;
import net.mcreator.ceshi.block.entity.Mlxdml02BlockEntity;
import net.mcreator.ceshi.block.entity.Mlxdml01BlockEntity;
import net.mcreator.ceshi.block.entity.LajitongBlockEntity;
import net.mcreator.ceshi.block.entity.HhzdbooBlockEntity;
import net.mcreator.ceshi.block.entity.Hhzd1BlockEntity;
import net.mcreator.ceshi.block.entity.Hhzd0BlockEntity;
import net.mcreator.ceshi.block.entity.GanjinglajitongxiangziBlockEntity;
import net.mcreator.ceshi.block.entity.DangaoliyueBlockEntity;
import net.mcreator.ceshi.block.entity.ChuangzaoxiaodengfasheqiBlockEntity;
import net.mcreator.ceshi.block.entity.CeshixiaodengfasheqiBlockEntity;
import net.mcreator.ceshi.block.entity.BwdxjhpyhfhBlockEntity;
import net.mcreator.ceshi.PrimogemcraftMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PrimogemcraftModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PrimogemcraftMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MOLADUI_02 = register("moladui_02", PrimogemcraftModBlocks.MOLADUI_02, Moladui02BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> LAJITONG = register("lajitong", PrimogemcraftModBlocks.LAJITONG, LajitongBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> GANJINGLAJITONGXIANGZI = register("ganjinglajitongxiangzi", PrimogemcraftModBlocks.GANJINGLAJITONGXIANGZI, GanjinglajitongxiangziBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MMOLAZHILAJITONG = register("mmolazhilajitong", PrimogemcraftModBlocks.MMOLAZHILAJITONG, MmolazhilajitongBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CESHIXIAODENGFASHEQI = register("ceshixiaodengfasheqi", PrimogemcraftModBlocks.CESHIXIAODENGFASHEQI, CeshixiaodengfasheqiBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CHUANGZAOXIAODENGFASHEQI = register("chuangzaoxiaodengfasheqi", PrimogemcraftModBlocks.CHUANGZAOXIAODENGFASHEQI, ChuangzaoxiaodengfasheqiBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MLXDML_01 = register("mlxdml_01", PrimogemcraftModBlocks.MLXDML_01, Mlxdml01BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MLXDML_02 = register("mlxdml_02", PrimogemcraftModBlocks.MLXDML_02, Mlxdml02BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MLXDML_03 = register("mlxdml_03", PrimogemcraftModBlocks.MLXDML_03, Mlxdml03BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DANGAOLIYUE = register("dangaoliyue", PrimogemcraftModBlocks.DANGAOLIYUE, DangaoliyueBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> XJHPYHFH = register("xjhpyhfh", PrimogemcraftModBlocks.XJHPYHFH, XjhpyhfhBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BWDXJHPYHFH = register("bwdxjhpyhfh", PrimogemcraftModBlocks.BWDXJHPYHFH, BwdxjhpyhfhBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> HHZD_0 = register("hhzd_0", PrimogemcraftModBlocks.HHZD_0, Hhzd0BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> HHZD_1 = register("hhzd_1", PrimogemcraftModBlocks.HHZD_1, Hhzd1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SHENMIWANOU = register("shenmiwanou", PrimogemcraftModBlocks.SHENMIWANOU, ShenmiwanouBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> HHZDBOO = register("hhzdboo", PrimogemcraftModBlocks.HHZDBOO, HhzdbooBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MOLADUI_02.get(), (blockEntity, side) -> ((Moladui02BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LAJITONG.get(), (blockEntity, side) -> ((LajitongBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GANJINGLAJITONGXIANGZI.get(), (blockEntity, side) -> ((GanjinglajitongxiangziBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MMOLAZHILAJITONG.get(), (blockEntity, side) -> ((MmolazhilajitongBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CESHIXIAODENGFASHEQI.get(), (blockEntity, side) -> ((CeshixiaodengfasheqiBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHUANGZAOXIAODENGFASHEQI.get(), (blockEntity, side) -> ((ChuangzaoxiaodengfasheqiBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MLXDML_01.get(), (blockEntity, side) -> ((Mlxdml01BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MLXDML_02.get(), (blockEntity, side) -> ((Mlxdml02BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MLXDML_03.get(), (blockEntity, side) -> ((Mlxdml03BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DANGAOLIYUE.get(), (blockEntity, side) -> ((DangaoliyueBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, XJHPYHFH.get(), (blockEntity, side) -> ((XjhpyhfhBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BWDXJHPYHFH.get(), (blockEntity, side) -> ((BwdxjhpyhfhBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HHZD_0.get(), (blockEntity, side) -> ((Hhzd0BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HHZD_1.get(), (blockEntity, side) -> ((Hhzd1BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SHENMIWANOU.get(), (blockEntity, side) -> ((ShenmiwanouBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HHZDBOO.get(), (blockEntity, side) -> ((HhzdbooBlockEntity) blockEntity).getItemHandler());
	}
}
