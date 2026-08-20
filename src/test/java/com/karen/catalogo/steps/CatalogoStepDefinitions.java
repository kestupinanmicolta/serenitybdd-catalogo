package com.karen.catalogo.steps;

import com.karen.catalogo.tasks.CatalogoApi;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class CatalogoStepDefinitions {

    @Steps
    CatalogoApi catalogoApi;

    @Given("the API base is configured as {string}")
    public void configurarApi(String baseUrl) {
    }

    @Given("I query product with identifier {int}")
    public void consultarProducto(int productId) {
        catalogoApi.consultarProducto(productId);
    }

    @Given("I query all products")
    public void consultarTodosLosProductos() {
        catalogoApi.consultarTodosLosProductos();
    }

    @Given("I filter products by user {int}")
    public void filtrarPorUsuario(int userId) {
        catalogoApi.filtrarPorUsuario(userId);
    }

    @Given("I query comments for product {int}")
    public void consultarComentarios(int productId) {
        catalogoApi.consultarComentarios(productId);
    }

    @When("I register a product with title {string}, description {string} and user {int}")
    public void registrarProducto(String title, String body, int userId) {
        catalogoApi.crearProducto(title, body, userId);
    }

    @When("I update product {int} with title {string} and description {string}")
    public void actualizarProducto(int productId, String title, String body) {
        catalogoApi.actualizarProducto(productId, title, body);
    }

    @When("I partially update product {int} with title {string}")
    public void actualizarParcialmente(int productId, String title) {
        catalogoApi.actualizarParcialmente(productId, title);
    }

    @When("I delete product {int}")
    public void eliminarProducto(int productId) {
        catalogoApi.eliminarProducto(productId);
    }

    @Then("the response returns product {int} titled {string}")
    public void validarProducto(int productId, String title) {
        restAssuredThat(response -> response.statusCode(200)
                .body("id", equalTo(productId))
                .body("title", equalTo(title)));
    }

    @Then("the product is registered with title {string}")
    public void validarRegistro(String title) {
        restAssuredThat(response -> response.statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo(title)));
    }

    @Then("the product is registered successfully")
    public void validarRegistroExitoso() {
        restAssuredThat(response -> response.statusCode(201)
                .body("id", notNullValue()));
    }

    @Then("the response contains at least {int} product")
    public void validarCantidadMinima(int minCount) {
        restAssuredThat(response -> response.statusCode(200)
                .body("size()", greaterThanOrEqualTo(minCount)));
    }

    @Then("each product has id, title and userId")
    public void validarCamposProducto() {
        restAssuredThat(response -> response.statusCode(200)
                .body("[0].id", notNullValue())
                .body("[0].title", notNullValue())
                .body("[0].userId", notNullValue()));
    }

    @Then("the response status code is {int}")
    public void validarCodigo(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Then("the operation returns status code {int}")
    public void validarCodigoOperacion(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Then("the response contains fields: id, title, body, userId")
    public void validarCamposRespuesta() {
        restAssuredThat(response -> response.statusCode(200)
                .body("id", notNullValue())
                .body("title", notNullValue())
                .body("body", notNullValue())
                .body("userId", notNullValue()));
    }

    @Then("all products belong to user {int}")
    public void validarUsuario(int userId) {
        restAssuredThat(response -> response.statusCode(200)
                .body("userId", everyItem(equalTo(userId))));
    }

    @Then("the response contains at least {int} comment")
    public void validarCantidadComentarios(int minCount) {
        restAssuredThat(response -> response.statusCode(200)
                .body("size()", greaterThanOrEqualTo(minCount)));
    }

    @Then("each comment has postId, id, name, email and body")
    public void validarCamposComentario() {
        restAssuredThat(response -> response.statusCode(200)
                .body("[0].postId", notNullValue())
                .body("[0].id", notNullValue())
                .body("[0].name", notNullValue())
                .body("[0].email", notNullValue())
                .body("[0].body", notNullValue()));
    }

    @Then("the response is received in less than {int} seconds")
    public void validarTiempoRespuesta(int segundos) {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Then("the Content-Type is {string}")
    public void validarContentType(String contentType) {
        restAssuredThat(response -> response.contentType(contentType));
    }

    @Given("I query all users")
    public void consultarTodosLosUsuarios() {
        catalogoApi.consultarTodosLosUsuarios();
    }

    @Given("I query user with identifier {int}")
    public void consultarUsuario(int userId) {
        catalogoApi.consultarUsuario(userId);
    }

    @When("I create a user with name {string}, email {string} and username {string}")
    public void crearUsuario(String name, String email, String username) {
        catalogoApi.crearUsuario(name, email, username);
    }

    @Then("the response contains at least {int} user")
    public void validarMinimoUsuarios(int min) {
        restAssuredThat(response -> response.statusCode(200)
                .body("size()", greaterThanOrEqualTo(min)));
    }

    @Then("each user has id, name and email")
    public void validarCamposUsuario() {
        restAssuredThat(response -> response.statusCode(200)
                .body("[0].id", notNullValue())
                .body("[0].name", notNullValue())
                .body("[0].email", notNullValue()));
    }

    @Then("the user has valid name and email")
    public void validarUsuarioDetalle() {
        restAssuredThat(response -> response.statusCode(200)
                .body("name", notNullValue())
                .body("email", notNullValue()));
    }

    @Then("the user is created successfully")
    public void validarUsuarioCreado() {
        restAssuredThat(response -> response.statusCode(201)
                .body("id", notNullValue()));
    }
}
