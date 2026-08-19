# language: es
Característica: Validación de límites y edge cases

  Antecedentes:
    Dado que la API base está configurada en "https://jsonplaceholder.typicode.com"

  # ==================== BOUNDARY VALUES ====================

  Escenario: Consultar producto con ID 0
    Dado que consulto el producto con identificador 0
    Entonces la consulta返回 código 404

  Escenario: Consultar producto con ID negativo
    Dado que consulto el producto con identificador -1
    Entonces la consulta返回 código 404

  Escenario: Consultar producto con ID decimal
    Dado que consulto el producto con identificador 1.5
    Entonces la consulta返回 código 404

  Escenario: Consultar producto con ID muy grande
    Dado que consulto el producto con identificador 999999999
    Entonces la consulta返回 código 404

  # ==================== VALIDACIÓN DE TIPOS ====================

  Escenario: Crear producto con título numérico
    Cuando registro un producto con título "12345", descripción "Test numérico" y usuario 1
    Entonces el producto es registrado exitosamente

  Escenario: Crear producto con título largo
    Cuando registro un producto con título "Este es un título extremadamente largo para probar los límites de validación del sistema y cómo maneja strings de gran longitud sin fallar"
    Entonces el producto es registrado exitosamente

  Escenario: Crear producto con caracteres especiales
    Cuando registro un producto con título "Producto @#$%^&*()", descripción "Descripción con ñ y tildes áéíóú" y usuario 1
    Entonces el producto es registrado exitosamente

  # ==================== VALIDACIÓN DE RESPUESTA ====================

  Escenario: Verificar tiempo de respuesta
    Dado que consulto el producto con identificador 1
    Entonces la respuesta se recibe en menos de 2 segundos

  Escenario: Verificar Content-Type
    Dado que consulto el producto con identificador 1
    Entonces el Content-Type es "application/json; charset=utf-8"
