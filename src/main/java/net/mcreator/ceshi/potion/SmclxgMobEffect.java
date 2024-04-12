
package net.mcreator.ceshi.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SmclxgMobEffect extends MobEffect {
	public SmclxgMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
