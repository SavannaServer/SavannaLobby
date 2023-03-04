package net.ramuremo.savannalobby.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public final class DisableHungerListener implements Listener {
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        final Entity entity = event.getEntity();

        if (!(entity instanceof Player)) return;

        event.setFoodLevel(20);
    }
}
