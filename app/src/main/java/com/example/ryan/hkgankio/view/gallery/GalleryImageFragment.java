package com.example.ryan.hkgankio.view.gallery;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryan.hkgankio.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by studio02 on 5/3/16.
 */
public class GalleryImageFragment extends Fragment {


    public static GalleryImageFragment newInstance(String imageUrl) {
        GalleryImageFragment f = new GalleryImageFragment();

        Bundle args = new Bundle();
        args.putString("imageUrl", imageUrl);
        f.setArguments(args);
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery_image, container, false);
        SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.gallery_big_image);
        String imaUrl = getArguments().getString("imageUrl");
        draweeView.setImageURI(Uri.parse(imaUrl));
        return view;
    }
}
