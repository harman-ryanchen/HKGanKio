package com.example.ryan.hkgankio.designpattern.adapt;

import com.orhanobut.logger.Logger;

/**
 * Created by studio02 on 8/4/16.
 * Android 设计模式之 适配者模式
 * 又分类适配和对象适配, HarmanOnyxSpeaker作类适配, JBLPauseSpeaker作对象适配
 * 当需求需要更多功能时,而现有的接口不满足需求时,而适配者模式就适用在这里.
 * 或者类似Listview的adapter一样当某些需求不确定时,可以把Adapter抛出来让用户来实现,然后接收定义好的数据和布局即可.
 */
public class HarmanSpeakerPlayer extends HarmanOnyxSpeaker implements HarmanSpeaker{

    private JBLPauseSpeaker jblPauseSpeaker;

    public void setJblPauseSpeaker(JBLPauseSpeaker jblPauseSpeaker) {
        this.jblPauseSpeaker = jblPauseSpeaker;
    }
    public  void playGoogleCast(){
        if (jblPauseSpeaker!=null){
            jblPauseSpeaker.playGoogleCast();
        }
    }

    @Override
    public void playAux() {
        Logger.e("Harman speaker all can play Aux","TEST_DESIGN_PATTERN");
    }

    @Override
    public void playBt() {
        super.playBt();
    }
}
