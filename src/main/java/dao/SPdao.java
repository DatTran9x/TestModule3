package dao;

import model.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SPdao {
    private final static Connection connection = GetConnection.getConnection();
    private static PreparedStatement preparedStatement;

    public List<SanPham> findAll( ){
        String getAllSql  = "Select * from sanpham";
        List<SanPham> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(getAllSql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id_sp = rs.getInt("id_sp");
                String name_sp = rs.getString("name_sp");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String mota_sp = rs.getString("mota_sp");
                int id_category = rs.getInt("id_category");
                SanPham sp = new SanPham(id_sp,name_sp,price,quantity,color,mota_sp,id_category);
                list.add(sp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void save(SanPham sp) {
        String saveSql = "insert into sanpham(name_sp,price,quantity,color,mota_sp,id_category) value (?,?,?,?,?,?);";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(saveSql);
            preparedStatement.setString(1,sp.getName_sp());
            preparedStatement.setInt(2,sp.getPrice());
            preparedStatement.setInt(3,sp.getQuantity());
            preparedStatement.setString(4,sp.getColor());
            preparedStatement.setString(5,sp.getMota_sp());
            preparedStatement.setInt(6,sp.getId_category());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public SanPham findByID(int id) {
        String getAllSql  = "Select * from sanpham where id_sp = ?";
        SanPham sp = new SanPham();
        try {
            preparedStatement = connection.prepareStatement(getAllSql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id_sp = rs.getInt("id_sp");
                String name_sp = rs.getString("name_sp");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String mota_sp = rs.getString("mota_sp");
                int id_category = rs.getInt("id_category");
                sp = new SanPham(id_sp,name_sp,price,quantity,color,mota_sp,id_category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sp;
    }

    public void edit(SanPham sp) {
        String editSql = "update sanpham set name_sp = ?,price = ?,quantity = ?,color = ?, mota_sp = ?,id_category = ? where id_sp = ?;";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(editSql);
            preparedStatement.setString(1,sp.getName_sp());
            preparedStatement.setInt(2,sp.getPrice());
            preparedStatement.setInt(3,sp.getQuantity());
            preparedStatement.setString(4,sp.getColor());
            preparedStatement.setString(5,sp.getMota_sp());
            preparedStatement.setInt(6,sp.getId_category());
            preparedStatement.setInt(7,sp.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        String deleteSql = "delete from sanpham where id_sp = ?;";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public SanPham findByName(String find) {
        String findSql = "SELECT * FROM test.sanpham WHERE name_sp like '%"+find+"%'";
        SanPham sp = new SanPham();
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(findSql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id_sp = rs.getInt("id_sp");
                String name_sp = rs.getString("name_sp");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String mota_sp = rs.getString("mota_sp");
                int id_category = rs.getInt("id_category");
                sp = new SanPham(id_sp,name_sp,price,quantity,color,mota_sp,id_category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sp;
    }
}
