package sh.miles.eriscl.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * ErisLabel represents a command label.
 * <p>
 * A command label tells the server and client how to identify the command the
 * label is associated with. Every executor must be associated with a label.
 * otherwise the server will have no way to know when to execute the command
 * code.
 */
@Getter
public final class ErisLabel {

    private static final String DEFAULT_DESCRIPTION = "A Command Created with ErisCL created by Y2K_ currently in version 1.0.0-SNAPSHOT";

    private final String name;
    private final String permission;
    @Setter
    private String description;
    @Setter
    private String usage;
    private final List<String> aliases;

    public ErisLabel(String name, String permission, String description, List<String> aliases) {
        this.name = name;
        this.permission = permission;
        this.description = description;
        this.usage = "/" + name;
        this.aliases = new ArrayList<>(aliases);
    }

    public ErisLabel(String name, String permission, String... aliases) {
        this(name, permission, DEFAULT_DESCRIPTION, Arrays.asList(aliases));
    }

    public ErisLabel(String name, String permission, List<String> aliases) {
        this(name, permission, DEFAULT_DESCRIPTION, aliases);
    }

    public ErisLabel(String name, String permission) {
        this(name, permission, DEFAULT_DESCRIPTION, new ArrayList<>());
    }

}
