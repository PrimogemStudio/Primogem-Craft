package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GogongsiguguzhongshuxingProcedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getItem().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		if (itemstack.getItem() == PrimogemcraftModItems.GONGSIDEGUGUZHONG.get()) {
			if (itemstack.getDamageValue() == 0 && (entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 1) {
				a = Mth.nextDouble(RandomSource.create(), 0.025, 0.75);
				b = DiaoyongjisuanjingyanzhiProcedure.execute(entity) * a;
				if (entity instanceof Player _player)
					_player.giveExperiencePoints(-((int) b));
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A75\u7CFB\u7EDF\uFF1A\u00A78\u4F60\u88AB\u00A75\u300E\u5947\u7269\u300F\u00A79\u516C\u53F8\u5495\u5495\u949F\u00A78\u538B\u69A8\u4E86\u00A7e\u7EA6"
							+ new java.text.DecimalFormat("##.##").format(Math.round(b)) + "\u00A78\u7ECF\u9A8C\u503C\uFF01\u00A77\uFF08\u7EA6" + new java.text.DecimalFormat("##.##").format(Math.round(a * 1000) * 0.1) + "%\uFF09")), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 4, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 4, (float) 0.5, false);
					}
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(2232, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		}
	}
}
