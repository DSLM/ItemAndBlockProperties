package com.dslm.item_and_block_properties.compat.top;

import com.dslm.item_and_block_properties.util.StaticValue;
import mcjty.theoneprobe.api.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TOPCompat
{
    private static List<Provider> providers = new ArrayList<>();
    
    public static class GetTheOneProbe implements Function<ITheOneProbe, Void>
    {
        
        @Override
        public Void apply(ITheOneProbe probe)
        {
            probe.registerProvider(new IProbeInfoProvider()
            {
                @Override
                public ResourceLocation getID()
                {
                    return new ResourceLocation(StaticValue.MOD_ID, "plugin");
                }
                
                @Override
                public void addProbeInfo(ProbeMode mode, IProbeInfo info, Player player, Level level, BlockState state, IProbeHitData hitData)
                {
                    providers.forEach(p -> p.addProbeInfo(mode, info, player, level, state, hitData));
                }
            });
            probe.registerElementFactory(new IElementFactory()
            {
                @Override
                public IElement createElement(FriendlyByteBuf friendlyByteBuf)
                {
                    return new PropertyElement(friendlyByteBuf);
                }
                
                @Override
                public ResourceLocation getId()
                {
                    return PropertyElement.ELEMENT_PROPERTY;
                }
            });
            return null;
        }
        
    }
    
    public static void registerProvider(Provider p)
    {
        providers.add(p);
    }
    
    public interface Provider
    {
        void addProbeInfo(ProbeMode mode, IProbeInfo info, Player player, Level level, BlockState state, IProbeHitData hitData);
    }
    
}