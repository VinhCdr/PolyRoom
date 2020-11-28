package poro.model.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poro.model.helper.JDBC;

/**
 *
 * @author vinh
 */
abstract public class Dao {

    public <T extends Dao> ArrayList<T> select(Object... idData) {
        ArrayList<T> result = new ArrayList<>();
        try {
            ResultSet rs = JDBC.executeQuery(getSqlSelect(), idData);

            Object[] row = new Object[getRowCout()];
            for (int i = 1; i <= getRowCout(); i++) {
                row[i - 1] = rs.getObject(i);
            }

            result.add((T) setData(row));
        } catch (SQLException ex) {

        }

        return result;
    }

    abstract protected String getSqlSelect();

    abstract protected int getRowCout();

    abstract protected Object setData(Object[] data);
}
