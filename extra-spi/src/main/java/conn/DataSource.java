package conn;

import spi.type.TypedSPI;
import spi.type.TypedSPILoader;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

/**
 * @author: CY.Ma
 * @date: 2024/5/29 18:22
 * @description:
 */
public class DataSource {

    public static void getConnection(String dbType) throws SQLException {
        Optional<DbDriver> optional = TypedSPILoader.findService(DbDriver.class, dbType);
        optional.ifPresent(e -> {
            String url = "jdbc:mysql://localhost:3306/demo_ds_0?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
            Properties properties = new Properties();
            properties.setProperty("user", "test");
            properties.setProperty("password", "test");
            try {
                Connection connection = e.getConnection(url, properties);
                System.out.println(connection);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
