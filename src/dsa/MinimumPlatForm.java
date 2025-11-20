package dsa;

import java.util.Arrays;

public class MinimumPlatForm {
    public static void main(String[] args) {
        //Given an array of train arrival and departure timing at a railway station, calculate the number of platforms required to
        //manage all the train arrivals and departures.
        int[][] trainTimings = new int[][]{{600, 700}, {630, 820}, {1200, 1500}};
        //expected answer is : 2
        int n = findMinimumNumberOfPlatform(trainTimings);
        System.out.println("Minimum Number Of Platform required is " + n);
    }

    private static int findMinimumNumberOfPlatform(int[][] trainTimings) {
       int n= trainTimings.length;

        int[] arrivalsTimes= new int[n];
        int[] departuresTime= new int[n];

         for(int i=0 ;i<n; i++){
             arrivalsTimes[i]= trainTimings[i][0];
             departuresTime[i]= trainTimings[i][1];
         }

         Arrays.sort(arrivalsTimes);
         Arrays.sort(departuresTime);

         int i=0,j=0;
         int platformCount=0;
         int maxPlatform=0;

         while(i<n && j<n){

             if(arrivalsTimes[i] <= departuresTime[j]){
                 platformCount++;
                 i++;
             }
             else{
                 platformCount--;
                 j++;
             }

             maxPlatform = Math.max(maxPlatform,platformCount);
         }

     return maxPlatform;
    }
}
