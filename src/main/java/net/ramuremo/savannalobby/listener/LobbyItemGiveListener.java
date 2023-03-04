package net.ramuremo.savannalobby.listener;

import net.ramuremo.savannalobby.asset.LobbyItemAsset;
import net.ramuremo.savannalobby.utility.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public final class LobbyItemGiveListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final ItemStack[] contents = player.getInventory().getContents();

        if (!Util.containsItemStack(contents, LobbyItemAsset.SPAWN_WARP.getItemStack())) {
            player.getInventory().addItem(LobbyItemAsset.SPAWN_WARP.getItemStack());
        }
    }
}
