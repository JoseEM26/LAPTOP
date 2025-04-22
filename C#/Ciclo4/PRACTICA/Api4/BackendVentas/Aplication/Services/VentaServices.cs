using Aplication.CasoDeUso;
using Aplication.DTOs;
using Aplication.MAPPERs;
using Dominio.Identity;
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

        public async Task<ResultadoTransaction<string>> AgregarVenta(VentaDTO ventaDTO)
        {
            var validate = new VentaCasoDeUso().ValidarVenta(ventaDTO);
            if(validate.idRegistro != 0)
            {
                return validate;
            }
            var venta = _repository.createVenta(new VentaMapper().MapearVentaDTO(ventaDTO));
            return await venta;

        }
    }
}
