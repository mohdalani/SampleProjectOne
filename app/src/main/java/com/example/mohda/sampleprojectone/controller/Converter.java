package com.example.mohda.sampleprojectone.controller;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;
import java.util.List;

/**
 * Created by mohda on 12/6/2017.
 */

public class Converter {
    public double position = 100;
    public double speed = 0;

    public void updatePosition(double time, boolean stop) {
        if (stop)
            speed = 0;
        else
            speed += time*9.81;

        position -= time * speed;
        if (position < 0)
            position = 0;
        if (position > 100)
            position = 100;
    }



    public double fromGtoKG(double value) {
        return value / 1000;
    }

    public double triangleArea(double a, double b, double c) throws BadTriangle {
        double p = (a + b + c) / 2;
        double value = p * (p - a) * (p - b) * (p - c);
        if (value < 0)
            throw new BadTriangle();
        return Math.sqrt(value);
    }

    @SuppressLint("NewApi")
    public List<Integer> sortList(List<Integer> param) {
        param.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                return (v1-v2);
            }
        });
        return param;
    }
 }
