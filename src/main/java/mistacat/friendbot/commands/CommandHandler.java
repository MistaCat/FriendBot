package mistacat.friendbot.commands;

import lombok.Getter;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
public class CommandHandler extends ListenerAdapter {
    private ArrayList<Command> commands = new ArrayList<>();
    private static final String PREFIX = "*";

    /**
     * A method to get a command out of our commands list through lambda.
     * The commands are looped through 1 at a time and if the command name is equal to what a player has sent then it will return that command
     * Otherwise it will return null which means it does not exist.
     * @param name
     * @return
     */
    private Command getCommand(final String name) {
        return commands.stream().filter(cmd -> cmd.getName().equalsIgnoreCase(name)).findAny().orElse(null);
    }

    /**
     * Handles command parsing.
     * Checks if the message is from a person and starts with the prefix
     * Then uses some string methods to get the name of command and the arguments for it.
     * Finally theres a check to see if our command is in the command list for handling. If it is then we run that command.
     * @param evt
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent evt) {
        if (evt.getAuthor().isBot() || !evt.getMessage().getContentRaw().startsWith(PREFIX)) {
            return;
        }

        String[] split = evt.getMessage().getContentRaw().split(" ");
        String name = split[0].replace(PREFIX, "");
        String[] args = Arrays.copyOfRange(split, 1, split.length);

        if (getCommand(name) != null) {
            getCommand(name).run(evt.getMessage(), args);
        }
    }

    /**
     * Adds a command into the list of commands for handling.
     * @param newCmd
     */
    public void addCommand(Command newCmd) {
        commands.add(newCmd);
    }
}
