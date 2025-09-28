package org.example;

import java.util.Scanner;

public class Compra {
    private Cajero cajero;
    private Productos productoSeleccionado;
    private int cantidad;
    private float subtotal;
    private float totalConIVA;
    private float iva;
    private final float TASA_IVA = 0.16f; // 16% de IVA

    // Constructor que recibe el cajero para la compra
    public Compra(Cajero cajero) {
        this.cajero = cajero;
    }

    public void registrarCompra(Productos[] productosDisponibles) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- INGRESO DE PRODUCTOS ---");
            System.out.println("Seleccione el producto comprado:");
            for (Productos p : productosDisponibles) {
                System.out.println(p);
            }
            System.out.print("Ingrese el ID del producto (1, 2 o 3): ");
            
            // Validar la opción
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= 3) {
                    this.productoSeleccionado = productosDisponibles[opcion - 1];
                } else {
                    System.out.println("ID no válido. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada inválida. Intente de nuevo.");
                opcion = 0;
            }
        } while (this.productoSeleccionado == null);

        System.out.print("Ingrese la cantidad a comprar: ");
        this.cantidad = sc.nextInt();
        
        // CÁLCULOS
        this.subtotal = this.cantidad * this.productoSeleccionado.getPrecio();
        this.iva = this.subtotal * TASA_IVA;
        this.totalConIVA = this.subtotal + this.iva;
        
        System.out.println("\n--- Venta registrada ---");
        System.out.println("Subtotal: $" + String.format("%.2f", this.subtotal));
        System.out.println("IVA (16%): $" + String.format("%.2f", this.iva));
        System.out.println("Total a pagar: $" + String.format("%.2f", this.totalConIVA));
    }

    // Método para generar y mostrar el ticket
    public void imprimirTicket() {
        Ticket ticket = new Ticket(this.cajero, this.productoSeleccionado, this.cantidad, this.subtotal, this.iva, this.totalConIVA);
        ticket.imprimir();
    }
}