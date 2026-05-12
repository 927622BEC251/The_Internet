package com.internetbot.utils;

import java.net.URISyntaxException;
import java.nio.file.Path;

public final class FileUtil {
    private FileUtil() {
    }

    public static Path resourcePath(String resourceName) {
        try {
            return Path.of(FileUtil.class.getClassLoader().getResource(resourceName).toURI());
        } catch (URISyntaxException exception) {
            throw new IllegalStateException("Invalid resource path: " + resourceName, exception);
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException("Resource not found: " + resourceName, exception);
        }
    }
}
