package com.evillonl.apiportafolio.model.dtos;


import lombok.Data;

import java.util.List;

@Data
public class DashboardResponse {

    Integer sesionesActivas;
    Integer sesionesInactivas;
    Long totalSesiones;

    Integer usuariosActivos;
    Integer usuariosInactivas;
    Integer usuariosPendientes;
    Long totalUsuarios;

    Integer productoActivos;
    Integer productoInactivas;
    Long totalProductos;

    List<SesionesResponse> seciones;
    List<UsuariosResponse> usuarios;
    List<ProductoResponse> productos;




}
