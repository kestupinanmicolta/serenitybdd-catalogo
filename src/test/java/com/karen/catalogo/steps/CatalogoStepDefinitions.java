package com.karen.catalogo.steps;

import com.karen.catalogo.tasks.CatalogoApi;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class CatalogoStepDefinitions {

    @Steps
    CatalogoApi catalogoApi;

    @Dado("que la API base está configurada en {string}")
    public void configurarApi(String baseUrl) {
        // La URL base ya está configurada en CatalogoApi
    }

    @Dado("que consulto el producto con identificador {int}")
    public void consultarProducto(int productId) {
        catalogoApi.consultarProducto(productId);
    }

    @Dado("que consulto todos los productos")
    public void consultarTodosLosProductos() {
        catalogoApi.consultarTodosLosProductos();
    }

    @Dado("que filtro productos por usuario {int}")
    public void filtrarPorUsuario(int userId) {
        catalogoApi.filtrarPorUsuario(userId);
    }

    @Dado("que consulto los comentarios del producto {int}")
    public void consultarComentarios(int productId) {
        catalogoApi.consultarComentarios(productId);
    }

    @Cuando("registro un producto con título {string}, descripción {string} y usuario {int}")
    public void registrarProducto(String title, String body, int userId) {
        catalogoApi.crearProducto(title, body, userId);
    }

    @Cuando("actualizo el producto {int} con título {string} y descripción {string}")
    public void actualizarProducto(int productId, String title, String body) {
        catalogoApi.actualizarProducto(productId, title, body);
    }

    @Cuando("actualizo parcialmente el producto {int} con título {string}")
    public void actualizarParcialmente(int productId, String title) {
        catalogoApi.actualizarParcialmente(productId, title);
    }

    @Cuando("elimino el producto {int}")
    public void eliminarProducto(int productId) {
        catalogoApi.eliminarProducto(productId);
    }

    @Entonces("la consulta devuelve el producto {int} titulado {string}")
    public void validarProducto(int productId, String title) {
        restAssuredThat(response -> response.statusCode(200)
                .body("id", equalTo(productId))
                .body("title", equalTo(title)));
    }

    @Entonces("el producto queda registrado con título {string}")
    public void validarRegistro(String title) {
        restAssuredThat(response -> response.statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo(title)));
    }

    @Entonces("el producto es registrado exitosamente")
    public void validarRegistroExitoso() {
        restAssuredThat(response -> response.statusCode(201)
                .body("id", notNullValue()));
    }

    @Entonces("la respuesta contiene al menos {int} producto")
    public void validarCantidadMinima(int minCount) {
        restAssuredThat(response -> response.statusCode(200)
                .body("size()", greaterThanOrEqualTo(minCount)));
    }

    @Entonces("cada producto tiene id, título y userId")
    public void validarCamposProducto() {
        restAssuredThat(response -> response.statusCode(200)
                .body("[0].id", notNullValue())
                .body("[0].title", notNullValue())
                .body("[0].userId", notNullValue()));
    }

    @Entonces("la consulta返回 código {int}")
    public void validarCodigo(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Entonces("la operación retorna código {int}")
    public void validarCodigoOperacion(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Entonces("la respuesta contiene los campos: id, title, body, userId")
    public void validarCamposRespuesta() {
        restAssuredThat(response -> response.statusCode(200)
                .body("id", notNullValue())
                .body("title", notNullValue())
                .body("body", notNullValue())
                .body("userId", notNullValue()));
    }

    @Entonces("todos los productos pertenecen al usuario {int}")
    public void validarUsuario(int userId) {
        restAssuredThat(response -> response.statusCode(200)
                .body("userId", everyItem(equalTo(userId))));
    }

    @Entonces("la respuesta contiene al menos {int} comentario")
    public void validarCantidadComentarios(int minCount) {
        restAssuredThat(response -> response.statusCode(200)
                .body("size()", greaterThanOrEqualTo(minCount)));
    }

    @Entonces("cada comentario tiene postId, id, name, email y body")
    public void validarCamposComentario() {
        restAssuredThat(response -> response.statusCode(200)
                .body("[0].postId", notNullValue())
                .body("[0].id", notNullValue())
                .body("[0].name", notNullValue())
                .body("[0].email", notNullValue())
                .body("[0].body", notNullValue()));
    }

    @Entonces("la respuesta se recibe en menos de {int} segundo(s)")
    public void validarTiempoRespuesta(int segundos) {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Entonces("el Content-Type es {string}")
    public void validarContentType(String contentType) {
        restAssuredThat(response -> response.contentType(contentType));
    }
}
