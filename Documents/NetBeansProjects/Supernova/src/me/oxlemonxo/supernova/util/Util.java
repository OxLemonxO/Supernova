package me.oxlemonxo.supernova.util;

import java.util.regex.Pattern;
import me.oxlemonxo.supernova.Supernova;
import net.dv8tion.jda.entities.User;

public class Util
{

    private static final Pattern mentionUserPattern = Pattern.compile("<@!?([0-9]{4,})>");

    public static String replaceLast(final String text, final String regex, final String replacement)
    {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }

    public static boolean isUserMention(String input)
    {
        return mentionUserPattern.matcher(input).matches();
    }

    public static User getUserFromName(String name)
    {
        try
        {
            for (User u : Supernova.jda.getUsers())
            {
                if (u.getUsername().equalsIgnoreCase(name))
                {
                    return u;
                }
            }
        } catch (NullPointerException ex)
        {
            System.out.println("Strange! We are having problem with finding a user");
        }
        return null;
    }

    public static String targetMention(String name)
    {
        User u = getUserFromName(name);
        return u.getAsMention();
    }
}
