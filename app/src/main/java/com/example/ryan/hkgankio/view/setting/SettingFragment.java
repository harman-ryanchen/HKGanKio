package com.example.ryan.hkgankio.view.setting;

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
public class SettingFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setToolBarInfo(new ToolBarInfo.Builder().setToolBarContentText("SettingFragment").build());
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }
}
