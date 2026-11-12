import java.util.Scanner;
 
public class FibonacciRecursive {
 
    static int stepCount = 0;
 
    static int fibonacci(int n) {
        stepCount++;  // Count each function call
 
        if (n == 0)
            return 0;
 
        if (n == 1)
            return 1;
 
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
 
        int result = fibonacci(n);
 
        System.out.println("Fibonacci number = " + result);
        System.out.println("Step Count = " + stepCount);
 
        sc.close();
    }
}





//Enter the value of n: 16
//Fibonacci number = 987
//Step Count = 45