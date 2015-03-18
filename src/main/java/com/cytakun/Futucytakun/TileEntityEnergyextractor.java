package com.cytakun.Futucytakun;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

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

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeCustomToNBT(nbt);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbt);
    }

    private void writeCustomToNBT(NBTTagCompound nbt) {
        nbt.setInteger("CK", this.CK);

        if (Itemstack0 !=null) {
            NBTTagCompound NBTTC0= new NBTTagCompound();
            Itemstack0.writeToNBT(NBTTC0);
            nbt.setTag("NBTTC0",NBTTC0);
        }

        if (Itemstack1 !=null) {
            NBTTagCompound NBTTC1= new NBTTagCompound();
            Itemstack1.writeToNBT(NBTTC1);
            nbt.setTag("NBTTC1",NBTTC1);
        }

        if (Itemstack2 !=null) {
            NBTTagCompound NBTTC2= new NBTTagCompound();
            Itemstack2.writeToNBT(NBTTC2);
            nbt.setTag("NBTTC2",NBTTC2);
        }
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readCustomFromNBT(pkt.func_148857_g());
        worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
    }

    private void readCustomFromNBT(NBTTagCompound nbt) {
        this.CK=nbt.getInteger("CK");
        if (nbt.hasKey("NBTTC0")) {
            NBTTagCompound NBTTC =nbt.getCompoundTag("NBTTCO");
            this.Itemstack0 = ItemStack.loadItemStackFromNBT(NBTTC);
        }
        if (nbt.hasKey("NBTTC1")) {
            NBTTagCompound NBTTC =nbt.getCompoundTag("NBTTC1");
            this.Itemstack1 = ItemStack.loadItemStackFromNBT(NBTTC);
        }
        if (nbt.hasKey("NBTTC2")) {
            NBTTagCompound NBTTC =nbt.getCompoundTag("NBTTC2");
            this.Itemstack2 = ItemStack.loadItemStackFromNBT(NBTTC);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        writeCustomToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        readCustomFromNBT(nbt);
    }

    int CK;

    @Override
    public void updateEntity() {

        if (worldObj.isRemote || worldObj.getTotalWorldTime()%20!=0) {
            return;
        }

        worldObj.markBlockForUpdate(xCoord ,yCoord, zCoord);

        if (CK<10000) {

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
        }

        if (CK>10000) {
            CK=10000;
        }
        System.out.println(CK);
    }

}

