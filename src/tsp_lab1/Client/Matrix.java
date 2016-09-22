/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_lab1.Client;

import tsp_lab1.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 *
 * @author Home
 */
public class Matrix implements Serializable{
    private double[][] matrix;
    private int height, weight;
    
    public Matrix (int height, int weight){
        this.matrix = new double[height][weight];
        this.height = height;
        this.weight = weight;
        for(int i=0; i<height;i++){
            for(int j=0;j<weight;j++){
                this.matrix[i][j] = 0;
            }
        }
    }
    
    public Matrix (int height, int weight, double[][] Matr){
        this.matrix = new double[height][weight];
        this.height = height;
        this.weight = weight;
        for(int i=0; i<height;i++){
            for(int j=0;j<weight;j++){
                this.matrix[i][j] = Matr[i][j];
            }
        }
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public double getElement(int x, int y){
        double res = matrix[x][y];
        return res;
    }
    
    public void setElement(int x, int y, double insert){
        this.matrix[x][y] = insert;
    }
    
    public static Matrix sum(Matrix matr1, Matrix matr2){
        Matrix res = new Matrix(matr1.getHeight(), matr1.getWeight());
        for(int i=0; i<matr1.getHeight();i++){
            for(int j=0;j<matr1.getWeight();j++){
                res.setElement(i, j, (matr1.getElement(i, j) + matr2.getElement(i, j)));;
            }
        }
        return res;
    }
    
    public static void save(Matrix matr,String filename){
        File file = new File(filename);
    try {
        if(!file.exists()){
            file.createNewFile();
        }
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        out.print(matr.getHeight()+" "+matr.getWeight()+" " + '\n');
        try {
            for(int i=0;i<matr.getHeight();i++){
                for(int j=0;j<matr.getWeight();j++){
                    out.print(matr.getElement(i, j) + " ");
                }
            out.print('\n');
            }
        } finally {
            out.close();
        }
    } catch(IOException e) {
        throw new RuntimeException(e);
    }
    }
    
    public static Matrix load(String filename) throws FileNotFoundException, IOException{
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String c = br.readLine();
        String[] s = c.split(" ");
        Matrix matr = new Matrix(new Integer(s[0]),new Integer(s[1]));
        for(int i = 0;i<matr.getHeight();i++){
            c = br.readLine();
            String[] s1 = c.split(" ");
            for(int j = 0 ;j<matr.getWeight();j++){
                matr.setElement(i, j,new Double(s1[j]));
            }
        }
        return matr;
    }
}
