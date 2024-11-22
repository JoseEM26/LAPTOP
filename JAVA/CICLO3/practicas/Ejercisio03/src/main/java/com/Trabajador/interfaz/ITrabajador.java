package com.Trabajador.interfaz;

import com.Trabajador.modelo.Trabajador;

public interface ITrabajador {
	   public int Insertar(Trabajador t);
	   public int actualizar(Trabajador t);
	   public int eliminar(int codigo);
}
