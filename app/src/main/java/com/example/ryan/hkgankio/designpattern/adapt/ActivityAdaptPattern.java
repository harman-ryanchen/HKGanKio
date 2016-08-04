package com.example.ryan.hkgankio.designpattern.adapt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.CloseState;
import com.example.ryan.hkgankio.designpattern.ElevatorController;
import com.example.ryan.hkgankio.designpattern.OpenState;
import com.example.ryan.hkgankio.designpattern.ProcessState;
import com.example.ryan.hkgankio.designpattern.StopProcessState;

/**
 * Created by ryan on 7/25/16.
 */
public class ActivityAdaptPattern extends Activity {


    private HarmanSpeakerPlayer harmanSpeakerPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapt_pattern);
        harmanSpeakerPlayer = new HarmanSpeakerPlayer();
    }

    public void playBt(View view) {
      harmanSpeakerPlayer.playBt();
    }

    public void playAux(View view) {
        harmanSpeakerPlayer.playAux();
    }

    public void playGoogleCast(View view) {
        harmanSpeakerPlayer.setJblPauseSpeaker(new JBLPauseSpeaker());
       harmanSpeakerPlayer.playGoogleCast();
    }

}
