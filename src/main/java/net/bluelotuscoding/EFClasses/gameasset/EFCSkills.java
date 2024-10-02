package net.bluelotuscoding.EFClasses.gameasset;

import net.bluelotuscoding.EFClasses.main.EpicFightClassesMod;
import net.bluelotuscoding.EFClasses.skill.weaponinnate.mage.HinotamaBurstSpell;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.damagesource.*;

import java.util.Set;


@Mod.EventBusSubscriber(modid = EpicFightClassesMod.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)
public class EFCSkills {
    // public static Skill ;

    // Guard --------------------------------------------------------
    // public static Skill BARRIER;
    // public static Skill AURA_BARRIER;

    // Weapon Skill ----------------------------------Caused by: java.lang.NullPointerException: Cannot invoke "yesman.epicfight.skill.weaponinnate.WeaponInnateSkill.newProperty()" because "hinotamaSpell" is null----------------------
    public static Skill HINOTAMA_BURST;

    //public static Skill STAND_BASIC_COMBO_ATTACK;


    // Weapon Passive --------------------------------------------------------
    // public static Skill EGO_WEAPON;


    // Passive --------------------------------------------------------

    public static void registerSkills() {
        // DODGES --------------------------------------------------------



        // WEAPON PASSIVE --------------------------------------------------------



        // WEAPON SKILL --------------------------------------------------------



        //  GUARD --------------------------------------------------------



    }

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent build) {
        SkillBuildEvent.ModRegistryWorker modRegistry = build.createRegistryWorker(EpicFightClassesMod.MOD_ID);
        // DODGES -------------------------------------------------------------------


        // PASSIVES ------------------------------------------------------------------


        //Weapon Innate Skills --------------------------------------------------------
        //Mage Basic Fire Burst Skill
        WeaponInnateSkill hinotamaBurst =  modRegistry.build("hinotama_burst", HinotamaBurstSpell::new, WeaponInnateSkill.createWeaponInnateBuilder());
        hinotamaBurst.newProperty()
                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(3))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(25.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageType.WEAPON_INNATE));
        HINOTAMA_BURST = hinotamaBurst;


        /*WeaponInnateSkill hinotamaBurst = modRegistry.build("hinotama_burst", HinotamaBurstSpell::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(() -> {
            return (AttackAnimation) EFCAnimations.HINOTAMA_BURST;
        }));
        hinotamaBurst.newProperty().addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.5F))
                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(20.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0])))
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageType.WEAPON_INNATE));
        HINOTAMA_BURST = hinotamaBurst;*/

    }

}

