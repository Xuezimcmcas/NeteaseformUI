package me.zhanshi.formuiplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

import me.zhanshi.formuiplugin.commandExe.CommandShowForm;
import com.neteasemc.spigotmaster.SpigotMaster;

public class CommandListener {
    private JavaPlugin plugin;
    private SpigotMaster spigotMaster;

    public CommandListener(JavaPlugin plugin){
        this.plugin = plugin;
        this.spigotMaster = (SpigotMaster)Bukkit.getPluginManager().getPlugin("SpigotMaster");
        // 注册命令监听
        plugin.getCommand("showForm").setExecutor(new CommandShowForm());
    }
}
