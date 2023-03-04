package net.ramuremo.savannalobby.asset;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.ramuremo.savannalobby.utility.RateLimiter;
import net.ramuremo.savannalobby.utility.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public interface LobbyItemAsset {
    LobbyItemAsset SPAWN_WARP = new LobbyItemAsset() {
        @Override
        public ItemStack getItemStack() {
            final ItemStack itemStack = new ItemStack(Material.ENDER_EYE);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.displayName(Component.text("スポーンにワープ").color(TextColor.color(0xC868FF))
                    .append(Component.text(" - ").color(TextColor.color(0xFFFFFF)))
                    .append(Component.text("右クリック可").color(TextColor.color(0xFFC600))));
            final List<Component> lore = Arrays.asList(
                    Component.text("右クリックで使用").color(TextColor.color(0xFFC600)),
                    Component.text(""),
                    Component.text("クリックでスポーン地点に移動します").color(TextColor.color(0xC661FF))
            );
            itemMeta.lore(lore);
            itemStack.setItemMeta(itemMeta);
            return itemStack;
        }

        private static final RateLimiter<Player> playerRateLimiter = new RateLimiter<>(1);

        @Override
        public Consumer<PlayerInteractEvent> getOnClick() {
            return (event) -> {
                final Player player = event.getPlayer();
                if (!playerRateLimiter.tryAcquire(player)) return;
                final Location spawnLocation = player.getWorld().getSpawnLocation();
                spawnLocation.setDirection(player.getLocation().getDirection());
                player.teleport(Util.toCenterLocation(spawnLocation));
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 2);
                player.spawnParticle(Particle.PORTAL, player.getLocation(), 10);
                event.setCancelled(true);
            };
        }
    };

    static Set<LobbyItemAsset> values() {
        return Set.of(SPAWN_WARP);
    }

    ItemStack getItemStack();
    @Nullable Consumer<PlayerInteractEvent> getOnClick();
}
