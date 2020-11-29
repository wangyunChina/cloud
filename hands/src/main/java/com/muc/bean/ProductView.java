package com.muc.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductView extends Product implements Serializable  {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> imageArray;

    public ArrayList<String> getImageArray() {
        return imageArray;
    }

    public void setImageArray(ArrayList<String> imageArray) {
        this.imageArray = imageArray;
    }
}
