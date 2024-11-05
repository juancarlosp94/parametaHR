package com.parametaHR.app.controller;

import com.parametaHR.app.dto.EmpleadoRequestDTO;
import com.parametaHR.app.dto.EmpleadoResponseDTO;
import com.parametaHR.app.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public EmpleadoResponseDTO crearEmpleado(@RequestBody EmpleadoRequestDTO empleadoRequest) {
        return empleadoService.validarDatosEmpleado(empleadoRequest);
    }
}
