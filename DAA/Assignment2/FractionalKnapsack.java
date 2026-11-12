//Knapsack

import java.util.*;
 
class Item {
    int weight;
    int profit;
    double ratio;
 
    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}
 
public class FractionalKnapsack {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
 
        Item[] items = new Item[n];
 
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = sc.nextInt();
 
            System.out.print("Enter profit of item " + (i + 1) + ": ");
            int profit = sc.nextInt();
 
            items[i] = new Item(weight, profit);
        }
 
        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();
 
        // Sort items by profit/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
 
        double totalProfit = 0.0;
        int remainingCapacity = capacity;
 
        System.out.println("\nItems selected:");
 
        for (int i = 0; i < n; i++) {
            if (remainingCapacity == 0)
                break;
 
            if (items[i].weight <= remainingCapacity) {
                // Take the complete item
                remainingCapacity -= items[i].weight;
                totalProfit += items[i].profit;
 
                System.out.println("Item " + (i + 1) +
                        ": 100% taken");
            } else {
                // Take the fractional part
                double fraction = (double) remainingCapacity / items[i].weight;
                totalProfit += items[i].profit * fraction;
 
                System.out.println("Item " + (i + 1) +
                        ": " + (fraction * 100) + "% taken");
 
                remainingCapacity = 0;
            }
        }
 
        System.out.println("\nMaximum Profit = " + totalProfit);
 
        sc.close();
    }
}