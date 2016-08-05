package com.example.ryan.hkgankio.designpattern.command;

/**
 * Created by studio02 on 8/5/16.
 * 辅助类
 */
public class DishBean {
    private String dishName;
    private Boolean isFinish;

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }


    public String getDishName() {
        return dishName;
    }

    public Boolean getFinish() {
        return isFinish;
    }

    public void setFinish(Boolean finish) {
        isFinish = finish;
    }
}
