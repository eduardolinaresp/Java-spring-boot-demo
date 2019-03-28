/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consumerPriceIndex.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

/**
 *
 * @author ext_ealinares
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {
    
    private String seriesID;
    private ArrayList<Datum> data;
    public String getSeriesID() {
        return seriesID;
    }

    public Series() {
    }

    public void setSeriesID(String seriesID) {
        this.seriesID = seriesID;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }
    
}
