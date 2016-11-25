package com.example.ryan.hkgankio.view.slideshow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.util.ToolBarInfo;
import com.example.ryan.hkgankio.view.MainActivity;

/**
 * Created by studio02 on 4/29/16.
 */
public class SlideshowFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setToolBarInfo(new ToolBarInfo.Builder().setToolBarContentText("SlideshowFragment").build());
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        view.findViewById(R.id.detail_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return view;
    }
}
