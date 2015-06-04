package com.PyroMC.PyroMCMaster.Commands;

import com.PyroMC.PyroMCMaster.PMM_Util;
import net.pravian.bukkitlib.command.BukkitCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Command_autobcast extends BukkitCommand {
    
        @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        if ((!sender.hasPermission("coloredbroadcast.broadcast")) && (!sender.isOp())) {
            sender.sendMessage(ChatColor.RED + "You do not have the required permissions.");
            return true;
        }

      String CBCC = args[0].toLowerCase();

      StringBuilder buffer = new StringBuilder();

      for (int i = 1; i < args.length; i++) {
        buffer.append(' ').append(args[i]);
      }

      String CBCM = buffer.toString();

      if (!PMM_Util.chatList.contains(CBCC)) {
        sender.sendMessage(ChatColor.RED + "Your Color doesn't match the colors that Minecraft supports, sorry.");
        return true;
      }

      Bukkit.broadcastMessage(PMM_Util.colorize(new StringBuilder().append(PMM_Util.Prefix).append(PMM_Util.chatPrefix).append(CBCC).append(CBCM).toString()));

      return true;
    }
    
}
