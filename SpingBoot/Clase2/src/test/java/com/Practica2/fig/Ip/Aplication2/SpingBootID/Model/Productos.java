package com.Practica2.fig.Ip.Aplication2.SpingBootID.Model;

public class Productos {
   private Long idProducto;
   private String nombre;
   private int precio;

   
public Productos(Long idProducto, String nombre, int precio) {
    this.idProducto = idProducto;
    this.nombre = nombre;
    this.precio = precio;
}
public Productos() {
}
public Long getIdProducto() {
    return idProducto;
}
public void setIdProducto(Long idProducto) {
    this.idProducto = idProducto;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public int getPrecio() {
    return precio;
}
public void setPrecio(int precio) {
    this.precio = precio;
}


   
}
