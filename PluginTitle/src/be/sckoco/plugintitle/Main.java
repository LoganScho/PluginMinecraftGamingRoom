package be.sckoco.plugintitle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
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
	
	private static final DateFormat formatFichier = new SimpleDateFormat("dd-MM-yyyy");
	private static final DateFormat formatPos = new SimpleDateFormat("HH:mm:ss");
	
	private String date = formatFichier.format(new Date());
	
	@Override
	public void onEnable() {
		System.out.println("Lancement du plugin GamingRoom");
		
		File dir = new File("plugins/PluginGR");
		if(!dir.exists()) {
			if(dir.mkdir()) {
				System.out.println("Dossier créé avec succès");
			}
			else {
				System.out.println("Erreur à la création");
			}
		}
		else {
			System.out.println("Dossier déjà existant");
		}
		
		File file = new File("plugins/PluginGR/" + date + ".txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Fichier du "+ date + " créé");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Fichier du " + date + " déjà existant");
		}
		
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
					try {
						FileWriter writer = new FileWriter(file, true);
						BufferedWriter bw = new BufferedWriter(writer);
						String line = "[" + formatPos.format(new Date()) + " - " + p.getWorld().getName() + "] : " + p.getName() + " -> X : " + loc.getBlockX() + " Y : " + loc.getBlockY() + " Z : " + loc.getBlockZ();
						bw.write(line + "\n");
						bw.close();
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
				}
			}
		}, 0, 900);
		
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				if(!date.equals(formatFichier.format(new Date()))) {
					date = formatFichier.format(new Date());
					File file = new File("plugins/PluginGR/" + date + ".txt");
					if(!file.exists()) {
						try {
							file.createNewFile();
							System.out.println("Fichier du "+ date + " créé");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}, 0, 900);
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin GamingRoom vient de s'éteindre");
	}
}
