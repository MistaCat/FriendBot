package mistacat.friendbot;

import lombok.Getter;
import mistacat.friendbot.commands.CommandHandler;
import mistacat.friendbot.commands.reactionCommands.bakaCommand;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

/**
 * Main class for FriendBot
 * Everything is started here in the main method.
 */

@Getter
public class FriendBot extends ListenerAdapter {
    public static JDA client;
    public static CommandHandler commandHandler = new CommandHandler();

    public static void main(String[] args) throws LoginException, InterruptedException {

        //Creates a new jda client for the bot
        client = new JDABuilder("NTYxNTY5MDY1NDA4Mzk3MzE1.XJ-_eg.-Hhwaz2BxXgK65gwb71ZS5rag3c")
                .addEventListener(new FriendBot())
                .addEventListener(commandHandler)
                .build();

        //Stops things from passing into the bot until a connection is secured and everything is good.
        client.awaitReady();
    }

    /**
     * The ready event. When the bot first starts up and logs in anything in the code block will run.
     * @param evt
     */
    @Override
    public void onReady(ReadyEvent evt) {
        commandHandler.addCommand(new bakaCommand());
        System.out.println("Friend bot online!");
    }
}
