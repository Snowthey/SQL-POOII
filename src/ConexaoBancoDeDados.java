import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexaoBancoDeDados {

    private Connection conexao;
    private String URL_Bancodedados;
    private String usuario;
    private String senha;

    public ConexaoBancoDeDados(){
        URL_Bancodedados = "jdbc:mysql://localhost:3306/matricula";
        usuario = "root";
        senha = "admin";
    }

    private void IniciarConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL_Bancodedados, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro ao acessar o Banco de Dados!");
        }
    }


    private void EncerrarConexao() throws SQLException{
        if(conexao != null){
            conexao.close();
        }
    }

    public String InserirDados(Matricula ObjetoPessoa, String tiposSangue, String tiposFator, String tiposCurso) throws SQLException {
        IniciarConexao();

        if (conexao != null) {
            try {
                PreparedStatement psInsert = conexao.prepareStatement("INSERT INTO matricula (nome, endereco, telefone, ContatoEmergencia, TelefoneEmergencia, TiposSangue, TiposFator, TiposCurso, Cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                psInsert.setString(1, ObjetoPessoa.getNome());
                psInsert.setString(2, ObjetoPessoa.getEndereco());
                psInsert.setString(3, ObjetoPessoa.getTelefone());
                psInsert.setString(4, ObjetoPessoa.getContatoEmergencia());
                psInsert.setString(5, ObjetoPessoa.getTelefoneEmergencia());
                psInsert.setString(6, ObjetoPessoa.getTiposSangue());
                psInsert.setString(7, ObjetoPessoa.getTiposFator());
                psInsert.setString(8, ObjetoPessoa.getTiposCurso());
                psInsert.setString(9, ObjetoPessoa.getcpf());
                psInsert.execute();

                EncerrarConexao();

                return "Cadastro realizado com sucesso!";
            } catch (SQLException e) {
                e.printStackTrace(); // Imprima a exceção para diagnóstico
                return "Erro! Inserção não realizada!";
            }
        } else {
            return "Erro! Conexão não estabelecida!";
        }
    }


    public String AlterarDados(Matricula ObjetoPessoa, int id) throws SQLException{
        IniciarConexao();

        if(conexao != null){
            PreparedStatement comandoupdate = conexao.prepareStatement("UPDATE matricula SET endereco = ?, telefone = ?, nome = ?, ContatoEmergencia = ?, TelefoneEmergencia = ?, TiposSangue = ?, TiposFator = ?, TiposCurso = ?, Cpf = ? WHERE id= ?");
            comandoupdate.setString(1, ObjetoPessoa.getEndereco());
            comandoupdate.setString(2, ObjetoPessoa.getTelefone());
            comandoupdate.setString(3, ObjetoPessoa.getNome());
            comandoupdate.setString(4, ObjetoPessoa.getContatoEmergencia());
            comandoupdate.setString(5, ObjetoPessoa.getTelefoneEmergencia());
            comandoupdate.setString(6, ObjetoPessoa.getTiposSangue());
            comandoupdate.setString(7, ObjetoPessoa.getTiposFator());
            comandoupdate.setString(8, ObjetoPessoa.getTiposCurso());
            comandoupdate.setString(9, ObjetoPessoa.getcpf());
            comandoupdate.setInt(4, id);
            comandoupdate.execute();

            EncerrarConexao();

            return "Alteração realizada com sucesso";
        } else{
            return "Erro! Alteração não realizada";
        }
    }

    public String RemoverDados(int id) throws SQLException{
        IniciarConexao();

        if(conexao != null){
            PreparedStatement comandodelete = conexao.prepareStatement("DELETE FROM matricula WHERE id = ?");
            comandodelete.setInt(1, id);
            comandodelete.execute();

            EncerrarConexao();

            return "Remoção realizada com sucesso";
        } else{
            return "Erro! Alteração não realizada";
        }
    }

    public ArrayList<String> Relatorio() throws SQLException{
        IniciarConexao();

        ArrayList<String> relatorioBancoDeDados = new ArrayList<String>();

        if(conexao != null){

            Statement comandoconsulta = conexao.createStatement();
            ResultSet resultadoconsultaBD = comandoconsulta.executeQuery("SELECT * FROM matricula");
            String resultado;
            String nome;
            String endereco;
            String telefone;
            String ContatoEmergencia;
            String TelefoneEmergencia;
            String id;
            while(resultadoconsultaBD.next()){
                nome = resultadoconsultaBD.getString("nome");
                endereco = resultadoconsultaBD.getString("endereco");
                telefone = resultadoconsultaBD.getString("telefone");
                ContatoEmergencia = resultadoconsultaBD.getString("ContatoEmergencia");
                TelefoneEmergencia = resultadoconsultaBD.getString("TelefoneEmergencia");
                id = resultadoconsultaBD.getString("id");

                resultado = "# ID: " + id + " Nome: " + nome + " Endereço: " + endereco + " Telefone: " + telefone + " Contato Emergencial: " + ContatoEmergencia + " Telefone Emergencial: " + TelefoneEmergencia;
                relatorioBancoDeDados.add(resultado);
            }

            EncerrarConexao();

            return relatorioBancoDeDados;
        }
        return null;
    }
}