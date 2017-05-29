package com.redstoner.modules.blockplacemods.mods;

import org.bukkit.entity.Player;

import com.redstoner.modules.blockplacemods.util.CommandException;
import com.redstoner.modules.datamanager.DataManager;

public abstract class ModBooleanAbstract extends ModAbstract<Boolean>
{
	protected boolean enabledByDefault;
	
	protected abstract boolean enabledByDefault();
	
	@Override
	protected void preConstruction()
	{
		enabledByDefault = enabledByDefault();
	}
	
	protected boolean hasEnabled(Player player)
	{
		return (boolean) DataManager.getOrDefault(player.getUniqueId().toString(), "BlockPlaceMods", getName(),
				enabledByDefault);
	}
	
	protected boolean setEnabled(Player sender, boolean enabled)
	{
		if (enabled == hasEnabled(sender))
			return false;
		if (enabled == (boolean) getDefault())
			reset(sender);
		else
			DataManager.setData(sender.getUniqueId().toString(), "BlockPlaceMods", getName(), enabled);
		return true;
	}
	
	@Override
	public String runCommand(Player sender, String[] args) throws CommandException
	{
		if (args.length == 0 || args[0].equalsIgnoreCase("toggle"))
		{
			boolean enabled = hasEnabled(sender);
			setEnabled(sender, !enabled);
			return !enabled ? "Enabled" : "Disabled";
		}
		if (args[0].equalsIgnoreCase("help"))
		{
			StringBuilder message = new StringBuilder();
			message.append("&a### &3").append(getName()).append("&a Help ###");
			message.append("\n&8If enabled, ").append(getDescription());
			message.append("\n&6/mod ").append(getName().toLowerCase()).append("&o toggle &btoggles state");
			message.append("\n&6/mod ").append(getName().toLowerCase()).append("&o on/off &bsets state");
			message.append("\n&6/mod ").append(getName().toLowerCase()).append("&o help &bshows this help page");
			return message.toString();
		}
		final boolean enable;
		if (args[0] == null)
		{
			throw new CommandException("Missing argument");
		}
		else
		{
			switch (args[0].toLowerCase())
			{
				case "on":
				case "enable":
				case "true":
					enable = true;
					break;
				case "off":
				case "disable":
				case "false":
					enable = false;
					break;
				default:
					throw new CommandException("Input '" + args[0] + "' was not understood. "
							+ "Use one of: \non, enable, true, off, disable, false.");
			}
		}
		if (!setEnabled(sender, enable))
		{
			throw new CommandException("Was already " + (enable ? "enabled" : "disabled"));
		}
		return enable ? "Enabled" : "Disabled";
	}
}
