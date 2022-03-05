package com.company.Controller.Implementation;

import com.company.Controller.CommonController;
import com.company.model.DAO.implementation.ScoreDAO;
import com.company.model.entity.Score;

import java.sql.SQLException;
import java.util.List;

public class ScoreController implements CommonController <Score> {

    ScoreDAO dao = new ScoreDAO();

    @Override
    public List<Score> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Score findByID(Integer id) throws SQLException {
        return dao.findByID(id);
    }

    @Override
    public void create(Score entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Score entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
