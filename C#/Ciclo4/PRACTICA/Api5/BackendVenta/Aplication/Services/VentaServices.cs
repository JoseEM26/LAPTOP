using Aplication.DTOs;
using Aplication.Mappers;
using Dominio.Identidad;
using Dominio.Interfaz;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplication.Services
{
    public class VentaServices
    {
        private readonly IVentaRepositorio _repository;

        public VentaServices(IVentaRepositorio repository)
        {
            _repository = repository;
        }

        public ResultadoTransaction<string> createVenta(VentaDTO ventaDTO)
        {
            return _repository.CreateVenta(new VentaMapper().ExecuteVentaMapper(ventaDTO));
        }
        public ResultadoTransaction<Venta> ListarVenta()
        {
            return _repository.ListarVenta();
        }
    }
}
