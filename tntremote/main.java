package tntremote;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.*;

public class main extends JavaPlugin implements Listener{
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@SuppressWarnings("deprecation")
	public Block getSelectedBlock(Player p) {
		  Block b = p.getTargetBlock(null, 200);
		  return b;
	}
	
	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if(event.getClickedBlock().getType() == Material.TNT){
			Location loc = event.getClickedBlock().getLocation();
			World w = player.getWorld();
			event.getClickedBlock().setType(Material.AIR);
			w.spawn(loc, TNTPrimed.class);
		}
	}
	
	
}
