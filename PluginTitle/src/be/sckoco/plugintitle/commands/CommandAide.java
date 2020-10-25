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
				p.sendMessage("§e-------------Commandes Plugin GamingRoom-------------");
				p.sendMessage("§e/avantposte -> Se téléporter à l'avant-poste");
				p.sendMessage("§e/bvn <pseudo> -> Accueillir la personne qui vient de rejoindre");
				p.sendMessage("§e/de -> Lancer les deux dés pour la partie de Monopoly");
				p.sendMessage("§e/rip -> Pleurer la mort d'un joueur");
				p.sendMessage("§e/village -> Se téléporter au village");
				p.sendMessage("§e/ville -> Se téléporter à la ville");
			}
			
			if(args.length == 1 && args[0].equalsIgnoreCase("admin") && p.isOp()) {
				p.sendMessage("§e-------------Commandes Plugin GamingRoom §c§lAdmin§r§e-------------");
				p.sendMessage("§e/bvn <pseudo> -> Accueillir la personne qui vient de rejoindre");
				p.sendMessage("§e/event <message> -> Mettre un message d'event");
				p.sendMessage("§e/monnaie -> Accès aux différentes monnaies");
				p.sendMessage("§e/rdm -> Prévenir d'un redémarrage du serveur");
				p.sendMessage("§e/rdv -> Mettre un message pour rendez-vous à l'église");
				p.sendMessage("§e/vague <numVague> -> Spawn une vague de Pillagers");
				p.sendMessage("§e/village -> Se téléporter au village");
				p.sendMessage("§e/ville -> Se téléporter à la ville");
			}
					
			
			return true;
		}
		
		return false;
	}

}
