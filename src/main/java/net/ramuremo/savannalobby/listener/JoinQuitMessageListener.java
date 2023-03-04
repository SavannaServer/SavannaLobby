package net.ramuremo.savannalobby.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class JoinQuitMessageListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        event.joinMessage(Component.text("§a+ §f").append(player.displayName()).append(Component.text(" §d§lが参加しました")));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        event.quitMessage(Component.text("§c- §f").append(player.displayName()).append(Component.text(" §d§lが参加しました")));
    }
}
