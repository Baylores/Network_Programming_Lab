/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_lab1.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author student220
 */
public class Client {
    public static final int Port = 8282;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Socket socket;

	/**
	 * «апрашивает у пользовател€ ник и организовывает обмен сообщени€ми с
	 * сервером
	 */
	public Client() {
		//Scanner scan = new Scanner(System.in);

		try {
			// ѕодключаемс€ в серверу и получаем потоки(in и out) дл€ передачи сообщений
			socket = new Socket("127.0.0.1" , Port);
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
                        Matrix matr = Matrix.load("1.txt");
                        Matrix matr1 = Matrix.load("2.txt");
                        out.writeObject(matr);
                        out.writeObject(matr1);
                        //out.flush();
                        Matrix res =(Matrix) in.readObject();
                        Matrix.save(res, "3.txt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	/**
	 * «акрывает входной и выходной потоки и сокет
	 */
	private void close() {
		try {
			in.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			System.err.println("ѕотоки не были закрыты!");
		}
	}

	/**
	 *  ласс в отдельной нити пересылает все сообщени€ от сервера в консоль.
	 * –аботает пока не будет вызван метод setStop().
	 * 
	 */
	
}
