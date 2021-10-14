Feature: Busqueda en Dafiti
  Como usuario web,
  Quiero buscar productos en Dafiti Argentina,
  Para realizar una compra.

 # @test @search
  Scenario: Busqueda por categoria
    Given estoy en un navegador con la pagina inicial de Dafiti Argentina
    When selecciono la categoria "Mujer"
    And selecciono la seccion "Deportes"
    Then  el navegador me muestra los productos disponibles en la seccion "deporte" de la categoria "mujer"

  @test @search
  Scenario: Busqueda por nombre
    Given estoy en un navegador con la pagina inicial de Dafiti Argentina
    When ingreso el texto "Vestido largo" en el campo de busqueda
    And presiono enter
    Then  el navegador me muestra los resultados de busqueda por nombre

