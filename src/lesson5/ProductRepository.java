package lesson5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {
    public void insert(Product p)
    {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "INSERT INTO san_pham"
                + " (ten, so_luong, mau_sac, don_gia, danh_muc_id) "
                + " VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, p.getTenSP());
            ps.setInt(2, p.getSoLg());
            ps.setString(3, p.getMauSac());
            ps.setDouble(4, p.getDonGia());
            ps.setInt(5, p.getDanhMucId());
            
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(int id, Product p)
    {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "UPDATE san_pham SET " +
                "ten = ?, so_luong = ?, mau_sac = ?, " +
                "don_gia = ?, danh_muc_id = ? " +
                 "WHERE id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, p.getTenSP());
            ps.setInt(2, p.getSoLg());
            ps.setString(3, p.getMauSac());
            ps.setDouble(4, p.getDonGia());
            ps.setInt(5, p.getDanhMucId());
            ps.setInt(6, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int id)
    {
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "DELETE FROM san_pham WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Product> all()
    {
        ArrayList<Product> listSP = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();
            String query = "SELECT * FROM san_pham";
            PreparedStatement ps = conn.prepareStatement(query);            
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            
            while (rs.next() == true) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String mau = rs.getString("mau_sac");
                int soLg = rs.getInt("so_luong");
                double donGia = rs.getDouble("don_gia");
                int danhMucId = rs.getInt("danh_muc_id");
                
                Product p = new Product(id, ten, soLg, donGia, mau, danhMucId);
                listSP.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listSP;
    }
}
