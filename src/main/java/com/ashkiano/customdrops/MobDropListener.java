package com.ashkiano.customdrops;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MobDropListener implements Listener {
    private final CustomDrops plugin;

    public MobDropListener(CustomDrops plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        ConfigurationSection mobDropSection = plugin.getConfig().getConfigurationSection(entity.getType().name());

        if (mobDropSection != null) {
            event.getDrops().clear();

            for (String key : mobDropSection.getKeys(false)) {
                Material material = Material.matchMaterial(key);
                int amount = mobDropSection.getInt(key, 1);

                if (material != null) {
                    event.getDrops().add(new ItemStack(material, amount));
                }
            }
        }
    }
}
