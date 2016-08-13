package com.example.ryan.hkgankio.designpattern.facade;

/**
 * Created by studio02 on 8/5/16.
 */
public class AMTSystem {

    private ChangePasswordSystem changePasswordSystem;
    private DrawMoneySystem drawMoneySystem;
    private TransferMoneySystem transferMoneySystem;

    public AMTSystem() {
       changePasswordSystem = new ChangePasswordSystem();
        drawMoneySystem = new DrawMoneySystem();
        transferMoneySystem = new TransferMoneySystem();
    }
    public void changePassword(){
        if (changePasswordSystem!=null){
            changePasswordSystem.ChangePassword();
        }
    } public void drawMoney(){
        if (drawMoneySystem!=null){
          drawMoneySystem.drawMoney();
        }
    } public void transferMoney(){
        if (transferMoneySystem!=null){
            transferMoneySystem.transferMoney();
        }
    }
}
