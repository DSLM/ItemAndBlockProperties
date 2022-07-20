package com.dslm.item_and_block_properties.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

import static com.dslm.item_and_block_properties.util.StaticValue.*;

public class LanguageUtil
{
    public static HashMap<String, String> StringKey_en = new HashMap<>();
    public static HashMap<String, String> StringKey_zh = new HashMap<>();
    
    public static HashMap<Item, String> ItemKey_en = new HashMap<>();
    public static HashMap<Item, String> ItemKey_zh = new HashMap<>();
    
    public static HashMap<Block, String> BlockKey_en = new HashMap<>();
    public static HashMap<Block, String> BlockKey_zh = new HashMap<>();
    
    public static HashMap<MobEffect, String> MobEffectKey_en = new HashMap<>();
    public static HashMap<MobEffect, String> MobEffectKey_zh = new HashMap<>();
    
    public static HashMap<EntityType, String> EntityType_en = new HashMap<>();
    public static HashMap<EntityType, String> EntityType_zh = new HashMap<>();
    
    public static void buildLanguage(DataGenerator generator)
    {
        //config
        {
            add(ITEM_CONFIG_STR + "stack_size.show", "Show stack max size", "显示堆叠上限");
            add(ITEM_CONFIG_STR + "stack_size.hide", "Hide the tooltip with this size", "隐藏此数值的物品堆叠上限");
            add(ITEM_CONFIG_STR + "stack_size.damage", "Show durability", "显示耐久度");
    
    
            add(BLOCK_CONFIG_STR + STR_FLAMMABLE + ".show", "Show flammability", "显示可燃性");
            add(BLOCK_CONFIG_STR + STR_LIGHT + ".show", "Show light level", "显示亮度");
            add(BLOCK_CONFIG_STR + STR_FRICTION + ".show", "Show friction", "显示摩擦力");
            add(BLOCK_CONFIG_STR + STR_EXPLOSION_RESISTANCE + ".show", "Show friction", "显示摩擦力");
            add(BLOCK_CONFIG_STR + STR_HARDNESS + ".hide", "Hide the friction with this value", "隐藏此数值的方块摩擦力");
            add(BLOCK_CONFIG_STR + STR_HARDNESS + ".show", "Show hardness", "显示硬度");
            add(BLOCK_CONFIG_STR + STR_DESTROY_TIME + ".show", "Show destroy time", "显示破坏时间");
        }
        
        //tooltip
        {
            add(ITEM_TOOLTIP_STR + "title", "Item Properties", "物品属性");
            add(ITEM_TOOLTIP_STR + "stack_size", "Stack Size: %s", "堆叠数量：%s");
            add(ITEM_TOOLTIP_STR + "damage", "Durability: %1$s/%2$s", "耐久度：%1$s/%2$s");
    
    
            add(BLOCK_TOOLTIP_STR + "title", "Block Properties", "方块属性");
            add(BLOCK_TOOLTIP_STR + STR_FLAMMABLE + ".true", "Flammable: True", "可燃性：是");
            add(BLOCK_TOOLTIP_STR + STR_FLAMMABLE + ".false", "Flammable: False", "可燃性：否");
            add(BLOCK_TOOLTIP_STR + STR_LIGHT, "Light Level: %s", "亮度：%s");
            add(BLOCK_TOOLTIP_STR + STR_FRICTION, "Friction: %s", "摩擦力：%s");
            add(BLOCK_TOOLTIP_STR + STR_EXPLOSION_RESISTANCE, "Explosion Resistance: %s", "爆炸抗性：%s");
            add(BLOCK_TOOLTIP_STR + STR_HARDNESS, "Hardness: %s", "硬度：%s");
            add(BLOCK_TOOLTIP_STR + STR_HARDNESS + ".unbreakable", "Hardness: Unbreakable", "硬度：不可破坏");
            add(BLOCK_TOOLTIP_STR + STR_DESTROY_TIME, "Destroy Time: %sS", "破坏时间：%s秒");
            add(BLOCK_TOOLTIP_STR + STR_DESTROY_TIME + ".infinity", "Destroy Time: Infinity", "破坏时间：无限");
    
    
            add(BLOCK_TOOLTIP_STR + "test", "Test: %s", "Test：%s");
        }
        
        
        //start generation
        generator.addProvider(new LanguageProvider(generator, "en_us"));
        generator.addProvider(new LanguageZhProvider(generator, "zh_cn"));
    }
    
    private static void add(EntityType key, String en, String zh)
    {
        EntityType_en.put(key, en);
        EntityType_zh.put(key, zh);
    }
    
    public static void add(String key, String en, String zh)
    {
        StringKey_en.put(key, en);
        StringKey_zh.put(key, zh);
    }
    
    public static void add(Item key, String en, String zh)
    {
        ItemKey_en.put(key, en);
        ItemKey_zh.put(key, zh);
    }
    
    public static void add(Block key, String en, String zh)
    {
        BlockKey_en.put(key, en);
        BlockKey_zh.put(key, zh);
    }
    
    public static void add(MobEffect key, String en, String zh)
    {
        MobEffectKey_en.put(key, en);
        MobEffectKey_zh.put(key, zh);
    }
}
