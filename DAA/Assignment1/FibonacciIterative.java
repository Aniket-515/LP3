import java.util.Scanner;
public class FibonacciIterative {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
 
        int a = 0, b = 1, c;
        int stepCount = 0;
 
        if (n == 0) {
            System.out.println("Fibonacci number = 0");
            stepCount = 1;
        }
        else if (n == 1) {
            System.out.println("Fibonacci number = 1");
            stepCount = 1;
        }
        else {
            for (int i = 2; i <= n; i++) {
                c = a + b;
                stepCount++;       // addition
                a = b;
                stepCount++;       // assignment
                b = c;
                stepCount++;       // assignment
            }
            System.out.println("Fibonacci number = " + b);
        }
        System.out.println("Step Count = " + stepCount);
        sc.close();
    }}







    //Enter the value of n: 5
//Fibonacci number = 5
//Step Count = 12