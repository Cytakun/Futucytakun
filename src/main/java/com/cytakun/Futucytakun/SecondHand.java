package com.cytakun.Futucytakun;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Khan Nguyen on 21.03.2015.
 */
public class SecondHand {

    public static void setTexture(ResourceLocation texture) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
    }
    public static void drawTexturedModalRect(int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 1F / (float) textureWidth;
        float f1 = 1F / (float) textureHeight;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y + height, 0, u * f, (v + height) * f1);
        tessellator.addVertexWithUV(x + width, y + height, 0, (u + width) * f, (v + height) * f1);
        tessellator.addVertexWithUV(x + width, y, 0, (u + width) * f, v * f1);
        tessellator.addVertexWithUV(x, y, 0, u * f, v * f1);
        tessellator.draw();
    }
}
