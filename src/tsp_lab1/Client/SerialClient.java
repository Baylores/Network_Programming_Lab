/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_lab1.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import tsp_lab1.Matrix;

/**
 *
 * @author student220
 */
public class SerialClient {
    public static void main(String[] args) throws ClassNotFoundException {
        String input1 = "input1.txt";//args[0];
        String input2 = "input2.txt";//args[1];
        String output = "output.txt";//args[2];
        
        
        try(Socket socket = new Socket("127.0.0.1", 5334);//localhost
            //PrintWriter out = new PrintWriter(new FileWriter(output));
            //BufferedReader in1 = new BufferedReader(new FileReader(input1));
            //BufferedReader in2  = new BufferedReader(new FileReader(input2)); 
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());    
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
            
            Matrix matr = Matrix.load(input1);
            Matrix matr1 = Matrix.load(input2);

            oos.writeObject(matr);
            oos.flush();
            oos.writeObject(matr1);
            oos.flush();
            
            Matrix res = null;
            res =(Matrix)ois.readObject();
            Matrix.save(res, output);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: localhost.");
            System.exit(1);
        }
    }
}
