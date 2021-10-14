Feature: Seleccionar país de operacion
  Como usuario web,
  Quiero elegir el pais de operacion de Dafiti,
  Para realizar una compra.

  @test
  Scenario: Seleccionar Dafiti Argentina
    Given estoy en un navegador con la pagina inicial de Dafiti
    When elijo comprar en "Argentina"
    Then el navegador me muestra el home de Dafiti "Argentina"