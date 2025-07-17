package org.iopro.limitedFarming;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;

public class WaterListener implements Listener {
    @EventHandler
    public void onWaterPlace(PlayerBucketEmptyEvent e) {
        if(e.getBucket() != Material.WATER_BUCKET)
            return;
        e.setCancelled(true);

        // Manually place the water (done this way to avoid scheduling)
        Block b = e.getBlock();
        b.setType(Material.WATER);
        Levelled waterLevel = (Levelled) b.getBlockData();
        waterLevel.setLevel(1);
        b.setBlockData(waterLevel);

        // Replace the water bucket with an empty one
        Player p = e.getPlayer();
        if(p.getGameMode() != GameMode.CREATIVE) {
            p.getInventory().getItem(e.getHand()).setType(Material.BUCKET);
        }
    }
}
