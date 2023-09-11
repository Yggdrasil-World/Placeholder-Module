package de.yggdrasil.core.placeholder;

@FindPlaceholder
public interface Placeholder {

    public String process(Context context);

    public String getIdentifier();

}
