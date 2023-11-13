package com.luxness.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource extends AbstractResource{
    private final String path;
    private InputStream is;
    public ClassPathResource(String path) {
        this.path = path;
        this.is = ClassLoader.getSystemResourceAsStream(this.path);
    }

    @Override
    public boolean exists() {
        if (this.is == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getDescription() {
        return "class path resource [" + this.path + "]";
    }

    public InputStream getInputStream() throws IOException{
        if (exists()){
            return this.is;
        } else {
            throw new FileNotFoundException("Can't find " + this.path);
        }
    }


}
