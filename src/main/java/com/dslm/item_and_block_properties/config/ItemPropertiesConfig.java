package com.dslm.item_and_block_properties.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.dslm.item_and_block_properties.util.StaticValue.ITEM_CONFIG_STR;

public class ItemPropertiesConfig
{
    public static ForgeConfigSpec.BooleanValue SHOW_STACK_SIZE;
    public static ForgeConfigSpec.IntValue HIDE_STACK_SIZE_VALUE;
    
    public static ForgeConfigSpec.BooleanValue SHOW_DAMAGE;
    
    public static void registerClientConfig(ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        CLIENT_BUILDER
                .push("stackSize");
        SHOW_STACK_SIZE = CLIENT_BUILDER
                .translation(ITEM_CONFIG_STR + "stack_size.show")
                .define("stackSizeShow", true);
        HIDE_STACK_SIZE_VALUE = CLIENT_BUILDER
                .translation(ITEM_CONFIG_STR + "stack_size.hide")
                .defineInRange("stackSizeHide", 64, -1, Integer.MAX_VALUE);
        CLIENT_BUILDER.pop();
    
        CLIENT_BUILDER
                .push("damage");
        SHOW_DAMAGE = CLIENT_BUILDER
                .translation(ITEM_CONFIG_STR + "damage.show")
                .define("damageShow", true);
        CLIENT_BUILDER.pop();
    }
}
