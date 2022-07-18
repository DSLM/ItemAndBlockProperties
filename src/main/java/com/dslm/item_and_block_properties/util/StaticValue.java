package com.dslm.item_and_block_properties.util;

import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.fml.ModList;

import static com.dslm.item_and_block_properties.config.BlockPropertiesConfig.*;

public class StaticValue
{
    public static final String MOD_ID = "item_and_block_properties";
    
    public static final int TOOLTIP_FONT_COLOR = 0xaaaaaa;
    
    public static final String ITEM_TOOLTIP_STR = "tooltip.item_and_block_properties.item.";
    public static final String BLOCK_TOOLTIP_STR = "tooltip.item_and_block_properties.block.";
    
    public static final String ITEM_CONFIG_STR = "config.item_and_block_properties.item.";
    public static final String BLOCK_CONFIG_STR = "config.item_and_block_properties.block.";
    
    public static final String TOP_MOD = "theoneprobe";
    
    public static final String STR_FLAMMABLE = "flammable";
    public static final String STR_LIGHT = "light";
    public static final String STR_FRICTION = "friction";
    public static final String STR_EXPLOSION_RESISTANCE = "explosion_resistance";
    public static final String STR_HARDNESS = "hardness";
    public static final String STR_DESTROY_TIME = "destroy_time";
    
    public static boolean checkMod(String modId)
    {
        return ModList.get().isLoaded(modId);
    }
    
    public static TranslatableComponent colorfulText(TranslatableComponent text, int color)
    {
        return (TranslatableComponent) text.withStyle(style -> style.withColor(TextColor.fromRgb(color)));
    }
    
    public static boolean clientConfigDisplayCheck(String key)
    {
        switch(key)
        {
            case STR_FLAMMABLE -> {
                return SHOW_FLAMMABLE.get();
            }
            case STR_LIGHT -> {
                return SHOW_LIGHT.get();
            }
            case STR_FRICTION -> {
                return SHOW_FRICTION.get();
            }
            case STR_EXPLOSION_RESISTANCE -> {
                return SHOW_EXPLOSION_RESISTANCE.get();
            }
            case STR_HARDNESS -> {
                return SHOW_HARDNESS.get();
            }
            case STR_DESTROY_TIME -> {
                return SHOW_DESTROY_TIME.get();
            }
            default -> {
                return true;
            }
        }
    }
}
