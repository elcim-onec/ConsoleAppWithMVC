package com.company.model.DAO.implementation;

import com.company.DBConnector;
import com.company.model.DAO.CommonDAO;
import com.company.model.entity.Sentiment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SentimentDAO implements CommonDAO <Sentiment> {
    private static final String GET_ALL = "SELECT * FROM system.Sentiment";
    private static final String GET_BY_ID = "SELECT * FROM system.Sentiment WHERE id=?";
    private static final String CREATE = "INSERT system.Sentiment "
            + "(sentimentType) VALUES (?)";
    private static final String UPDATE = "UPDATE system.Sentiment"
            + " SET sentimentType=? WHERE id=?";
    private static final String DELETE = "DELETE FROM system.Sentiment WHERE id=?";

    @Override
    public List<Sentiment> findAll() throws SQLException {
        List<Sentiment> sentiments= new ArrayList<>();
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(GET_ALL)){
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Sentiment sentiment = new Sentiment(
                        resultSet.getInt("id"),
                        resultSet.getString("sentimentType")
                );
                sentiments.add(sentiment);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Sentiment findByID(Integer id) throws SQLException {
        Sentiment sentiment = null;
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                sentiment = new Sentiment(
                        resultSet.getInt("id"),
                        resultSet.getString("sentimentType")
                );
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return sentiment;
    }

    @Override
    public void create(Sentiment sentiment) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(CREATE)){
            statement.setString(1, sentiment.getSentimentType());

            statement.executeUpdate();
            System.out.println(statement);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Sentiment sentiment) throws SQLException {
        try(PreparedStatement statement = DBConnector.getConnection().prepareStatement(UPDATE)){

            statement.setString(1, sentiment.getSentimentType());

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
