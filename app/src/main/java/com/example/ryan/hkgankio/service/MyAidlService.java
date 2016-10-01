package com.example.ryan.hkgankio.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.example.ryan.hkgankio.IMyAidlInterface;
import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 9/28/16.
 */
public class MyAidlService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBind();
    }

    class MyBind extends IMyAidlInterface.Stub {
        private String name;
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getName() throws RemoteException {
            return "Test the AIDL name";
        }

        @Override
        public void setName(String name) throws RemoteException {
            this.name = name;
            Logger.d("TEST_AIDL name = %s",name);
        }
    }

}
