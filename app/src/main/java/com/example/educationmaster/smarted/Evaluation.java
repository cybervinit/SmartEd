package com.example.educationmaster.smarted;

import java.util.Date;

/**
 * Created by Vishwa on 1/8/2017.
 */

public class Evaluation {
    private String evalName;
    private int evalweight;
    private Date evaldate;

    public Evaluation(String evalName, int evalweight, Date evaldate){
        this.evalName = evalName;
        this.evalweight = evalweight;
        this.evaldate = evaldate;
    }
    public void addEvaluation(String evalName, int evalweight){
        this.evalName = evalName;
        this.evalweight = evalweight;
        this.evaldate = evaldate;
    }


}
