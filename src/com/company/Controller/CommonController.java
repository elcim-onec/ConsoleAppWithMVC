package com.company.Controller;

import java.sql.SQLException;
import java.util.List;

public interface CommonController <E> {

    List<E> findAll() throws SQLException;

    E findByID(Integer id) throws SQLException;

    void create(E entity) throws SQLException;

    void update(Integer id, E entity) throws SQLException;

    void delete(Integer id) throws SQLException;

}
