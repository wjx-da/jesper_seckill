package com.liko.demo01;

public class Binary_Search {
    public static void main(String[] args) {
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch1(arr, 100);
        System.out.println(index);
    }
//Ñ­»·¶þ·Ö
    private static int binarySearch1(int[] arr, int i) {
        int target=0;
        int beg=0;
        int end=arr.length-1;
        while (beg<=end){
           int mid=(beg+end)/2;
           if(i==arr[mid]){
                return mid;
           }else if(i<arr[mid]){
               end=mid-1;
           }else {
               beg=mid+1;
           }
        }
        return -1;
    }
}
