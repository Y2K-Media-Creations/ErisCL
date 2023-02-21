package sh.miles.eriscl.simple;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * A Functional Interface that represents a completer for an ErisCommand. This
 * is different from the Bukkit completer "TabCompleter" which contains a String
 * label. This is prone to be abused by beginners who tend to not separate their
 * code. This is why ErisCL prefers to use this interface.
 */
@FunctionalInterface
public interface ErisCompleter {

    /**
     * Acts as a completer for an ErisCommand.
     * 
     * @param sender the sender of the command
     * @param args   all arguments associated with the command
     * @return a list of possible completions
     */
    List<String> complete(CommandSender sender, String[] args);

    static List<String> empty() {
        return List.of();
    }

    static List<String> intRange(int min, int max, int step) {
        List<String> list = new ArrayList<>();
        for (int i = min; i <= max; i += step) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    static List<String> doubleRange(double min, double max, double step) {
        List<String> list = new ArrayList<>();
        for (double i = min; i <= max; i += step) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    static List<String> onlinePlayers() {
        List<String> list = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            list.add(player.getName());
        }
        return list;
    }

}
