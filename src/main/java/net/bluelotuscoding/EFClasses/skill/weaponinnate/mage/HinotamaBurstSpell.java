package net.bluelotuscoding.EFClasses.skill.weaponinnate.mage;

import net.bluelotuscoding.EFClasses.gameasset.EFCAnimations;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HinotamaBurstSpell extends WeaponInnateSkill {
    private static final UUID EVENT_UUID = UUID.fromString("33348129-d6d4-4b24-972d-9d9df582259d");

    public HinotamaBurstSpell(Skill.Builder<?> builder) {
        super(builder);
    }

    public void onInitiate(SkillContainer container) {
        if (!container.getExecuter().isLogicalClient()) {
            this.setConsumption(container, 6.0F);
            this.setConsumptionSynchronize((ServerPlayerPatch)container.getExecuter(), 6.0F);
        }

        container.setResource(6.0F);
    }

    public void executeOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {

            executer.playAnimationSynchronized(EFCAnimations.HINOTAMA_BURST, 0.0F);
            super.executeOnServer(executer, args);
    }

    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map)this.properties.get(0), "Each Strike:");
        return list;
    }

    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);

        container.getExecuter().getEventListener().removeListener(PlayerEventListener.EventType.DEALT_DAMAGE_EVENT_HURT, EVENT_UUID);
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


}




