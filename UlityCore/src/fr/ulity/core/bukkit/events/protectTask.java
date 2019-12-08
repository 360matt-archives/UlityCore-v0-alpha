package fr.ulity.core.bukkit.events;

import java.util.List;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import fr.ulity.core.bukkit.config;
import fr.ulity.core.bukkit.lang;
import fr.ulity.core.bukkit.temp;
import net.minecraft.server.v1_14_R1.Explosion;


public class protectTask implements Listener{
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        try {
        	Player player = e.getPlayer();
        	
        	List<?> WorldsProtecteds = config.getList("WorldProtect");
        	
        	if (WorldsProtecteds.contains(player.getWorld().getName())) {
        		if (!temp.isSet("player." + player.getName() + ".WorldProtect")) {
            		e.setCancelled(true);
            		player.sendMessage(lang.get("msg.CantEditMap"));
            	}
        	}
        	
        	
        }
        catch(Exception err) {
           	err.printStackTrace();
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        try {
        	Player player = e.getPlayer();
        	
        	List<?> WorldsProtecteds = config.getList("WorldProtect");
        	
        	if (WorldsProtecteds.contains(player.getWorld().getName())) {
        		if (!temp.isSet("player." + player.getName() + ".WorldProtect")) {
            		e.setCancelled(true);
            		player.sendMessage(lang.get("msg.CantEditMap"));
            	}
        	}

    	
        }
        catch(Exception err) {
        	err.printStackTrace();
        }
    }
    
    @EventHandler
    public void onEntityExplose(EntityExplodeEvent e){
        try {
        	List<?> WorldsProtecteds = config.getList("WorldProtect");
        	
        	if (WorldsProtecteds.contains(e.getEntity().getWorld().getName())) {
            	if (e.getEntityType() == EntityType.PLAYER) {
            		Player player = (Player) e.getEntity();
	        		if (!temp.isSet("player." + player.getName() + ".WorldProtect")) {
	            		e.setCancelled(true);
	            		player.sendMessage(lang.get("msg.CantEditMap"));
	            	}
            	}
            	else {
            		e.setCancelled(true);
            	}
        	}
        }
        catch(Exception err) {
        	err.printStackTrace();
        }
    }
    
    @EventHandler
    public void onBlockExplose(BlockExplodeEvent e){
        try {
        	List<?> WorldsProtecteds = config.getList("WorldProtect");

        	if (WorldsProtecteds.contains(e.getBlock().getWorld().getName())) 
            	e.setCancelled(true);

        }
        catch(Exception err) {
        	err.printStackTrace();
        }
    }
        
    
}
