package mistacat.friendbot.commands;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;

/**
 * The basic class for a command!
 * Your commands will extend this class which means every command inherits these methods and variables
 * So when you have many different types of commands they all share a common root.
 */
@Getter @Setter
public abstract class Command {
    private String name;
    private String description;

    /**
     * Every command you make will override this method.
     * This is what we call when a command is handled through our command handler.
     * So when a command is sent anything in this method will run!
     * @param msg
     * @param args
     */
    public abstract void run(Message msg, String[] args);

    /**
     * Returns an embed of the command information!
     * Can be used for any command that inherits this class!
     * @return
     */
    public MessageEmbed getInfo() {
        EmbedBuilder msg = new EmbedBuilder();
        msg.setTitle(name);
        msg.setDescription(description);
        return msg.build();
    }
}
