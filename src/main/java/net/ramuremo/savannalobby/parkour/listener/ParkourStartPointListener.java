package net.ramuremo.savannalobby.parkour.listener;

import net.ramuremo.savannalobby.parkour.ParkourHandler;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class ParkourStartPointListener extends ParkourListener {
    public ParkourStartPointListener(ParkourHandler handler) {
        super(handler);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        final Action action = event.getAction();
        if (!action.equals(Action.PHYSICAL)) return;
        final Block block = event.getClickedBlock();
        if (block==null) return;
        if (!block.equals(getParkourHandler().getStartPoint())) return;

    }
}
