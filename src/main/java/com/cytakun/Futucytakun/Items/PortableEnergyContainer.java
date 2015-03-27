package com.cytakun.Futucytakun.Items;

import com.cytakun.Futucytakun.Futucytakun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import sun.reflect.misc.FieldUtil;

import java.util.List;

/**
 * Created by Khan Nguyen on 25.03.2015.
 */
public class PortableEnergyContainer extends Item{
    public PortableEnergyContainer() {
        setCreativeTab(Futucytakun.Futucytakun);
        setUnlocalizedName("PortableEnergyContainer");
        setTextureName("futucytakun:PortableEnergyContainer");
    }

    public static int UpdateCK(ItemStack itemStack) {
        int CK=0;
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("CK")) {
            CK=itemStack.getTagCompound().getInteger("CK");
        }
        return CK;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add(String.valueOf(UpdateCK(itemStack)));
        super.addInformation(itemStack, player, list, p_77624_4_);
    }

    public static void setCK(ItemStack itemStack,int CK) {
        if (!itemStack.hasTagCompound()) {
            itemStack.setTagCompound(new NBTTagCompound());
        }
        itemStack.getTagCompound().setInteger("CK",CK);

    }
}
