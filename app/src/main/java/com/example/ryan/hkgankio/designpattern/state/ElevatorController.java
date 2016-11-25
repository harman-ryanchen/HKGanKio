package com.example.ryan.hkgankio.designpattern.state;


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
