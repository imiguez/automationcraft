package automationcraft.testcreation.webDafiti.pages;

import automationcraft.engine.database.MongoDBManage;
import automationcraft.engine.database.models.SearchData;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import automationcraft.engine.selenium.SeleniumBase;

import java.util.List;

public class DafitiHomePageArg extends SeleniumBase {

    public DafitiHomePageArg(WebDriver driver) {
        super(driver);
    }

    MongoDBManage manage;
    //Locators
    By search = By.name("q");
    By btnSearch = By.xpath("//button[@name='submit']");
    By categories = By.xpath("//a[contains(@class,'segment')]");
    By sections = By.xpath("//a[contains(@class,'sectionName')]");
    By cart = By.id("cart-head");
    By items = By.xpath("//div[@class='itm-product-main-info']");
    By btnAdd = By.xpath("//button[contains(@class,'btn-add-cart')]");
    By itemTitle = By.xpath("//*[@class='itm-title']");
    By cartBox = By.xpath("//*[contains(@class,'cartBox')]");
    By titleCatalog = By.xpath("//*[contains(@class,'titleCatalog mts mbl')]");
    By checkboxes = By.xpath("//a[contains(@data-label,'size')]");
    By btnApplyFilter = By.xpath("//*[contains(@class,'applyFilterButton')]");
    By newsLetterBox = By.id("newsletter-email");
    By buttonsNewsletter = By.name("subscription");
    By messageNewsletterBox = By.xpath("//*[contains(@class,'sel-message-error')]");
    By login = By.id("LoginInfoTag");
    //Keyword Driven

    /***
     * funcion: Ingresa texto al campo de busqueda y guarda en la bd dicho texto.
     * @param item Item a buscar
     */
    public void setTextSearch(String item){
        WebElement searchBox = findElement(search);
        searchBox.sendKeys(item);
        manage = new MongoDBManage("test");
        SearchData searchData = new SearchData("Busqueda por nombre",getUrl(),item);
        manage.insertObject("search",searchData,SearchData.class);
        Assert.assertEquals(item, getAttributeValue(search));
    }

    /***
     *  funcion: Presiona el boton de busqueda
     */
    public void search(){
      click(btnSearch);
        waitUrlContains("?q=");
    }

    /**
     * funcion: seleccionar categoria
     * @param cat Nombre categoria
     */
    public void selectCategory(String cat) {
        List<WebElement> catgoriesList = findElements(categories);
        WebElement categorySelected = null;
        for (WebElement category: catgoriesList) {
            if (category.getText().equals(cat.toUpperCase())){
                categorySelected = category;
                break;
            }
        }
        Assert.assertEquals(cat.toUpperCase(), categorySelected.getText());
        moveToElement(categorySelected);
    }

    /**
     * funcion: seleccionar seccion dentro de una categoria
     * @param s Nombre seccion
     */
    public void selectSection(String s){
        List<WebElement> sectionList = findElements(sections);
        for (WebElement section: sectionList) {
            if (section.getText().equals(s.toUpperCase())){
                section.click();
                break;
            }
        }
        waitElementVisible(titleCatalog);
    }

    /**
     * funcion: seleccionar producto
     * @param prod Nombre producto
     */
    public void selectProduct(String prod){
        List<WebElement> itemsList = findElements(items);
        WebElement item = null;
        for (WebElement product:itemsList) {
            if(product.findElement(itemTitle).getText().equals(prod)){
                item = product;
                break;
            }
        }
        moveToElement(item);
        waitElementClickable(btnAdd);
    }

    /**
     * funcion: añadir a carrito
     */
    public void addCart() {
        WebElement add = findElement(btnAdd);
        add.click();
        waitElementVisible(cartBox);
    }

    /**
     * funcion: validar si el desplegable que muetsra el carrito de compras esta desplegado
     */
    public void cartBoxDisplayed(){
        WebElement cart = findElement(cartBox);
        Assert.assertTrue(cart.isDisplayed());
    }

    /**
     * funcion: presionar icono ir al carrito de compras
     */
    public void goToCart() {
        WebElement cartButton = findElement(cart);
        cartButton.click();
        waitUrlContains("cart");
    }

    /**
     * funcion: seleccionar filtro talle
     * @param size Filtro talle
     */
    public void filterBySize(String size){
        List<WebElement> checkbox = findElements(checkboxes);
        for (WebElement option:checkbox) {
            if(option.getAttribute("data-value").equals(size)){
                option.click();
                break;
            }
        }

    }

    /**
     * funcion: presionar boton aplicar filtro de busqueda talle
     */
    public void applyFilterSize() {
        List<WebElement> btnsApply = findElements(btnApplyFilter);
        WebElement btnApply = btnsApply.get(0);
        btnApply.click();
        waitUrlContains("size=");
    }

    /**
     * funcion: ingresar texto en el campo email de newsletter
     * @param email Texto a ingresar en el campo
     */
    public void setTextNewletter(String email) {
        WebElement emailBox = findElement(newsLetterBox);
        emailBox.sendKeys(email);
    }

    /**
     *  funcion: presionar boton para suscribirse a newsletter
     * @param type Texto del boton que quiere presionar
     */
    public void clickBtnNewsletter(String type) {
        List<WebElement> buttons = findElements(buttonsNewsletter);
        switch (type){
            case "Soy Mujer":
                for (WebElement b: buttons) {
                    if(b.getAttribute("value").equals("female")){
                        b.click();
                        break;
                    }
                }
                break;
            case "Soy Hombre":
                for (WebElement b: buttons) {
                    if(b.getAttribute("value").equals("male")){
                        b.click();
                        break;
                    }
                }
                break;
        }
    }

    /**
     * funcion: validar el mensaje de error de newsletter
     * @param m Mensaje esperado
     */
    public void getMessageNewsletter(String m) {
        WebElement message = findElement(messageNewsletterBox);
        Assert.assertEquals(m,message.getText());
    }

    /**
     * funcion: presionar enter para realizar una busqueda
     */
    public void searchEnter() {
        setKeys(Keys.ARROW_DOWN,search);
        setKeys(Keys.ENTER,search);
        waitUrlContains("?q=");
    }
}
