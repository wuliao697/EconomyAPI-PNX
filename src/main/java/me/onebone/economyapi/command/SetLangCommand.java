package me.onebone.economyapi.command;

/*
 * EconomyAPI: Core of economy system for Nukkit
 * Copyright (C) 2016  onebone <jyc00410@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.lang.TranslationContainer;
import cn.nukkit.utils.TextFormat;
import me.onebone.economyapi.EconomyAPI;

import java.util.Objects;

public class SetLangCommand extends Command {
    private final EconomyAPI plugin;

    public SetLangCommand(EconomyAPI plugin) {
        super("setlang", "Sets your preferred language", "/setlang <ccTLD>");

        this.plugin = plugin;

        // command parameters
        commandParameters.clear();
        commandParameters.put("default", new CommandParameter[]{
                CommandParameter.newType("ccTLD", false , CommandParamType.STRING)
        });
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!this.plugin.isEnabled()) return false;
        if (!sender.hasPermission("economyapi.command.setlang")) {
            sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));
            return false;
        }

        if (args.length < 1) {
            sender.sendMessage(new TranslationContainer("commands.generic.usage", this.getUsage()));
            return true;
        }
        String lang = args[0];
        String set = plugin.getLanguage();
        for (String element : EconomyAPI.langList) {
            if (Objects.equals(lang, element)){
                plugin.getConfig().set("data.language", lang);
                plugin.getConfig().save();
                sender.sendMessage(this.plugin.getMessage("language-set",new String[]{lang}, sender));
            }
        }
        if (!Objects.equals(set, plugin.getLanguage())){
            sender.sendMessage(this.plugin.getMessage("setlang-failed", sender));
            return false;
        }
        return true;
    }
}
