package com.dslm.item_and_block_properties;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

import static com.dslm.item_and_block_properties.config.ItemPropertiesConfig.*;
import static com.dslm.item_and_block_properties.util.StaticValue.*;

public class PropertiesGetter
{
    public static List<Pair<String, Component>> getBlockProperties(BlockState blockState, Level level, BlockPos pos, Direction face, Player player)
    {
        ArrayList<Pair<String, Component>> list = new ArrayList<>();
        
        Block block = blockState.getBlock();
        
        list.add(Pair.of(STR_FLAMMABLE,
                colorfulText(
                        new TranslatableComponent(BLOCK_TOOLTIP_STR + STR_FLAMMABLE + "." + blockState.isFlammable(level, pos, face)),
                        TOOLTIP_FONT_COLOR)));
    
        list.add(Pair.of(STR_LIGHT,
                colorfulText(
                        new TranslatableComponent(BLOCK_TOOLTIP_STR + STR_LIGHT, blockState.getLightEmission(level, pos)),
                        TOOLTIP_FONT_COLOR)));
        
        list.add(Pair.of(STR_FRICTION,
                colorfulText(
                        new TranslatableComponent(BLOCK_TOOLTIP_STR + STR_FRICTION, blockState.getBlock().getFriction()),
                        TOOLTIP_FONT_COLOR)));

//        list.add(Pair.of("flammable",
//                colorfulText(
//                        new TranslatableComponent(BLOCK_TOOLTIP_STR + "test", ForgeRegistries.BLOCKS.tags().getTag(BlockTags.MINEABLE_WITH_AXE)),
//                        TOOLTIP_FONT_COLOR)));
    
        list.add(Pair.of(STR_EXPLOSION_RESISTANCE,
                colorfulText(
                        new TranslatableComponent(BLOCK_TOOLTIP_STR + STR_EXPLOSION_RESISTANCE, blockState.getBlock().getExplosionResistance()),
                        TOOLTIP_FONT_COLOR)));
    
        float destroySpeed = blockState.getDestroySpeed(level, pos);
        list.add(Pair.of(STR_HARDNESS,
                colorfulText(
                        destroySpeed == -1.0f ?
                                new TranslatableComponent(BLOCK_TOOLTIP_STR + STR_HARDNESS + ".unbreakable")
                                :
                                new TranslatableComponent(BLOCK_TOOLTIP_STR + STR_HARDNESS, destroySpeed),
                        TOOLTIP_FONT_COLOR)));
    
        if(player != null)
        {
            float destroyProgress = blockState.getDestroyProgress(player, level, pos);
            list.add(Pair.of(STR_DESTROY_TIME,
                    colorfulText(
                            destroyProgress <= 0 ?
                                    new TranslatableComponent(BLOCK_TOOLTIP_STR + STR_DESTROY_TIME + ".infinity")
                                    :
                                    new TranslatableComponent(BLOCK_TOOLTIP_STR + STR_DESTROY_TIME, String.format("%.2f", 1.0 / 20.0 / destroyProgress)),
                            TOOLTIP_FONT_COLOR)));
        }
        
        return list;
    }
    
    public static List<Component> getItemProperties(ItemStack itemStack)
    {
        ArrayList<Component> list = new ArrayList<>();
        
        Item item = itemStack.getItem();
        
        //stack
        if(SHOW_STACK_SIZE.get() && HIDE_STACK_SIZE_VALUE.get() != itemStack.getMaxStackSize())
        {
            list.add(
                    colorfulText(
                            new TranslatableComponent(ITEM_TOOLTIP_STR + "stack_size",
                                    itemStack.getMaxStackSize()),
                            TOOLTIP_FONT_COLOR));
        }
        
        //durability
        if(SHOW_DAMAGE.get() && itemStack.getMaxDamage() > 0)
        {
            list.add(
                    colorfulText(
                            new TranslatableComponent(ITEM_TOOLTIP_STR + "damage",
                                    itemStack.getMaxDamage() - itemStack.getDamageValue(), itemStack.getMaxDamage()),
                            TOOLTIP_FONT_COLOR));
        }
        
        return list;
    }
}
