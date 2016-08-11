package com.example.ryan.hkgankio.designpattern.visitor;

/**
 * Created by studio02 on 8/11/16.
 */
public abstract class Visitor {


    private String visitorName;

    public Visitor(String visitorName) {
        this.visitorName = visitorName;
    }

    abstract void manage(Cargo cargo);
}
