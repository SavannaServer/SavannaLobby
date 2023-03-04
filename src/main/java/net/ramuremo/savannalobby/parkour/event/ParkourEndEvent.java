package net.ramuremo.savannalobby.parkour.event;

import net.ramuremo.savannalobby.parkour.ParkourPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import javax.annotation.Nonnull;

public final class ParkourEndEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final ParkourPlayer parkourPlayer;

    public ParkourEndEvent(ParkourPlayer parkourPlayer) {
        this.parkourPlayer = parkourPlayer;
    }

    public ParkourPlayer getParkourPlayer() {
        return parkourPlayer;
    }

    @Override
    public @Nonnull HandlerList getHandlers() {
        return HANDLERS;
    }
}
