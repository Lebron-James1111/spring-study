package impl;

import com.mysql.cj.jdbc.Driver;
import conn.DbDriver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: CY.Ma
 * @date: 2024/5/29 18:28
 * @description:
 */
public class MysqlDbDriver implements DbDriver {
    @Override
    public Connection getConnection(String url, Properties info) throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        return driver.connect(url, info);
    }

    @Override
    public String getType() {
        return "Mysql";
    }
}
