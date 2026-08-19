# Serenity BDD - API Testing Catalogo

Suite BDD completa de testing API contra JSONPlaceholder con reportes Serenity. Incluye tests de catálogo, usuarios, boundary values, y validación de schema.

## Características

- **Testing BDD**: Gherkin en español con Screenplay pattern
- **CRUD Completo**: Consulta, creación, actualización, eliminación
- **Boundary Values**: Tests de límites y edge cases
- **Validación de Schema**: Estructura de respuesta completa
- **Reportes Serenity**: Documentación detallada de tests

## Requisitos

- JDK 21

## Ejecución

```powershell
# Ejecutar todos los tests
.\gradlew.bat test

# Generar reporte Serenity
.\gradlew.bat aggregate
```

## Reportes

El reporte Serenity se genera en: `target/site/serenity/index.html`

## Estructura

```
src/test/
├── java/com/karen/catalogo/
│   ├── CucumberTestSuite.java
│   ├── steps/
│   │   └── CatalogoStepDefinitions.java
│   └── tasks/
│       └── CatalogoApi.java
└── resources/features/
    ├── catalogo.feature
    ├── boundary.feature
    └── usuarios.feature
```

## Features

| Feature | Escenarios | Descripción |
|---------|------------|-------------|
| catalogo.feature | 12 | CRUD completo de productos |
| boundary.feature | 8 | Boundary values y edge cases |
| usuarios.feature | 4 | Gestión de usuarios |

<!-- lastupdate: 2026-08-18 21:18 -->
