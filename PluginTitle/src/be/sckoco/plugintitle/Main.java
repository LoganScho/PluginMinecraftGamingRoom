package be.sckoco.plugintitle;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import be.sckoco.plugintitle.commands.CommandBvn;
import be.sckoco.plugintitle.commands.CommandDe;
import be.sckoco.plugintitle.commands.CommandEvent;
import be.sckoco.plugintitle.commands.CommandMonnaie;
import be.sckoco.plugintitle.commands.CommandAide;
import be.sckoco.plugintitle.commands.CommandAvantPoste;
import be.sckoco.plugintitle.commands.CommandBox;
import be.sckoco.plugintitle.commands.CommandRdm;
import be.sckoco.plugintitle.commands.CommandRdv;
import be.sckoco.plugintitle.commands.CommandRip;
import be.sckoco.plugintitle.commands.CommandSoute;
import be.sckoco.plugintitle.commands.CommandVague;
import be.sckoco.plugintitle.commands.CommandVillage;
import be.sckoco.plugintitle.commands.CommandVille;

public class Main extends JavaPlugin {
	
	@SuppressWarnings("deprecation")
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
		getCommand("avantposte").setExecutor(new CommandAvantPoste());
		getCommand("vague").setExecutor(new CommandVague());
		getCommand("soute").setExecutor(new CommandSoute());
		getCommand("rip").setExecutor(new CommandRip());
		getCommand("de").setExecutor(new CommandDe());
		getCommand("box").setExecutor(new CommandBox());
		getServer().getPluginManager().registerEvents(new PluginListeners(), this);
		
		
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				for(Player p : Bukkit.getWorld("world").getPlayers()) {
					Location loc = p.getLocation();
					System.out.println(p.getName() + " -> X : " + loc.getBlockX() + " Y : " + loc.getBlockY() + " Z : " + loc.getBlockZ());
				}
			}
		}, 0, 900);
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin GamingRoom vient de s'éteindre");
	}
}
