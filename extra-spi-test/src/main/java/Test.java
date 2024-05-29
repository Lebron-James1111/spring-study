import conn.DataSource;

import java.sql.SQLException;

/**
 * @author: CY.Ma
 * @date: 2024/5/29 18:27
 * @description:
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        DataSource.getConnection("Mysql");
    }
}
