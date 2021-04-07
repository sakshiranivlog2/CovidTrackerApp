package com.example.stateapi2.Model;

public class HelpModel {

    private String stateName;
    private String helpNo;


    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getHelpNo() {
        return helpNo;
    }

    public void setHelpNo(String helpNo) {
        this.helpNo = helpNo;
    }

    public HelpModel(String stateName, String helpNo) {
        this.stateName = stateName;
        this.helpNo = helpNo;
    }
}

