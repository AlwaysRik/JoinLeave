package org.alwaysrik.joinleave;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class joinListener implements Listener {
   private final main plugin;

   public joinListener(main plugin) {
      this.plugin = plugin;
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onPlayerJoin(PlayerJoinEvent event) {
      String joinMessage = this.plugin.getConfig().getString("join-motd");
      if (joinMessage == null) {
         this.plugin.getLogger().warning("join-motd is not set in the config.yml");
      } else {
         joinMessage = joinMessage.replace("%player%", event.getPlayer().getName());
         joinMessage = ChatColor.translateAlternateColorCodes('&', joinMessage);
         event.setJoinMessage(joinMessage);
      }
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onPlayerLeave(PlayerQuitEvent event) {
      String leaveMessage = this.plugin.getConfig().getString("leave-motd");
      if (leaveMessage == null) {
         this.plugin.getLogger().warning("leave-motd is not set in the config.yml");
      } else {
         leaveMessage = leaveMessage.replace("%player%", event.getPlayer().getName());
         leaveMessage = ChatColor.translateAlternateColorCodes('&', leaveMessage);
         event.setQuitMessage(leaveMessage);
      }
   }
}
