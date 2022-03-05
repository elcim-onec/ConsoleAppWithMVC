package com.company.model.DAO.implementation;

import com.company.DBConnector;
import com.company.model.DAO.CommonDAO;
import com.company.model.entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO  implements CommonDAO <Product>{
    private static final String GET_ALL = "SELECT * FROM system.product";
    private static final String GET_BY_ID = "SELECT * FROM system.product WHERE id=?";
    private static final String CREATE = "INSERT system.product "
            + "(name) VALUES (?)";
    private static final String UPDATE = "UPDATE system.product"
            + " SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM system.product WHERE id=?";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
                products.add(product);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public Product findByID(Integer id) throws SQLException {
        Product product = null;
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        } catch (Exception e){
            System.out.println("Could not find Product ID");
            e.printStackTrace();
        }
        return product;
    }


    @Override
    public void create(Product product) throws SQLException {

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(CREATE)){

            statement.setString(1, String.valueOf(product.getName()));

            statement.executeUpdate();
            System.out.println(statement);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Product product) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(UPDATE)){
            statement.setString(1, String.valueOf(product.getName()));

            statement.executeUpdate();
            System.out.println(statement);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(DELETE)){
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
