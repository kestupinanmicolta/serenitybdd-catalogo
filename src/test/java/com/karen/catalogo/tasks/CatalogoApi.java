package com.karen.catalogo.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

public class CatalogoApi {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Step("Consultar el producto con id {0}")
    public void consultarProducto(int productId) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .when()
                .get("/posts/{id}", productId);
    }

    @Step("Consultar todos los productos")
    public void consultarTodosLosProductos() {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .when()
                .get("/posts");
    }

    @Step("Crear un producto llamado {0}")
    public void crearProducto(String title, String body, int userId) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(Map.of("title", title, "body", body, "userId", userId))
                .when()
                .post("/posts");
    }

    @Step("Actualizar el producto {0} con título {1}")
    public void actualizarProducto(int productId, String title, String body) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(Map.of("title", title, "body", body, "userId", 1))
                .when()
                .put("/posts/{id}", productId);
    }

    @Step("Actualizar parcialmente el producto {0} con título {1}")
    public void actualizarParcialmente(int productId, String title) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(Map.of("title", title))
                .when()
                .patch("/posts/{id}", productId);
    }

    @Step("Eliminar el producto {0}")
    public void eliminarProducto(int productId) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .when()
                .delete("/posts/{id}", productId);
    }

    @Step("Filtrar productos por usuario {0}")
    public void filtrarPorUsuario(int userId) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .queryParam("userId", userId)
                .when()
                .get("/posts");
    }

    @Step("Consultar comentarios del producto {0}")
    public void consultarComentarios(int productId) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .queryParam("postId", productId)
                .when()
                .get("/comments");
    }

    @Step("Consultar todos los usuarios")
    public void consultarTodosLosUsuarios() {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .when()
                .get("/users");
    }

    @Step("Consultar usuario con id {0}")
    public void consultarUsuario(int userId) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .when()
                .get("/users/{id}", userId);
    }

    @Step("Crear usuario {0}")
    public void crearUsuario(String name, String email, String username) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(Map.of("name", name, "email", email, "username", username))
                .when()
                .post("/users");
    }
}
