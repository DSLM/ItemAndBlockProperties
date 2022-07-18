package com.dslm.item_and_block_properties.compat.top;

import com.dslm.item_and_block_properties.PropertiesGetter;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;


public class TOPPlugin implements TOPCompat.Provider
{
    
    public static void register()
    {
        TOPCompat.registerProvider(new TOPPlugin());
    }
    
    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo info, Player player, Level level, BlockState state, IProbeHitData hitData)
    {
        PropertiesGetter.getBlockProperties(state, level, hitData.getPos(), hitData.getSideHit(), player).forEach(pair -> info.element(new PropertyElement(pair.getSecond(), pair.getFirst())));
    }
}
