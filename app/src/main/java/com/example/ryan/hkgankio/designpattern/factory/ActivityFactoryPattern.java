package com.example.ryan.hkgankio.designpattern.factory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.facade.AMTSystem;

/**
 * Created by ryan on 7/25/16.
 */
public class ActivityFactoryPattern extends Activity {

    private MemberFactory memberFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facade_pattern);
        memberFactory = new MemberFactory();
    }

    public void ironmember(View view) {
        IronMember ironMember = memberFactory.createMember(IronMember.class);
        ironMember.bath();
        ironMember.consume();
        ironMember.reCharge();
    }

    public void goldmember(View view) {
       GoldMember goldMember = memberFactory.createMember(GoldMember.class);
        goldMember.bathWithMan();
        goldMember.reCharge();
        goldMember.consume();
    }

    public void diamondmember(View view) {
       DiamondMember diamondMember = memberFactory.createMember(DiamondMember.class);
        diamondMember.consume();
        diamondMember.reCharge();
        diamondMember.bathWithPrettyGirl();
    }
}
