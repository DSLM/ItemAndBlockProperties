package com.dslm.item_and_block_properties.compat;

import com.dslm.item_and_block_properties.compat.top.TOPCompat;
import com.dslm.item_and_block_properties.util.StaticValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;

import static com.dslm.item_and_block_properties.util.StaticValue.TOP_MOD;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = StaticValue.MOD_ID)
public final class CompatRegistry
{
    
    @SubscribeEvent
    public static void onEnqueue(final InterModEnqueueEvent event)
    {
        event.enqueueWork(() -> InterModComms.sendTo(TOP_MOD, "getTheOneProbe", TOPCompat.GetTheOneProbe::new));
    }
}
