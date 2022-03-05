package com.company.model.DAO.implementation;

import com.company.DBConnector;
import com.company.model.DAO.CommonDAO;
import com.company.model.entity.Score;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO implements CommonDAO<Score> {
    private static final String GET_ALL = "SELECT * FROM system.Score";
    private static final String GET_BY_ID = "SELECT * FROM system.score WHERE id=?";
    private static final String CREATE = "INSERT system.Score "
            + "(score_type) VALUES (?)";
    private static final String UPDATE = "UPDATE system.Score"
            + " SET score_type=? WHERE id=?";
    private static final String DELETE = "DELETE FROM system.Score WHERE id=?";


    @Override
    public List<Score> findAll() throws SQLException {
        List<Score> scores= new ArrayList<>();
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(GET_ALL)){
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Score score = new Score(
                        resultSet.getInt("id"),
                        resultSet.getString("score_type")
                        );
                scores.add(score);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Score findByID(Integer id) throws SQLException {
        Score score = null;
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                score = new Score(
                        resultSet.getInt("id"),
                        resultSet.getString("score_type")
                );
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return score;
    }

    @Override
    public void create(Score scores) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(CREATE)){
            statement.setString(1, String.valueOf(scores.getScoreType()));

            statement.executeUpdate();
            System.out.println(statement);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Score scores) throws SQLException {
        try(PreparedStatement statement = DBConnector.getConnection().prepareStatement(UPDATE)){

            statement.setString(1, scores.getScoreType());
            statement.setInt(2, scores.getId());
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
