package com.PyroMC.PyroMCMaster;

import com.PyroMC.PyroMCMaster.Commands.Command_autobcast;
import com.PyroMC.PyroMCMaster.Modules.Regenforkiller;
import net.pravian.bukkitlib.command.BukkitCommandHandler;
import net.pravian.bukkitlib.config.YamlConfig;
import net.pravian.bukkitlib.implementation.BukkitPlugin;
import net.pravian.bukkitlib.util.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.scheduler.BukkitRunnable;

public class PyroMCMaster extends BukkitPlugin {

    public static PyroMCMaster plugin;
    public YamlConfig config;
    public BukkitCommandHandler handler;
    public static String pluginName;
    public static String pluginVersion;
    public static String pluginAuthor;
    public Regenforkiller killerRegen;
   
   @Override
   public void onLoad() {
        plugin = this;
        config = new YamlConfig(plugin, "config.yml", true);
        handler = new BukkitCommandHandler(plugin);
        
        killerRegen = new Regenforkiller(plugin);
   }

    @Override
    public void onEnable() {

        PluginDescriptionFile pdf = plugin.getDescription();
        pluginName = pdf.getName();
        pluginVersion = pdf.getVersion();
        pluginAuthor = pdf.getAuthors().get(0);
        config.load();        
        handler.setCommandLocation(Command_autobcast.class.getPackage());
        
        if(!config.getString("broadcast").equals("")) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    plugin.getServer().broadcastMessage(ChatUtils.colorize(config.getString("prefix") + config.getString("broadcast")));
                }
                
            }.runTaskTimer(plugin, 20L, config.getInt("interval")*20L);
        }
        
        PMM_Log.info(pluginName + " version " + pluginVersion + " by " + pluginAuthor + " is enabled");        
   }

   @Override
   public void onDisable() {
       PMM_Log.info(pluginName + " version " + pluginVersion + " by " + pluginAuthor + " is disabled");
   }
   
   @Override
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       return handler.handleCommand(sender, command, label, args);
   }
}
