package model.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class TronDAO extends AbstractDAO {
    private static String sqlResult = "{call showResult(?, ?)}";
    public static void setResult(final int player, final long time) throws SQLException {
        final CallableStatement callStatement = AbstractDAO.prepareCall(TronDAO.sqlResult);
        callStatement.setInt(1, player);
        callStatement.setLong(2, time);
        callStatement.executeUpdate();

}
    }
