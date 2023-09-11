package de.yggdrasil.core.placeholder;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;

public class PlaceholderLibrary {

    private final HashMap<String, Placeholder> placeholderHashMap = new HashMap<>();

    public PlaceholderLibrary(){
        this.addPlaceholders(PlaceholderCollector.collect());
    }

    public Placeholder getPlaceholder(String placeholder) {
        return this.placeholderHashMap.get(placeholder);
    }

    public void addPlaceholders(Set<Class<Placeholder>> placeholders){
        for (Class<Placeholder> p:
             placeholders) {
            try {
                Placeholder placeholder = p.getDeclaredConstructor().newInstance();
                placeholderHashMap.put(placeholder.getIdentifier(), placeholder);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

}
