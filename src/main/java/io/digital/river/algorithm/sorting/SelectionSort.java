package com.example.demo;

/**
*
*https://www.toptal.com/developers/sorting-algorithms 
*https://sadanandpai.github.io/sorting-visualizer/dist/
https://www.geeksforgeeks.org/sorting-algorithms/?ref=lbp#Basic
https://visualgo.net/en/sorting
*/
public class SelectionSort {

	public static void main(String[] args){
		int arr[] = {64, 25, 12, 22, 11};
		int n = arr.length;
		for(int i= 0; i<n -1; i++){
			int minIndex = i;
			for (int j = i; j< n ; j++){
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			swap(arr, minIndex, i);
		}
		for (int x : arr){
			System.out.print(x + ",");
		}
	}

	public static void swap(int arr[], int minIndex, int swapIndex ){
		 int temp =  arr[minIndex];
		 arr[minIndex] = arr[swapIndex];
		 arr[swapIndex] = temp;
	}

}
