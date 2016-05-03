/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDDMapper;

import Entidades.Int_String;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Dani
 */
public class Int_StringMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Int_String intString = new Int_String();
        intString.setTexto(rs.getString(2));
        intString.setValor(rs.getInt(1));
        return intString;
    }
    
}
