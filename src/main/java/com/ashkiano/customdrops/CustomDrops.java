package com.ashkiano.customdrops;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomDrops extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.reloadConfig();
        getServer().getPluginManager().registerEvents(new MobDropListener(this), this);

        Metrics metrics = new Metrics(this, 19462);

        this.getLogger().info("Thank you for using the CustomDrops plugin! If you enjoy using this plugin, please consider making a donation to support the development. You can donate at: https://donate.ashkiano.com");
    }
}
