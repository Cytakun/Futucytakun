package com.cytakun.Futucytakun.TileEntity;


import com.cytakun.Futucytakun.Futucytakun;
import com.cytakun.Futucytakun.Items.PortableEnergyContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Khan Nguyen on 20.03.2015.
 */
public class TileEntityEnergystorer extends TileEntity implements ISidedInventory{

    ItemStack Itemstack0 ;
    ItemStack Itemstack1 ;

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeCustomToNBT(nbt);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbt);
    }

    private void writeCustomToNBT(NBTTagCompound nbt) {
        nbt.setInteger("CK", this.CK);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readCustomFromNBT(pkt.func_148857_g());
        worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
    }

    private void readCustomFromNBT(NBTTagCompound nbt) {
        this.CK = nbt.getInteger("CK");
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

    @Override
    public void updateEntity() {
        worldObj.markBlockForUpdate(xCoord,yCoord,zCoord);
        if (Itemstack0!=null && Itemstack0.getItem()== Futucytakun.PortableEnergyContainer) {
            if (this.CK>=0) {
                int x=PortableEnergyContainer.UpdateCK(Itemstack0);
                if (x<=24990) {
                    PortableEnergyContainer.setCK(Itemstack0, x + 10);
                    CK = CK - 10;
                }
            }
        }
        if (Itemstack1!=null && Itemstack1.getItem()== Futucytakun.PortableEnergyContainer) {
            if (this.CK<50000) {
                int y=PortableEnergyContainer.UpdateCK(Itemstack1);
                if (y>0) {
                    PortableEnergyContainer.setCK(Itemstack1, y-10);
                    CK=CK + 10;
                }
            }
        }
    }

    public int CK;

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack itemStack, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack itemStack, int p_102008_3_) {
        return false;
    }

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
        return null;
    }

    @Override
    public ItemStack decrStackSize(int Slot, int Max) {
        ItemStack newItemstack0;
        ItemStack newItemstack1;

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
        else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int Slot, ItemStack itemstack) {
        if (Slot==0) {
            Itemstack0=itemstack;
        }
        if (Slot==1) {
            Itemstack1=itemstack;
        }
    }

    @Override
    public String getInventoryName() {
        return "Energystorer";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return false;
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


}
