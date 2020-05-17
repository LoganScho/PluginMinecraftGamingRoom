package be.sckoco.plugintitle;

import org.bukkit.plugin.java.JavaPlugin;

import be.sckoco.plugintitle.commands.CommandBvn;
import be.sckoco.plugintitle.commands.CommandEvent;
import be.sckoco.plugintitle.commands.CommandMonnaie;
import be.sckoco.plugintitle.commands.CommandAide;
import be.sckoco.plugintitle.commands.CommandRdm;
import be.sckoco.plugintitle.commands.CommandRdv;
import be.sckoco.plugintitle.commands.CommandVillage;
import be.sckoco.plugintitle.commands.CommandVille;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Lancement du plugin GamingRoom");
		getCommand("rdm").setExecutor(new CommandRdm());
		getCommand("event").setExecutor(new CommandEvent());
		getCommand("rdv").setExecutor(new CommandRdv());
		getCommand("bvn").setExecutor(new CommandBvn());
		getCommand("aide").setExecutor(new CommandAide());
		getCommand("village").setExecutor(new CommandVillage());
		getCommand("ville").setExecutor(new CommandVille());
		getCommand("monnaie").setExecutor(new CommandMonnaie());
		getServer().getPluginManager().registerEvents(new PluginListeners(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin GamingRoom vient de s'éteindre");
	}
}
