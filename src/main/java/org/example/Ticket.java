package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private Cajero cajero;
    private Productos producto;
    private int cantidad;
    private float subtotal;
    private float iva;
    private float total;
    
    public Ticket(Cajero cajero, Productos producto, int cantidad, float subtotal, float iva, float total) {
        this.cajero = cajero;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public void imprimir() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");

        System.out.println("\n=======================================");
        System.out.println("    Abarrotes \"Los primos\"");
        System.out.println("    Suchiapa, Chiapas");
        System.out.println("---------------------------------------");
        System.out.println("    " + fechaActual.format(formato));
        System.out.println("    Atendido por: " + this.cajero.getNombreCompleto());
        System.out.println("---------------------------------------");
        
        System.out.printf("%-10s %-20s %-8s\n", "Cantidad", "Detalle de la compra", "Total");
        System.out.printf("%-10d %-20s %-8.2f\n", 
            this.cantidad, 
            this.producto.getNombreProduc() + " " + this.producto.getMili() + "ml",
            this.subtotal);
        
        System.out.println("---------------------------------------");
        System.out.printf("%-30s %-8.2f\n", "Subtotal", this.subtotal);
        System.out.printf("%-30s %-8.2f\n", "IVA 16%", this.iva);
        System.out.printf("%-30s %-8.2f\n", "Total", this.total);
        System.out.println("=======================================\n");
    }
}