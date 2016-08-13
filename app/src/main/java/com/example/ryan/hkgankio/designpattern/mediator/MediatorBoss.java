package com.example.ryan.hkgankio.designpattern.mediator;

/**
 * Created by ryan on 8/9/16.
 */
public class MediatorBoss implements Mediator{
    private ColleagueDeveloper colleagueDeveloper;
    private ColleagueTestteam colleagueTestteam;
    private ColleagueUI colleagueUI;

    @Override
    public void pushJob(Colleague colleague) {
        if (colleague instanceof ColleagueUI){
            colleagueDeveloper.workJob();
        }else if (colleague instanceof ColleagueDeveloper){
            colleagueTestteam.workJob();
        }else if (colleague instanceof ColleagueTestteam){
            colleagueDeveloper.fixBugs();
        }
    }

    public void setColleagueDeveloper(ColleagueDeveloper colleagueDeveloper) {
        this.colleagueDeveloper = colleagueDeveloper;
    }

    public void setColleagueTestteam(ColleagueTestteam colleagueTestteam) {
        this.colleagueTestteam = colleagueTestteam;
    }

    public void setColleagueUI(ColleagueUI colleagueUI) {
        this.colleagueUI = colleagueUI;
    }
}
