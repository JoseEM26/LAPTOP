package com.formulario.Intefaz;

import com.formulario.model.Trabajador;

public interface Crud {
   public int Insertar(Trabajador t);
   public int update(Trabajador t);
   public int Eliminar(Trabajador t);
   
}
