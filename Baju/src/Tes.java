/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Muhammad Prasasta
 */
public class Tes {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int jumlah = sc.nextInt();
        int[] arrJml = new int[jumlah];
        for(int i=0; i<jumlah; i++){
            arrJml[i] = sc.nextInt();
        }
        CountBaju kokon = new CountBaju();
        kokon.sort(arrJml);
        String hasil = kokon.jumlah(kokon.getFix());
        System.out.print(hasil);
    }
}

class CountBaju {
    
    private int[] fix;
    
    private void mergeSort(int[] arr, int left,int right){
        if(left<right){
            int mid = (left+right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr,left,mid,right);
        }
    }
    
    private void merge(int[] arr, int left, int mid, int right){
        int lSize = mid - left + 1;
        int rSize = right - mid;
        int[] arrL = new int[lSize+1];
        int[] arrR = new int[rSize+1];
        
        for(int i=0; i<lSize; i++){
            arrL[i] = arr[left+i];
        }
        
        for(int i=0; i<rSize; i++){
            arrR[i] = arr[mid+1+i];
        }
        
        arrR[rSize] = Integer.MAX_VALUE;
        arrL[lSize] = Integer.MAX_VALUE;
        int idxR=0;
        int idxL=0;
        
        for(int i=left; i<=right; i++){
            if(arrL[idxL] <= arrR[idxR]){
                arr[i] = arrL[idxL];
                idxL++;
            }
            else{
                arr [i] = arrR[idxR];
                idxR++;
            }
        }
        this.fix = arr;
        
    }
    
    public void sort(int[]arr){
        mergeSort(arr, 0, arr.length-1);
    }
    
    public int[] getFix(){
        return this.fix;
    }
    
    public String jumlah(int[] arr){
        String res = "";
        int temp = 0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == arr[i+1]){
                temp++;
            }
            else 
                res+= arr[i]+"("+temp+")"+" ";
                temp=0;
        }
        return res;    
    }
}
   