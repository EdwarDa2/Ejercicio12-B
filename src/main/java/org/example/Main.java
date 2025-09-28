package org.example;

public class Main {
    public static void main(String[] args) {
        
        Productos[] productos = new Productos[3];
        productos[0] = new Productos(1, "Mi refresco", 8f, 235);
        productos[1] = new Productos(2, "Mi refresco", 12f, 500);
        productos[2] = new Productos(3, "Mi refresco", 13f, 600); 


        System.out.println("\n--- LISTA DE PRODUCTOS Y PRECIOS FINALES ---");
        for (Productos producto : productos) {
            System.out.println(producto);
        }
        System.out.println("--------------------------------------------");

        
        Cajero cajeroActual = Cajero.registrarCajero();
        
        Compra nuevaCompra = new Compra(cajeroActual);
        nuevaCompra.registrarCompra(productos);
        
       
        nuevaCompra.imprimirTicket();
    }
}