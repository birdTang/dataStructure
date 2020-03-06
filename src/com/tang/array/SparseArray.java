package com.tang.array;

/**
 * 稀疏数组
 * @ate 2020年3月6日
 * @author Administrator
 */
public class SparseArray {

	public static void main(String[] args) {
		int[][] oldArrs = new int[11][11];
		oldArrs[0][2] = 1;
		oldArrs[1][3] = 2;
		oldArrs[2][1] = 2;
		printArr(oldArrs);
		
		/**
		 * 1、计算原数组的有效值
		 */
		int sum=0;
		for(int i=0;i<oldArrs.length;i++) {
			for(int j=0;j<oldArrs[i].length;++j) {
				if(oldArrs[i][j]!=0) sum++;
			}
		}
		System.out.println("===========================================");
		//定义稀疏数组
		int[][] sparseArr = new int[sum+1][3];

		sparseArr[0][0] = oldArrs.length;
		sparseArr[0][1] = oldArrs.length;
		sparseArr[0][2] = sum;
		//转化为稀疏数组
		int index = 1;
		for(int i=0;i<oldArrs.length;i++) {
			for(int j=0;j<oldArrs[i].length;++j) {
				if(oldArrs[i][j]!=0) {
					sparseArr[index][0] = i;
					sparseArr[index][1] = j;
					sparseArr[index][2] = oldArrs[i][j];
					index++;
				}
			}
		}
		printArr(sparseArr);
		System.out.println("===========================================");
		
		//稀疏数组转换为原数组
		int[][] newArr = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		for(int i=1;i<sparseArr.length;i++) {
			newArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2]; 
		}
		
		printArr(newArr);
	}
	
	public static void printArr(int[][] arrs) {
		for(int i=0;i<arrs.length;i++) {
			for(int j=0;j<arrs[i].length;++j) {
				System.out.printf("%d\t", arrs[i][j]);
			}
			System.out.println();
		}
	}
}