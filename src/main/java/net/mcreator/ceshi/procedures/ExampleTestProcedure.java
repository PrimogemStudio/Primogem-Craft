package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class ExampleTestProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		entity.hurt(ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.ARROW), entity), 1, 1), 1);
		entity.hurt(ElementDamageSetApplyProcedure.execute(ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.ARROW), entity), 1, 2), false), 2);
		entity.hurt(ElementDamageSetCriticalProcedure.execute(ElementDamageSetKnockbackProcedure.execute(ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.ARROW), entity), 1, 3), false), false), 3);
		entity.hurt(FullToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.ARROW), entity), false, true, true, false, 1, 4), 4);
	}
}
