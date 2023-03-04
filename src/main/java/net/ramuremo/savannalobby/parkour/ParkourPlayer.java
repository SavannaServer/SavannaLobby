package net.ramuremo.savannalobby.parkour;

import net.ramuremo.savannalobby.SavannaLobby;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import javax.annotation.Nonnull;

public final class ParkourPlayer {
    private final Player bukkitPlayer;

    private boolean started = false;
    private BukkitTask timerTask;
    private float maxTime = 0F, time = 0F;

    public ParkourPlayer(@Nonnull Player buikkitPlayer) {
        this.bukkitPlayer = buikkitPlayer;
    }

    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }

    public boolean isStarted() {
        return started;
    }

    public float getCurrentTime() {
        return time;
    }

    public void start() {
        if (started) cancel();
        started = true;

        timerTask = new BukkitRunnable() {
            @Override
            public void run() {
                time += 0.05F;
            }
        }.runTaskTimerAsynchronously(SavannaLobby.getInstance(), 1, 1);
    }

    public void cancel() {
        if (!started) return;
        timerTask.cancel();
        started = false;
    }

    public void end() {
        if (maxTime < time) maxTime = time;
        
    }
}
