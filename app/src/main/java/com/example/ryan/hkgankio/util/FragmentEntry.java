package com.example.ryan.hkgankio.util;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.lang.ref.WeakReference;

/**
 * Fragment information used by SectionMgr to keep track of what fragments belong to which backstack entry.
 */
public class FragmentEntry {
    /**
     * Store the actual fragment as FragmentManager.getFragmentByTag() does not work until after the transaction has
     * been committed and sometimes we need the fragment before that has happened.
     * Also ensures we know exactly what fragment will be returned in case of identical HKBaseFragment.getTagname().
     */
    @NonNull
    private final WeakReference<Fragment> mFragment;
    @NonNull
    private final WeakReference<FragmentManager> mManager;
    private final String mBackstackTag;
    private final int mBackstackId;
    private final int mMusicServiceId;
    @IdRes
    private final int mContainerId;
    private final boolean mCallBackpressOnClear;

    public FragmentEntry(@NonNull Fragment fragment,
                         @NonNull FragmentManager manager,
                         String backstackTag,
                         int backstackId,
                         int musicServiceId,
                         @IdRes int containerId,
                         boolean callBackpressOnClear) {
        mFragment = new WeakReference<>(fragment);
        mManager = new WeakReference<>(manager);
        mBackstackTag = backstackTag;
        mBackstackId = backstackId;
        mMusicServiceId = musicServiceId;
        mContainerId = containerId;
        mCallBackpressOnClear = callBackpressOnClear;
    }

    @Nullable
    public Fragment getFragment() {
        return mFragment.get();
    }

    public String getBackstackTag() {
        return mBackstackTag;
    }

    public int getBackstackId() {
        return mBackstackId;
    }

    public int getMusicServiceId() {
        return mMusicServiceId;
    }

    public boolean isCallBackpressOnClear() {
        return mCallBackpressOnClear;
    }

    /**
     * @return true if the fragment is still valid, false if it has been detached.
     */
    public boolean isValid() {
        Fragment fragment = mFragment.get();
        return fragment != null && !fragment.isDetached();
    }

    @Override
    public String toString() {
//        ShortToStringStyle style = new ShortToStringStyle();
//        style.setUseClassName(false);
//        ToStringBuilder builder = new ToStringBuilder(this, style);
//        Fragment fragment = mFragment.get();
//        if (fragment != null) {
//            builder.append("fragment", fragment.getTag());
//        }
//        return builder
//                .append("backstackTag", mBackstackTag)
//                .append("backstackId", mBackstackId)
//                .toString();
        return "";
    }

    public int getContainerId() {
        return mContainerId;
    }

    @Nullable
    public FragmentManager getManager() {
        return mManager.get();
    }
}