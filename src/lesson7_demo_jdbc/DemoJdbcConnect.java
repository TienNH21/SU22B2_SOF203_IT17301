package lesson7_demo_jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import lesson5.Product;

public class DemoJdbcConnect {
    public static void main(String[] args) {
        try {
            // B1: Load Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Kết nối
            String dbUser = "sa", dbPass = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;"
                    + ";databaseName=su22b2_sof203";
            
            Connection conn = DriverManager
                .getConnection(dbUrl, dbUser, dbPass);
            System.out.println("Kết nối thành công");
            
            Product p = new Product(0, "Áo thể thao", 10, 99999, "YELLOW", 1);
            
            String query = "INSERT INTO san_pham"
                + " (ten, so_luong, mau_sac, don_gia, danh_muc_id) "
                + " VALUES (?, ?, ?, ?, ?)";
            //              1  2  3  4  5
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, p.getTenSP());
            ps.setInt(2, p.getSoLg());
            ps.setString(3, p.getMauSac());
            ps.setDouble(4, p.getDonGia());
            ps.setInt(5, p.getDanhMucId());
            
            ps.execute();
            
            System.out.println("Success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
