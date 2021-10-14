package automationcraft.engine.database.models;

import org.bson.codecs.pojo.annotations.*;

@BsonDiscriminator
public class SearchData {
    @BsonProperty("testName")
    private String testCase;
    @BsonProperty("url")
    private String web;
    @BsonProperty("textSearch")
    private String textSearch;

    @BsonCreator
    public  SearchData(@BsonProperty String testName, @BsonProperty String url, @BsonProperty String textSearch){
        this.testCase = testName;
        this.web = url;
        this.textSearch = textSearch;
    }

    public String getTestCase() {
        return testCase;
    }
    public String getTextSearch() {
        return textSearch;
    }
    public String getWeb() {
        return web;
    }
    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }
    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }
    public void setWeb(String web) {
        this.web = web;
    }
}
