package com.dslm.item_and_block_properties.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config
{
    // TODO: 2022/5/10 药水效果削弱乘数，参考滞留
    // TODO: 2022/5/10 维度黑白名单？
    // TODO: 2022/5/10 方块基底黑白名单？
    
    public static void register()
    {
        registerServerConfigs();
        registerCommonConfigs();
        registerClientConfigs();
    }
    
    private static void registerClientConfigs()
    {
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
        BlockPropertiesConfig.registerClientConfig(CLIENT_BUILDER);
        ItemPropertiesConfig.registerClientConfig(CLIENT_BUILDER);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_BUILDER.build());
    }
    
    private static void registerCommonConfigs()
    {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build());
    }
    
    private static void registerServerConfigs()
    {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_BUILDER.build());
    }
}