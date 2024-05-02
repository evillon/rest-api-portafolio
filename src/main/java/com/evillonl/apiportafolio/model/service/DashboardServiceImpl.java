package com.evillonl.apiportafolio.model.service;

import com.evillonl.apiportafolio.model.dtos.DashboardResponse;
import com.evillonl.apiportafolio.model.dtos.ProductoResponse;
import com.evillonl.apiportafolio.model.dtos.SesionesResponse;
import com.evillonl.apiportafolio.model.dtos.UsuariosResponse;
import com.evillonl.apiportafolio.model.persistence.repositories.ProductoRepository;
import com.evillonl.apiportafolio.model.persistence.repositories.SesionRepository;
import com.evillonl.apiportafolio.model.persistence.repositories.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ObjectMapper mapper;


    @Override
    public ResponseEntity<Object> consulta(Integer estado) {

        Long totalUsuarios = usuarioRepository.count();
        Long totalSeciones = sesionRepository.count();
        Long totalProductos = productoRepository.count();

        List<UsuariosResponse> listaUsuarioActivo = usuarioRepository.findAllByEstado(1).stream().map(ob -> mapper.convertValue(ob, UsuariosResponse.class) ).toList();
        List<UsuariosResponse> listaUsuarioInactivo = usuarioRepository.findAllByEstado(2).stream().map(ob -> mapper.convertValue(ob, UsuariosResponse.class) ).toList();
        List<UsuariosResponse> listaUsuarioPendiente = usuarioRepository.findAllByEstado(4).stream().map(ob -> mapper.convertValue(ob, UsuariosResponse.class) ).toList();
        List<UsuariosResponse> usuariosResponsesList = usuarioRepository.findAll().stream().map(ob ->mapper.convertValue(ob, UsuariosResponse.class)).toList();

        List<SesionesResponse> listaSesionesActivo = sesionRepository.findAllByEstado(1).stream().map(ob -> mapper.convertValue(ob, SesionesResponse.class) ).toList();
        List<SesionesResponse> listaSesionesInactivo = sesionRepository.findAllByEstado(2).stream().map(ob -> mapper.convertValue(ob, SesionesResponse.class) ).toList();
        List<SesionesResponse> sesionesResponseList = sesionRepository.findAll().stream().map(ob ->mapper.convertValue(ob, SesionesResponse.class) ).toList();

        List<ProductoResponse> listaProductosActivo = productoRepository.findAllByEstado(1).stream().map(ob -> mapper.convertValue(ob, ProductoResponse.class) ).toList();
        List<ProductoResponse> listaProductosInactivo = productoRepository.findAllByEstado(2).stream().map(ob -> mapper.convertValue(ob, ProductoResponse.class) ).toList();
        List<ProductoResponse> productosResponseList = productoRepository.findAll().stream().map(ob -> mapper.convertValue(ob, ProductoResponse.class) ).toList();

        Integer usuariosActivos =  listaUsuarioActivo.size();
        Integer usuariosInactivos = listaUsuarioInactivo.size();
        Integer usuariosPendientes = listaUsuarioPendiente.size();

        Integer sesionesActivos = listaSesionesActivo.size();
        Integer sesionesInactivos = listaSesionesInactivo.size();

        Integer productosActivos = listaProductosActivo.size();
        Integer productosInactivos = listaProductosInactivo.size();

        DashboardResponse response = new DashboardResponse();

        switch (estado){
            case 1:
                response.setSeciones(listaSesionesActivo);
                response.setUsuarios(listaUsuarioActivo);
                response.setProductos(listaProductosActivo);
                break;
            case 2:
                response.setSeciones(listaSesionesInactivo);
                response.setUsuarios(listaUsuarioInactivo);
                response.setProductos(listaProductosInactivo);
                break;
            case 3:
                response.setUsuarios(listaUsuarioPendiente);
                //response.setProductos();
                break;
            default:
                response.setSeciones(sesionesResponseList);
                response.setUsuarios(usuariosResponsesList);
                response.setProductos(productosResponseList);

        }

        response.setTotalUsuarios(totalUsuarios);
        response.setTotalProductos(totalProductos);
        response.setTotalSesiones(totalSeciones);

        response.setUsuariosActivos(usuariosActivos);
        response.setUsuariosInactivas(usuariosInactivos);
        response.setUsuariosPendientes(usuariosPendientes);

        response.setSesionesActivas(sesionesActivos);
        response.setSesionesInactivas(sesionesInactivos);

        response.setProductoActivos(productosActivos);
        response.setProductoInactivas(productosInactivos);

        return ResponseEntity.ok(response);
    }
}
