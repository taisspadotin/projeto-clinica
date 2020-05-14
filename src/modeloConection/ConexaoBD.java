package modeloConection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;


public class ConexaoBD {
    
public Statement stn;//estado
public ResultSet rs;
private String driver="org.postgresql.Driver";
private String caminho="jdbc:postgresql://localhost:5433/projetoclinica"; //caminho
private String usuario="postgres";//meu usuario
private String senha="06121998";//minha senha
public Connection con;//conexao

public void conexao(){
try{
    System.setProperty("jdbc.Drivers", driver);//set a propiedade do drive de conexão
con=DriverManager.getConnection(caminho, usuario, senha);
//JOptionPane.showMessageDialog(null, "Conecção Efetuada com sucesso!!");
}catch(SQLException ex){
JOptionPane.showMessageDialog(null, "ERRO na conexão com o banco de dados:\n" +ex.getMessage());
}
}
public void executasql(String sql){
    try {
        stn = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
    rs=stn.executeQuery(sql);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "ERROna execução do sql\n" +ex.getMessage());

    }


}
public void desconecta(){
    try {
        con.close();
      //  JOptionPane.showMessageDialog(null, "BD Desconectado com sucesso");
    } catch (SQLException ex) {
        Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Erro ao desconectar do banco de dados!!:\n" +ex.getMessage());
    }
}
}