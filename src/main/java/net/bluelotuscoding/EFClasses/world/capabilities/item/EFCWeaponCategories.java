package net.bluelotuscoding.EFClasses.world.capabilities.item;

import yesman.epicfight.world.capabilities.item.WeaponCategory;

public enum EFCWeaponCategories implements WeaponCategory {
    OATH_TAKER;

    final int id;

    EFCWeaponCategories() {
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
    }

    @Override
    public int universalOrdinal() {
        return this.id;
    }
}