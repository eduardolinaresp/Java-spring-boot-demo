/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consumerPriceIndex.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author ext_ealinares
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Rootobject {

    private String status;
    private int responseTime;
    private Object[] message;
    //   private ArrayList<Results> results;
    //  @JsonProperty("results")
    private Results results;

    public Rootobject() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public Object[] getMessage() {
        return message;
    }

    public void setMessage(Object[] message) {
        this.message = message;
    }

    // @JsonProperty("results")
    public Results getResults() {
        return results;
    }

    // @JsonProperty("results")
    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ClassRootobject [results = " + results + "]";
    }
//    public ArrayList<Results> getResults() {
//        return results;
//    }
//
//    public void setResults(ArrayList<Results>  results) {
//        this.results = results;
//    }

}
