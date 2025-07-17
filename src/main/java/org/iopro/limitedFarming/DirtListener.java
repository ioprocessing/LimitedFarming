package org.iopro.limitedFarming;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class DirtListener implements Listener {
    @EventHandler
    public void onDirtBreak(BlockBreakEvent e) {
        Block b = e.getBlock();
        if(Collections.dropsDirt.contains(b.getType()) && e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            // Replace all dirt drops with coarse dirt
            e.setDropItems(false);
            b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.COARSE_DIRT));
        }
    }

    @EventHandler
    public void onHoe(PlayerInteractEvent e) {
        // Return if the action isn't a right click, or the player doesn't have an item, or if the item isn't a hoe, or if the block isn't coarse dirt
        if(e.getAction() != Action.RIGHT_CLICK_BLOCK || e.getItem() == null || !Collections.hoes.contains(e.getItem().getType()) || e.getClickedBlock().getType() != Material.COARSE_DIRT)
            return;
        e.setCancelled(true);
    }
}
