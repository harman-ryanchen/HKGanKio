package com.example.ryan.hkgankio.designpattern.command;

import com.orhanobut.logger.Logger;

import java.util.List;


/**
 * Created by studio02 on 8/5/16.
 * 接受者角色（Receiver）：Receiver是真正执行命令的对象。任何类都可能成为一个接收者，只要它能够实现命令要求实现的相应功能。
 */
public class Cooker {

    /**
     * Receiver 执行方法
     * @param dishBeen 菜单里的菜
     */
    public void cookDish(List<DishBean> dishBeen){
        for (DishBean db : dishBeen){
            if (!db.getFinish()){
                db.setFinish(true);
                Logger.d("TEST_DESIGN_PATTERN dish name = %s, is finish = %s",db.getDishName(),db.getFinish());
            }
        }

    }

    /**
     * Receiver 撤销方法
     * @param dishBeen
     * @param index
     */
    public void undo(List<DishBean> dishBeen, int index){

    }
}
