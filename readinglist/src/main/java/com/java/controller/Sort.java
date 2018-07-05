package com.java.controller;

/**
 * 冒泡排序
 * @author Future
 */
public class Sort {
    public static void main(String[] args) {
        int score[] = {67, 69, 63, 88};
        for(int i = 0 ; i<score.length ; i++){
            for(int j = 0; j<score.length -i-1;j++){
                System.out.println(score[j] + " "+ score[j+1]);
                if(score[j] < score[j+1]){
                    int temp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < score.length; i++) {
            int i1 = score[i];
            System.out.print(i1 + "     ");
        }
    }
}
