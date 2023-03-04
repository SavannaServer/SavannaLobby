package net.ramuremo.savannalobby.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public final class DisableDamageListener implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        final Entity entity = event.getEntity();
        if (!(entity instanceof Player)) return;
        event.setCancelled(true);
    }
}
