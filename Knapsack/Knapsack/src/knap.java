import java.util.Scanner;
import java.util.Arrays;

public class knap {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the capacity of the knapsack");
        int size = input.nextInt();
        System.out.println("Enter the total number of items");
        int numItems = input.nextInt();
        int[][] items = new int[numItems][2];
        int[][] sack = new int[numItems][size + 1];
        for (int i = 0; i < numItems; i++) {
            System.out.println("Enter the value for object " + (i + 1));
            items[i][0] = input.nextInt();
            System.out.println("Enter the weight for object " + (i + 1));
            items[i][1] = input.nextInt();
        }
        System.out.println(Arrays.deepToString(items));
        for (int i = 0; i < numItems; i++) {
            for (int j = 0; j < size + 1; j++) {
                // If fits first part
                if (items[i][1] <= j) {
                    // If on item 1
                    if (i == 0) {
                        sack[i][j] = items[0][0];
                    } else {
                        // If not first item
                        if (j != 0) {
                            if (sack[i - 1][j - items[i][1]] + items[i][0] > sack[i - 1][j]) {
                                sack[i][j] = sack[i - 1][j - items[i][1]] + items[i][0];
                            } else {
                                sack[i][j] = sack[i - 1][j];
                            }
                        } else {
                            sack[i][j] = items[i][0];
                        }
                    }
                }
            }
        }
        System.out.println("Maximum value: " + sack[numItems - 1][size]);
    }
}
