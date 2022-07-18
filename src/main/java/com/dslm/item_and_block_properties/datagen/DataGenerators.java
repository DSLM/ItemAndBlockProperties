package com.dslm.item_and_block_properties.datagen;

import com.dslm.item_and_block_properties.util.StaticValue;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = StaticValue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        if(event.includeServer())
        {
        }
        if(event.includeClient())
        {
            LanguageUtil.buildLanguage(generator);
        }
    }
}