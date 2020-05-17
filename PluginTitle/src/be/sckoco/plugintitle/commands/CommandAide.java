package be.sckoco.plugintitle.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAide implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				p.sendMessage("�e-------------Commandes Plugin GamingRoom-------------");
				p.sendMessage("�e/bvn <pseudo> -> Accueillir la personne qui vient de rejoindre");
				p.sendMessage("�e/village -> Se teleporter au village");
				p.sendMessage("�e/ville -> Se t�l�porter � la ville");
			}
			
			if(args.length == 1 && args[0].equalsIgnoreCase("admin")) {
				p.sendMessage("�e-------------Commandes Plugin GamingRoom �c�lAdmin�r�e-------------");
				p.sendMessage("�e/bvn <pseudo> -> Accueillir la personne qui vient de rejoindre");
				p.sendMessage("�e/event <message> -> Mettre un message d'event");
				p.sendMessage("�e/rdm -> Pr�venir d'un red�marrage du serveur");
				p.sendMessage("�e/rdv -> Mettre un message d'un rendez-vous � l'�glise");
				p.sendMessage("�e/village -> Se teleporter au village");
				p.sendMessage("�e/ville -> Se t�l�porter � la ville");
			}
					
			
			return true;
		}
		
		return false;
	}

}