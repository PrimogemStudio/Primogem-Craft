
package net.mcreator.ceshi.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class CangsangshizhuanloutiBlock extends StairBlock {
	public CangsangshizhuanloutiBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(2f, 15f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 15f;
	}
}
