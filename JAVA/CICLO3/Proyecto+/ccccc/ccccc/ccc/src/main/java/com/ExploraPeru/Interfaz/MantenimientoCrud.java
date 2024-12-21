package com.ExploraPeru.Interfaz;

import java.util.List;

public interface MantenimientoCrud<T> {

	public List<T> getLista();
	public T Details();
	public int  Actualizar();
	public int  Eliminar();
	public int  Insertar();
}
