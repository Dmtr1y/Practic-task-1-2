/*  16 option, task 2
 * Sylkin Dmytro student Nure KNT-21-4
 * email: dmytro.sylkin@nure.ua
 * Telegram: @d_ims
 * */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //зчитуємо з консолі дані і вносимо їх в змінну n
        System.out.println("Enter 'N': ");
        int n = scanner.nextInt();
        int[][] arr = new int[n + 15][n + 15];  //створимо массив (n+15)x(n+15)
        fill(arr, n);   //по черзі визиваємо методи для заповнення, виводу та сортування масиву
        System.out.println("--------------------Array filled random numbers--------------------");
        output(arr, n);
        sort(arr, n);
        System.out.println("----------------------------Sorted array---------------------------");
        output(arr, n);
    }

    /*
    * Заповнюємо масив випадковими числами від -N-15 до N+15
    * */
    static void fill(int[][] arr, int n){
        for (int i = 0; i < n + 15; i++){   //створимо цикл для перебору всих елементів масиву
            for(int j = 0; j < n + 15; j++) {
                Random rnd = new Random();  //використаємо Random
                arr[i][j] = rnd.nextInt(-n-15, n+15);
            }
        }
    }
    /*
    * Виводимо масив в консоль
    * */
    static void output(int [][] arr, int n){
        for (int i = 0; i < n + 15; i++){
            for(int j = 0; j < n + 15; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    /*
    * Метод для сортування масиву
    * */
    static void sort(int[][] arr, int n){
        int amount_num = (n + 15) * (n + 15);
        int[] flat = new int [amount_num]; //створимо новий масив щоб
        // записати в нього двовимірний масив як одновимірний

        int counter = 0;
        for (int i = 0; i < n + 15; i++){ //трансформуємо двовимірний в одновимірний масив
            for(int j = 0; j < n + 15; j++) {
                flat[counter++] = arr[i][j];
            }
        }

        Arrays.sort(flat);  // для того щоб використати метод Array.sort(),
        // нам потрібно передати йому одновимірний масив


        /*трансформуємо одновимірний масив в двовимірний, одночасно з цим
        *будемо записувати його у вигляді вертикальної змійки.
        *для цього використаємо залишок від ділення. У випадку парного числа
        * запишемо у двовимірний масив від більшого до меншого, якщо непарний,
        * то від меншого до більшого.
        * */
        counter = 0;
        for (int i = 0; i < n + 15; i++){
            if ((i % 2) == 0){
                for(int j = 0; j < n + 15; j++) {
                    arr[j][i] = flat[counter++];
                }
            }
            else{
                for(int j = (n + 15) - 1; j >= 0; j--) {
                    arr[j][i] = flat[counter++];
                }
            }
        }
    }
}

