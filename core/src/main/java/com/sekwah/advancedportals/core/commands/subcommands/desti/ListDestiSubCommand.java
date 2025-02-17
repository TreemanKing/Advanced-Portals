package com.sekwah.advancedportals.core.commands.subcommands.desti;

import com.google.inject.Inject;
import com.sekwah.advancedportals.core.commands.SubCommand;
import com.sekwah.advancedportals.core.connector.containers.CommandSenderContainer;
import com.sekwah.advancedportals.core.permissions.Permissions;
import com.sekwah.advancedportals.core.services.DestinationServices;
import com.sekwah.advancedportals.core.util.Lang;
import java.util.List;
import java.util.stream.Collectors;

public class ListDestiSubCommand implements SubCommand {
    @Inject
    DestinationServices portalServices;

    @Override
    public void onCommand(CommandSenderContainer sender, String[] args) {
        sender.sendMessage(
            Lang.getPositivePrefix()
            + Lang.translate("command.destination.list") + " "
            + portalServices.getDestinationNames().stream().sorted().collect(
                Collectors.joining(", ")));
    }

    @Override
    public boolean hasPermission(CommandSenderContainer sender) {
        return Permissions.LIST_DESTI.hasPermission(sender);
    }

    @Override
    public List<String> onTabComplete(CommandSenderContainer sender,
                                      String[] args) {
        return null;
    }

    @Override
    public String getBasicHelpText() {
        return Lang.translate("command.destination.list.help");
    }

    @Override
    public String getDetailedHelpText() {
        return Lang.translate("command.destination.list.help");
    }
}
