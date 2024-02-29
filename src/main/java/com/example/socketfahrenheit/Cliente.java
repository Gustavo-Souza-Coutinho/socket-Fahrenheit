package com.example.socketfahrenheit;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        double real = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura em Celcius:"));

        try( Socket conexao = new Socket("127.0.0.1", 40000)){

            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

            saida.writeObject(real);
            double fahrenheit = (double)entrada.readObject();

            JOptionPane.showMessageDialog(null,"A temperatura em Fahrenheit: " + fahrenheit);


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}