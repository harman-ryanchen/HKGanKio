package com.example.ryan.hkgankio.designpattern.composite;

/**
 * Created by studio02 on 8/11/16.
 */
public interface Dir {

    void print();
    void addFile(Dir dir);
    void removeFile(Dir dir);
}
