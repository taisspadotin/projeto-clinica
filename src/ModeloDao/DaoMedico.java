
package ModeloDao;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansMedico;

/**
 *
 * @author taisspadotin
 */
public class DaoMedico {
ConexaoBD conec= new ConexaoBD();
BeansMedico mod= new BeansMedico();
public void salvar(BeansMedico mod){
conec.conexao();
    try {
        PreparedStatement pst=conec.con.prepareStatement("insert into medicos(nome_medico, especialidade, crm_medico) values(?, ?, ?);");
    pst.setString(1, mod.getNome());
    pst.setString(2, mod.getEspecialidade());
    pst.setInt(3, mod.getCrm());
    pst.execute();
    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!");
    } catch (SQLException ex) {
        Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "ERRO ao inserir dados:"+ex);

    }
conec.desconecta();
}
public BeansMedico buscaMedico(BeansMedico mod){
conec.conexao();
conec.executasql("select *from medicos where nome_medico like '%"+mod.getPesquisa()+"%'");
    try {
        conec.rs.first();
        mod.setCodigo(conec.rs.getInt("cod_medico"));
        mod.setNome(conec.rs.getString("nome_medico"));
        mod.setEspecialidade(conec.rs.getString("especialidade"));
        mod.setCrm(conec.rs.getInt("crm_medico"));
       
        
    } catch (SQLException ex) {
        Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "ERRO ao buscar medico:\n00"+ex);
    }

conec.desconecta();
return mod;

}


}
