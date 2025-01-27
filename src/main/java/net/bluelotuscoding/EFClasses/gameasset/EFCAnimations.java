package net.bluelotuscoding.EFClasses.gameasset;


import net.bluelotuscoding.EFClasses.main.EpicFightClassesMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;

@Mod.EventBusSubscriber(modid = EpicFightClassesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EFCAnimations {

    //Mage Moveset
    public static StaticAnimation MAGE_IDLE;
    public static StaticAnimation MAGE_BASIC_ATTACK_01;
    public static StaticAnimation MAGE_BASIC_ATTACK_02;
    public  static StaticAnimation MAGE_BASIC_ATTACK_03;

    //Mage Innate/Spells
    public static StaticAnimation HINOTAMA_BURST;

    //Warrior Moveset
    //public static StaticAnimation WARRIOR_IDLE;
    //public static StaticAnimation WARRIOR_BASIC_ATTACK_01;

    //Cleric Moveset
    public static StaticAnimation CLERIC_IDLE;
    public static StaticAnimation CLERIC_BASIC_ATTACK_01;
    public static StaticAnimation CLERIC_BASIC_ATTACK_02;
    public static StaticAnimation CLERIC_BASIC_ATTACK_03;

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put("epicfightclasses", EFCAnimations::build);
    }

    private static void build() {
        HumanoidArmature biped = Armatures.BIPED;
        // IDLEs
        MAGE_IDLE = new StaticAnimation (0.2F,true, "biped/living/mage_idle", biped);

        CLERIC_IDLE = new StaticAnimation (0.2F,true, "biped/living/cleric_idle", biped);

        // Basic Attacks for MAGE
        MAGE_BASIC_ATTACK_01 = new BasicAttackAnimation(0.0F, 0.0F, 0.4F, 0.4F, null,biped.toolR,"biped/combat/mage/oath_taker_basic_attack_01", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F);

        MAGE_BASIC_ATTACK_02 = new BasicAttackAnimation(0.1F, 0.5F, 0.15F, 0.4F, null,biped.toolR, "biped/combat/mage/oath_taker_basic_attack_02", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F);

        MAGE_BASIC_ATTACK_03 = new BasicAttackAnimation(0.2F, 0.10F, 0.15F, 0.F, null,biped.toolR, "biped/combat/mage/oath_taker_basic_attack_03", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F);

        // MAGE Burst Skill
        HINOTAMA_BURST = new BasicAttackAnimation(0.2F, 0.10F, 0.15F, 0.F, null,biped.toolR, "biped/skill/mage/hinotama_burst", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F);

        //Warrior Moveset
//        WARRIOR_BASIC_ATTACK_01 = new BasicAttackAnimation(0.0F, 0.0F, 0.4F, 0.4F, null,biped.toolR,"biped/combat/warrior/warrior_basic_attack_01", biped)
//                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F);

        //Cleric Moveset
        CLERIC_BASIC_ATTACK_01 = new BasicAttackAnimation(0.1F, 0.0F, 0.5F, 0.4F, null,biped.toolR,"biped/combat/cleric/cleric_basic_attack_01", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.4F);

        CLERIC_BASIC_ATTACK_02 = new BasicAttackAnimation(0.2F, 0.5F, 0.15F, 0.4F, null,biped.toolR, "biped/combat/cleric/cleric_basic_attack_02", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F);

        CLERIC_BASIC_ATTACK_03 = new BasicAttackAnimation(0.3F, 0.10F, 0.15F, 0.F, null,biped.toolR, "biped/combat/cleric/cleric_basic_attack_03", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.0F);


    }


}
