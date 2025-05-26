package util;
import dao.AlunoDAO;
import dao.mongoConexao;
import model.Aluno;

public class MongoConnection {
    public static void main(String[] args) {
        mongoConexao connection = new mongoConexao();
       AlunoDAO operations = new AlunoDAO(connection);
        Aluno alunonew = new Aluno("Bruno", "508",55, 55, 55);
        operations.initAlunos();
        operations.deleteAluno("Igor");
        operations.readAlunos();


    }
}
