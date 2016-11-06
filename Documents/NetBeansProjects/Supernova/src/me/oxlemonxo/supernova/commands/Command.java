package me.oxlemonxo.supernova.commands;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import me.oxlemonxo.supernova.Supernova;
import me.oxlemonxo.supernova.util.Util;
import me.oxlemonxo.supernova.util.EightBallUtil;
import me.oxlemonxo.supernova.util.UptimeUtil;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.PrivateChannel;
import net.dv8tion.jda.entities.TextChannel;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.entities.VoiceChannel;
import net.dv8tion.jda.managers.AccountManager;

public class Command
{

    public static Random random = new Random();
    public static String onUser = "";
    public static String builtBy = "Lemon";
    public static String buildDate = "November 6, 2016";
    public static String version = "beta 1.0.0";
    public static String versionName = "'Just, why.'";

    public static void runCommand(TextChannel channel, String command, User author)
    {
        if (command.toLowerCase().startsWith("rate"))
        {
            int rating = random.nextInt(10);
            if (command.length() >= 4)
            {
                if (rating < 4)
                {
                    rating++;
                    rating++;
                }
                onUser = command.substring(5);

                if (onUser.toLowerCase().contains("supernova"))
                {

                    channel.sendMessage("I give myself an **11/10**, because why not.");
                    return;
                }
                if (onUser.startsWith("@"))
                {
                    onUser = onUser.replaceAll("@", "");
                    onUser = Util.targetMention(onUser);
                    channel.sendMessage("I give " + onUser + " a " + String.valueOf(rating) + "/10");
                    return;
                }
                channel.sendMessage("I give `" + onUser + "` a " + String.valueOf(rating) + "/10");

            } else
            {
                channel.sendMessage("```Give a rating for someone or something! \nUsage: .rate someone```");
            }
        }
        if (command.toLowerCase().startsWith("8ball"))
        {
            if (command.length() > 5)
            {
                Random random = new Random();
                int select = random.nextInt(100);

                if (select > 50)
                {
                    channel.sendMessage(author.getAsMention() + " " + EightBallUtil.getYesString());
                }
                if (select < 50 && select > 20)
                {
                    channel.sendMessage(author.getAsMention() + " " + EightBallUtil.getNeutralString());
                }
                if (select < 20)
                {
                    channel.sendMessage(author.getAsMention() + " " + EightBallUtil.getNoString());
                }
            } else
            {
                channel.sendMessage("```Rub the mystical 8ball!\nUsage: .8ball message```");
            }
        }
        if (command.toLowerCase().equals("uptime"))
        {
            channel.sendMessage("I have been online for\n" + UptimeUtil.getUptime());
        }
        if (command.toLowerCase().startsWith("say"))
        {
            if (command.length() > 3)
            {
                channel.sendMessage(command.substring(3));
            } else
            {
                channel.sendMessage("```Make the bot say something!\nUsage: .say message```");
            }
        }
        if (command.toLowerCase().startsWith("setgame"))
        {
            if (command.length() > 7)
            {
                if (command.substring(7) == "clear")
                {
                    channel.sendMessage("Game cleared.");
                    Supernova.jda.getAccountManager().setGame(null);
                    return;
                }
                channel.sendMessage("Game set to **" + command.substring(7) + "**");
                Supernova.jda.getAccountManager().setGame(command.substring(7));
            } else
            {
                channel.sendMessage("``Set the bots game.(clear to clear)\nUsage: .setgame <message>```");
            }

        }
        if (command.toLowerCase().equals("stats"))
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            int userCount = 0;
            int serverCount = 0;
            int textChannelCount = 0;
            int voiceChannelCount = 0;
            int privateChannelsCount = 0;
            int emojiCount = 0;
            String javaVersion = System.getProperty("java.version");

            userCount = Supernova.jda.getUsers().stream().map((_item) -> 1).reduce(userCount, Integer::sum);

            serverCount = Supernova.jda.getGuilds().stream().map((_item) -> 1).reduce(serverCount, Integer::sum);

            textChannelCount = Supernova.jda.getTextChannels().stream().map((_item) -> 1).reduce(textChannelCount, Integer::sum);

            voiceChannelCount = Supernova.jda.getVoiceChannels().stream().map((_item) -> 1).reduce(voiceChannelCount, Integer::sum);

            privateChannelsCount = Supernova.jda.getPrivateChannels().stream().map((_item) -> 1).reduce(privateChannelsCount, Integer::sum);

            channel.sendMessage("```python\n~~~~~~Supernova System Stats~~~~~\n"
                    + "Built by: "
                    + builtBy
                    + "\n"
                    + "Bot Version: "
                    + version
                    + " "
                    + versionName
                    + "\nUsers: "
                    + userCount
                    + "\nServers: "
                    + serverCount
                    + "\nText Channels: "
                    + textChannelCount
                    + "\nVoice Channels: "
                    + voiceChannelCount
                    + "\nPrivate Channels: "
                    + privateChannelsCount
                    + "\nJava Version: "
                    + javaVersion
                    + "\nDate and Time: "
                    + dateFormat.format(date)
                    +"\n~~~~~~~~~~~~~~~~~~~~~~~~~~"
                    + "\n```"
            );

        }
        if (command.toLowerCase().equals("shutdown"))
        {
            if (author.getUsername().equals("Lemon") && author.getId().equals("150094546527715329"))
            {
                channel.sendMessage("**dies**");
                Supernova.jda.shutdown();
            } else
            {
                channel.sendMessage("Only the bot owner(Lemon#4081) can use this command.");
            }
        }
        if (command.toLowerCase().equals("help"))
        {
            channel.sendMessage("```This bot is currently in BETA.\nExpect things to break.\n\nCommands:\n.uptime - Show the uptime.\n.8ball <message> - Rub the mystical 8ball.\n.rate <someone/something> - Rate someone or something.\n.say <message> - Make the bot say something.\n.setgame <game> Set the bot's game.\n.shutdown - Kill the bot.```");
        }
    }
}
