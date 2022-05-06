package dev.pyrrha.atme.quilt;

import dev.pyrrha.atme.common.Constants;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class AtMeQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        Constants.LOG.info("quilt be loadin");
    }
}
