package com.company.model.DAO.implementation;

import com.company.DBConnector;
import com.company.model.DAO.CommonDAO;
import com.company.model.entity.CommentSegment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentSegmentDAO implements CommonDAO<CommentSegment> {

    private static final String GET_ALL = "SELECT * FROM system.commentSegment";
    private static final String GET_BY_ID = "SELECT * FROM system.commentSegment WHERE id=?";
    private static final String CREATE = "INSERT system.commentSegment"
            + "(commentType) VALUES (?)";
    private static final String UPDATE = "UPDATE system.commentSegment"
            + " SET commentType=? WHERE id=?";
    private static final String DELETE = "DELETE FROM system.commentSegment WHERE id=?";


    @Override
    public List<CommentSegment> findAll() throws SQLException {

        List<CommentSegment> segments = new ArrayList<>();

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CommentSegment cSegment = new CommentSegment(
                        resultSet.getInt("id"),
                        resultSet.getString("commentType")
                );
                segments.add(cSegment);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return segments;
    }

    @Override
    public CommentSegment findByID(Integer id) {

        CommentSegment cSegment = null;

        try(PreparedStatement statement = DBConnector.getConnection().prepareStatement(GET_BY_ID)){

            statement.setInt(1,id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                cSegment = new CommentSegment(
                        resultSet.getInt("id"),
                        resultSet.getString("commentType")
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return cSegment;
    }

    @Override
    public void create(CommentSegment cSegment) throws SQLException {

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1,String.valueOf(cSegment.getCommentType()));

            statement.executeUpdate();
            System.out.println(statement);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, CommentSegment cSegment) throws SQLException {

        try(PreparedStatement statement = DBConnector.getConnection().prepareStatement(UPDATE)){

            statement.setInt(2, cSegment.getId());
            statement.setString(1,cSegment.getCommentType());

            statement.executeUpdate();
            System.out.println(statement);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(DELETE)) {

            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println(statement);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
