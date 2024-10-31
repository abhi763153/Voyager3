package com.abhiapps.voyager3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class WebBrowser extends Application {
    private WebView webView;
    private TextField urlField;
    private ObservableList<String> history = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        // Create the root layout
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));

        // Create navigation controls
        HBox navigationBar = new HBox(5);
        Button backButton = new Button("←");
        Button forwardButton = new Button("→");
        Button refreshButton = new Button("⟳");
        Button homeButton = new Button("🏠");
        urlField = new TextField();
        Button goButton = new Button("Go");

        // URL field should expand to fill available space
        HBox.setHgrow(urlField, Priority.ALWAYS);

        navigationBar.getChildren().addAll(
                backButton, forwardButton, refreshButton,
                homeButton, urlField, goButton
        );

        // Create the web view
        webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Create status bar
        HBox statusBar = new HBox(5);
        Label statusLabel = new Label("Ready");
        ProgressBar loadProgress = new ProgressBar();
        statusBar.getChildren().addAll(statusLabel, loadProgress);

        // Add everything to the root layout
        root.getChildren().addAll(navigationBar, webView, statusBar);
        VBox.setVgrow(webView, Priority.ALWAYS);

        // Set up event handlers
        backButton.setOnAction(e -> webEngine.getHistory().go(-1));
        forwardButton.setOnAction(e -> webEngine.getHistory().go(1));
        refreshButton.setOnAction(e -> webEngine.reload());
        homeButton.setOnAction(e -> webEngine.load("https://www.google.com"));
        goButton.setOnAction(e -> loadUrl());
        urlField.setOnAction(e -> loadUrl());

        // Bind progress bar to loading progress
        loadProgress.progressProperty().bind(webEngine.getLoadWorker().progressProperty());

        // Update status label when loading state changes
        webEngine.getLoadWorker().stateProperty().addListener((obs, oldValue, newValue) -> {
            switch (newValue) {
                case SUCCEEDED:
                    statusLabel.setText("Page loaded");
                    urlField.setText(webEngine.getLocation());
                    history.add(webEngine.getLocation());
                    break;
                case FAILED:
                    statusLabel.setText("Loading failed");
                    break;
                case RUNNING:
                    statusLabel.setText("Loading...");
                    break;
                default:
                    statusLabel.setText("Ready");
            }
        });

        // Create scene and show stage
        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setTitle("Voyager3");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Load home page
        webEngine.load("https://www.google.com");
    }

    private void loadUrl() {
        String url = urlField.getText();
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        webView.getEngine().load(url);
    }

    public static void main(String[] args) {
        launch(args);
    }
}