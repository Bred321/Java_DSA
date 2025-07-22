package Practices.Stacks;

import java.util.Stack;

public class BaseBallGame {
    public static void main(String[] args) {
        String[] operations = {"-52","-92","-70","C","+","26","17","+","17","+","-27","-46","73","D","+","D","-25","C","84","C"};
        BaseBallGame game = new BaseBallGame();
        int result = game.calPoints(operations);
        System.out.println("Total points: " + result); // Output: Total points: 30
    }

    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<operations.length;i++){
            String op=operations[i];

            if(op.equals("C")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(op.equals("D")){
                if(!stack.isEmpty()){
                    int last=stack.peek();
                    stack.push(2*last);
                }
            }
            else if(op.equals("+")){
                if(stack.size()>=0){
                    int top1=stack.pop();
                    int top2=stack.peek();
                    int sum=top1+top2;
                    stack.push(top1);
                    stack.push(sum);
                }
            }
            else{
                int val=Integer.parseInt(op);
                stack.push(val);
            }
        }

        int total=0;
        for (int i = 0; i < stack.size(); i++) {
            total += stack.get(i);  // access via index
        }

        return total;
    }
}
