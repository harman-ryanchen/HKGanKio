package com.example.ryan.hkgankio.designpattern;


import android.os.Handler;
import android.os.Message;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 7/25/16.
 */
public class ElevatorController {

    Istate elevatorState = new CloseState();

    private static ElevatorController elevatorController;

    public static ElevatorController getInstance(){
        if (elevatorController==null){
            elevatorController = new ElevatorController();
        }
        return elevatorController;
    }

    public void setElevatorState(Istate state){
        this.elevatorState = state;
    }
    public boolean openDoor() {
        return elevatorState.openDoor();
    }

    public boolean closeDoor() {
        return elevatorState.closeDoor();
    }

    public boolean process() {
        return elevatorState.process();
    }
    public boolean processStop() {
        return elevatorState.procesStop();
    }
}
