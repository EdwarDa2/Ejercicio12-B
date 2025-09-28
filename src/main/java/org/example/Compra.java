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
        int opcion = 0;

        do {
            System.out.println("\n--- INGRESO DE PRODUCTOS ---");
            System.out.println("Seleccione el producto comprado:");
            for (Productos p : productosDisponibles) {
                System.out.println(p);
            }

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
        this.subtotal = this.cantidad * this.productoSeleccionado.getPrecioBase();
        this.iva = this.subtotal * TASA_IVA;
        this.totalConIVA = this.subtotal + this.iva;

        if (opcion == 3) {
            System.out.println("\n--Se aplica un descuento del 10%!--");
            float montoDelDescuento = this.subtotal * 0.10f;
            this.subtotal = this.subtotal - montoDelDescuento;
        } else {
            System.out.println("\nNo se aplica un descuento.");
        }
        System.out.println("\n--- Venta registrada ---");
        System.out.println("Subtotal: $" + String.format("%.2f", this.subtotal));
        System.out.println("IVA (16%): $" + String.format("%.2f", this.iva));
        System.out.println("Total a pagar: $" + String.format("%.2f", this.totalConIVA));
    }

    public void imprimirTicket() {
        Ticket ticket = new Ticket(this.cajero, this.productoSeleccionado, this.cantidad, this.subtotal, this.iva, this.totalConIVA);
        ticket.imprimir();
    }
}