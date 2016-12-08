package com.example.ryan.hkgankio.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.ryan.hkgankio.R;

/**
 * Created by studio02 on 11/24/16.
 */

public class CustomViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customview,null);
//        final SetPolyToPoly poly = (SetPolyToPoly) rootView.findViewById(R.id.poly);
//        RadioGroup group = (RadioGroup) rootView.findViewById(R.id.group);
//        assert group != null;
//        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (group.getCheckedRadioButtonId()){
//                    case R.id.point0: poly.setTestPoint(0); break;
//                    case R.id.point1: poly.setTestPoint(1); break;
//                    case R.id.point2: poly.setTestPoint(2); break;
//                    case R.id.point3: poly.setTestPoint(3); break;
//                    case R.id.point4: poly.setTestPoint(4); break;
//                }
//            }
//        });
        return rootView;

    }

}
