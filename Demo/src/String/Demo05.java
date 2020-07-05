package String;

import java.util.ArrayList;
import java.util.Scanner;
public class Demo05 {
    ArrayList<Integer> list=new ArrayList<Integer>();
    int []number={1,12,43,12,13,12,43};
    public void inputList(){ //将这些数字添加到集合里面
        for(int i=0;i<number.length;i++){
            list.add(number[i]);
        }
    }
    public int getAmount(Integer i){ //计算输入数字的个数
        int amount=0;
        while(list.remove(i)){
            amount++;
        }
        return amount;
    }
    public static void main(String o[]){
        Demo05 yourAnswer=new Demo05();
        yourAnswer.inputList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number:");
        int getInput=sc.nextInt();    //输入一个数字
        int amount=yourAnswer.getAmount(getInput);
        System.out.println("The amount of "+getInput+" in the list is "+amount);
    }
}