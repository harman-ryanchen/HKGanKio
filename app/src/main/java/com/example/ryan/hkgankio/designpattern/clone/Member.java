package com.example.ryan.hkgankio.designpattern.clone;

/**
 * Created by ryan on 8/13/16.
 * 原型模式:
 * 有两点优势:
 * 一: 如果是复杂性对象,clone可以使创建对象更高效
 * 二: 起到保护作用,如对象只可读性的,被clone的对象无论如何修改都不会影响到原型.
 */
public class Member implements Cloneable{

    @Override
    protected Object clone() {
        Member member = null;
        try {
            member = (Member) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return member;
    }

    private String name;
    private int level;

    public Member(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
