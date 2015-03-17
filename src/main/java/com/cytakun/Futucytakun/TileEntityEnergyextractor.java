package com.cytakun.Futucytakun;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Khan Nguyen on 15.03.2015.
 */
public class TileEntityEnergyextractor extends TileEntity implements ISidedInventory{

    ItemStack Itemstack0 ;
    ItemStack Itemstack1 ;
    ItemStack Itemstack2 ;

    @Override
    public int[] getAccessibleSlotsFromSide(int Side) {
        return new int[0];
    }

    //Automatisierung
    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }
    //

    @Override
    public int getSizeInventory() {
        return 0;
}

    @Override
    public ItemStack getStackInSlot(int Slot) {
        if (Slot==0) {
            return Itemstack0;
        }
        if (Slot==1) {
            return Itemstack1;
        }
        if (Slot==2) {
            return Itemstack2;
        }
        else {
            return null;
        }
    }

    @Override
    public ItemStack decrStackSize(int Slot, int Max) {

        ItemStack newItemstack0;
        ItemStack newItemstack1;
        ItemStack newItemstack2;

        if (Slot==0) {
            newItemstack0=Itemstack0;
            Itemstack0=null;
            return newItemstack0;
        }
        if (Slot==1) {
            newItemstack1=Itemstack1;
            Itemstack1=null;
            return newItemstack1;
        }
        if (Slot==2) {
            newItemstack2=Itemstack2;
            Itemstack2=null;
            return newItemstack2;
        }
        else {
            return null;
        }

    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int Slot  , ItemStack itemstack) {

        //if (!isItemValidForSlot(Slot,itemstack)) {
        //    return;
        //}

        if (Slot==0) {
            Itemstack0=itemstack;
        }
        if (Slot==1) {
            Itemstack1=itemstack;
        }
        if (Slot==2) {
            Itemstack2=itemstack;
        }


    }

    @Override
    public String getInventoryName() {
        return "Energyextractor";

    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer Player) {
        return Player.getDistanceSq(xCoord,yCoord,zCoord)<64;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    int CK;

    @Override
    public void updateEntity() {
        if (worldObj.isRemote || worldObj.getTotalWorldTime()%20!=0) {
            return;
        }
        if (Itemstack0!=null && Itemstack0.getItem()== Items.coal) {
            CK=CK+100;
            Itemstack0.stackSize--;
            if (Itemstack0.stackSize<=0) {
                Itemstack0=null;
            }

        }
        if (Itemstack1!=null && Itemstack1.getItem()== Items.coal) {
            CK=CK+100;
            Itemstack1.stackSize--;
            if (Itemstack1.stackSize<=0) {
                Itemstack1=null;
            }
        }
        if (Itemstack2!=null && Itemstack2.getItem()== Items.coal) {
            CK=CK+100;
            Itemstack2.stackSize--;
            if (Itemstack2.stackSize<=0) {
                Itemstack2=null;
            }

        }
        System.out.println(CK);
    }

}
