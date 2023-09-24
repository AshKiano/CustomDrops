package com.ashkiano.customdrops;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomDrops extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.reloadConfig();
        getServer().getPluginManager().registerEvents(new MobDropListener(this), this);

        Metrics metrics = new Metrics(this, 19462);
    }
}
