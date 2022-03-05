package com.company.View;

import com.company.Controller.Implementation.CommentSegmentController;
import com.company.Controller.Implementation.ProductController;
import com.company.Controller.Implementation.ScoreController;
import com.company.Controller.Implementation.SentimentController;
import com.company.model.entity.CommentSegment;
import com.company.model.entity.Product;
import com.company.model.entity.Score;
import com.company.model.entity.Sentiment;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner sc = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private final ScoreController scoreController = new ScoreController();
    private final ProductController productController = new ProductController();
    private final SentimentController sentimentController = new SentimentController();
    private final CommentSegmentController commentSegmentController = new CommentSegmentController();


    public View() {

        menu.put("1-1", this::getAllScores);
        menu.put("1-2", this::getScoresById);
        menu.put("1-3", this::createScores);
        menu.put("1-4", this::updateScores);
        menu.put("1-5", this::deleteScores);

        menu.put("2-1", this::getAllSentiments);
        menu.put("2-2", this::getSentimentsById);
        menu.put("2-3", this::createSentiments);
        menu.put("2-4", this::updateSentiments);
        menu.put("2-5", this::deleteSentiments);

        menu.put("3-1", this::getAllSegments);
        menu.put("3-2", this::getSegmentsById);
        menu.put("3-3", this::createSegments);
        menu.put("3-4", this::updateSegments);
        menu.put("3-5", this::deleteSegments);

        menu.put("4-1", this::getAllProducts);
        menu.put("4-2", this::getProductById);
        menu.put("4-3", this::createProduct);
        menu.put("4-4", this::updateProduct);
        menu.put("4-5", this::deleteProduct);


    }

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("Enter entity and operation combinations like shown: 1-2, 2-3 etc...");

        do {
            try {
                input = sc.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (sc.hasNext());
    }

    //----------------SCORES----------------
    private void getAllScores() throws SQLException {
        System.out.println("\n All scores: ");
        System.out.println(scoreController.findAll() + "\n");
    }

    private void getScoresById() throws SQLException{
        System.out.println("\nGET Score by ID... Enter Score ID: ");
        Integer id = sc.nextInt();
        System.out.println(scoreController.findByID(id));
    }

    private Score getScoreInputs() {
        System.out.println("\nEnter a new Score Type: ");
        String scoreType = sc.next();
        return new Score(scoreType);
    }

    private void createScores() throws SQLException {
        System.out.println("\nCreating Score Type: ");
        Score score = getScoreInputs();
        scoreController.create(score);
        System.out.println("A new Score Type is created\n");
    }

    private void updateScores() throws SQLException {
        System.out.println("\nUPDATE Score Type... Enter Score ID: ");
        Integer id = sc.nextInt();
        Score score = getScoreInputs();
        score.setId(id);

        scoreController.update(score.getId(), score);
        System.out.println("Updated Score with Score ID=" + id + " \n");
    }

    private void deleteScores() throws SQLException {
        System.out.println("\nDELETE Score type... Enter ID: ");
        int id = sc.nextInt();

        scoreController.delete(id);
        System.out.println("Deleted Score Type with ID=" + id + " \n");
    }

    //----------------SENTIMENTS----------------

    private void getAllSentiments() throws SQLException {
        System.out.println("\nAll scores: ");
        System.out.println(sentimentController.findAll() + "\n");

    }

    private void getSentimentsById() throws SQLException{
        System.out.println("\nGET Sentiment by ID... Enter Sentiment ID: ");
        Integer id = sc.nextInt();
        System.out.println(sentimentController.findByID(id));
    }

    private Sentiment getSentimentInputs() {
        System.out.println("\nEnter a new Sentiment Type: ");
        String sentimentType = sc.next();
        return new Sentiment(sentimentType);
    }

    private void createSentiments() throws SQLException {
        System.out.println("\nCreating Score Type: ");
        Sentiment sentiment = getSentimentInputs();
        sentimentController.create(sentiment);
        System.out.println("A new Sentiment Type is created\n");
    }

    private void updateSentiments() throws SQLException {
        System.out.println("\nUPDATE Sentiment Type... Enter Sentiment ID: ");
        Integer id = sc.nextInt();
        Sentiment sentiment = getSentimentInputs();
        sentiment.setId(id);

        sentimentController.update(sentiment.getId(), sentiment);
        System.out.println("Updated Sentiment with Score ID=" + id + " \n");
    }

    private void deleteSentiments() throws SQLException {
        System.out.println("\nDELETE Sentiment type... Enter Sentiment ID: ");
        int id = sc.nextInt();

        sentimentController.delete(id);
        System.out.println("Deleted Sentiment Type with ID=" + id + " \n");
    }

    //----------------COMMENT SEGMENTS----------------

    private void getAllSegments() throws SQLException {
        System.out.println("\nAll Segments: ");
        System.out.println(commentSegmentController.findAll() + "\n");
    }

    private void getSegmentsById() throws SQLException{
        System.out.println("\nGET Segment by ID... Enter Segment ID: ");
        Integer id = sc.nextInt();
        System.out.println(commentSegmentController.findByID(id));
    }

    private CommentSegment getSegmentsInputs() {
        System.out.println("\nEnter a new Segment Type: ");
        String commentType = sc.next();
        return new CommentSegment(commentType);
    }

    private void createSegments() throws SQLException {
        System.out.println("\nCreating Segment Type: ");
        CommentSegment commentSegment = getSegmentsInputs();
        commentSegmentController.create(commentSegment);
        System.out.println("A new Segments Type is created\n");
    }

    private void updateSegments() throws SQLException {
        System.out.println("\nUPDATE Segments Type... Enter Sentiment ID: ");
        Integer id = sc.nextInt();
        CommentSegment commentSegment = getSegmentsInputs();
        commentSegment.setId(id);

        commentSegmentController.update(commentSegment.getId(), commentSegment);
        System.out.println("Updated Segment with Segment ID=" + id + " \n");
    }

    private void deleteSegments() throws SQLException {
        System.out.println("\nDELETE Segment type... Enter Segment ID: ");
        int id = sc.nextInt();

        commentSegmentController.delete(id);
        System.out.println("Deleted Segment Type with ID=" + id + " \n");
    }

    //----------------PRODUCT---------------

    private void getAllProducts() throws SQLException {
        System.out.println("\nAll Products: ");
        System.out.println(commentSegmentController.findAll() + "\n");
    }

    private void getProductById() throws SQLException{
        System.out.println("\nGET Product by ID... Enter Product ID: ");
        Integer id = sc.nextInt();
        System.out.println(productController.findByID(id));
    }

    private Product getProductInputs() {
        System.out.println("\nEnter a new Product: ");
        String name = sc.next();
        return new Product(name);
    }

    private void createProduct() throws SQLException {
        System.out.println("\nCreating Products: ");
        Product product = getProductInputs();
        productController.create(product);
        System.out.println("A new Product is created\n");
    }

    private void updateProduct() throws SQLException {
        System.out.println("\nUPDATE Product... Enter Product ID: ");
        Integer id = sc.nextInt();
        Product product= getProductInputs();
        product.setId(id);

        productController.update(product.getId(), product);
        System.out.println("Updated Product with Product ID=" + id + " \n");
    }

    private void deleteProduct() throws SQLException {
        System.out.println("\nDELETE Product type... Enter Product ID: ");
        int id = sc.nextInt();

        productController.delete(id);
        System.out.println("Deleted Product Type with ID=" + id + " \n");
    }

}
