package com.company.model.DAO;

import com.company.model.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface CommonDAO <E>{
    List<E> findAll() throws SQLException;

    E findByID(Integer id) throws SQLException;

    void create(E object) throws SQLException;

    void update(Integer id, E object) throws SQLException;

    void delete(Integer id) throws SQLException;
}
