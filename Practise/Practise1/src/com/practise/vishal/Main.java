package com.practise.vishal;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        int[] height={1,2,1};
        MostWater area=new MostWater();
        int val=area.maxArea(height);
        System.out.println(reverse(1534236469));

    }

    public static int reverse(int x) {
        String sol="";
        int val=Math.abs(x);
        String newVal=""+val;
        for(int i=newVal.length()-1;i>=0;i--){
            sol+=newVal.charAt(i);
        }
        try {
            int value = Integer.parseInt(sol);
            value = x < 0 ? -value : value;
            return value;
        }
        catch (NumberFormatException e){
            return 0;
        }
    }
}