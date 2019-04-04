package mistacat.friendbot.commands.reactionCommands;

import mistacat.friendbot.Utils;
import mistacat.friendbot.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import org.json.JSONObject;

import java.awt.*;

public class bakaCommand extends Command {
    public bakaCommand() {
        setName("baka");
        setDescription("BAKAAAAAAAAAAAAAAAA");
    }

    @Override
    public void run(Message msg, String[] args) {

        JSONObject reaction = new JSONObject(Utils.readJsonURL("https://nekos.life/api/v2/img/baka"));
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.ORANGE);
        embed.setImage(reaction.getString("url"));

        msg.getChannel().sendMessage(embed.build()).queue();
    }
}
