package com.practise.vishal;


import javax.swing.*;
import java.util.Arrays;

import static java.lang.Math.min;

public class MostWater {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int area=0;
        while(left<right){
            int min=min(height[left],height[right]);
            int sol=(right-left)*min;
            if(sol>area) area=sol;
            else if(height[left]<height[right]) left++;
            else if(height[right]<height[left]) right--;
            else if(height[left]==height[right]) {
                left++;
                right--;
            }
        }
        return area;
    }
}
