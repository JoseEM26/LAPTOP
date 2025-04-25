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
        public async Task<ResultadoTransaction<Venta>> ListaVenta()
        {
            return await _repository.ListarVenta();
        }
        public async Task<ResultadoTransaction<VentaDet>> ListaVentaDetalle()
        {
            return await _repository.ListarVentaDet();
        }
        public async Task<ResultadoTransaction<VentaDet>> ListaVentaDetalleXidVEnta(int idVenta)
        {
            return await _repository.ListarVentaDetalleXIDVenta(idVenta);
        }
        public async Task<ResultadoTransaction<string>> ActualizarVenta(VentaDTO ventaDto)
        {
            var resultado = await _repository.ActualizarVenta(new VentaMapper().MapearVentaDTO(ventaDto));
            return resultado;
        }
        public async Task<ResultadoTransaction<string>> ActualizarVentaDetalle(VentaDetDTO ventaDetDTO)
        {
            var resultado = await _repository.ActualizarVentaDetalle(new VentaMapper().MapearVentaDetalleDTO(ventaDetDTO));
            return resultado;
        }
        public async Task<ResultadoTransaction<string>> EliminarVenta(int id)
        {
            var resultado = await _repository.Eliminarventa(id);
            return resultado;
        }
        public async Task<ResultadoTransaction<string>> EliminarVentaDetalle(int idVenta,int idVentaDet)
        {
            var resultado = await _repository.EliminarventaDetalle(idVenta,idVentaDet);
            return resultado;
        }
    }
}
