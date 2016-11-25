package com.example.ryan.hkgankio.designpattern.composite;

import android.app.Activity;
import android.os.Bundle;

import com.example.ryan.hkgankio.R;

/**
 * Created by ryan on 7/25/16.
 */
public class ActivityCompositePattern extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composite_pattern);
        Dir dir = new Folder();
        dir.addFile(new TextFile());
        dir.addFile(new JpgFile());
        dir.print();

    }


}
