/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_lab1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author overl
 */
public class TSP_lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int i,j;
        System.out.println("Введите число строк:");
        i = sc.nextInt();
        System.out.println("Введите число столбцов:");
        j = sc.nextInt();
        Matrix matr = new Matrix(i,j);
        System.out.println("Введите элементы матрицы:");
        for(int m=0;m<matr.getHeight();m++){
            for(int n=0;n<matr.getWeight();n++){
                matr.setElement(m, n, sc.nextDouble());
            }
        }
        System.out.println("Введите имя файла для записи:");
        String filename = sc.next();
        Matrix.save(matr, filename);
        
        Matrix matr1 = Matrix.load(filename);
        Matrix matr2 = Matrix.sum(matr, matr1);
        for(int m=0;m<matr2.getHeight();m++){
            for(int n=0;n<matr2.getWeight();n++){
                System.out.println(matr2.getElement(m, n));
            }
        }
    }
    
}
