package me.oxlemonxo.supernova;

import javax.security.auth.login.LoginException;
import me.oxlemonxo.supernova.listening.BotListener;
import me.oxlemonxo.supernova.listening.CommandListener;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.dv8tion.jda.entities.Guild;

public class Supernova
{

    public static JDA jda;

    public static void main(String[] args)
    {

        setupBot();
    }

    public static String setupBot()
    {
        try
        {
            jda = new JDABuilder()
                    .setBotToken("MjQ0NDMyNDk2MjUzNTk5NzQ0.Cv9fXw.IUP7ctxDQWTO1V3paGbeVTXk96Y")
                    .addListener(new BotListener())
                    .addListener(new CommandListener())
                    .buildBlocking();
            return "[Supernova] Supernova is starting..";

        } catch (Exception ex)
        {
            return "[Supernova] Supernova failed to start: " + ex.getMessage();
        }

    }
}
