package iuh.fit.nguyenngochongminh_tuan04_bai3.dao;

import iuh.fit.nguyenngochongminh_tuan04_bai3.model.Product;
import iuh.fit.nguyenngochongminh_tuan04_bai3.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DBUtil dbUtil;

    public ProductDAO(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = dbUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String model = rs.getString("MODEL");
                double price = rs.getDouble("PRICE");
                int quantity = rs.getInt("QUANTITY");
                String description = rs.getString("DESCRIPTION");
                Product p = new Product(id, model, description, quantity, price);
                list.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE ID=?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Integer proid = rs.getInt("ID");
                    String model = rs.getString("MODEL");
                    Double price = rs.getDouble("PRICE");
                    Integer quantity = rs.getInt("QUANTITY");
                    String description = rs.getString("DESCRIPTION");
                    return new Product(proid, model, description, quantity, price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}