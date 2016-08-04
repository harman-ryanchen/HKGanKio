package com.example.ryan.hkgankio.designpattern.state;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;

/**
 * Created by ryan on 7/25/16.
 */
public class ActivityStatePattern extends Activity {


    public static int OPEN_THE_DOOR = 1;
    public static int CLOSE_THE_DOOR = 2;
    public static int PROCESS_THE_ELEVATOR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_pattern);
    }

    public void opendoor(View view) {
        if (ElevatorController.getInstance().openDoor()) {
            ElevatorController.getInstance().setElevatorState(new OpenState());
        }

    }

    public void closedoor(View view) {

        if (ElevatorController.getInstance().closeDoor())
            ElevatorController.getInstance().setElevatorState(new CloseState());
    }

    public void processelevator(View view) {
        if (ElevatorController.getInstance().process())
            ElevatorController.getInstance().setElevatorState(new ProcessState());
    }

    public void processstopelevator(View view) {
        if (ElevatorController.getInstance().processStop())
            ElevatorController.getInstance().setElevatorState(new StopProcessState());
    }
}
