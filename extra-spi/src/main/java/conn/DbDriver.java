package conn;

import spi.type.TypedSPI;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: CY.Ma
 * @date: 2024/3/26 18:14
 * @description:
 */
public interface DbDriver extends TypedSPI {

    Connection getConnection(String url, Properties info) throws SQLException;

    @Override
    String getType();
}
