package automationcraft.testcreation.webDafiti.pages;

import automationcraft.engine.database.MongoDBManage;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import automationcraft.engine.selenium.SeleniumBase;

import java.util.Collection;
import java.util.List;

/***
 * @author Luisina.Kelly
 * @version 1
 */

public class DafitiHomePage extends SeleniumBase {
    public DafitiHomePage(WebDriver driver) {
        super(driver);
    }
    final static String arg = ".ar";
    final static String cl = ".cl";
    final static String br = ".br";
    final static String co = ".co";

    //Locators
    By countries = By.className("footer");

    //Keyword Driven

    /***
     * Seleccionar país de operación
     * @param countryName Nombre del país
     */
    public void selectCountry(String countryName){
        List<WebElement> countriesList = findElement(countries).findElements(By.tagName("a"));
        for (WebElement country: countriesList) {
            if(country.getText().equals(countryName)) {
                country.click();
                break;
            }
        }
        waitUrlContains(arg);
    }


    /**
     * funcion: Obtener el fragmento del dominio que indica el pais de la base de datos.
     * Se utiliza MongoDB como base de datos
     * @param string Pais elegido
     * @return
     */
    public String getUrlCountry(String string) {
        MongoDBManage manage = new MongoDBManage("test");
        Document country = new Document("pais",string);
        List<Document> result = manage.getDocuments(country,"countries");
        return result.get(0).getString("url");
    }


}
