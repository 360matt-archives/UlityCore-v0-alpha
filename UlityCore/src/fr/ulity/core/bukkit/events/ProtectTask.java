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

import fr.ulity.core.bukkit.Config;
import fr.ulity.core.bukkit.MainBukkit;
import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.bukkit.Temp;
import net.minecraft.server.v1_14_R1.Explosion;


public class ProtectTask implements Listener{
	Config config = new Config();
	
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        try {
        	Player player = e.getPlayer();
        	
        	List<?> WorldsProtecteds = MainBukkit.config.getList("WorldProtect");
        	
        	if (WorldsProtecteds.contains(player.getWorld().getName())) {
        		if (!Temp.isSet("player." + player.getName() + ".WorldProtect")) {
            		e.setCancelled(true);
            		player.sendMessage(Lang.get("msg.CantEditMap"));
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
        	
        	List<?> WorldsProtecteds = MainBukkit.config.getList("WorldProtect");
        	
        	if (WorldsProtecteds.contains(player.getWorld().getName())) {
        		if (!Temp.isSet("player." + player.getName() + ".WorldProtect")) {
            		e.setCancelled(true);
            		player.sendMessage(Lang.get("msg.CantEditMap"));
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
        	List<?> WorldsProtecteds = MainBukkit.config.getList("WorldProtect");
        	
        	if (WorldsProtecteds.contains(e.getEntity().getWorld().getName())) {
            	if (e.getEntityType() == EntityType.PLAYER) {
            		Player player = (Player) e.getEntity();
	        		if (!Temp.isSet("player." + player.getName() + ".WorldProtect")) {
	            		e.setCancelled(true);
	            		player.sendMessage(Lang.get("msg.CantEditMap"));
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
        	List<?> WorldsProtecteds = MainBukkit.config.getList("WorldProtect");

        	if (WorldsProtecteds.contains(e.getBlock().getWorld().getName())) 
            	e.setCancelled(true);

        }
        catch(Exception err) {
        	err.printStackTrace();
        }
    }
        
    
}
