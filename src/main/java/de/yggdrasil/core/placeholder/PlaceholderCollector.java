package de.yggdrasil.core.placeholder;

import org.reflections.Reflections;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PlaceholderCollector {

    public static Set<Class<Placeholder>> collect(){
        Reflections reflections = new Reflections("de.yggdrasil");
        return reflections.getTypesAnnotatedWith(FindPlaceholder.class).stream()
                .filter(Placeholder.class::isAssignableFrom)
                .filter(aClass -> Arrays.stream(aClass.getConstructors()).anyMatch(constructor -> constructor.getParameterCount() == 0))
                .map(aClass -> (Class<Placeholder>) aClass)
                .collect(Collectors.toUnmodifiableSet());
    }

}
