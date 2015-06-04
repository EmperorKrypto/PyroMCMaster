package com.PyroMC.PyroMCMaster.Modules;

import com.PyroMC.PyroMCMaster.PyroMCMaster;
import org.bukkit.Server;


public class PyroMCModule {
   protected final PyroMCMaster plugin;
   protected final Server server;

   public PyroMCModule(PyroMCMaster plugin)
    {
        this.plugin = plugin;
        this.server = plugin.getServer();
    }
}
