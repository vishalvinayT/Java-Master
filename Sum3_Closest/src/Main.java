import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int sum=threeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(sum);
    }
    public static int threeSumClosest(int[] nums, int target) {
        int maxval=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    maxval=Math.abs(maxval-target)>Math.abs(sum-target)?  sum:maxval;
                }
            }
        }
        return maxval;
    }

}