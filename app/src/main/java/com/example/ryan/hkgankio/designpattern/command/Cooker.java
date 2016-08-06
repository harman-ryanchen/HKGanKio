package com.example.ryan.hkgankio.designpattern.command;

import com.orhanobut.logger.Logger;

import java.util.List;


/**
 * Created by studio02 on 8/5/16.
 * 接受者角色（Receiver）：Receiver是真正执行命令的对象。任何类都可能成为一个接收者，只要它能够实现命令要求实现的相应功能。
 */
public class Cooker {
    private List<DishBean> dishBeanList;

    public void setDishBeanList(List<DishBean> dishBeanList) {
        this.dishBeanList = dishBeanList;
    }

    /**
     * Receiver 执行方法
     */
    public void cookDish() {
        if (dishBeanList == null) return;
        for (DishBean db : dishBeanList) {
            if (!db.getFinish()) {
                db.setFinish(true);
                Logger.d("TEST_DESIGN_PATTERN dish name = %s, is finish = %s", db.getDishName(), db.getFinish());
            }
        }

    }

    /**
     * Receiver 撤销方法
     */
    public void undo(DishBean dishBean) {
        if (dishBeanList == null) return;
        for (DishBean db : dishBeanList) {
            if (!db.getFinish() && dishBeanList.contains(dishBean)) {
                dishBeanList.remove(dishBean);
                Logger.d("TEST_DESIGN_PATTERN undo dish name = %s, remove dish = %s", db.getDishName(), dishBean.getDishName());
            }
        }
    }

    /**
     * Receiver 更改方法
     *
     * @param olddishBean
     * @param newDishbean
     */
    public void redo(DishBean olddishBean, DishBean newDishbean) {
        if (dishBeanList == null) return;
        dishBeanList.set(dishBeanList.indexOf(olddishBean), newDishbean);
        for (DishBean db : dishBeanList) {
            Logger.d("TEST_DESIGN_PATTERN redo dish name = %s", db.getDishName());
        }
    }

}
