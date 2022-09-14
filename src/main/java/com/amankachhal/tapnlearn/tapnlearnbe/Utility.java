package com.amankachhal.tapnlearn.tapnlearnbe;

public class Utility {
    public static int genRandomInt(int min,int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
