package net.bluelotuscoding.EFClasses.world.capabilities.item;

import net.bluelotuscoding.EFClasses.gameasset.EFCAnimations;
import net.bluelotuscoding.EFClasses.gameasset.EFCColliders;
import net.bluelotuscoding.EFClasses.gameasset.EFCSkills;
import net.bluelotuscoding.EFClasses.main.EpicFightClassesMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = EpicFightClassesMod.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)
public class EFCWeaponCapabilityPresets {

    //Preset Below for Mage
    public static final Function<Item, CapabilityItem.Builder> OATH_TAKER = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder()
                .category(EFCWeaponCategories.OATH_TAKER)
                .hitSound(EpicFightSounds.BLADE_HIT.get())
                .collider(EFCColliders.OATH_TAKER)
                .newStyleCombo(CapabilityItem.Styles.ONE_HAND, EFCAnimations.OATH_TAKER_BASIC_ATTACK_01, EFCAnimations.OATH_TAKER_BASIC_ATTACK_02, EFCAnimations.OATH_TAKER_BASIC_ATTACK_03, Animations.SWORD_DASH, Animations.SWORD_AIR_SLASH)
                .newStyleCombo(CapabilityItem.Styles.MOUNT, Animations.SWORD_MOUNT_ATTACK)
                .innateSkill(CapabilityItem.Styles.ONE_HAND, (itemstack) -> EFCSkills.HINOTAMA_BURST)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.IDLE, EFCAnimations.MAGE_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.WALK, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.CHASE, Animations.VINDICATOR_CHASE)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.RUN, Animations.BIPED_RUN)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.BLOCK, Animations.SPEAR_GUARD);
        return builder;
    };

    /*public static final Function<Item, CapabilityItem.Builder> OATH_TAKER = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder().category(EFCWeaponCategories.OATH_TAKER).styleProvider((playerpatch) -> {
            return CapabilityItem.Styles.ONE_HAND;
        })
        .collider(EFCColliders.OATH_TAKER).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get())
        .comboCancel((style) -> {
            return false;
                })
        .newStyleCombo(CapabilityItem.Styles.ONE_HAND, new StaticAnimation[]{EFCAnimations.OATH_TAKER_BASIC_ATTACK_01, EFCAnimations.OATH_TAKER_BASIC_ATTACK_02, EFCAnimations.OATH_TAKER_BASIC_ATTACK_03, Animations.SWORD_DASH, Animations.SWORD_AIR_SLASH})
        .innateSkill(CapabilityItem.Styles.ONE_HAND, (itemStack) -> {
        return EFCSkills.HINOTAMA_BURST;
    })
    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.IDLE, EFCAnimations.MAGE_IDLE)
    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.WALK, Animations.BIPED_HOLD_SPEAR)
    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.CHASE, Animations.VINDICATOR_CHASE)
    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.RUN, Animations.BIPED_RUN)
    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_SPEAR)
    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.BLOCK, Animations.SPEAR_GUARD);
        return builder;
    }; */


    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.tryParse("oath_taker"), OATH_TAKER);
    }
}
