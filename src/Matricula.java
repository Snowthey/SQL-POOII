public class Matricula {
    private String Nome;
    private String Endereco;
    private String Telefone;
    private String tiposSangue;
    private String tiposFator;
    private String cpf;
    private String tiposCurso;
    private String ContatoEmergencia;
    private String TelefoneEmergencia;
    private int id;

    public Matricula(String Nome, String Endereco, String Telefone, String cpf, String tiposSangue, String tiposFator, String tiposCurso, String ContatoEmergencia, String TelefoneEmergencia){
        this.Nome = Nome;
        this.Endereco = Endereco;
        this.Telefone = Telefone;
        this.cpf = cpf;
        this.ContatoEmergencia = ContatoEmergencia;
        this.TelefoneEmergencia = TelefoneEmergencia;
        this.tiposFator = tiposFator;
        this.tiposSangue = tiposSangue;
        this.tiposCurso = tiposCurso;
    }

    public String getNome(){
        return Nome;
    }

    public String getEndereco(){
        return Endereco;
    }

    public String getTelefone(){
        return Telefone;
    }

    public String getContatoEmergencia(){
        return ContatoEmergencia;
    }
    public String getTelefoneEmergencia(){
        return TelefoneEmergencia;
    }
    public String getTiposSangue(){
        return tiposSangue;
    }
    public String getTiposFator(){
        return tiposFator;
    }
    public String getTiposCurso(){
        return tiposCurso;
    }
    public String getcpf(){
        return cpf;
    }


}

