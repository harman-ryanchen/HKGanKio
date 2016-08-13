package com.example.ryan.hkgankio.designpattern.command;

/**
 * Created by studio02 on 8/5/16.
 * 命令角色（Command）：定义命令的接口，声明具体命令类需要执行的方法。这是一个抽象角色。
 *
 */
public interface IMenu {

    /**
     * 执行烹饪命令
     */
    void execute();

    /**
     * 撤销命令,这菜不要了
     */
    void undo();

    /**
     * 更改命令, 这菜改一下
     */
    void redo();
}
