package automationcraft.testcreation.petclinic.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.petclinic.MongoDB.MongoConnection;
import automationcraft.testcreation.petclinic.pages.petClinicFindPetsPage;
import automationcraft.testcreation.petclinic.pages.petClinicHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bson.Document;
import org.testng.Assert;


import static org.testng.Assert.assertTrue;

public class petClinicSteps {

	protected petClinicHomePage petHome ;
	protected petClinicFindPetsPage petFindPetsPage;
	protected MongoConnection mongoConnection;

	@Given("el usuario se encuentra en la pagina de inicio")
	public void el_usuario_se_encuentra_en_la_pagina_de_inicio() {
		petHome = new petClinicHomePage(DriverFactory.getDriver());
		//petHome.validarPetClinicHomePage();
	}

	@Given("existen mascotas registradas")
	public void existen_mascotas_registradas() {
		// todo validar que existan mascotas por bd
		assertTrue(true);
	}
	@When("se hace la busqueda de mascotas por nombre {string}")
	public void se_hace_la_busqueda_de_mascotas_por_nombre(String string) {
		petHome.irAFindPetsDesdeHomePage();
		petFindPetsPage = new petClinicFindPetsPage(DriverFactory.getDriver());
		petFindPetsPage.buscarPet(string);
	}
	@Then("se deben listar todas las mascotas que empiecen por {string}")
	public void se_deben_listar_todas_las_mascotas_que_empiecen_por(String string) {
		Document doc = petFindPetsPage.validarBusquedaListaPet(string);
		this.mongoConnection = new MongoConnection("bootcamp", "bootcamp", "test");
		this.mongoConnection.addDocument("registros", doc);

	}

	@Given("existen mascotas registradas de varios tipos")
	public void existen_mascotas_registradas_de_varios_tipos() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@When("haga la busqueda filtrando por tipo {string}")
	public void haga_la_busqueda_filtrando_por_tipo(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@Then("se deben listar solo las mascotas iguales al tipo seleccionado")
	public void se_deben_listar_solo_las_mascotas_iguales_al_tipo_seleccionado() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}



}
