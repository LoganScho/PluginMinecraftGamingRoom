package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEvent implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.isOp()) {
				
				if(args.length == 0) {
					p.sendMessage("§cVeuillez précisez un message");
				}
				
				if(args.length >= 1) {
					StringBuffer txt = new StringBuffer();
					
					for (String word : args) {
						txt.append(word+" ");
					}
					
					for(Player pl : Bukkit.getOnlinePlayers()) {
						pl.sendTitle("§6Début de l'évent", "§e"+ txt.toString(), 10, 70, 20);
					}
				}
			}
			
			return true;
		}
		return false;
	}

}
