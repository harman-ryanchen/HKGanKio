package com.example.ryan.hkgankio.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by studio02 on 8/11/16.
 */
public class Storage{

    private List<Cargo> cargoList = new ArrayList<>();

    public Storage() {
        cargoList.add(new CheeseCargo("cheese"));
        cargoList.add(new CheeseCargo("cheese1"));
        cargoList.add(new CheeseCargo("milk"));
        cargoList.add(new CheeseCargo("milk2"));
    }
    public void showConsumeBehaviour(Visitor visitor){
        for (Cargo c: cargoList){
            c.consume(visitor);
        }
    }
    public void showDeliverBehaviour(Visitor visitor){
        for (Cargo c: cargoList){
            c.produce(visitor);
        }
    }

}
