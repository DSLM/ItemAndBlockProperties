package com.dslm.item_and_block_properties.event;

import com.dslm.item_and_block_properties.PropertiesGetter;
import com.dslm.item_and_block_properties.util.StaticValue;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE, modid = StaticValue.MOD_ID)
public class ForgeBusClientHandler
{
    @SubscribeEvent
    public static void onItemToolTipAdded(ItemTooltipEvent event)
    {
        List<TranslatableComponent> list = PropertiesGetter.getItemProperties(event.getItemStack());
        if(event.getItemStack().getItem() instanceof BlockItem blockItem && Minecraft.getInstance().level != null)
        {
            PropertiesGetter.getBlockProperties(blockItem.getBlock().defaultBlockState(), Minecraft.getInstance().level, BlockPos.ZERO, Direction.UP, event.getPlayer())
                    .forEach(pair -> {
                        if(StaticValue.clientConfigDisplayCheck(pair.getFirst(), pair.getSecond()))
                            list.add(pair.getSecond());
                    });
        }
        event.getToolTip().addAll(list);
    }
}
