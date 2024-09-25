package net.bluelotuscoding.EFClasses.skill;

import net.bluelotuscoding.EFClasses.gameasset.EFCAnimations;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
    private static final UUID EVENT_UUID = UUID.fromString("3461f6fb-ac1d-4d0d-950e-b4cde8a96a25");

    public HinotamaBurstSpell(Skill.Builder<?> builder){
        super(builder);
    }

    public void onInitiate(SkillContainer container) {
        if (!container.getExecuter().isLogicalClient()) {
            this.setConsumption(container, 10.0F);
            this.setConsumptionSynchronize((ServerPlayerPatch)container.getExecuter(), 10.0F);
        }

        container.setResource(10.0F);
    }

    public void executeOnServer(ServerPlayerPatch playerPatch, FriendlyByteBuf args) {
        playerPatch.playAnimationSynchronized(EFCAnimations.HINOTAMA_BURST, 0.0F);
        super.executeOnServer(playerPatch, args);
    }

    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);

        container.getExecuter().getEventListener().removeListener(PlayerEventListener.EventType.DEALT_DAMAGE_EVENT_DAMAGE, EVENT_UUID);

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map)this.properties.get(0), "Each Strike:");
        return list;
    }


    public WeaponInnateSkill registerPropertiesToAnimation() {
        return this;
    }

    public void updateContainer(SkillContainer container) {
        if (!container.getExecuter().isLogicalClient()) {
            this.setConsumption(container, 10.0F);
            this.setConsumptionSynchronize((ServerPlayerPatch)container.getExecuter(), 10.0F);
        }

        container.setResource(10.0F);
        container.deactivate();
    }
}
