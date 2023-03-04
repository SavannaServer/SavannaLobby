package net.ramuremo.savannalobby;

import net.ramuremo.savannalobby.listener.*;
import net.ramuremo.savannalobby.parkour.ParkourHandler;
import net.ramuremo.savannalobby.utility.EventUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class SavannaLobby extends JavaPlugin {
    private static SavannaLobby instance;
    private static ParkourHandler parkourHandler;

    public static SavannaLobby getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        parkourHandler = new ParkourHandler();
        EventUtil.register(
                this,
                new PlateJumpListener(),
                new VoidIntoListener(),
                new LobbyItemAssetListener(),
                new LobbyItemGiveListener(),
                new DisableDamageListener(),
                new DisableDropListener(),
                new JoinQuitMessageListener(),
                new DisableHungerListener()
        );
        getLogger().info("The plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled.");
    }
}
