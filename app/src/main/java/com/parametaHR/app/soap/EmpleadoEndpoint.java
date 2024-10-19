package com.parametaHR.app.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.parametaHR.app.dto.EmpleadoRequestDTO;
import com.parametaHR.app.dto.EmpleadoResponseDTO;
import com.parametaHR.app.service.EmpleadoService;

@Endpoint
public class EmpleadoEndpoint {

    private static final String NAMESPACE_URI = "http://parametaHR.com/empleado";

    @Autowired
    private EmpleadoService empleadoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmpleadoRequest")
    @ResponsePayload
    public EmpleadoResponseDTO crearEmpleado(@RequestPayload EmpleadoRequestDTO request) {
        return empleadoService.calcularDatosEmpleado(request);
    }
}