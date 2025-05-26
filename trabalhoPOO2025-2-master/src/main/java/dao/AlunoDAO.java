package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Aluno;
import org.bson.Document;
import util.MongoConnection;

public class AlunoDAO {
    private MongoCollection<Document> docsAlunos;

    public AlunoDAO(mongoConexao connection){
        this.docsAlunos = connection.getDatabase().getCollection("alunos"); //nome da colecao: alunos
    }


    public void initAlunos(){
        Aluno nom1 = new Aluno("Igor","508",55,43,  90);

        docsAlunos.insertOne(nom1.toDocument());
        System.out.println("aluno inserido");
    }
//================================================CRUD================================================

    //CREATE
    public void createAluno (Aluno aluno){ //CRIA O ALUNO
        docsAlunos.insertOne(aluno.toDocument()); //INSERE NO BANCO DE DADOS
        System.out.println("aluno inserido"+ aluno);
    }
    //READ
    public void readAlunos(){
        System.out.println("Alunos cadastrados");
        for(Document doc: docsAlunos.find()){
            System.out.println(Aluno.fromDocument(doc));
        }
    }

    //UPDATE
    public void updateAlunosFull(String nome,String newturma,int newnota1,int newnota2, int newmedia){
        Document upddates = new Document();
        upddates.append("turma", newturma);
        upddates.append("atividades", newnota1);
        upddates.append("provas", newnota2);
        upddates.append("media", newmedia);

        docsAlunos.updateOne(Filters.eq("nome", nome), Updates.combine(Updates.set("turma", newturma),
                Updates.set("atividades", newnota1),
                Updates.set("provas", newnota2),
                Updates.set("media", newmedia)));

        System.out.println("Aluno " + nome+ " atualizado");
    }

    //DELETE
    public void deleteAluno(String nome){
        docsAlunos.deleteOne(Filters.eq("nome", nome));
        System.out.println("Aluno " + nome+ " apagado");
    }


    

}
