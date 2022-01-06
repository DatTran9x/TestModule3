package dao;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Categorydao {
    private final static Connection connection = GetConnection.getConnection();
    private static PreparedStatement preparedStatement;

    public List<Category> getAll() {
        String getAllSql = "SELECT * FROM category";
        List<Category> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(getAllSql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id_category = rs.getInt("id_category");
                String name_category = rs.getString("name_category");
                Category newCategory = new Category(id_category,name_category);
                list.add(newCategory);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
