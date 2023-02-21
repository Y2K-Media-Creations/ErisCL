package sh.miles.eriscl.simple.builder;

import java.util.List;

import lombok.Singular;
import lombok.experimental.SuperBuilder;
import sh.miles.eriscl.simple.ErisLabel;

@SuperBuilder
public class ErisLabelBuilder {

    protected String name;
    protected String permission;
    protected String description;
    protected String usage;
    @Singular
    protected List<String> aliases;

    public ErisLabel make() {
        final ErisLabel label = new ErisLabel(name, permission, aliases);
        if (usage != null) {
            label.setUsage(usage);
        }

        if (description != null) {
            label.setDescription(description);
        }

        return label;
    }

    public static ErisLabelBuilderBuilder<?, ?> of(String name) {
        return ErisLabelBuilder.builder().name(name);
    }

    public static ErisLabelBuilderBuilder<?, ?> of(String name, String permission) {
        return ErisLabelBuilder.builder().name(name).permission(permission);
    }

}
