/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_lab1.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import tsp_lab1.Matrix;
/**
 *
 * @author overl
 */


public class SerialServer implements Runnable{

    Socket socket;

    SerialServer(Socket socket) {
        this.socket = socket;
    }
    
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(5334)){
            while (true) {
                Socket sock = ss.accept();
                new Thread(new SerialServer(sock)).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(SerialServer.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public void run() {
        try(ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()) ;
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())){
            
            Matrix matr = null;
            Matrix matr1 = null;
            Matrix res = null;
            System.out.println("SERVER: reading data from the client");
            matr =(Matrix) ois.readObject();
            matr1 = (Matrix) ois.readObject();
            System.out.println("SERVER: reading data from the client:Success!");
            res = Matrix.sum(matr, matr1);
            System.out.println("SERVER: sending data to the client");
            oos.writeObject(res);
            System.out.println("SERVER: sending data to the client:Success!");
            oos.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(SerialServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerialServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
