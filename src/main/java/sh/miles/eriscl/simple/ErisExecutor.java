package sh.miles.eriscl.simple;

import org.bukkit.command.CommandSender;

import lombok.NonNull;

/**
 * A Functional Interface that represents an executor for an ErisCommand. This
 * is different from the Bukkit exector "CommandExecutor" which contains a
 * String label. This is prone to be abused by beginners who tend to not
 * separate their code. This is why ErisCL prefers to use this interface.
 */
@FunctionalInterface
public interface ErisExecutor {

    /**
     * Acts as an exector for an ErisCommand.
     * 
     * @param sender the sender of the command
     * @param args   all arguments associated with the command
     * @return true if the command was succesfully executed otherwise false
     */
    boolean execute(@NonNull final CommandSender sender, @NonNull final String[] args);

}
