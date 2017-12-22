package com.sahabatdeveloper.bayes;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahabat Developer on 21/09/2017.
 */

public class Helper extends Application{
    private ArrayList<Model> listTable = new ArrayList<>();

    public ArrayList<Model> getListTable() {
        return listTable;
    }

    public void setListTable(ArrayList<Model> listTable) {
        this.listTable = listTable;
    }
}
