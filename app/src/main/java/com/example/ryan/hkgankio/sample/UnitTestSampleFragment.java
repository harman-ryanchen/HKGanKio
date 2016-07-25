package com.example.ryan.hkgankio.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryan.hkgankio.R;
import com.orhanobut.logger.Logger;


/**
 * Created by ryan on 7/20/16.
 */
public class UnitTestSampleFragment extends Fragment {

    private int number = 0;

    public UnitTestSampleFragment() {
        super();
        Logger.d(getClass().getName(), "");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d(getClass().getName(), "");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d(getClass().getName(), "");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d(getClass().getName(), "");
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d(getClass().getName(), "");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(getClass().getName(), "");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d(getClass().getName(), "");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.d(getClass().getName(), "");
        View view = inflater.inflate(R.layout.fragment_unittest,null);
        number = getArguments().getInt("index");
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.d(getClass().getName(), "");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Logger.d(getClass().getName(), "");
    }

    /**
     * Static factory method that takes an int parameter,
     * initializes the fragment's arguments, and returns the
     * new fragment to the client.
     */
    public static UnitTestSampleFragment newInstance(int index) {
        UnitTestSampleFragment f = new UnitTestSampleFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    public int getNumber() {
        return number;
    }
}
