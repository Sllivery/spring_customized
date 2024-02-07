package com.luxness.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class AbstractResource implements Resource{
    @Override
    public boolean exists() {
        if (isFile()) {
            try {
                return getFile().exists();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            getInputStream().close();
            return true;
        }
        catch (Throwable ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isReadable() {
        return exists();
    }

    /**
     * This implementation always returns {@code false}.
     */
    @Override
    public boolean isFile() {
        return false;
    }

    /**
     * This implementation always returns {@code false}.
     */
    @Override
    public boolean isOpen() {
        return false;
    }

    /**
     * This implementation throws a FileNotFoundException, assuming
     * that the resource cannot be resolved to a URL.
     */
    @Override
    public URL getURL() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to URL");
    }

    @Override
    public File getFile() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to absolute file path");
    }

    @Override
    public String getFileName() {
        return null;
    }
}
