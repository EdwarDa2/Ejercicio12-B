package org.example;

public class Productos {
    private int id_producto;
    private String nombreProduc;
    private float precio; 
    private float precioBase; 
    private int mili;

    public Productos(int id_producto, String nombreProduc, float precioBase, int mili) {
        this.id_producto = id_producto;
        this.nombreProduc = nombreProduc;
        this.precioBase = precioBase;
        this.mili = mili;
        
        this.precio = aplicarDescuento(precioBase, mili);
    }

    public float aplicarDescuento(float precio, int mili) {
        
        if (mili >= 600) {
            float descuento = precio * 0.10f;
            System.out.println("\n Producto con 10% de descuento aplicado");
            return precio - descuento;
        }
        return precio;
    }


    public float getPrecio() {
        return precio;
    }

    public String getNombreProduc() {
        return nombreProduc;
    }

    public int getMili() {
        return mili;
    }

    @Override
    public String toString() {
        return "ID: " + this.id_producto + " | " +
                "Producto: " + this.nombreProduc + " " + this.mili + "ml | " +
                "Precio: $" + String.format("%.2f", this.precio);
    }
}