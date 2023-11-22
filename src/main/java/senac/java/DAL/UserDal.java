package senac.java.DAL;

import java.sql.*;

public class UserDal {

    public Connection conectar() {

        Connection conexao = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=master1";
            String usuario = "SENACRJEDU/116128412023.1";
            String senha = "senac@12841";

            conexao = DriverManager.getConnection(url, usuario, senha);

            if (conexao != null) {
                return conexao;

            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("O erro foi: " + e);

        } finally {

            try {
                if (conexao != null && !conexao.isClosed()) {
                    conexao.close();
                }

            } catch (SQLException e) {
                System.out.println("O erro do SQL foi: " + e);
            }

        }
        return conexao;

    }

    //Inserir - Create

    public int inserirUsuario(String name, String lastName, String genero, String datanasc,
                              String email,String endereco, String cep, String estado, String cidade, String cpf, String telefone) throws SQLException{
        String sql = "INSERT into usuario(name, lastName, genero, datanasc, email,endereco,cep, estado, cidade, cpf, telefone) VALUES(?,?,?,?,?,?,?,?,?)";
        int linhasAfetadas = 0;
        Connection conexao = conectar();

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setString(3, genero);
            statement.setString(4, datanasc);
            statement.setString(5, email);
            statement.setString(6, endereco);
            statement.setString(7, cep);
            statement.setString(8, estado);
            statement.setString(9, cidade);
            statement.setString(10, cpf);
            statement.setString(11, telefone);

            linhasAfetadas = statement.executeUpdate();

            System.out.println("Foram modificadas " + linhasAfetadas + " no banco de dados");

            conexao.close();
            return linhasAfetadas;
        }catch(SQLException e){
            System.out.println("O erro na incerção de dados foi: " + e);
            conexao.close();
        }
        conexao.close();
        return linhasAfetadas;
    }

    public ResultSet listarUsuario() throws SQLException{
        String sql = "SELECT * FROM usuario";
        ResultSet result = null;

        try(PreparedStatement statement = conectar().prepareStatement(sql)){
            result = statement.executeQuery();

            System.out.println("Listagem dos usuários: ");

            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("name");
                String sobrenome = result.getString("lastName");
                String genero = result.getString("genero");
                String datanasc = result.getString("datanasc");
                String email = result.getString("email");
                String endereco = result.getString("endereco");
                String cep = result.getString("cep");
                String estado = result.getString("estado");
                String cidade = result.getString("cidade");
                String cpf = result.getString("cpf");
                String telefone = result.getString("telefone");


                System.out.println("id" + id);
                System.out.println("nome" + nome);
                System.out.println("sobrenome" + sobrenome);
                System.out.println("genero" + genero);
                System.out.println("datanasc" + datanasc);
                System.out.println("email" + email);
                System.out.println("endereco" + endereco);
                System.out.println("cep" + cep);
                System.out.println("estado" + estado);
                System.out.println("cidade" + cidade);
                System.out.println("cpf" + cpf);
                System.out.println("telefone" + telefone);
                System.out.println(" ");

            }

            return result;
        }catch(SQLException e){
            System.out.println("o erro na listagem foi:" + e);
        }
        return result;
    }

    public int atualizarUsuario(String name, String lastname, String genero, String datanasc, String email,
                                String estado, String cidade, String cpf, String telefone, String s, String string, int id) throws SQLException{
        String sql = "UPDATE usuario SET name = ?, lastname = ?, genero = ?," +
                " datanasc = ?, email = ?,endereco = ?, cep = ?, estado = ?, cidade= ?, cpf = ?, telefone =? WHERE id = ?";
        int linhasAfetadas = 0;

        try(PreparedStatement statement = conectar().prepareStatement(sql)){
//            statement.setString(1, name);
//            statement.setString(2, lastName);
//            statement.setString(3, genero);
//            statement.setString(4, datanasc);
//            statement.setString(5, email);
//            statement.setString(6, estado);
//            statement.setString(7, cidade);
//            statement.setString(8, cpf);
//            statement.setString(9, telefone);
//            statement.setInt(10, id);

            linhasAfetadas = statement.executeUpdate();

            System.out.println("Foram modificadas " + linhasAfetadas + " no banco de dados");

            return linhasAfetadas;
        }catch (SQLException e){
            System.out.println("O erro na atualização de dados foi: " + e);
        }
        return linhasAfetadas;
    }

    public int excluirUsuario(int id) throws SQLException{
        String sql = "DELETE FROM usuario WHERE id = ?";
        int linhasAfetadas = 0;

        try(PreparedStatement statement = conectar().prepareStatement(sql)){

//            statement.setInt(1, id);

            linhasAfetadas = statement.executeUpdate();

            System.out.println("Foram modificadas " + linhasAfetadas + " no banco de dados");
            return linhasAfetadas;

        }catch (SQLException e){
            System.out.println("O erro na exclusão de dados foi: " + e);
        }
        return linhasAfetadas;
    }
}
