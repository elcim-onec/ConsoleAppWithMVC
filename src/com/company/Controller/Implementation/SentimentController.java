package com.company.Controller.Implementation;

import com.company.Controller.CommonController;
import com.company.model.DAO.implementation.SentimentDAO;
import com.company.model.entity.Sentiment;

import java.sql.SQLException;
import java.util.List;

public class SentimentController implements CommonController <Sentiment>{

    SentimentDAO dao = new SentimentDAO();

    @Override
    public List<Sentiment> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Sentiment findByID(Integer id) throws SQLException {
        return dao.findByID(id);
    }

    @Override
    public void create(Sentiment entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Sentiment entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
