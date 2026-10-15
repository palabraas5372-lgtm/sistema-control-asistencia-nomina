package com.construandina.asistencia.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 * Punto de partida para las reglas de nómina.
 * Completar las reglas con la normativa aplicable y los requisitos del proyecto.
 */
@Service
public class PlanillaService {
    public BigDecimal calcularPagoBase(BigDecimal sueldoBase) {
        if (sueldoBase == null || sueldoBase.signum() < 0) {
            throw new IllegalArgumentException("El sueldo base debe ser un importe válido y no negativo.");
        }
        return sueldoBase;
    }
}
