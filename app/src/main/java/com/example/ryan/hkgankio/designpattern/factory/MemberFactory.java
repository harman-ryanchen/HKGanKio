package com.example.ryan.hkgankio.designpattern.factory;

/**
 * Created by studio02 on 8/5/16.
 */
public class MemberFactory implements Factory{

    @Override
    public <T extends Member> T createMember(Class<T> tClass) {
        Member member = null;
        try {
            member = (Member) Class.forName(tClass.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) member;
    }
}
