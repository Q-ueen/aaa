package com.zretc.util;

import java.sql.*;

public class DBUtil {
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    // 获取数据库连接对象
    public static Connection getConn() {
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/three", "root", "root");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 关闭资源
    public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
