package dev.pyrrha.atme.quilt.platform;

import dev.pyrrha.atme.common.platform.services.IPlatformHelper;
import org.quiltmc.loader.api.QuiltLoader;

public class QuiltPlatformHandler implements IPlatformHelper {
    @Override
    public String getPlatformName() {
        return "Quilt";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return QuiltLoader.isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return QuiltLoader.isDevelopmentEnvironment();
    }
}
