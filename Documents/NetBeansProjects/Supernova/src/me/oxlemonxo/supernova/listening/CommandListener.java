package me.oxlemonxo.supernova.listening;

import me.oxlemonxo.supernova.commands.Command;
import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.TextChannel;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter
{

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if(event.getMessage().getContent().contains("┻━┻")) {
            TextChannel channel = event.getTextChannel();            
            channel.sendMessage("ヘ(´° □°)ヘ┳━┳ PLEASE STOP FLIPPING THE FUCKING TABLES!"); 
        }
        if (event.getMessage().getContent().startsWith(".") && !event.getMessage().getAuthor().getId().equals(event.getJDA().getSelfInfo().getId()))
        {
            TextChannel channel = event.getTextChannel();
            Message message = event.getMessage();
            User author = event.getAuthor();

            String command = message.getContent().substring(".".length());
            Command.runCommand(channel, command, author);
        }
    }
}
