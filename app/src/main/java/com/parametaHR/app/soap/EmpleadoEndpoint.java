//package com.parametaHR.app.soap;
//
//import com.parametaHR.app.entity.EmpleadoEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//import com.parametaHR.app.dto.EmpleadoRequestDTO;
//import com.parametaHR.app.dto.EmpleadoResponseDTO;
//import com.parametaHR.app.service.EmpleadoService;
////import com.parametaHR.empleado.GetEmpleadoResponse;
////import io.spring.guides.gs_producing_web_service.GetCountryRequest;
////import io.spring.guides.gs_producing_web_service.GetCountryResponse;
//
//@Endpoint
//public class EmpleadoEndpoint {
//
//    private static final String NAMESPACE_URI = "http://parametaHR.com/empleado";
//
//
//    private EmpleadoRepo empleadoRepo;
//
//    @Autowired
//    public EmpleadoEndpoint (EmpleadoRepo empleadoRepo) {
//        this.empleadoRepo = empleadoRepo;
//    }
//
////    @ResponsePayload
////    public GetEmpleadoResponse getCountry(@RequestPayload GetCountryRequest request) {
////        GetCountryResponse response = new GetCountryResponse();
////        response.setCountry(countryRepository.findCountry(request.getName()));
////
////        return response;
////    }
//
////    @Autowired
////    private EmpleadoService empleadoService;
//
//
////    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmpleadoRequest")
////    @ResponsePayload
////    public EmpleadoResponseDTO crearEmpleado(@RequestPayload EmpleadoRequestDTO request) {
////        return empleadoService.calcularDatosEmpleado(request);
////    }
//}