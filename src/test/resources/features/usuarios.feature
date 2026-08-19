# language: es
Característica: API de usuarios

  Antecedentes:
    Dado que la API base está configurada en "https://jsonplaceholder.typicode.com"

  Escenario: Consultar todos los usuarios
    Dado que consulto todos los usuarios
    Entonces la respuesta contiene al menos 1 usuario
    Y cada usuario tiene id, name y email

  Escenario: Consultar usuario específico
    Dado que consulto el usuario con identificador 1
    Entonces el usuario tiene nombre y email válidos

  Escenario: Crear usuario válido
    Cuando creo un usuario con nombre "Karen Test", email "karen@test.com" y username "karentest"
    Entonces el usuario es creado exitosamente

  Escenario: Consultar usuario inexistente
    Dado que consulto el usuario con identificador 99999
    Entonces la consulta返回 código 404
