package me.zhanshi.formuiplugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
public final class FormUIPlugin extends JavaPlugin implements Listener {

    private CommandListener cmdListener;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("com.neteasemc.formuiplugin onEnable");
        cmdListener = new CommandListener(this);

    }

        @Override
        public void onDisable () {
            // Plugin shutdown logic
        }
    }