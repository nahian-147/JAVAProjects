import databasemanager.DatabaseManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class TableInfo {
    static Logger logger = Logger.getLogger(TableInfo.class.getName());
    public ArrayList<String> getTableColumns(String tableName){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement stmt=null;
        ArrayList<String> columnNames = new ArrayList<>();
        try {
            con = DatabaseManager.getInstance().getConnection();

            DatabaseMetaData meta = con.getMetaData();
            ResultSet columns = meta.getColumns(null,null,tableName,null);

            stmt = con.createStatement();


            while (columns.next()) {
                columnNames.add(columns.getString("COLUMN_NAME"));
            }
            rs.close();
        } catch (Exception e) {
            logger.fatal(e);
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException e) {
                logger.fatal(e);
            }
        }
        logger.info("Found " + columnNames.size() + " Coulmns in the Table, "+tableName);
        logger.info("They are: " + columnNames);
        return columnNames;
    }
}
