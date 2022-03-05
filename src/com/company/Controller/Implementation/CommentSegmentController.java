package com.company.Controller.Implementation;

import com.company.Controller.CommonController;
import com.company.model.DAO.implementation.CommentSegmentDAO;
import com.company.model.entity.CommentSegment;

import java.sql.SQLException;
import java.util.List;

public class CommentSegmentController implements CommonController <CommentSegment> {

    CommentSegmentDAO dao = new CommentSegmentDAO();

    @Override
    public List<CommentSegment> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CommentSegment findByID(Integer id) throws SQLException {
        return dao.findByID(id);
    }

    @Override
    public void create(CommentSegment entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CommentSegment entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
