
package net.mcreator.ceshi.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CangsangshizhuanweiqiangBlock extends WallBlock {
	public CangsangshizhuanweiqiangBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(2f, 15f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false)
				.dynamicShape().forceSolidOn());
	}
}
