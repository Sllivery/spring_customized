package com.luxness.io;

import java.io.IOException;
import java.io.InputStream;

public interface InputeStreamSource {
    InputStream getInputStream() throws IOException;
}
