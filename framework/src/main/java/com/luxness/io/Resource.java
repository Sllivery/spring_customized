package com.luxness.io;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public interface Resource extends InputeStreamSource{
    /*
    我也不知道Resource需要干嘛

    所以把spring的代码搬过来之后，我不知道逻辑
    一个个研究一下？

    先研究AbstractResource
     */

    /**
     * 根据实现类的不同，逻辑不一样
     * @return
     */
    boolean exists();


    /**
     * 确定这个文件可不可读？//todo 不知道这个什么意思
     * @return
     */
    default boolean isReadable() {
        return exists();
    }

    /**
     * 是否打开？//todo 不知道这个有啥用
     * @return
     */
    default boolean isOpen() {return false;}


    /**
     * 也不知道这个有啥用
     * @return
     */
    default boolean isFile() {return false;}

    /**
     * 同上
     * @return
     * @throws IOException
     */
    URL getURL() throws IOException;

    /**
     * 同上
     * @return
     * @throws IOException
     */
    File getFile() throws IOException;

    String getDescription();

    String getFileName();
}
