package dev.pyrrha.atme.fabric;

import dev.pyrrha.atme.common.Constants;
import net.fabricmc.api.ModInitializer;

public class AtMeFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Constants.LOG.info("fabric be loadin");
    }
}
