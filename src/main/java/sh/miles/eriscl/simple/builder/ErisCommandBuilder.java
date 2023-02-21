package sh.miles.eriscl.simple.builder;

import java.util.List;

import org.bukkit.command.CommandSender;

import lombok.Builder.Default;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import sh.miles.eriscl.simple.ErisBukkitBridge;
import sh.miles.eriscl.simple.ErisCommand;
import sh.miles.eriscl.simple.ErisCompleter;
import sh.miles.eriscl.simple.ErisExecutor;
import sh.miles.eriscl.simple.ErisLabel;

@SuperBuilder
public class ErisCommandBuilder {

    protected ErisLabel label;
    @Default
    protected ErisExecutor nativeExecutor = (CommandSender sender, String[] args) -> true;
    @Default
    protected ErisCompleter nativeCompleter = (CommandSender sender, String[] args) -> List.of();
    @Singular
    protected List<ErisCommand> subcommands;

    public ErisCommand make() {
        if (label == null) {
            throw new IllegalStateException("Label cannot be null");
        }

        final ErisCommand command = new ErisCommand(this.label);
        command.setNativeExecutor(this.nativeExecutor);
        command.setNativeCompleter(this.nativeCompleter);

        for (ErisCommand entry : subcommands) {
            command.addSubcommand(entry);
        }

        return command;
    }

    public ErisCommand makeAndRegister() {
        final ErisCommand command = make();
        ErisBukkitBridge.register(new ErisBukkitBridge(command));
        return command;
    }

    public static ErisCommandBuilderBuilder<?, ?> of(ErisLabel label) {
        return ErisCommandBuilder.builder().label(label);
    }

    public static ErisCommandBuilderBuilder<?, ?> of(ErisLabelBuilder label) {
        return ErisCommandBuilder.builder().label(label.make());
    }
}
