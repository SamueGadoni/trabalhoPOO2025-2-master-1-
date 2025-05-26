package dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class mongoConexao {
    public static final String USERNAME = "igorcquintino"; //USUARIO
    public static final String PASSWORD  = "gtn8MzoptGhZRR58"; //SENHA
    public static final String CLUSTER_URL =  "cluster0poo.6esceum.mongodb.net"; //CLUSTER
    public static final String DATABASE_NAME = "AlunosSpecs"; //NOMNE DO BANCO DE DADOS

    private MongoClient  mongoClient;
    private MongoDatabase  database;

    public mongoConexao(){
        try{
            //strting de conexao com credenciais
            String connetionString = String.format("mongodb+srv://"+ USERNAME+":"+PASSWORD+"@"+CLUSTER_URL+"/?retryWrites=true&www=majority&appName="+DATABASE_NAME);

            //configurando cliente mongodb
            ConnectionString connSring  = new ConnectionString(connetionString);
            MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connSring).build();

            //criacao de cliente
            mongoClient = MongoClients.create(settings);
            //seleciona o banco de dados
            database = mongoClient.getDatabase(DATABASE_NAME);

            System.out.println("conexao bem sucedida");



        }catch(Exception e){
            System.err.println("erro de conexao:  "+ e.getMessage());
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase(){return database;}
}
