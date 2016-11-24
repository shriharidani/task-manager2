package com.example.shrihari.navbar.DataObject;

/**
 * Created by Shrihari on 11/6/2016.
 */
public class dataObject {
    boolean completed = false;
    String name;
    public dataObject(String name,boolean completed){
        this.name = name;
        this.completed = completed;
    }


    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }
}
