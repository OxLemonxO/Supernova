package me.oxlemonxo.supernova.listening;

import net.dv8tion.jda.events.DisconnectEvent;
import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.ReconnectedEvent;
import net.dv8tion.jda.events.ShutdownEvent;
import net.dv8tion.jda.events.StatusChangeEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter
{

    @Override
    public void onReady(ReadyEvent event)
    {
        System.out.println("[Supernova] Supernova is ready!");
        return;
    }

    @Override
    public void onDisconnect(DisconnectEvent event)
    {
        System.out.println("[Supernova] Supernova has disconnected.");
        return;
    }

    @Override
    public void onReconnect(ReconnectedEvent event)
    {
        System.out.println("[Supernova] Supernova has reconnected.");
        return;
    }

    @Override
    public void onShutdown(ShutdownEvent event)
    {
        System.out.println("[Supernova] Supernova is shutting down..");
        return;
    }

    @Override
    public void onStatusChange(StatusChangeEvent event)
    {
        System.out.println("[Supernova] Status has been changed to: " + event.getStatus().toString());   
    }
}
