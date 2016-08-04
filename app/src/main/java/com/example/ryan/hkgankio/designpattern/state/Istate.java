package com.example.ryan.hkgankio.designpattern.state;

/**
 * Created by ryan on 7/25/16.
 */
public interface Istate {

    boolean openDoor();
    boolean closeDoor();
    boolean process();
    boolean procesStop();
}
