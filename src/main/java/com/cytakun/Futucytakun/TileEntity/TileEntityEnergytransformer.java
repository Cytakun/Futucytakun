package com.cytakun.Futucytakun.TileEntity;

import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.lang.reflect.Field;

/**
 * Created by Khan Nguyen on 28.03.2015.
 */
public class TileEntityEnergytransformer extends TileEntity implements ISidedInventory,IEnergyHandler {

    public int CK;


    @Override
    public void updateEntity() {

        if (worldObj.getTileEntity(xCoord+1,yCoord,zCoord) instanceof TileEntityEnergystorer) {
            TileEntityEnergystorer Energystorer = (TileEntityEnergystorer) worldObj.getTileEntity(xCoord+1,yCoord,zCoord);

            if (Energystorer.CK>0) {
                if (this.CK<10000) {
                    this.CK = this.CK + 50;
                    Energystorer.CK = Energystorer.CK - 50;
                    for(int i=0;i<6;i++) {
                        TileEntity TE = worldObj.getTileEntity(xCoord + ForgeDirection.values()[i].offsetX,
                                yCoord + ForgeDirection.values()[i].offsetY,
                                zCoord + ForgeDirection.values()[i].offsetZ);
                        if (TE instanceof IEnergyReceiver) {
                            ((IEnergyReceiver)TE).receiveEnergy(ForgeDirection.values()[i].getOpposite(),250,false);
                            this.CK = this.CK - 250;
                        }
                    }
                }
            }

            /*if (this.CK>0) {
                if (Energystorer.CK <= 50000) {
                    Energystorer.CK = Energystorer.CK - 500;
                    if (Energystorer.CK<50000) {
                        this.CK = this.CK + 500;
                    }
                }
                if (Energystorer.CK > 50000) {
                    Energystorer.CK = 50000;
                }
            }*/
        }
        if (worldObj.getTileEntity(xCoord,yCoord+1,zCoord) instanceof TileEntityEnergystorer) {
            TileEntityEnergystorer Energystorer = (TileEntityEnergystorer) worldObj.getTileEntity(xCoord,yCoord+1,zCoord);

            if (Energystorer.CK>0) {
                if (this.CK<10000) {
                    this.CK = this.CK + 50;
                    Energystorer.CK = Energystorer.CK - 50;
                    for(int i=0;i<6;i++) {
                        TileEntity TE = worldObj.getTileEntity(xCoord + ForgeDirection.values()[i].offsetX,
                                yCoord + ForgeDirection.values()[i].offsetY,
                                zCoord + ForgeDirection.values()[i].offsetZ);
                        if (TE instanceof IEnergyReceiver) {
                            ((IEnergyReceiver)TE).receiveEnergy(ForgeDirection.values()[i].getOpposite(),250,false);
                            this.CK = this.CK - 250;
                        }
                    }
                }
            }
        }
        if (worldObj.getTileEntity(xCoord,yCoord,zCoord+1) instanceof TileEntityEnergystorer) {
            TileEntityEnergystorer Energystorer = (TileEntityEnergystorer) worldObj.getTileEntity(xCoord,yCoord,zCoord+1);

            if (Energystorer.CK>0) {
                if (this.CK<10000) {
                    this.CK = this.CK + 50;
                    Energystorer.CK = Energystorer.CK - 50;
                    for(int i=0;i<6;i++) {
                        TileEntity TE = worldObj.getTileEntity(xCoord + ForgeDirection.values()[i].offsetX,
                                yCoord + ForgeDirection.values()[i].offsetY,
                                zCoord + ForgeDirection.values()[i].offsetZ);
                        if (TE instanceof IEnergyReceiver) {
                            ((IEnergyReceiver)TE).receiveEnergy(ForgeDirection.values()[i].getOpposite(),250,false);
                            this.CK = this.CK - 250;
                        }
                    }
                }
            }
        }
        if (worldObj.getTileEntity(xCoord-1,yCoord,zCoord) instanceof TileEntityEnergystorer) {
            TileEntityEnergystorer Energystorer = (TileEntityEnergystorer) worldObj.getTileEntity(xCoord-1,yCoord,zCoord);

            if (Energystorer.CK>0) {
                if (this.CK<10000) {
                    this.CK = this.CK + 50;
                    Energystorer.CK = Energystorer.CK - 50;
                    for(int i=0;i<6;i++) {
                        TileEntity TE = worldObj.getTileEntity(xCoord + ForgeDirection.values()[i].offsetX,
                                yCoord + ForgeDirection.values()[i].offsetY,
                                zCoord + ForgeDirection.values()[i].offsetZ);
                        if (TE instanceof IEnergyReceiver) {
                            ((IEnergyReceiver)TE).receiveEnergy(ForgeDirection.values()[i].getOpposite(),250,false);
                            this.CK = this.CK - 250;
                        }
                    }
                }
            }
        }
        if (worldObj.getTileEntity(xCoord,yCoord-1,zCoord) instanceof TileEntityEnergystorer) {
            TileEntityEnergystorer Energystorer = (TileEntityEnergystorer) worldObj.getTileEntity(xCoord,yCoord-1,zCoord);

            if (Energystorer.CK>0) {
                if (this.CK<10000) {
                    this.CK = this.CK + 50;
                    Energystorer.CK = Energystorer.CK - 50;
                    for(int i=0;i<6;i++) {
                        TileEntity TE = worldObj.getTileEntity(xCoord + ForgeDirection.values()[i].offsetX,
                                yCoord + ForgeDirection.values()[i].offsetY,
                                zCoord + ForgeDirection.values()[i].offsetZ);
                        if (TE instanceof IEnergyReceiver) {
                            ((IEnergyReceiver)TE).receiveEnergy(ForgeDirection.values()[i].getOpposite(),250,false);
                            this.CK = this.CK - 250;
                        }
                    }
                }
            }
        }
        if (worldObj.getTileEntity(xCoord,yCoord,zCoord-1) instanceof TileEntityEnergystorer) {
            TileEntityEnergystorer Energystorer = (TileEntityEnergystorer) worldObj.getTileEntity(xCoord,yCoord,zCoord-1);

            if (Energystorer.CK>0) {
                if (this.CK<10000) {
                    this.CK = this.CK + 50;
                    Energystorer.CK = Energystorer.CK - 50;
                    for(int i=0;i<6;i++) {
                        TileEntity TE = worldObj.getTileEntity(xCoord + ForgeDirection.values()[i].offsetX,
                                yCoord + ForgeDirection.values()[i].offsetY,
                                zCoord + ForgeDirection.values()[i].offsetZ);
                        if (TE instanceof IEnergyReceiver) {
                            ((IEnergyReceiver)TE).receiveEnergy(ForgeDirection.values()[i].getOpposite(),250,false);
                            this.CK = this.CK - 250;
                        }
                    }
                }
            }
        }

        /*for(int i=0;i<6;i++) {
            TileEntity TE = worldObj.getTileEntity(xCoord + ForgeDirection.values()[i].offsetX,
                    yCoord + ForgeDirection.values()[i].offsetY,
                    zCoord + ForgeDirection.values()[i].offsetZ);
            if (TE instanceof IEnergyReceiver) {
                ((IEnergyReceiver)TE).receiveEnergy(ForgeDirection.values()[i].getOpposite(),25,false);
            }
        }
        EnergyHelper.insertEnergyIntoAdjacentEnergyReceiver(this, 0, 25, false);*/
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int p_70301_1_) {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {

    }

    @Override
    public String getInventoryName() {
        return null;
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

    //RF

    @Override
    public int receiveEnergy(ForgeDirection forgeDirection, int i, boolean b) {
        return 0;
    }

    @Override
    public int extractEnergy(ForgeDirection forgeDirection, int i, boolean b) {
        return 25;
    }

    @Override
    public int getEnergyStored(ForgeDirection forgeDirection) {
        return 25;
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection forgeDirection) {
        return 25;
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection forgeDirection) {
        return true;
    }
}
