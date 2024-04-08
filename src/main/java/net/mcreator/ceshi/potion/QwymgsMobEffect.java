
package net.mcreator.ceshi.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class QwymgsMobEffect extends MobEffect {
	public QwymgsMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -154);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
