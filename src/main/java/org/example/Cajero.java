package org.example;

import java.util.Scanner;

public class Cajero {
    private String nombre;
    private String apellidoP;

    public Cajero(String nombre, String apellidoP) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidoP;
    }

    public static Cajero registrarCajero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Bienvenido, listo para cobrar---");
        System.out.println("-Por favor de registrarse-");
        System.out.println("Ingrese el nombre del cajero:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del cajero:");
        String apellidoP = sc.nextLine();
        
        System.out.println("\nRegistro exitoso: " + nombre + " " + apellidoP);
        return new Cajero(nombre, apellidoP);
    }
}