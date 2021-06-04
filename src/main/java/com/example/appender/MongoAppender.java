package com.example.appender;

/*
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.slf4j.event.LoggingEvent;*/

public class MongoAppender{
//public class MongoAppender extends AppenderSkeleton {

    /*private MongoClient mongoClient;                        //mongodb的连接客户端
    private MongoDatabase mongoDatabase;                    //记录日志的数据库
    private MongoCollection<BasicDBObject> logsCollection;  //记录日志的集合

    private String connectionUrl;   //连接mongodb的串
    private String databaseName;    //数据库名
    private String collectionName;  //集合名

    //@Override
    protected void append(LoggingEvent loggingEvent) {
        if( mongoDatabase == null ){
            MongoClientURI connectionString = new MongoClientURI(connectionUrl);
            mongoClient = new MongoClient(connectionString);
            mongoDatabase = mongoClient.getDatabase(databaseName);
            logsCollection = mongoDatabase.getCollection(collectionName,BasicDBObject.class);
        }
        //logsCollection.insertOne((BasicDBObject)loggingEvent.getMessage());

    }

    //@Override
    public void close() {
        if( mongoClient != null ){
            mongoClient.close();
        }
    }

   // @Override
    public boolean requiresLayout() {
        return false;
    }


    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public MongoCollection<BasicDBObject> getLogsCollection() {
        return logsCollection;
    }

    public void setLogsCollection(MongoCollection<BasicDBObject> logsCollection) {
        this.logsCollection = logsCollection;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }*/
}
