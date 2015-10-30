package com.petersoj.DEVproject;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

public class EntityDamage implements Listener{
	
	public EntityDamage(Plugin p){
		Bukkit.getServer().getPluginManager().registerEvents(this, p);
	}
	
	@EventHandler
	public void entityDMG(EntityDamageByEntityEvent e){
		Entity attacker = (Entity)e.getDamager();		
		if(e.getEntity() instanceof LivingEntity){
			if(attacker instanceof Snowball){
				e.setDamage(3);
			}else{
				return;
			}
			if(attacker instanceof WitherSkull){
				e.setDamage(15);
			}else{
				return;
			}
		}else{
			return;
		}
		
	}
}
