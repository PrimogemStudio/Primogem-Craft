package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DadaletoushibiezhuangtaiProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.YIYINHEDALETOU.get()) {
				if (entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
						&& _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:lletouderenke"))).isDone()) {
					if (Math.random() < 0.8) {
						if (Math.random() < 0.006 && !(entity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel
								&& _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:nibaodimeila"))).isDone())) {
							if (entity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:nibaodimeila"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
								_setstack.setCount(64);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PrimogemcraftModEntities.QQIWUZHANLIPINSHITI.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7a\u83B7\u5F97\u968F\u673A\u5947\u7269\uFF01"), false);
							} else {
								if (Math.random() < 0.5) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1,
													1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
									if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.FEIQIUPINGZHENG.get())) : false) || entity instanceof ServerPlayer _plr21
											&& _plr21.level() instanceof ServerLevel && _plr21.getAdvancements().getOrStartProgress(_plr21.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:lletouderenke"))).isDone()) {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
															.withSuppressedOutput(),
													"loot spawn ~ ~ ~ loot primogemcraft:feiqiutongdao");
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7b\u7A33\u8D5A\u4E0D\u8D54"), false);
									} else {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
															.withSuppressedOutput(),
													"loot spawn ~ ~ ~ loot primogemcraft:blocks/yinhedaletouzhanlipinbiao");
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7b\u5C0F\u8D5A\u4E00\u7B14"), false);
									}
								} else {
									if (Math.random() < 0.01 && !(entity instanceof ServerPlayer _plr32 && _plr32.level() instanceof ServerLevel
											&& _plr32.getAdvancements().getOrStartProgress(_plr32.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:zhongjifeiqiu"))).isDone())) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(PrimogemcraftModItems.FEIQIUPINGZHENG.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									} else {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 7, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 7, 1, false);
											}
										}
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth(1);
										if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.FEIQIUPINGZHENG.get())) : false) {
											if (entity instanceof Player _player)
												_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) * 0.5));
										} else {
											if (entity instanceof Player _player)
												_player.getFoodData().setFoodLevel(1);
										}
										if (entity instanceof Player _player)
											_player.getFoodData().setSaturation(0);
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 127));
										{
											ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
											if (_ist.hurt((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getMaxDamage(), RandomSource.create(), null)) {
												_ist.shrink(1);
												_ist.setDamageValue(0);
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(PrimogemcraftModItems.SHQWYHDLT.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7b\u300E\u5947\u7269\u300F\u94F6\u6CB3\u5927\u4E50\u900F\u00A74\u5DF2\u635F\u574F\uFF01"), true);
										{
											double _setval = (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).daletou_jishu + 1;
											entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.daletou_jishu = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (!(entity instanceof ServerPlayer _plr48 && _plr48.level() instanceof ServerLevel
												&& _plr48.getAdvancements().getOrStartProgress(_plr48.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:lletouderenke"))).isDone())
												&& (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).daletou_jishu >= 100) {
											if (entity instanceof ServerPlayer _player) {
												Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:lletouderenke"));
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7e\u5C0F\u8D4C\u6021\u60C5\uFF0C\u5927\u8D4C\u4F24\u8EAB\uFF01"), false);
										}
									}
								}
							}
						}
					}
				} else {
					if (Math.random() < 0.4) {
						if (Math.random() < 0.006 && !(entity instanceof ServerPlayer _plr51 && _plr51.level() instanceof ServerLevel
								&& _plr51.getAdvancements().getOrStartProgress(_plr51.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:nibaodimeila"))).isDone())) {
							if (entity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:nibaodimeila"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
								_setstack.setCount(64);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PrimogemcraftModEntities.QQIWUZHANLIPINSHITI.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7a\u83B7\u5F97\u968F\u673A\u5947\u7269\uFF01"), false);
							} else {
								if (Math.random() < 0.4) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1,
													1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
									if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.FEIQIUPINGZHENG.get())) : false) || entity instanceof ServerPlayer _plr68
											&& _plr68.level() instanceof ServerLevel && _plr68.getAdvancements().getOrStartProgress(_plr68.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:lletouderenke"))).isDone()) {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
															.withSuppressedOutput(),
													"loot spawn ~ ~ ~ loot primogemcraft:feiqiutongdao");
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7b\u7A33\u8D5A\u4E0D\u8D54"), false);
									} else {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
															.withSuppressedOutput(),
													"loot spawn ~ ~ ~ loot primogemcraft:blocks/yinhedaletouzhanlipinbiao");
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7b\u5C0F\u8D5A\u4E00\u7B14"), false);
									}
								} else {
									if (Math.random() < 0.01 && !(entity instanceof ServerPlayer _plr79 && _plr79.level() instanceof ServerLevel
											&& _plr79.getAdvancements().getOrStartProgress(_plr79.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:zhongjifeiqiu"))).isDone())) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(PrimogemcraftModItems.FEIQIUPINGZHENG.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									} else {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 7, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 7, 1, false);
											}
										}
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth(1);
										if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.FEIQIUPINGZHENG.get())) : false) {
											if (entity instanceof Player _player)
												_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) * 0.5));
										} else {
											if (entity instanceof Player _player)
												_player.getFoodData().setFoodLevel(1);
										}
										if (entity instanceof Player _player)
											_player.getFoodData().setSaturation(0);
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 127));
										{
											ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
											if (_ist.hurt((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getMaxDamage(), RandomSource.create(), null)) {
												_ist.shrink(1);
												_ist.setDamageValue(0);
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(PrimogemcraftModItems.SHQWYHDLT.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7b\u300E\u5947\u7269\u300F\u94F6\u6CB3\u5927\u4E50\u900F\u00A74\u5DF2\u635F\u574F\uFF01"), true);
										{
											double _setval = (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).daletou_jishu + 1;
											entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.daletou_jishu = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (!(entity instanceof ServerPlayer _plr95 && _plr95.level() instanceof ServerLevel
												&& _plr95.getAdvancements().getOrStartProgress(_plr95.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:lletouderenke"))).isDone())
												&& (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).daletou_jishu >= 100) {
											if (entity instanceof ServerPlayer _player) {
												Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("primogemcraft:lletouderenke"));
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u00A7e\u5C0F\u8D4C\u6021\u60C5\uFF0C\u5927\u8D4C\u4F24\u8EAB\uFF01"), false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
