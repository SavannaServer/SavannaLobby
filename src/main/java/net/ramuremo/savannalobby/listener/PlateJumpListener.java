package net.ramuremo.savannalobby.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlateJumpListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        final Player player = event.getPlayer();

        if (!event.getAction().equals(Action.PHYSICAL)) return;
        if (event.getClickedBlock() == null || !event.getClickedBlock().getType().equals(Material.OAK_PRESSURE_PLATE)) return;
        final Vector velocity = player.getLocation().getDirection();
        velocity.multiply(3);
        velocity.setY(1.5);
        player.setVelocity(velocity);
        player.playSound(player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 10, 1);
    }
}
