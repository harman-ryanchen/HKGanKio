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
        cargoList.add(new CheeseCargo("cheese"));
        cargoList.add(new CheeseCargo("cheese"));
        cargoList.add(new CheeseCargo("cheese"));
    }
}
