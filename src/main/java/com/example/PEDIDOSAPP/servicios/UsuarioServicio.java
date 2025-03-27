package com.example.PEDIDOSAPP.servicios;

import com.example.PEDIDOSAPP.modelos.Usuario;
import com.example.PEDIDOSAPP.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositorio repositorio;

    //Listar los metodos que activaran
    //Las consultas en la BD

    //guarda
    public Usuario guardarUsuario(Usuario datosUsuario)throws Exception{
        try {

            //validar los datos de entrada
            return this.repositorio.save(datosUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }
    // buscar todos los registros
    public List<Usuario> buscarTodosUsuarios()throws Exception{
        try {

            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    //buscar este ID
    public Usuario buscarUsuarioPorid(Integer idUsuario)throws Exception{
        try {
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(idUsuario);
            if (usuarioBuscado.isPresent()){
                return usuarioBuscado.get();
            }else {
                throw new Exception("el usuario buscado no esta en la BD");
            }
        }catch (Exception eror){
            throw new Exception(eror.getMessage());
        }
    }

    // modificar por id
    public Usuario modificarUsuario(Integer id, Usuario datosUsuario)throws Exception{
        try {
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()){
                usuarioBuscado.get().setTelefono(datosUsuario.getTelefono());
                usuarioBuscado.get().setCorreoElectronico(datosUsuario.getCorreoElectronico());
                return this.repositorio.save(usuarioBuscado.get());

            }else{
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // eliminar por id
    public boolean eliminarUsuario(Integer id) throws Exception{
        try {
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
