
package net.mcreator.ceshi.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SyzfMobEffect extends MobEffect {
	public SyzfMobEffect() {
		super(MobEffectCategory.NEUTRAL, -3368449);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
