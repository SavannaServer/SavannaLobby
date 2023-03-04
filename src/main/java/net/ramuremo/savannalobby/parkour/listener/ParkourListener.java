package net.ramuremo.savannalobby.parkour.listener;

import net.ramuremo.savannalobby.parkour.ParkourHandler;
import org.bukkit.event.Listener;

public class ParkourListener implements Listener {
    private final ParkourHandler handler;

    public ParkourListener(ParkourHandler handler) {
        this.handler = handler;
    }

    public ParkourHandler getParkourHandler() {
        return handler;
    }
}
