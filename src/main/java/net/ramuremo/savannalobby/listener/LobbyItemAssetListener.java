package net.ramuremo.savannalobby.listener;

import net.ramuremo.savannalobby.asset.LobbyItemAsset;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public final class LobbyItemAssetListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        final ItemStack itemStack = event.getItem();

        if (itemStack == null) return;
        final LobbyItemAsset lobbyAssetItem = LobbyItemAsset.values().stream()
                .filter(item -> item.getItemStack().equals(itemStack))
                .findAny()
                .orElse(null);
        if (lobbyAssetItem == null || lobbyAssetItem.getOnClick() == null) return;
        lobbyAssetItem.getOnClick().accept(event);
    }
}
