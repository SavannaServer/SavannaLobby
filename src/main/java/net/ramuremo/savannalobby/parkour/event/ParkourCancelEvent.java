package net.ramuremo.savannalobby.parkour.event;

import net.ramuremo.savannalobby.parkour.ParkourPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

public final class ParkourCancelEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final ParkourPlayer parkourPlayer;

    public ParkourCancelEvent(ParkourPlayer parkourPlayer) {
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