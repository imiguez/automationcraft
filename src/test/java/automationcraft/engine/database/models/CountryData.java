package automationcraft.engine.database.models;

public class CountryData  {
    private String name;
    private String url;

    public CountryData(){}
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
