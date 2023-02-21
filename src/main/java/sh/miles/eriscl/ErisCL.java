package sh.miles.eriscl;

import lombok.NonNull;
import sh.miles.eriscl.simple.ErisBukkitBridge;
import sh.miles.eriscl.simple.ErisCommand;
import sh.miles.eriscl.simple.ErisLabel;
import sh.miles.eriscl.simple.builder.ErisCommandBuilder;
import sh.miles.eriscl.simple.builder.ErisCommandBuilder.ErisCommandBuilderBuilder;
import sh.miles.eriscl.simple.builder.ErisLabelBuilder;
import sh.miles.eriscl.simple.builder.ErisLabelBuilder.ErisLabelBuilderBuilder;

public final class ErisCL {

    private ErisCL() {
    }

    public static void register(@NonNull final ErisCommand command) {
        ErisBukkitBridge.register(new ErisBukkitBridge(command));
    }

    public static void unregister(@NonNull final String commandName) {
        ErisBukkitBridge.unregister(commandName);
    }

    @SuppressWarnings("unchecked")
    public static <C extends ErisCommandBuilder, B extends ErisCommandBuilder.ErisCommandBuilderBuilder<C, B>> ErisCommandBuilderBuilder<C, B> command(
            @NonNull final ErisLabel label) {
        return (ErisCommandBuilderBuilder<C, B>) ErisCommandBuilder.of(label);
    }

    @SuppressWarnings("unchecked")
    public static <C extends ErisCommandBuilder, B extends ErisCommandBuilder.ErisCommandBuilderBuilder<C, B>> ErisCommandBuilderBuilder<C, B> command(
            @NonNull final ErisLabelBuilder label) {
        return (ErisCommandBuilderBuilder<C, B>) ErisCommandBuilder.of(label);
    }

    @SuppressWarnings("unchecked")
    public static <C extends ErisLabelBuilder, B extends ErisLabelBuilder.ErisLabelBuilderBuilder<C, B>> ErisLabelBuilderBuilder<C, B> label(
            @NonNull final String name) {
        return (ErisLabelBuilderBuilder<C, B>) ErisLabelBuilder.of(name);
    }

    @SuppressWarnings("unchecked")
    public static <C extends ErisLabelBuilder, B extends ErisLabelBuilder.ErisLabelBuilderBuilder<C, B>> ErisLabelBuilderBuilder<C, B> label(
            @NonNull final String name, @NonNull final String permission) {
        return (ErisLabelBuilderBuilder<C, B>) ErisLabelBuilder.of(name, permission);
    }

}
