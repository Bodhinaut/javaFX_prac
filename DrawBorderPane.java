import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;

import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;

import javafx.scene.control.Button;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;
import java.util.Random;

public class DrawBorderPane extends BorderPane {
    Pane pane;
    Circle face;
    Circle leftEye;
    Circle rightEye;
    Ellipse mouth;
    Polygon hat;
    HBox controlHBox;
    Button hatButton;
    Button faceButton;
    Button leftEyeButton;
    Button rightEyeButton;
    Button mouthButton;
    
    Random rnd;
    
    public DrawBorderPane() {
        rnd = new Random();
        buildUI();
        customizeUI();
        registerEvents();
    }
    
    public void buildUI() {
        face = new Circle(250, 250, 200);
        leftEye = new Circle(150, 150, 30);
        rightEye = new Circle(350, 150, 30);
        mouth = new Ellipse(250, 350, 15, 40);
        
        hat = new Polygon(15.0, 70.0,
                          250.0, 10.0,
                          465.0, 70.0); // three doubles for point, 
        
        pane = new Pane( face, leftEye, rightEye, mouth, hat);
        setCenter(pane);
        
        hatButton = new Button("Hat");
        faceButton = new Button("Face");
        leftEyeButton = new Button("Left eye");
        rightEyeButton = new Button("Right eye");
        mouthButton = new Button("Mouth");
        
        controlHBox = new HBox(10, hatButton, faceButton, leftEyeButton, rightEyeButton, mouthButton);
        setBottom( controlHBox );
    }
    
    
    public void customizeUI() {
        //setStyle("-fx-padding: 20px 20px 20px 20px;");
        face.setStyle("-fx-stroke: yellow; -fx-fill: yellow;");
        // run through for each through the buttons to set them all easily, 
        for ( Node button : controlHBox.getChildren() ) {
            ( (Button)button ).setPrefWidth(90.0);
            //above he type casted for button ,
        }
        
        controlHBox.setStyle("-fx-padding: 10px 10px 10px 10px; " +
                         "-fx-text-align: center; " +
                         "-fx-border-width: 1px 1px 1px 1px; " +
                         "-fx-border-color: #bbbbbb; " + 
                         "-fx-border-style: solid;");
    }
    // beow adding so many buttons, what is the better way to do this?
/// lambda will be a huge reduction in code 
    public void registerEvents() {
        
       // hatButton.setOnAction(e -> ) {}
        
        
        
        // action events
        // target and register the hatbutton first , // crate insatnace of class to handle interface
        hatButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override // override action event this is an interface 
            public void handle(MouseEvent e) {
                System.out.println("Mouse was clicked");
            }// this is anonymous inner class 
        
        
        } );    // just created an object that
        // implements the interface 
        
        // mouse events
        
        // key events 
        // below the node has the focs Hbox
        controlHBox.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override // override action event this is an interface 
            public void handle(KeyEvent e) {
                Color rgb = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256) );
                //takes a mod 0 - 255 
                if (e.getCode() == KeyCode.H || e.getCode() == KeyCode.ENTER) {
                    hat.setFill(rgb);
                }
                 // fill random color 
            }// this is anonymous inner class 
        
        // h box should respond to evetns, not just button or wouldnt be able to access them all?
    } );
    
  }
}