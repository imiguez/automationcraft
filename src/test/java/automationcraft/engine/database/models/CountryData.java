package automationcraft.engine.database.models;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class CountryData  {
    @BsonProperty("pais")
    private String name;
    @BsonProperty("url")
    private String url;

    public CountryData(){}
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    public void setName( @BsonProperty String pais) {
        this.name = pais;
    }
    public void setUrl( @BsonProperty String url) {
        this.url = url;
    }
}
