/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_lab1.Server;

/**
 *
 * @author student220
 */
public class Server_main {
    public static void main(String[] args) {
	System.out.println("Программа запущена в режиме сервера");
            while (true) {
		new Server();
		break;
            } 
    }
}
