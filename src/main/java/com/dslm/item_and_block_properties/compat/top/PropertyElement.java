package com.dslm.item_and_block_properties.compat.top;

import com.dslm.item_and_block_properties.mixin.MixinElementText;
import com.dslm.item_and_block_properties.util.StaticValue;
import com.mojang.blaze3d.vertex.PoseStack;
import mcjty.theoneprobe.apiimpl.elements.ElementText;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class PropertyElement extends ElementText
{
    public static final ResourceLocation ELEMENT_PROPERTY = new ResourceLocation(StaticValue.MOD_ID, "property");
    protected final String displayCheck;
    
    
    public PropertyElement(Component text, String displayCheck)
    {
        super(text);
        this.displayCheck = displayCheck;
    }
    
    public PropertyElement(FriendlyByteBuf buf)
    {
        super(buf);
        this.displayCheck = buf.readUtf();
    }
    
    public String getDisplayCheck()
    {
        return displayCheck;
    }
    
    public TranslatableComponent getRealComponent()
    {
        if(((MixinElementText) this).getText() instanceof TranslatableComponent translatableComponent)
        {
            return translatableComponent;
        }
        return null;
    }
    
    @Override
    public void render(PoseStack matrixStack, int x, int y)
    {
        if(!StaticValue.clientConfigDisplayCheck(displayCheck, getRealComponent()))
        {
            return;
        }
        super.render(matrixStack, x, y);
    }
    
    @Override
    public int getWidth()
    {
        if(!StaticValue.clientConfigDisplayCheck(displayCheck, getRealComponent()))
        {
            return 0;
        }
        return super.getWidth();
    }
    
    @Override
    public int getHeight()
    {
        if(!StaticValue.clientConfigDisplayCheck(displayCheck, getRealComponent()))
        {
            return 0;
        }
        return super.getHeight();
    }
    
    @Override
    public void toBytes(FriendlyByteBuf buffer)
    {
        super.toBytes(buffer);
        buffer.writeUtf(displayCheck);
    }
    
    @Override
    public ResourceLocation getID()
    {
        return ELEMENT_PROPERTY;
    }
}
