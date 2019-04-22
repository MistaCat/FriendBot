package mistacat.friendbot.commands.generalCommands;

import lombok.Getter;
import mistacat.friendbot.commands.Command;
import mistacat.friendbot.commands.CommandType;
import net.dv8tion.jda.core.entities.Message;

/**
 * The help command!
 * Displays useful information to the user!
 */
@Getter
public class HelpCommand extends Command {
    public HelpCommand() {
        setName("help");
        setDescription("Lists commands!");
        setCommandType(CommandType.GENERAL);
    }

    @Override
    public void run(Message msg, String[] args) {

    }
}
