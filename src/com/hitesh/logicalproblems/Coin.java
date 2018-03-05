package com.hitesh.logicalproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hiteshs on 2/28/18.
 */
public class Coin {

    public static void main(String[] args) {
        Map<Integer,Integer> coin= new HashMap<>();
        int arr[] = new int[]{3,1,10,9};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(x-> System.out.println(x));
        int length=arr.length;
        int arr1[]= new int[arr.length];
        int total= 3;
        for(int x=0;x<length;x++) {
            int result=cointest(arr,total);
            arr1[x]=result;
            arr=Arrays.copyOf(arr, arr.length-1);
        }
        System.out.println("****Minimum Coin:***** "+Arrays.stream(arr1).min().getAsInt());
    }
    public static int cointest(int arr[],int total){
        int arr1[]= new int[arr.length];
        int changes=0;
        for(int i=arr.length-1,k=0; i>=0;i--,k++){
            int mod=total%arr[i];
            if(mod==0){
                changes=total/arr[i];
                arr1[k]= changes;
                return changes;
            }
            else{
                int currentno=arr[i];
                changes=total/arr[i];
                int newtotal=mod;
                return changes+cointest(Arrays.stream(arr).filter(x->x!=currentno).toArray(),newtotal);

            }

        }
        return changes;
    }
}

