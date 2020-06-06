package be.sckoco.plugintitle.commands;

import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vindicator;

public class CommandVague implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			World world = Bukkit.getWorld("world");
			
			if(player.isOp()) {
				Location[] locs = new Location[10];
				
				insertLocation(locs, 0, world, 1051.521, 64, -681.822);
				insertLocation(locs, 1, world, 1027.423, 69, -703.754);
				insertLocation(locs, 2, world, 1022.542, 63, -721.518);
				insertLocation(locs, 3, world, 1031.824, 64, -755.561);
				insertLocation(locs, 4, world, 1061.503, 70, -762.333);
				insertLocation(locs, 5, world, 1097.391, 65, -752.371);
				insertLocation(locs, 6, world, 1113.736, 65, -727.380);
				insertLocation(locs, 7, world, 1107.316, 66, -704.432);
				insertLocation(locs, 8, world, 1086.466, 66, -683.851);
				insertLocation(locs, 9, world, 1066.556, 68, -674.529);
				
				int nbSpawns = 0;
				int nbSpots = 0;
				
				if(args.length == 0) {
					player.sendMessage("§cVeuillez préciser un paramètre");
					return false;
				}
				
				switch(args[0]) {
					case "1" :
						nbSpawns = 30;
						nbSpots = 2;
						
						break;
					case "2" :
						nbSpawns = 40;
						nbSpots = 2;
						break;
					case "3" :
						nbSpawns = 45;
						nbSpots = 3;
						break;
					case "4" :
						nbSpawns = 50;
						nbSpots = 4;
						break;
					case "5" :
						nbSpawns = 60;
						nbSpots = 5;
						break;
					case "6" :
						nbSpawns = 60;
						nbSpots = 5;
						break;
					case "7" :
						nbSpawns = 70;
						nbSpots = 6;
						break;
					case "8" :
						nbSpawns = 70;
						nbSpots = 7;
						break;
					case "9" :
						nbSpawns = 30;
						nbSpots = 7;
						break;
					case "10" :
						nbSpawns = 45;
						nbSpots = 7;
						break;
					case "11" :
						nbSpawns = 30;
						nbSpots = 2;
						break;
					case "12" :
						nbSpawns = 40;
						nbSpots = 2;
						break;
					case "13" :
						nbSpawns = 45;
						nbSpots = 3;
						break;
					case "14" :
						nbSpawns = 50;
						nbSpots = 4;
						break;
					case "15" :
						nbSpawns = 60;
						nbSpots = 5;
						break;
					case "16" :
						nbSpawns = 60;
						nbSpots = 5;
						break;
					case "17" :
						nbSpawns = 70;
						nbSpots = 6;
						break;
					case "18" :
						nbSpawns = 70;
						nbSpots = 7;
						break;
					case "19" :
						nbSpawns = 30;
						nbSpots = 7;
						break;
					case "20" :
						nbSpawns = 45;
						nbSpots = 7;
						break;
					case "boss" :
						for(Player pl : Bukkit.getOnlinePlayers()) {
							pl.sendTitle("§cWarning ! Plot twist", null, 10, 70, 20);
						}
						break;
					default :
						player.sendMessage("§4Le paramètre n'est pas valide");
						return false;
				}
				
				if(!args[0].equalsIgnoreCase("boss")) {
					for(Player pl : Bukkit.getOnlinePlayers()) {
						pl.sendTitle("§6Vague "+args[0], null, 10, 70, 20);
					}
				}
				
				for(int i = 0; i < nbSpawns; i++) {
					Random random = new Random();
					int nb = 0 + random.nextInt(nbSpots-0);
					Location spawnLoc = locs[nb];
					
					int pourcentage = 1 + random.nextInt(11-1);
					if(pourcentage <= 8) {
						Pillager pillager = (Pillager) world.spawnEntity(spawnLoc, EntityType.PILLAGER);
					}
					else if(pourcentage > 8) {
						Vindicator vindicator = (Vindicator) world.spawnEntity(spawnLoc, EntityType.VINDICATOR);
					}
				}
			}
			return true;
		}
		
		return false;
	}

	private void insertLocation(Location[] locs, int i, World world, double x, double y, double z) {
		Location loc = new Location(world, x, y, z);
		locs[i] = loc;
	}
	
}
