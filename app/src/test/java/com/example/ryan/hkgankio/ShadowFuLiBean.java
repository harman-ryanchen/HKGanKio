package com.example.ryan.hkgankio;

import com.example.ryan.hkgankio.bean.FuLiBean;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * Created by ryan on 7/21/16.
 */
@Implements(FuLiBean.class)
public class ShadowFuLiBean {

    @Implementation
    public String getName(){
        return "FuliBean";
    }
}
