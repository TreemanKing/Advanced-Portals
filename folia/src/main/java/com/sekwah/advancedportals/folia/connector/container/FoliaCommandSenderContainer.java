package com.sekwah.advancedportals.folia.connector.container;

import com.sekwah.advancedportals.core.connector.containers.CommandSenderContainer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FoliaCommandSenderContainer implements CommandSenderContainer {
    private final CommandSender sender;

    public FoliaCommandSenderContainer(CommandSender commandSender) {
        this.sender = commandSender;
    }

    public void sendMessage(String message) {
        sender.sendMessage(message);
    }

    public boolean isOp() {
        return sender.isOp();
    }

    /**
     * @return null if there isnt a player e.g. the console
     */
    public FoliaPlayerContainer getPlayerContainer() {
        if (sender instanceof Player) {
            return new FoliaPlayerContainer((Player) sender);
        }
        return null;
    }

    public boolean hasPermission(String permission) {
        return sender.hasPermission(permission);
    }
}
