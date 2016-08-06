package com.example.ryan.hkgankio.designpattern.command;

import android.util.SparseArray;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by studio02 on 8/5/16.
 * 调用者角色（Invoker）：负责调用命令对象执行请求，通常会持有命令对象（可以持有多个命令对象）。Invoker是Client真正触发命令并要求命令执行相应操作的地方（使用命令对象的入口）。
 */
public class Waiter {

    private Menu menu = new Menu();
    private List<DishBean> dishBeanList = new ArrayList<>();


    public void orderDish(DishBean dishBean) {
        dishBeanList.add(dishBean);
    }

    public void execute() {
        menu.setDishBeens(dishBeanList);
        menu.execute();
        dishBeanList.clear();
    }

    public void undo(DishBean dishBean) {
        menu.undo(dishBean);
    }

    public void redo(DishBean oldDishBean, DishBean newDishBean) {
        menu.redo(oldDishBean,newDishBean);
    }

}
