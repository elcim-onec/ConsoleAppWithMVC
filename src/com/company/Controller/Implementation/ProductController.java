package com.company.Controller.Implementation;

import com.company.Controller.CommonController;
import com.company.model.DAO.implementation.ProductDAO;
import com.company.model.entity.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductController implements CommonController <Product> {

    ProductDAO dao = new ProductDAO();

    @Override
    public List<Product> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Product findByID(Integer id) throws SQLException {
        return dao.findByID(id);
    }

    @Override
    public void create(Product entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Product entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
