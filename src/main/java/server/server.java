package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/*
A class to have make a server for our application, which can be started using the terminal.
 */
public class server {

    public static void main(String[] args) throws IOException{
        connectToSever();
    }


   public static void connectToSever() throws IOException {
       try(ServerSocket serverSocket = new ServerSocket(9991)) {
           Socket connectionSocket = serverSocket.accept();
           InputStream inputToServer = connectionSocket.getInputStream();
           OutputStream outputFromServer = connectionSocket.getOutputStream();
           Scanner scanner = new Scanner(inputToServer, "UTF-8");
           PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);
           serverPrintOut.println("Hello! Your server works...");

           //This is the server logic. This defines when the server will be closed.
           boolean done = false;
           while (!done && scanner.hasNextLine()){
               String line = scanner.nextLine();
               serverPrintOut.println("Echo from <Your name Here> Server: " + line);
               if(line.toLowerCase().trim().equals("close")) {
                   done = true;
               }
           }
       }
       catch (IOException e){
           System.out.println("You have an IO Exception!");
           e.printStackTrace();
       }
   }




}
