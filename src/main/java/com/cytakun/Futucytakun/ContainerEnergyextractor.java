package com.cytakun.Futucytakun;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
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

        addSlotToContainer(new Slot((IInventory)entity, 0, 26, 22));
        addSlotToContainer(new Slot((IInventory)entity, 1, 50, 22));
        addSlotToContainer(new Slot((IInventory)entity, 2, 73, 22));


        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(player, i, 8 + i * 18, 61 + 58));
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(player, 9 + j + i *  9, 8 + j *  18, 61 + i * 18));
            }
        }
    }
    TileEntity entity;

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int p_82846_2_) {
        return null;
    }
}

