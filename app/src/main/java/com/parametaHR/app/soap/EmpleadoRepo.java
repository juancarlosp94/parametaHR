//package com.parametaHR.app.soap;
//
//import com.parametaHR.app.dto.EmpleadoRequestDTO;
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class EmpleadoRepo {
//
//    private static final Map<String, EmpleadoRequestDTO> empleados = new HashMap<>();
//
//    @PostConstruct
//    public void initData() {
//        EmpleadoRequestDTO empleado1 = new EmpleadoRequestDTO();
//        empleado1.setNombres("Juan");
//        empleado1.setApellidos("Perez");
//        empleado1.setTipoDocumento("CC");
//        empleado1.setNumeroDocumento("46704314");
//        empleado1.setFechaNacimiento(LocalDate.parse("1995-10-20"));
//        empleado1.setFechaVinculacion(LocalDate.parse("2021-11-12"));
//        empleado1.setCargo("Desarrollador");
//        empleado1.setSalario(50000000);
//
//
//
//        empleados.put(empleado1.getNombres(), empleado1);
//
//
//    }
//
//    public EmpleadoRequestDTO findEmpleado(String name) {
//        Assert.notNull(name, "El empleado no puede ser nulo");
//        return empleados.get(name);
//    }
//}
