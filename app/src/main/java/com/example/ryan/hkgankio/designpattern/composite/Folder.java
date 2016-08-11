package com.example.ryan.hkgankio.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by studio02 on 8/11/16.
 */
public class Folder implements Dir{

    private List<Dir> dirList = new ArrayList<>();

    public void addFile(Dir dir){
        dirList.add(dir);
    }

    @Override
    public void removeFile(Dir dir) {
        dirList.remove(dir);
    }
    @Override
    public void print() {
        for (Dir d: dirList){
            d.print();
        }
    }
}
