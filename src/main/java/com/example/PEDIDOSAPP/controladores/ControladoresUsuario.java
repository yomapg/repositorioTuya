package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Usuario;
import com.example.PEDIDOSAPP.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ControladoresUsuario {

    @Autowired
    UsuarioServicio usuarioServicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario datosPeticion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.usuarioServicio.guardarUsuario(datosPeticion));

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());


        }
    }

    //Buscar Todos
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.buscarTodosUsuarios());

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.buscarUsuarioPorid(id));

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Usuario datos) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.modificarUsuario(id, datos));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {

        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.eliminarUsuario(id));


        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }


    }
}
