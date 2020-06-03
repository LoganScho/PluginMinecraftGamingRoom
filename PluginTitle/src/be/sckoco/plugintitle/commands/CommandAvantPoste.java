package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAvantPoste implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			Location avantPoste = new Location(Bukkit.getWorld("world"), 1037.641, 64, -724.431, -90.8f, 1.1f);
			
			player.teleport(avantPoste);
			player.sendMessage("§6Téléportation vers l'avant-poste terminé");
			
			return true;
		}
		return false;
	}

}
