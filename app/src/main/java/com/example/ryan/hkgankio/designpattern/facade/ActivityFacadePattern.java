package com.example.ryan.hkgankio.designpattern.facade;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.state.CloseState;
import com.example.ryan.hkgankio.designpattern.state.ElevatorController;
import com.example.ryan.hkgankio.designpattern.state.OpenState;
import com.example.ryan.hkgankio.designpattern.state.ProcessState;
import com.example.ryan.hkgankio.designpattern.state.StopProcessState;

/**
 * Created by ryan on 7/25/16.
 * <p/>
 * 模式的定义
 * <p/>
 * 外观模式(也成为门面模式)要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。它提供一个高层次的接口，使得子系统更易于使用。
 * <p/>
 * 模式的使用场景
 * <p/>
 * 在设计初期阶段，将不同的两个层分离；
 * 在开发阶段，子系统往往因为不断的重构演化而变得越来越复杂，大多数的模式使用时也都会产生很多很小的类，这本是好事，但也给外部调用它们的用户程序带来了使用上的困难，增加外观Facade可以提供一个简单的接口，减少它们之间的依赖。
 * 在维护一个遗留的大型系统时，可能这个系统已经非常难以维护和扩展了，但因为它包含非常重要的功能，新的需求开发必须依赖于它
 * <p/>
 * 优点与缺点
 * <p/>
 * 优点
 * <p/>
 * 使用方便，使用外观模式客户端完全不需要知道子系统的实现过程；
 * 降低客户端与子系统的耦合；
 * 更好的划分访问层次；
 * 缺点
 * <p/>
 * 减少了可变性和灵活性；
 * 在不引入抽象外观类的情况下，增加新的子系统可能需要修改外观类或客户端的源代码，违背了“开闭原则”；
 */
public class ActivityFacadePattern extends Activity {

    private AMTSystem amtSystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facade_pattern);
        amtSystem = new AMTSystem();
    }

    public void drawmoney(View view) {
        if (amtSystem != null) {
            amtSystem.drawMoney();
        }
    }

    public void transfermoney(View view) {
        if (amtSystem != null) {
            amtSystem.transferMoney();
        }
    }

    public void changepassword(View view) {
        if (amtSystem != null) {
            amtSystem.changePassword();
        }
    }
}
