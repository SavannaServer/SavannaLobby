package net.ramuremo.savannalobby.parkour;

import net.ramuremo.savannalobby.config.ConfigFile;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public final class ParkourConfig extends ConfigFile {
    public ParkourConfig(Plugin plugin) {
        super(plugin, "parkour-config.yml");

        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public boolean isEnable() {
        return getConfig().getBoolean("parkour.enable", false);
    }

    @Nullable
    public Location getStartPoint() {
        return getConfig().getObject("parkour.start-point-block", Location.class, null);
    }

    public List<Location> getCheckpoints() {
        return (List<Location>) getConfig().getList("parkour.checkpoints", new ArrayList<Location>());
    }
}
