package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBox implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			 Player player = (Player) sender;
			 
			 if(player.getUniqueId().toString().equals("ed281829-ab88-4782-ba14-3a5926962fc0") || player.getUniqueId().toString().equals("4fe584b4-7864-4c29-b07a-1e1a887b8b0b")){
				 
				 Location box = new Location(Bukkit.getWorld("world"), -12525.470, 66, 85.500, -180.0f, 3.2f);
				 
				 player.teleport(box);
				 player.sendMessage("§6Téléportation à la box terminée");
				 
				 return true;
			 }
			 else {
				 player.sendMessage("§cVous n'êtes pas autorisé à entrer cette commande");
			 }
			 
		}
		
		return false;
	}

}
