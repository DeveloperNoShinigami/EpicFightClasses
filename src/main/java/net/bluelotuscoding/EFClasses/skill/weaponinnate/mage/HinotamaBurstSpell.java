package net.bluelotuscoding.EFClasses.skill.weaponinnate.mage;


import net.bluelotuscoding.EFClasses.gameasset.EFCAnimations;
import net.minecraft.network.FriendlyByteBuf;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
import java.util.UUID;

public class HinotamaBurstSpell extends WeaponInnateSkill {
    private static final UUID EVENT_UUID = UUID.fromString("33348129-d6d4-4b24-972d-9d9df582259d");

    public HinotamaBurstSpell(Builder<? extends Skill> builder) {
        super(builder);
    }

    public void onInitiate(SkillContainer container) {
        if (!container.getExecuter().isLogicalClient()) {
            this.setConsumption(container, 6.0F);
            this.setConsumptionSynchronize((ServerPlayerPatch)container.getExecuter(), 6.0F);
        }

        container.setResource(6.0F);
    }
    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);
        container.getExecuter().getEventListener().removeListener(PlayerEventListener.EventType.DEALT_DAMAGE_EVENT_HURT, EVENT_UUID);
    }

    public void executeOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {
        executer.playAnimationSynchronized(EFCAnimations.HINOTAMA_BURST, 0.0F);
        super.executeOnServer(executer, args);
    }

    @Override
    public boolean canExecute(PlayerPatch<?> executer) {
        return true;
    }

     public WeaponInnateSkill registerPropertiesToAnimation() {
        return this;
    }

    public void updateContainer(SkillContainer container) {
        if (!container.getExecuter().isLogicalClient()) {
            this.setConsumption(container, 6.0F);
            this.setConsumptionSynchronize((ServerPlayerPatch)container.getExecuter(), 6.0F);
        }

        container.setResource(6.0F);
        container.deactivate();
    }
    /*@Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);

        container.getExecuter().getEventListener().addEventListener(PlayerEventListener.EventType.DEALT_DAMAGE_EVENT_HURT, EVENT_UUID, (event) -> {
            if (event.getDamageSource().getAnimation() == EFCAnimations.HINOTAMA_BURST) {
                ValueModifier damageModifier = ValueModifier.empty();
                this.getProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, this.properties.get(0)).ifPresent(damageModifier::merge);
                damageModifier.merge(ValueModifier.multiplier(0.8F));
                float health = event.getTarget().getHealth();
                float executionHealth = damageModifier.getTotalValue((float)event.getPlayerPatch().getOriginal().getAttributeValue(Attributes.ATTACK_DAMAGE));

                if (health < executionHealth) {
                    if (event.getDamageSource() != null) {
                        event.getDamageSource().addRuntimeTag(EpicFightDamageType.EXECUTION);
                    }
                }
            }
        });
    }

    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);

        container.getExecuter().getEventListener().removeListener(PlayerEventListener.EventType.DEALT_DAMAGE_EVENT_HURT, EVENT_UUID);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public List<Component> getTooltipOnItem(ItemStack itemstack, CapabilityItem cap, PlayerPatch<?> playerpatch) {
        List<Component> list = Lists.newArrayList();
        List<Object> tooltipArgs = Lists.newArrayList();
        String traslatableText = this.getTranslationKey();
        double damage = playerpatch.getOriginal().getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() + EnchantmentHelper.getDamageBonus(itemstack, MobType.UNDEFINED);
        ValueModifier damageModifier = ValueModifier.empty();

        Set<AttributeModifier> damageModifiers = Sets.newHashSet();
        damageModifiers.addAll(playerpatch.getOriginal().getAttribute(Attributes.ATTACK_DAMAGE).getModifiers());
        damageModifiers.addAll(CapabilityItem.getAttributeModifiers(Attributes.ATTACK_DAMAGE, EquipmentSlot.MAINHAND, itemstack, playerpatch));

        for (AttributeModifier modifier : damageModifiers) {
            damage += modifier.getAmount();
        }

        this.getProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, this.properties.get(0)).ifPresent(damageModifier::merge);
        damageModifier.merge(ValueModifier.multiplier(0.8F));
        tooltipArgs.add(ChatFormatting.RED + ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(damageModifier.getTotalValue((float)damage)));

        list.add(Component.translatable(traslatableText).withStyle(ChatFormatting.WHITE).append(Component.literal(String.format("[%.0f]", this.consumption)).withStyle(ChatFormatting.AQUA)));
        list.add(Component.translatable(traslatableText + ".tooltip", tooltipArgs.toArray(new Object[0])).withStyle(ChatFormatting.DARK_GRAY));

        this.generateTooltipforPhase(list, itemstack, cap, playerpatch, this.properties.get(0), "Each Strike:");

        return list;
    }*/


}




