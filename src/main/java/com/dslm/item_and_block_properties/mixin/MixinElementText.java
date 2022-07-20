package com.dslm.item_and_block_properties.mixin;

import mcjty.theoneprobe.apiimpl.elements.ElementText;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ElementText.class)
public interface MixinElementText
{
    @Accessor()
    @Mutable
    public Component getText();
}
