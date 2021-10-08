Feature: HU-001 Buscador de Mascotas
  Como usuario
  Quiero hacer búsquedas de mascotas por atributos
  Para encontrar rápidamente los datos de sus dueños

  Background:
    Given el usuario se encuentra en la pagina de inicio

  @demo
  Scenario: Busqueda por nombre de mascota
    Given existen mascotas registradas
    When se hace la busqueda de mascotas por nombre "Lu"
    And guardo los datos en la bbdd
    Then se deben listar todas las mascotas que empiecen por "Lu"

  Scenario: Filtrar por tipo de mascota
    Given existen mascotas registradas de varios tipos
    When haga la busqueda filtrando por tipo "tipo de mascota"
    Then se deben listar solo las mascotas iguales al tipo seleccionado
