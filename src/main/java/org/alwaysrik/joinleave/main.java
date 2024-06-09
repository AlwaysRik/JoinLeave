package org.alwaysrik.joinleave;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    public void onEnable() {
        this.getLogger().info("Join/Leave by AlwaysRik has been enabled!");
        this.getServer().getPluginManager().registerEvents(new joinListener(this), this);
        this.saveDefaultConfig();
    }

    public void onDisable() {

        this.getLogger().info("Join/Leave by AlwaysRik has been disabled!");
    }
}
