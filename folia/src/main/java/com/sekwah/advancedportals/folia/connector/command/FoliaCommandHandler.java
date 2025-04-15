package com.sekwah.advancedportals.folia.connector.command;

import com.sekwah.advancedportals.core.commands.CommandTemplate;
import com.sekwah.advancedportals.spigot.connector.container.SpigotCommandSenderContainer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class FoliaCommandHandler implements CommandExecutor, TabCompleter {
    private final CommandTemplate commandExecutor;

    public FoliaCommandHandler(CommandTemplate commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command,
                             String s, String[] args) {
        this.commandExecutor.onCommand(
            new SpigotCommandSenderContainer(commandSender), command.getName(),
            args);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender,
                                      Command command, String s,
                                      String[] args) {
        return this.commandExecutor.onTabComplete(
            new SpigotCommandSenderContainer(commandSender), args);
    }
}
