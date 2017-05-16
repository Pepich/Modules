package com.redstoner.modules.easyranks;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import com.nemez.cmdmgr.Command;
import com.nemez.cmdmgr.CommandManager;
import com.redstoner.annotations.Version;
import com.redstoner.misc.Main;
import com.redstoner.misc.Utils;
import com.redstoner.modules.Module;

@Version(major = 3, minor = 0, revision = 0, compatible = 3)
public class EasyRanks implements Module{
		
		private static final int secInWeeks = 604800;
		
		@Override
		public void postEnable()
		{
			CommandManager.registerCommand(this.getClass().getResourceAsStream("EasyRanks.cmd"), this, Main.plugin);
		}
		
		@Command(hook = "promote")
		public void promote(CommandSender sender, String user, boolean kick) {
			run(sender, "/sudo CONSOLE promote " + user, user, kick);
			message(sender,"&3" + user + "&a has been promoted.");
		}
		
		@Command(hook = "demote")
		public void demote(CommandSender sender, String user, boolean kick) {
			run(sender, "/sudo CONSOLE demote " + user, user, kick);
			message(sender,"&3" + user + "&a has been demoted.");
		}
		
		@Command(hook = "retire")
		public void retire(CommandSender sender, String user, boolean kick) {
			run(sender, "pex user " + user + " group set trusted", user, false);
			run(sender, "pex user " + user + " group add +retired", user, kick);
			message(sender,"&3" + user + "&a has been retired.");
		}
		
		@Command(hook = "donated")
		public void donated(CommandSender sender, String user, boolean alot, boolean kick) {
			if(alot)
				run(sender, "pex user " + user + " group add +donorplus", user, kick);
			else
				run(sender, "pex user " + user + " group add +donor", user, kick);
			message(sender,"&3" + user + "&a has been added to the Donor(+) group.");
		}
		
		@Command(hook = "dev")
		public void dev(CommandSender sender, String user, boolean kick) {
			run(sender, "pex user " + user + " group add +dev", user, kick);
			message(sender,"&3" + user + "&a has been added to the Developer group.");
		}
		
		@Command(hook = "lead")
		public void lead(CommandSender sender, String user, boolean kick) {
			run(sender, "pex user " + user + " group add +lead", user, kick);
			message(sender,"&3" + user + "&a has been added to the Staff-Lead group.");
		}
		
		@Command(hook = "nowe")
		public void nowe(CommandSender sender, String user, boolean kick) {
			run(sender, "pex user " + user + " group add +nowe", user, kick);
			message(sender,"&3" + user + "&a can no longer use World Edit.");
		}
		
		@Command(hook = "nowet")
		public void nowet(CommandSender sender, String user, int weeks, boolean kick) {
			run(sender, "pex user " + user + " group add +nowe * " + (weeks * secInWeeks), user, kick);
			message(sender,"&3" + user + "&a can't use World Edit for " + weeks + " weeks.");
		}
		
		@Command(hook = "no_sv")
		public void no_sv(CommandSender sender, String user, boolean kick) {
			run(sender, "pex user " + user + " group add +no_sv", user, kick);
			message(sender,"&3" + user + "&a can no longer use the Survival World.");
		}
		
		@Command(hook = "no_svt")
		public void no_svt(CommandSender sender, String user, int weeks, boolean kick) {
			run(sender, "pex user " + user + " group add +no_sv * " + (weeks * secInWeeks), user, kick);
			message(sender,"&3" + user + "&a can't use the Survival World for " + weeks + " weeks.");
		}
		
		@Command(hook = "no_tsv")
		public void no_tsv(CommandSender sender, String user, boolean kick) {
			run(sender, "pex user " + user + " group add +no_tsv", user, kick);
			message(sender,"&3" + user + "&a can no longer use the Trusted Survival World.");
		}
		
		@Command(hook = "no_tsvt")
		public void no_tsvt(CommandSender sender, String user, int weeks, boolean kick) {
			run(sender, "pex user " + user + " group add +no_tsv * " + (weeks * secInWeeks), user, kick);
			message(sender,"&3" + user + "&a can't use the Trusted Survival World for " + weeks + " weeks.");
		}
		
		private void run(CommandSender sender, String command, String user, boolean kick) {
			Bukkit.getServer().dispatchCommand(sender, command);
			if(kick)
				Bukkit.getServer().dispatchCommand(sender, "/kick " + user + " Rejoin");
		}
		
		private void message(CommandSender sender, String message) {
			Utils.sendMessage(sender, null, message);
		}
}
