package com.cytakun.Futucytakun;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Khan Nguyen on 15.03.2015.
 */
public class ContainerEnergyextractor extends Container{
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public ContainerEnergyextractor(InventoryPlayer player, TileEntity entity){
        this.entity = entity;

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(player, i, 7 + i * 18, 60 + 58));
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(player, 9 + j + i *  9, 7 + j *  18, 60 + i * 18));
            }
        }
    }
    TileEntity entity;
}

