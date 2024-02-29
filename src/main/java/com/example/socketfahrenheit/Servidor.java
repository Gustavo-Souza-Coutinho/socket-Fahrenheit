package com.example.socketfahrenheit;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(40000)) {
            while(true){
                try (Socket conexao = servidor.accept();
                     ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
                     ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream())) {

                    double celcius = (double)entrada.readObject();
                    double fahrenheit = (celcius * 1.8) + 32;
                    saida.writeObject(fahrenheit);
                }

            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}