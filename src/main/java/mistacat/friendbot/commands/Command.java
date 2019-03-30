package mistacat.friendbot.commands;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;

/**
 * The basic class for a command!
 */
@Getter @Setter
public abstract class Command {
    private String name;
    private String description;

    public abstract void run(Message msg, String[] args);

    public MessageEmbed getInfo() {
        EmbedBuilder msg = new EmbedBuilder();
        msg.setTitle("Error!");
        msg.setDescription("This command does not have any information!");
        return msg.build();
    }
}
