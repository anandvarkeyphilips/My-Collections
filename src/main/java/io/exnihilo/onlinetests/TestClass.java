package io.exnihilo.onlinetests;/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNumber = Integer.parseInt(br.readLine());
        
        for(int i=0;i<testNumber;i++){
            String[] inputCond = br.readLine().split(" "); 
            int n = Integer.parseInt(inputCond[0]);
            int k = Integer.parseInt(inputCond[1]);
            
            String[] stringArray = br.readLine().split(" "); 
            int[] intArray = new int[k];
            for(int j=0;j<n;j++){
                intArray[j] = Integer.parseInt(stringArray[j]);
            }
            
            for(int j=0;j<n;j++){
                intArray[j] = Integer.parseInt(stringArray[j]);
            }
            
        }
        


    }
}
