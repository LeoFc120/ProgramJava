package com.example.backend1.dto;
import lombok.Data;

@Data // Aquí sí podemos usar @Data sin peligro porque no hay relaciones de base de datos
public class LoginRequest {
    private String correo;
    private String password;
}