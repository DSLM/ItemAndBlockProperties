package com.dslm.item_and_block_properties;

import com.dslm.item_and_block_properties.compat.top.TOPPlugin;
import com.dslm.item_and_block_properties.config.Config;
import com.dslm.item_and_block_properties.util.StaticValue;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(StaticValue.MOD_ID)
public class ItemAndBlockProperties
{
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public ItemAndBlockProperties()
    {
        Config.register();
        
        if(StaticValue.checkMod(StaticValue.TOP_MOD))
        {
            TOPPlugin.register();
        }
    }
}
