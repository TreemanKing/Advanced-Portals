package com.sekwah.advancedportals.folia;

import com.sekwah.advancedportals.core.util.InfoLogger;

public class FoliaInfoLogger extends InfoLogger {

    private final AdvancedPortalsPlugin plugin;

    public FoliaInfoLogger(AdvancedPortalsPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public void warning(String s) {
        plugin.getLogger().warning(s);
    }

    @Override
    public void info(String s) {

    }

    @Override
    public void error(Exception e) {

    }
}
