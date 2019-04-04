package mistacat.friendbot;

import lombok.Getter;
import mistacat.friendbot.commands.CommandHandler;
import mistacat.friendbot.commands.reactionCommands.bakaCommand;
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
        client = new JDABuilder("NTYxNTY5MDY1NDA4Mzk3MzE1.XJ-_eg.-Hhwaz2BxXgK65gwb71ZS5rag3c")
                .addEventListener(new FriendBot())
                .addEventListener(commandHandler)
                .build();

        client.awaitReady();
    }

    @Override
    public void onReady(ReadyEvent evt) {
        commandHandler.getCommands().add(new bakaCommand());
        System.out.println("Friend bot online!");
    }
}
