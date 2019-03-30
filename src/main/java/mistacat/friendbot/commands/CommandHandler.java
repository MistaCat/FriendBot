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

    private Command getCommand(final String name) {
        return commands.stream().filter(cmd -> cmd.getName() == name).findAny().orElse(null);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent evt) {
        if (evt.getAuthor().isBot() || evt.getMessage().getContentRaw().startsWith(PREFIX)) {
            return;
        }

        String[] split = evt.getMessage().getContentRaw().split(" ");
        String name = split[0].replace(PREFIX, "");
        String[] args = Arrays.copyOfRange(split, 1, split.length);

        if (getCommand(name) != null) {
            getCommand(name).run(evt.getMessage(), args);
        }
    }
}
