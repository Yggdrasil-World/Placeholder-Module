package de.yggdrasil.core.placeholder;

import de.yggdrasil.core.localisation.LocalisationAPI;
import net.minestom.server.entity.Player;

public class PlaceholderAPI {

    private static final PlaceholderPipeline PIPELINE = new PlaceholderPipeline();
    private static final LocalisationAPI LOCALISATION_API = new LocalisationAPI();

    public String process(String input, Player player){
        return PIPELINE.process(input, this.createContext(player));
    }

    private Context createContext(Player player){
        return new Context(player, LOCALISATION_API.getPlayerLocale(player));
    }

}
