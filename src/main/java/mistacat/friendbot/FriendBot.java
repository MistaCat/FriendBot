package mistacat.friendbot;

import lombok.Getter;
import mistacat.friendbot.commands.CommandHandler;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

@Getter
public class FriendBot extends ListenerAdapter {
    public static JDA client;
    public static CommandHandler commandHandler = new CommandHandler();

    public static void main(String[] args) throws LoginException, InterruptedException {
        client = new JDABuilder("token goes here")
                .addEventListener(new FriendBot())
                .addEventListener(commandHandler)
                .build();

        client.awaitReady();
    }

    @Override
    public void onReady(ReadyEvent evt) {
        System.out.println("Friend bot online!");
    }
}
