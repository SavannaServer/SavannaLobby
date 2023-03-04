package net.ramuremo.savannalobby.parkour;

import net.ramuremo.savannalobby.SavannaLobby;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ParkourHandler {
    private final ParkourConfig config;
    private final Block startPoint;
    private final Map<Integer, Block> checkpoints;

    private final List<ParkourPlayer> parkourPlayers = new ArrayList<>();

    public ParkourHandler() {
        this.config = new ParkourConfig(SavannaLobby.getInstance());

        if (!config.isEnable()) {
            startPoint = null;
            checkpoints = null;
            return;
        }

        final Location blockLocation = config.getStartPoint();
        final Block startPoint = blockLocation.getBlock();
        if (!startPoint.getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)) {
            throw new IllegalArgumentException("start-point-block needs be type of LIGHT_WEIGHTED_PRESSURE_PLATE");
        }
        this.startPoint = startPoint;

        final List<Location> locations = config.getCheckpoints();
        final Map<Integer, Block> locationMap = new HashMap<>();
        for (int i = 0; i < locations.size(); i++) {
            final Block block = locations.get(i).getBlock();
            if (!block.getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)) {
                throw new IllegalArgumentException("start-point-block needs be type of LIGHT_WEIGHTED_PRESSURE_PLATE");
            }
            locationMap.put(i, block);
        }
        this.checkpoints = locationMap;
    }

    public Block getStartPoint() {
        return startPoint;
    }

    public Map<Integer, Block> getCheckpoints() {
        return checkpoints;
    }

    public ParkourPlayer getParkourPlayer(@Nonnull Player player) {
        final ParkourPlayer lookedUpParkourPlayer = parkourPlayers.stream()
                .filter(pp -> pp.getBukkitPlayer().equals(player))
                .findFirst()
                .orElse(null);

        if (lookedUpParkourPlayer != null)  return lookedUpParkourPlayer;
        final ParkourPlayer parkourPlayer = new ParkourPlayer(player);
        parkourPlayers.add(parkourPlayer);
        return parkourPlayer;
    }
}
