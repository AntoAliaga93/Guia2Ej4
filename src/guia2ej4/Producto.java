/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia2ej4;

/**
 *
 * @author Anto
 */
public class Producto implements Comparable<Producto> {
    
    private int codigo;
    private String descripcion;
    private double precio;
    private int stock;
    private Rubro rubro;

    public Producto(int codigo, String descripcion, double precio, int stock, Rubro rubro) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.rubro = rubro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    @Override
    public int compareTo(Producto producto) {
       if(codigo==producto.codigo){
           return 0;
       }else if(codigo<producto.getCodigo()){
           return -1;
       }else{
           return 1;
       }
    }
    
    
}
