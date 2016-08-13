package com.example.ryan.hkgankio.designpattern.composite;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/11/16.
 */
public class TextFile implements Dir{
    @Override
    public void print() {
        Logger.d("TEST_DESIGN_PATTERN --->我是JPG文件");
    }

    @Override
    public void addFile(Dir dir) {
        throw new NoSuchFieldError();
    }

    @Override
    public void removeFile(Dir dir) {
        throw new NoSuchFieldError();
    }
}
