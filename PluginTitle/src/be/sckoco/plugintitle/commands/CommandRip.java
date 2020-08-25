package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRip implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if (args.length == 0) {
				p.sendMessage("§cVeuillez préciser le nom du joueur");
				
				return true;
			}
			
			if (args.length == 1) {
				String targetName = args[0];
				
				if(Bukkit.getPlayer(targetName) != null) {
					p.chat("Repose en paix §a"+ targetName);
				}
				else {
					p.sendMessage("§cLe joueur n'existe pas");
				}
				
				return true;
			}
			
			if(args.length > 1) {
				p.sendMessage("§cVeuillez préciser qu'un seul joueur");
				
				return true;
			}
			
		}
		return false;
	}

}
