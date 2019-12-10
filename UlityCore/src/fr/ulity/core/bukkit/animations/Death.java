package fr.ulity.core.bukkit.animations;

import fr.ulity.core.bukkit.*;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.util.Vector;

import fr.mrmicky.fastparticle.FastParticle;
import fr.mrmicky.fastparticle.ParticleType;

public class death {
	private static int count = 0;
	private static Object task;
	

	@EventHandler
    public static void run(Object victim){
		if (!(victim instanceof Player)) 
			return;
		
		Player player = (Player) victim;
		
		GameMode oldGameMode = player.getGameMode();
    	
		FastParticle.spawnParticle(((Location) victim).getWorld(), ParticleType.REDSTONE, ((Entity) victim).getLocation(), 100, Color.RED);
		FastParticle.spawnParticle(((Location) victim).getWorld(), ParticleType.REDSTONE, ((Entity) victim).getLocation().add(0, 0.5, 0), 100, Color.RED);
		FastParticle.spawnParticle(((Location) victim).getWorld(), ParticleType.REDSTONE, ((Entity) victim).getLocation().add(0, 1, 0), 100, Color.RED);
		FastParticle.spawnParticle(((Location) victim).getWorld(), ParticleType.REDSTONE, ((Entity) victim).getLocation().add(0, 1.5, 0), 100, Color.RED);
		FastParticle.spawnParticle(((Location) victim).getWorld(), ParticleType.REDSTONE, ((Entity) victim).getLocation().add(0, 2, 0), 100, Color.RED);
		FastParticle.spawnParticle(((Location) victim).getWorld(), ParticleType.EXPLOSION_LARGE, ((Entity) victim).getLocation().add(0, 1, 0), 100, Color.RED);
		
		player.setGameMode(GameMode.SPECTATOR);
		player.setHealth(20);
		
		// forcer le vecteur
			Location _old = ((Entity) victim).getLocation();
			_old.setY(_old.getY() + 1);
			((Entity) victim).teleport(_old);
		// force le vecteur
		
		count = 100;
		// nombre de loop
		
		
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(mainBukkit.plugin, new Runnable() {
            @Override
            public void run() {
            	if (!player.isOnline()) {
            		Bukkit.getScheduler().cancelTask((int) task);
            	}
            	else if (count == 0) {
                	if (config.isSet("global.spawn_location")) {
                		player.teleport((Location) config.get("global.spawn_location"));
                	}
                	player.setGameMode(oldGameMode);
                	
                	Bukkit.getScheduler().cancelTask((int) task);
            	}
            	else {
                	
                	Vector unitVector = new Vector(0, 0.50, 0);
                	unitVector.multiply(1.5);
                	((Entity) victim).setVelocity(unitVector);

            		count--;
            	}
            }
        }, 20L, 0);
        // animation fly + tp au spawn
       
        
    }

}

