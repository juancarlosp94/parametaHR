package com.parametaHR.app.soap;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XmlRootElement(name = "EmpleadoResponse")
public class EmpleadoResponse {

    private String resultado;

}
