package com.trabajador.intefaz;

import com.trabajador.model.Trabajador;

public interface IMantenimiento {
    public int Insert(Trabajador t);
    public int update(Trabajador t);
    public int delete(int codigo);
}
