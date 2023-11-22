package senac.java.Domain;

import org.json.JSONObject;

public class Adm {

    public int id;
    public String nome = "";
    public String sobrenome = "";
    public String genero = "";
    public String dataNasc = "";
    public String codigo = "";
    public String email = "";
    public String endereco = "";
    public String cep = "";
    public String cidade = "";
    public String estado = "";
    public String cpf = "";
    public String telefone = "";

    public Adm(){

    }

    public Adm(String nome, String sobrenome, String genero, String dataNasc, String codigo,
               String email, String endereco, String cep, String estado, String cidade ,String cpf, String telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.dataNasc = dataNasc;
        this.codigo = codigo;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.cpf = cpf;
        this.telefone= telefone;
        this.id = id;

    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("nome",nome);
        json.put("sobrenome",sobrenome);
        json.put("genero",genero);
        json.put("dataNasc",dataNasc);
        json.put("codigo",codigo);
        json.put("email",email);
        json.put("endereco",endereco);
        json.put("cep",cep);
        json.put("estado",estado);
        json.put("cidade",cidade);
        json.put("cpf",cpf);
        json.put("telefone",telefone);

        return json;
    }
}
