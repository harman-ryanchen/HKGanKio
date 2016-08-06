package com.example.ryan.hkgankio.designpattern.command;

import java.util.List;

/**
 * Created by studio02 on 8/5/16.
 * 具体命令角色（ConcreteCommand）：命令接口的具体实现对象，通常会持有接收者，并调用接收者的功能来完成命令要执行的操作。
 */
public class Menu implements IMenu {
    private Cooker cooker;
    private List<DishBean> dishBeens;
    private int tableNum;

    public void setDishBeens(List<DishBean> dishBeens) {
        this.dishBeens = dishBeens;
        cooker.setDishBeanList(dishBeens);
    }

    public Menu() {
        cooker = new Cooker();
    }

    public Menu(int tableNum) {
        this.tableNum = tableNum;
        cooker = new Cooker();
    }

    @Override
    public void execute() {
        if (dishBeens!=null){
            cooker.cookDish();
        }
    }

    @Override
    public void undo(DishBean dishBean) {
        if (dishBeens!=null){
            cooker.undo(dishBean);
        }
    }

    @Override
    public void redo(DishBean olddishBean, DishBean newdishBean) {
        if (dishBeens!=null){
            cooker.redo(olddishBean,newdishBean);
        }
    }


}
