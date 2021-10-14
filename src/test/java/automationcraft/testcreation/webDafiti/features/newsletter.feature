Feature: Suscripcion newsletter Dafiti
  Como usuario web,
  Quiero suscribirme al newsletter de Dafiti Argentina,
  Para informarme de las ofertas via mail.

 # @test @newsletter
  Scenario: Suscripcion con direccion de correo invalida
    Given estoy en un navegador con la pagina inicial de Dafiti Argentina
    When ingreso en el campo mail "direccionDeCorreoInvalida"
    And presiono boton "Soy Mujer"
    Then  el navegador me muestra mensaje de error "Dirección inválida"
