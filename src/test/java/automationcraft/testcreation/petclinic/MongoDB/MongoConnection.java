package automationcraft.testcreation.petclinic.MongoDB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Iterator;
import java.util.List;

public class MongoConnection {

    private ConnectionString connectionString;
    private MongoClientSettings settings;
    private static MongoClient mongoClient;
    private String dbName;

    public MongoConnection(String user, String password, String dbName) {
        this.dbName = dbName;
        this.connectionString = new ConnectionString("mongodb+srv://"+user+":"+password+"@cluster0.ox5lc.mongodb.net/"+dbName+"?retryWrites=true&w=majority");
        this.settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(this.settings);
    }

    public void addDocument(String collectionName, Document document) {
        MongoDatabase database = mongoClient.getDatabase(this.dbName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document doc = new Document("feature", "HU-001");
        collection.insertOne(doc);
    }

    public Iterator<Document> getDocuments(String collectionName) {
        MongoDatabase database = mongoClient.getDatabase(this.dbName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext())
            System.out.println(cursor.next().toJson());
        //Document doc = new Document("_id", "2").append("atc", "atc02");
        return cursor;
    }

}
