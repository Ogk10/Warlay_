package com.mycompany.warlay.controller;

import com.mycompany.warlay.model.FrameBuild;
import com.mycompany.warlay.model.FrameBuilds;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {           
    
    FrameBuilds frameBuilds = new FrameBuilds();
    
    FrameBuild frameBuild = new FrameBuild();
    
    OverlayController newOverlay = new OverlayController();
        
    @FXML
    private Spinner<Integer> positionX;

    @FXML
    private Spinner<Integer> positionY;
    
    @FXML
    private Spinner<Integer> fontSize;
    
    @FXML
    private ComboBox<String> warframe = new ComboBox<>();
    
    @FXML
    private ComboBox<String> obs = new ComboBox<>();
    
    private void loadData() {
        
        frameBuilds.loadFrameBuild();        
         
        warframe.getItems().clear();     
        
        for( int i = 0; i < frameBuilds.getFrameBuilds().size(); i++ )
        {
            warframe.getItems().add( frameBuilds.getFrameBuilds().get(i).getName() );
        }  
    }
    
    @FXML
    private void warframeNewButtonAction(ActionEvent event) throws IOException 
    {        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/NewWarframe.fxml"));
                
        Stage stage  = new  Stage();        
        stage.setTitle("New Warframe");
        stage.setScene(new Scene(root, 1000, 400));
        stage.getScene().getStylesheets().add("/styles/Main.css");
        stage.setResizable(false);
        stage.show();
        stage.setOnHidden( e -> {loadData();} );
    }
    
    @FXML
    private void warframeEditButtonAction(ActionEvent event) throws IOException 
    {        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/EditWarframe.fxml"));	

        Stage stage  = new  Stage();
        stage.setTitle("Edit Warframe");
        stage.setScene(new Scene(root, 1000, 400));
        stage.getScene().getStylesheets().add("/styles/Main.css");
        stage.setResizable(false);
        stage.show();
        stage.setOnHidden( e -> {loadData();} );
    }
    
    @FXML
    private void openAction (ActionEvent event)
    {   
        if( warframe.getValue() != null && !newOverlay.overlay.isShowing() )
        {   
            newOverlay = new OverlayController();            
            
            if( obs.getValue().equals("Display") )
            {
                newOverlay.overlay.initStyle(StageStyle.TRANSPARENT);
                newOverlay.box.setStyle("-fx-background-color: rgba(0,0,0,0.7);");    
            }
            else
            {                
                newOverlay.box.setStyle("-fx-background-color: #00ff00;"); 
            }
            
            newOverlay.overlay.setAlwaysOnTop(true);  
            
            newOverlay.showOverlay(warframe.getValue(), fontSize.getValue(), positionX.getValue(), positionY.getValue());
        }
    }
    
    @FXML
    private void closeAction (ActionEvent event)
    {
        if( newOverlay.overlay.isShowing() )
        {    
            newOverlay.overlay.getScene().getWindow().hide();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        
        obs.getItems().add("Display");
        obs.getItems().add("Window");
        
        obs.getSelectionModel().selectFirst();
        
        SpinnerValueFactory<Integer> fontValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99999999, 17);
        fontSize.setValueFactory(fontValueFactory);
        
        SpinnerValueFactory<Integer> positionXValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(-99999999, 99999999, 25);
        positionX.setValueFactory(positionXValueFactory);
        
        SpinnerValueFactory<Integer> positionYValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(-99999999, 99999999, 370);
        positionY.setValueFactory(positionYValueFactory);
    }    
}