package com.PyroMC.PyroMCMaster.Listeners;

import com.PyroMC.PyroMCMaster.PyroMCMaster;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerListener implements Listener {
 
    private final PyroMCMaster plugin;

    public PlayerListener(PyroMCMaster plugin)
    {
        this.plugin = plugin;
    }
    
    public void onPlayerDeath(PlayerDeathEvent event){
        plugin.killerRegen.onPlayerDeath(event);
    }
    
}
