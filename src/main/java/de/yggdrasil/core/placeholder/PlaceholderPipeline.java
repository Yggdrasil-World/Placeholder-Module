package de.yggdrasil.core.placeholder;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderPipeline {

    private final PlaceholderLibrary library = new PlaceholderLibrary();

    public String process(String input, Context context){
        for (String placeholder:
             this.findPlaceholders(input)) {
            Placeholder placeholderInstance = this.library.getPlaceholder(placeholder);
            input = input.replaceAll(placeholder, placeholderInstance.process(context));
        }
        return input;
    }

    private List<String> findPlaceholders(String input){
        List<String> result = new ArrayList<>();
        for (String s:
             input.split(" ")) {
            if (s.startsWith("$$")){
                result.add(s.substring(2));
            }
        }
        return result;
    }
}
