package net.ramuremo.savannalobby.listener;

import net.ramuremo.savannalobby.utility.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public final class VoidIntoListener implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        final Player player = (Player) event.getEntity();

        if (!event.getCause().equals(EntityDamageEvent.DamageCause.VOID)) return;
        event.setCancelled(true);
        player.teleport(Util.toCenterLocation(player.getWorld().getSpawnLocation()));
    }
}
