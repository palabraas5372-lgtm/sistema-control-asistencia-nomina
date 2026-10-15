# Sistema de Control de Asistencia y Nómina

Proyecto base en Java 17, Spring Boot, Maven, Spring Data JPA y Azure SQL Database.

## Estado del proyecto

Este repositorio contiene una estructura inicial de referencia para desarrollar el sistema. Los módulos de negocio completos (marcaje QR, cálculo legal de nómina, aprobación de pagos, seguridad por roles y demás) deben implementarse y probarse antes de utilizarlo en producción.

## Requisitos

- JDK 17 o superior
- Maven 3.9 o superior (o usar el Maven Wrapper cuando se agregue)
- Acceso a una instancia SQL Server / Azure SQL Database

## Configuración de la base de datos

Define estas variables de entorno antes de ejecutar la aplicación:

- `DB_SERVIDOR`: servidor y base de datos, por ejemplo `tcp:servidor.database.windows.net:1433;databaseName=asistencia_nomina`
- `DB_USUARIO`: usuario de base de datos
- `DB_CLAVE`: contraseña de base de datos

No guardes credenciales reales en el repositorio.

## Ejecutar

```bash
mvn spring-boot:run
```

Compilar y ejecutar pruebas:

```bash
mvn clean verify
```

## Estructura

```text
src/main/java/com/construandina/asistencia/
├── SistemaAsistenciaApplication.java
├── controller/
├── service/
├── repository/
├── model/
├── dto/
├── config/
└── exception/
src/main/resources/application.properties
src/test/java/com/construandina/asistencia/
```

## Flujo recomendado para implementar módulos

1. Definir tablas, claves foráneas e índices en el script DDL.
2. Crear entidades JPA.
3. Crear repositorios.
4. Implementar reglas de negocio en servicios.
5. Crear controladores y DTO de entrada/salida.
6. Agregar pruebas unitarias y de integración.
7. Ejecutar `mvn clean verify` antes de integrar cambios.

## Convenciones

- Clases: `PascalCase`.
- Métodos y atributos: `camelCase`.
- Paquetes: minúsculas.
- Importes monetarios: `BigDecimal`.
- Consultas parametrizadas; nunca concatenar datos del usuario en SQL.
- Usar `spring.jpa.hibernate.ddl-auto=validate`.
- Mantener historial cuando corresponda y evitar eliminar registros históricos sin una política definida.

## Repositorio remoto

Después de crear el repositorio en GitHub o GitLab, pega aquí su URL.
