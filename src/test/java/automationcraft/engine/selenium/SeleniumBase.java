package automationcraft.engine.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Clase Base de Selenium, para poder enmascarar
 * la version de Selenium
 * @responsable eduardo.araya
 */
public class SeleniumBase {

    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor Base
    public SeleniumBase(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    //Wrappers Selenium
    /**
     * funcion wrapper para obtener un WebElement
     * @param locator: Objeto By de la Page
     * @return WebElement
     */
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    /**
     * funcion wrapper para obtener una Lista de WebElement
     * @param locator: Objeto By de la Page
     * @return Lista de WebElement
     */
    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    /**
     * funcion que obtiene el texto de un objeto WebElement
     * @param locator: Objeto By del repositorio
     * @return String     *
     */
    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    /**
     * funcion que escribe un texto enviado a un objeto WebElement
     * @param inputText : texto a escribir
     * @param locator : Objeto By del repositorio
     */
    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    /**
     * funcion que hace 1 click en un WebElement
     * @param locator : Objeto By del repositorio
     */
    public void click(By locator){
        driver.findElement(locator).click();
    }

    /**
     * funcion que cierra el Objeto WebDriver
     */
    public void closeDriver(){
        driver.close();
    }

    /**
     * funcion para saber si un WebElement esta desplegado en pantalla
     * @param locator : Objeto By del repositorio
     * @return : verdadero o falso
     */
    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    /**
     * funcion para Navegar a un URL
     * @param url : String con URL
     */
    public void goToUrl(String url){
        driver.get(url);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void moveToElement(WebElement we){
        Actions action = new Actions(driver);
        action.moveToElement(we).build().perform();
    }
    public void clickAndHold(WebElement we){
        Actions action = new Actions(driver);
        action.clickAndHold(we).build().perform();
    }

    public String getAttributeValue(By localizador){
        return findElement(localizador).getAttribute("value");
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void waitUrlContains(String s) {
        wait.until(ExpectedConditions.urlContains(s));
    }

    public void waitForElementAndClick(By localizador){
        wait.until(ExpectedConditions.elementToBeClickable(localizador)).click();
    }
    public void waitElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    public void waitElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public void setKeys(Keys key, By locator){
        driver.findElement(locator).sendKeys(key);
    }

    public void selectByVisibleText(By locator, String text){
        WebElement dropdown = findElement(locator);
        Select manageDropdown = new Select(dropdown);
        manageDropdown.selectByVisibleText(text);
    }
    public void setText(By localizador, String s){
        driver.findElement(localizador).sendKeys(s);
    }

}
