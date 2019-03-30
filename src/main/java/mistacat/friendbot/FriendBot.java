package mistacat.friendbot;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class FriendBot {
    public static JDA client;

    public static void main(String[] args) throws LoginException, InterruptedException {
        client = new JDABuilder("token goes here").build();

        client.awaitReady();
    }
}
