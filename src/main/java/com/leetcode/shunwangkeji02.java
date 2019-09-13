package com.leetcode;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

public class shunwangkeji02 implements DataSource {

    private static LinkedList<Connection> connPool = new LinkedList<Connection>();

    static {
        InputStream in = shunwangkeji02.class.getClassLoader().getResourceAsStream("db.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            int InitSize = Integer.parseInt(prop.getProperty("InitSize"));
            Class.forName(driver);
            for (int i = 0; i < InitSize; i++) {
                Connection conn = DriverManager.getConnection(url, user, password);
                connPool.add(conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        if (connPool.size() > 0) {
            final Connection conn = connPool.removeFirst();
            return (Connection) Proxy.newProxyInstance(shunwangkeji02.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
                    if (!"close".equals(method.getName())) {
                        return method.invoke(conn, args);
                    } else {
                        connPool.add(conn);
                        return null;
                    }
                }
            });
        } else {
            throw new RuntimeException("DB busy, please retry later");
        }
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }



    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public ConnectionBuilder createConnectionBuilder() throws SQLException {
        return null;
    }



    @Override
    public ShardingKeyBuilder createShardingKeyBuilder() throws SQLException {
        return null;
    }

    public Object unwrap(Class iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class iface) throws SQLException {
        return false;
    }

    public Connection getConnection(String username, String password)
            throws SQLException {
        return null;
    }
}
