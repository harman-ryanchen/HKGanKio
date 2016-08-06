package com.example.ryan.hkgankio.designpattern.command;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.designpattern.facade.AMTSystem;


/**
 * Created by ryan on 7/25/16.
 * 模式的定义
 * <p/>
 * 将一个请求封装成一个对象，从而使你可用不同的请求对客户进行参数化，对请求排队或记录请求日志，以及支持可撤销的操作。
 * <p/>
 * 模式的使用场景
 * <p/>
 * 系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
 * 系统需要在不同的时间指定请求、将请求排队和执行请求。
 * 系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作。
 * 系统需要将一组操作组合在一起，即支持宏命令。
 * 优点与缺点
 * <p/>
 * 优点
 * <p/>
 * 降低对象之间的耦合度。
 * 新的命令可以很容易地加入到系统中。
 * 可以比较容易地设计一个组合命令。
 * 调用同一方法实现不同的功能
 * 缺点
 * <p/>
 * 使用命令模式可能会导致某些系统有过多的具体命令类。因为针对每一个命令都需要设计一个具体命令类，因此某些系统可能需要大量具体命令类，这将影响命令模式的使用。
 * 比如上面的PeopleBean的属性增加，Receiver针对PeopleBean一个属性一个执行方法，一个Command的实现可以调用Receiver的一个执行方法，由此得需要设计多少个具体命令类呀！！
 */
public class ActivityCommandPattern extends Activity implements View.OnClickListener {

    private Waiter waiter;
    private CheckedTextView checkedTextView1, checkedTextView2, checkedTextView3, checkedTextView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_pattern);
        waiter = new Waiter();
        checkedTextView1 = (CheckedTextView) findViewById(R.id.boilingfish);
        checkedTextView2 = (CheckedTextView) findViewById(R.id.steambaozi);
        checkedTextView3 = (CheckedTextView) findViewById(R.id.shaoya);
        checkedTextView4 = (CheckedTextView) findViewById(R.id.xiaochaorou);

        checkedTextView1.setOnClickListener(this);
        checkedTextView2.setOnClickListener(this);
        checkedTextView3.setOnClickListener(this);
        checkedTextView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.shaoya) {
            if (checkedTextView3.isChecked()) {

            } else {

            }
        } else if (v.getId() == R.id.xiaochaorou) {

        } else if (v.getId() == R.id.boilingfish) {

        } else if (v.getId() == R.id.steambaozi) {

        }
    }
}
