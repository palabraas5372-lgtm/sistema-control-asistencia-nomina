package com.construandina.asistencia.controller;

import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Comprueba que la API puede consultar la base de datos de Azure. */
@RestController
public class DbHealthController {

    private final JdbcTemplate jdbc;

    public DbHealthController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/api/health/db")
    public Map<String, Object> salud() {
        String bd = jdbc.queryForObject("SELECT DB_NAME()", String.class);
        Integer empleados = jdbc.queryForObject("SELECT COUNT(*) FROM empleados", Integer.class);
        return Map.of("status", "UP", "baseDeDatos", bd, "empleados", empleados);
    }
}