-- Ejecutar en pgAdmin (Query Tool) sobre la base de datos "postgres"
CREATE TABLE IF NOT EXISTS estudiante (
    idestudiante   SERIAL PRIMARY KEY,
    carnet         VARCHAR(30)  NOT NULL,
    primerNombre   VARCHAR(60)  NOT NULL,
    primerApellido VARCHAR(60)  NOT NULL,
    direccion      VARCHAR(120),
    telefono       INTEGER,
    carrera        VARCHAR(80),
    fechaIngreso   DATE,
    cuotaMensual   NUMERIC(10,2)
);
