package com.dslm.item_and_block_properties.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.dslm.item_and_block_properties.util.StaticValue.*;

public class BlockPropertiesConfig
{
    public static ForgeConfigSpec.BooleanValue SHOW_FLAMMABLE;
    
    public static ForgeConfigSpec.BooleanValue SHOW_LIGHT;
    
    public static ForgeConfigSpec.BooleanValue SHOW_FRICTION;
    
    public static ForgeConfigSpec.BooleanValue SHOW_EXPLOSION_RESISTANCE;
    
    public static ForgeConfigSpec.BooleanValue SHOW_HARDNESS;
    
    public static ForgeConfigSpec.BooleanValue SHOW_DESTROY_TIME;
    
    public static void registerClientConfig(ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        CLIENT_BUILDER
                .push(STR_FLAMMABLE);
        SHOW_FLAMMABLE = CLIENT_BUILDER
                .translation(BLOCK_CONFIG_STR + STR_FLAMMABLE + ".show")
                .define(STR_FLAMMABLE + "Show", true);
        CLIENT_BUILDER.pop();
        
        CLIENT_BUILDER
                .push(STR_LIGHT);
        SHOW_LIGHT = CLIENT_BUILDER
                .translation(BLOCK_CONFIG_STR + STR_LIGHT + ".show")
                .define(STR_LIGHT + "Show", true);
        CLIENT_BUILDER.pop();
        
        CLIENT_BUILDER
                .push(STR_FRICTION);
        SHOW_FRICTION = CLIENT_BUILDER
                .translation(BLOCK_CONFIG_STR + STR_FRICTION + ".show")
                .define(STR_FRICTION + "Show", true);
        CLIENT_BUILDER.pop();
        
        CLIENT_BUILDER
                .push(STR_EXPLOSION_RESISTANCE);
        SHOW_EXPLOSION_RESISTANCE = CLIENT_BUILDER
                .translation(BLOCK_CONFIG_STR + STR_EXPLOSION_RESISTANCE + ".show")
                .define(STR_EXPLOSION_RESISTANCE + "Show", true);
        CLIENT_BUILDER.pop();
        
        CLIENT_BUILDER
                .push(STR_HARDNESS);
        SHOW_HARDNESS = CLIENT_BUILDER
                .translation(BLOCK_CONFIG_STR + STR_HARDNESS + ".show")
                .define(STR_HARDNESS + "Show", true);
        CLIENT_BUILDER.pop();
        
        CLIENT_BUILDER
                .push(STR_DESTROY_TIME);
        SHOW_DESTROY_TIME = CLIENT_BUILDER
                .translation(BLOCK_CONFIG_STR + STR_DESTROY_TIME + ".show")
                .define(STR_DESTROY_TIME + "Show", true);
        CLIENT_BUILDER.pop();
    }
}
