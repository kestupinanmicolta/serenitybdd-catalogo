# language: es
Característica: Administración del catálogo de productos

  Antecedentes:
    Dado que la API base está configurada en "https://jsonplaceholder.typicode.com"

  # ==================== CONSULTA DE PRODUCTOS ====================

  Escenario: Consultar el detalle de un producto existente
    Dado que consulto el producto con identificador 1
    Entonces la consulta devuelve el producto 1 titulado "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"

  Escenario: Consultar todos los productos disponibles
    Dado que consulto todos los productos
    Entonces la respuesta contiene al menos 1 producto
    Y cada producto tiene id, título y userId

  Escenario: Consultar producto con ID inválido
    Dado que consulto el producto con identificador 99999
    Entonces la consulta返回 código 404

  # ==================== REGISTRO DE PRODUCTOS ====================

  Escenario: Registrar un producto nuevo
    Cuando registro un producto con título "Audífonos inalámbricos", descripción "Producto para pruebas BDD" y usuario 7
    Entonces el producto queda registrado con título "Audífonos inalámbricos"

  Escenario: Registrar producto sin título
    Cuando registro un producto con título "", descripción "Sin título" y usuario 1
    Entonces el producto es registrado exitosamente

  Escenario: Registrar producto con datos mínimos
    Cuando registro un producto con título "Mínimo", descripción "Test" y usuario 1
    Entonces el producto queda registrado con título "Mínimo"

  # ==================== ACTUALIZACIÓN DE PRODUCTOS ====================

  Escenario: Actualizar producto existente con PUT
    Dado que consulto el producto con identificador 1
    Cuando actualizo el producto 1 con título "Producto Actualizado" y descripción "Contenido actualizado"
    Entonces el producto queda registrado con título "Producto Actualizado"

  Escenario: Actualizar parcialmente con PATCH
    Dado que consulto el producto con identificador 1
    Cuando actualizo parcialmente el producto 1 con título "Solo Título"
    Entonces el producto queda registrado con título "Solo Título"

  # ==================== ELIMINACIÓN DE PRODUCTOS ====================

  Escenario: Eliminar producto existente
    Dado que consulto el producto con identificador 1
    Cuando elimino el producto 1
    Entonces la operación retorna código 200

  # ==================== VALIDACIÓN DE SCHEMA ====================

  Escenario: Validar estructura de respuesta de producto
    Dado que consulto el producto con identificador 1
    Entonces la respuesta contiene los campos: id, title, body, userId

  # ==================== BÚSQUEDA POR USUARIO ====================

  Escenario: Filtrar productos por usuario
    Dado que filtro productos por usuario 1
    Entonces todos los productos pertenecen al usuario 1

  # ==================== COMENTARIOS ====================

  Escenario: Consultar comentarios de un producto
    Dado que consulto los comentarios del producto 1
    Entonces la respuesta contiene al menos 1 comentario
    Y cada comentario tiene postId, id, name, email y body
