package com.cytakun.Futucytakun;

import com.cytakun.Futucytakun.Items.Energycleaver;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Khan Nguyen on 25.03.2015.
 */
public class Recipes {
    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(Futucytakun.Energycleaver), "xdx","xix","xrx",'d',new ItemStack(Items.diamond),'i',new ItemStack(Items.iron_ingot),'r',new ItemStack(Items.redstone));
        GameRegistry.addRecipe(new ItemStack(Futucytakun.Energyextractor), "igi","geg","igi",'i',new ItemStack(Blocks.iron_block),'g',new ItemStack(Blocks.glass),'e',new ItemStack(Futucytakun.Energycleaver));
        GameRegistry.addRecipe(new ItemStack(Futucytakun.Energycell), "iri", "rdr", "iri",'i',new ItemStack(Items.iron_ingot),'r', new ItemStack(Items.redstone),'d', new ItemStack(Items.diamond));
        GameRegistry.addRecipe(new ItemStack(Futucytakun.PortableEnergyContainer), "idi","iei","iii", 'i',new ItemStack(Items.iron_ingot), 'd',new ItemStack(Items.diamond),'e',new ItemStack(Futucytakun.Energycell) );
        GameRegistry.addRecipe(new ItemStack(Futucytakun.Energycontainer), "idi", "rer", "idi", 'i', new ItemStack(Items.iron_ingot), 'd', new ItemStack(Items.diamond), 'e', new ItemStack(Futucytakun.Energycell), 'r', new ItemStack(Items.redstone) );
    }
}
