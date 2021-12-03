import databasemanager.DatabaseManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    static Logger logger = Logger.getLogger("Database Scrapper");
    public static void main(String args[]){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement stmt=null;
        ArrayList<String> tableNames = new ArrayList<>();
        try {
            con = DatabaseManager.getInstance().getConnection();

            DatabaseMetaData meta = con.getMetaData();
            ResultSet tables = meta.getTables(null,null,null,null);

            stmt = con.createStatement();
            while (tables.next()) {
                tableNames.add(tables.getString("TABLE_NAME"));
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
        logger.info("Found " + tableNames.size() + " Tables in the specified DB.");
        logger.info("They are: " + tableNames);
        ArrayList <String> queries = new ArrayList<>();
        TableInfo ti = new TableInfo();
        for (String table:tableNames){
            ArrayList<String> columns = ti.getTableColumns(table);
            String query;
            query = "insert into "+table+"(";
            for(String column : columns){
                query += column;
                if (!column.equals(columns.get(columns.size()-1))){
                    query += ",";
                }
            }
            query += ")";
            queries.add(query);
        }
        logger.info(queries);
    }
}
