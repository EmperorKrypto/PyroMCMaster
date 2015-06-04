package com.PyroMC.PyroMCMaster.Modules;

import com.PyroMC.PyroMCMaster.PyroMCMaster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Regenforkiller extends PyroMCModule implements Listener {
   
    public Regenforkiller(PyroMCMaster plugin)
    {
        super(plugin);
    }
    
    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
      public void onPlayerDeath(PlayerDeathEvent event){
          if (event.getEntity().getLastDamageCause() == null||event.getEntity().getKiller() == null) {
            return;
          }
 
          Player dead = event.getEntity();
          Player killer = event.getEntity().getKiller();
         
 
          EntityDamageEvent.DamageCause cause = event.getEntity().getLastDamageCause().getCause();
          if ((cause == EntityDamageEvent.DamageCause.ENTITY_ATTACK || cause == EntityDamageEvent.DamageCause.PROJECTILE) && (killer != null)){
              killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 2, 5), true);
              }
         
      }
    
}
