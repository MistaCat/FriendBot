package mistacat.friendbot.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This is an enum of command types.
 * We set commands to this type to easily sort what kind of command it is!
 */

@Getter @AllArgsConstructor
public enum CommandType {
    GENERAL("General"),
    REACTIONS("Reaction");

    String name;
}
