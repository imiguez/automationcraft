package automationcraft.testcreation.petclinic.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static automationcraft.engine.selenium.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class petClinicFindPetsPage extends SeleniumBase {
    public petClinicFindPetsPage(WebDriver driver) {
        super(driver);
    }

    // objects
    private By searchBoxPetName = By.xpath("//input[@id='name']");
    private By btnFindPet = By.xpath("//button[@type='submit']");
    private By resultTable = By.xpath("//table[@id='pets']//tbody");

    // methods
    //method
    public void validarPetClinicFindPetsPage(){

        String validador = getTitle();
        if (validador != null){
            assertEquals(validador,"PetClinic :: a Spring Framework demonstration");
        }
    }

    public void buscarPet(String name){
        if(isDisplayed(btnFindPet)){
            type(name,searchBoxPetName);
            click(btnFindPet);
        }
    }

    public Document validarBusquedaListaPet(String name){
        Document doc = new Document("feature", "HU-001").append("scenario", "Busqueda por nombre de mascota").append("passed", false);
        if(isDisplayed(resultTable)){
            int coincidencias=0;
            WebElement webTable = getDriver().findElement(resultTable);
            List<WebElement> rows = getDriver().findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));
                int columnsCount = columns.size();
                for (WebElement column: columns) {
                    String cellText = column.getText();
                    if(cellText.contains(name)){
                        coincidencias++;
                    }
                }
            }
            assertTrue(coincidencias>0);
            System.out.println("paso");
            doc.append("passed", coincidencias>0);
        }
        return doc;
    }

}
