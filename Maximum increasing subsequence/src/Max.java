/* This program has the user enter an array and the size of the array.
 * It will then find the Maximum increasing subset and print the path in reverse order.
 */

import java.util.Scanner;

public class Max {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();
        int[][] arr = new int[size][3];
        // Array Input
        System.out.println("Enter the numbers inside of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i][0] = input.nextInt();
        }
        // Set the first input number to point to -1 and length 1
        arr[0][1] = 1;
        arr[0][2] = -1;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                // If the j's number < i's number and j's length >= i's length
                if (arr[j][0] < arr[i][0] && arr[j][1] >= arr[i][1]) {
                    arr[i][1] = arr[j][1] + 1;
                    arr[i][2] = j;
                }
            }
            // If the length is still 0 set length to 1 and pointer to -1
            if (arr[i][1] == 0) {
                arr[i][1] = 1;
                arr[i][2] = -1;
            }
        }
        int longest = 0;
        int holder = 0;
        for (int i = 0; i < size; i++) {
            if (longest < arr[i][1]) {
                longest = arr[i][1];
                holder = i;
            }
        }
        System.out.println("Path to get to the maximum subset in reverse order: ");
        while (true) {
            System.out.print(arr[holder][0] + ", ");
            if (arr[holder][2] != -1) {
                holder = arr[holder][2];
            } else {
                break;
            }
        }
    }
}