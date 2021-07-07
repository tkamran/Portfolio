package cc;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ccgui extends Application {
	
	private boolean isServer = false;
	
	private TextArea messages = new TextArea();
	private serverConnect connection = isServer ? createServer() : createClient();
	
	
	
	private Parent createContent() {
		
		messages.setPrefHeight(400);
		TextField input = new TextField();
		input.setOnAction(event -> {
			String message = isServer ? "Person 1: " : "Person 2: ";
			message += input.getText();
			input.clear();
			
			messages.appendText(message + "\n");
			
			try {
				connection.send(message);
				
			} catch (Exception e) {
				
				messages.appendText("Failed to Send" + "\n");
			}
			
		});
		
		VBox root = new VBox(20, messages, input);
		root.setPrefSize(600, 300);
		return root;
		
	}
	
	public void init() throws Exception {
		connection.startConnection();
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
		
	}
	
	public void stop() throws Exception {
		connection.closeConnection();
	}
	
	private Server createServer() {
		return new Server(55555, data -> {
			Platform.runLater(() -> {
				messages.appendText(data.toString() + "\n");
			});
		});
	}
	
	private Client createClient() {
		return new Client("127.0.0.1", 55555, data -> {
			Platform.runLater(() -> {
				messages.appendText(data.toString() + "\n");
			});
		});
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}

