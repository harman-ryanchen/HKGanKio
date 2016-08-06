package com.example.ryan.hkgankio.designpattern.factory;

/**
 * Created by ryan on 8/6/16.
 */
public interface Factory {
    public abstract <T extends Member> T createMember(Class<T> tClass);
}
