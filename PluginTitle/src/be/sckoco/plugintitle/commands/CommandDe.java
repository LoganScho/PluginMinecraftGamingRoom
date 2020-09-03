package be.sckoco.plugintitle.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDe implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Random random  = new Random();
			
			int firstDe = 1 + random.nextInt(6-0);
			int secondDe = 1 + random.nextInt(6-0);;
			
			Bukkit.broadcastMessage("Lancer de dé par "+ p.getName() + " : " + firstDe + " et " + secondDe);
		
			return true;
		}
		return false;
	}

}
