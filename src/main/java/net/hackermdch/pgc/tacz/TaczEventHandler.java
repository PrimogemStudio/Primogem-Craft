package net.hackermdch.pgc.tacz;

import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.hackermdch.pgc.GenshinCraftAPI;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import static com.tacz.guns.api.event.common.GunDamageSourcePart.ARMOR_PIERCING;
import static com.tacz.guns.api.event.common.GunDamageSourcePart.NON_ARMOR_PIERCING;
import static net.hackermdch.pgc.CustomAPI.GenshinCraftLoaded;
import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber(modid = MODID)
public class TaczEventHandler {
    private static final ResourceLocation id = ResourceLocation.fromNamespaceAndPath("pgfs", "tiankong");

    @SubscribeEvent
    private static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        if (event.getLogicalSide().isServer() && event.getGunId().equals(id)) {
            var level = event.getBullet().level();
            var type = level.random.nextInt(1, 8);
            var ds1 = toElement(event.getDamageSource(ARMOR_PIERCING), type, true, true);
            var ds2 = toElement(event.getDamageSource(NON_ARMOR_PIERCING), type, false, false);
            event.setDamageSource(ARMOR_PIERCING, ds1);
            event.setDamageSource(NON_ARMOR_PIERCING, ds2);
            if (!(event.getHurtEntity() instanceof LivingEntity entity)) return;
            switch (type) {
                case 1:
                    entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 40, 0, false, false));
                    break;
                case 3:
                    var lb = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
                    lb.moveTo(entity.position());
                    lb.setVisualOnly(true);
                    level.addFreshEntity(lb);
                    break;
                case 4:
                    entity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 0, false, false));
                    break;
                case 6:
                    entity.igniteForSeconds(3);
                    break;
                case 7:
                    entity.setTicksFrozen(60);
                    break;
            }
        }
    }

    private static DamageSource toElement(DamageSource original, int type, boolean apply, boolean critical) {
        return GenshinCraftLoaded ? GenshinCraftAPI.toElement(original, type, 1, apply, critical, false, false) : original;
    }
}
