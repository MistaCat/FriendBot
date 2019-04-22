package mistacat.friendbot.commands.reactionCommands;

import mistacat.friendbot.Utils;
import mistacat.friendbot.commands.Command;
import mistacat.friendbot.commands.CommandType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import org.json.JSONObject;

import java.awt.*;

/**
 * A simple baka reaction command
 */
public class BakaCommand extends Command {
    public BakaCommand() {
        setName("baka");
        setDescription("BAKAAAAAAAAAAAAAAAA");
        setCommandType(CommandType.REACTIONS);
    }

    @Override
    public void run(Message msg, String[] args) {

        //Creates a json object so that we can read information from the website.
        JSONObject reaction = new JSONObject(Utils.readJsonURL("https://nekos.life/api/v2/img/baka"));

        //Creates a new class to create an embed text box in discord!
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.ORANGE);

        //Set the image from our JSONObject named "reaction" by using the getString method and using the a key.
        //This key will return the string in our json file that matches the key we put in which is "url" for the image link.
        embed.setImage(reaction.getString("url"));

        //Send the message to whatever channel the command msg was sent to.
        //use the queue method when sending so jda will automatically handle sending too many requests!
        msg.getChannel().sendMessage(embed.build()).queue();
    }
}
