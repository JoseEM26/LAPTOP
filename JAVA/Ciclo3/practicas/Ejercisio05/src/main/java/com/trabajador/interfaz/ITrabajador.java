package com.trabajador.interfaz;

import com.trabajador.model.Trabajador;

public interface ITrabajador {
	public int Registrar(Trabajador t);
	public int actualizar(Trabajador t);
	public int eliminar(int codigo);

}
