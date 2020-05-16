package com.mycompany.warlay.controller;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.Node;
import java.util.ArrayList;
import javafx.scene.text.Text;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import com.mycompany.warlay.model.FrameMods;
import com.mycompany.warlay.model.Frames;

import com.mycompany.warlay.model.FrameBuilds;
import com.mycompany.warlay.model.FrameBuild;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EditWarframeController implements Initializable {
    
    /**
     * Logger for this class.
     */
    private final Logger slf4jLogger = LoggerFactory.getLogger(EditWarframeController.class);
        
    FrameMods frameModList = new FrameMods(); 
    Frames frameList = new Frames();
    
    FrameBuilds frameBuilds = new FrameBuilds();
    
    FrameBuild frameBuild = new FrameBuild();
    
    @FXML
    private ComboBox<String> warframe = new ComboBox<>();
    
    @FXML
    private ComboBox<String> name = new ComboBox<>();
    
    @FXML
    private Text message;
    
    @FXML
    private ArrayList<ComboBox<String>> mod = new ArrayList<>();
    @FXML
    private ArrayList<ComboBox<String>> modRank = new ArrayList<>();
    
    @FXML
    private Text armor;     
    
    @FXML
    private Text energy;    
    
    @FXML
    private Text health;
    
    @FXML
    private Text shield;
    
    @FXML
    private Text duration;
    
    @FXML
    private Text efficiency;
    
    @FXML
    private Text range;
    
    @FXML
    private Text strength;
    
    @FXML
    private TextField saveName;
    
    private void loadData() {
        frameModList.loadFrameMods();
        
        frameList.loadFrames();
        
        frameBuilds.loadFrameBuild();
    }
    
    private void loadName(){
        
        name.getItems().clear();        
        
        for( int i = 0; i < frameBuilds.getFrameBuilds().size(); i++ )
        {
            name.getItems().add( frameBuilds.getFrameBuilds().get(i).getName() );
        }       
    }
    
    private void loadWarframe(){
        
        warframe.getItems().clear();
        
        for (int i = 0; i < frameList.getFrames().size(); i++)
        {
            warframe.getItems().add(frameList.getFrames().get(i).getName());
        }
    }
    
    private void loadSlots()
    {              
        mod.get(0).getItems().clear(); 
        
        for(int i = 0; i < frameModList.getMods().size(); i++)
        {
            if( frameModList.getMods().get(i).getName().equals("Empty Slot") 
                || ( frameModList.getMods().get(i).getSlot().equals("aura")
                && ( frameModList.getMods().get(i).getAugment().equals( warframe.getValue() )
                || warframe.getValue().equals( frameModList.getMods().get(i).getAugment() + " Prime" )
                || frameModList.getMods().get(i).getAugment().equals( "no" ) ) ) )
                mod.get(0).getItems().add(frameModList.getMods().get(i).getName());
        }
                
        mod.get(1).getItems().clear(); 
        
        for(int i = 0; i < frameModList.getMods().size(); i++)
        {
            if( frameModList.getMods().get(i).getName().equals("Empty Slot") 
                || ( frameModList.getMods().get(i).getSlot().equals("exilus")
                && ( frameModList.getMods().get(i).getAugment().equals( warframe.getValue() )
                || warframe.getValue().equals( frameModList.getMods().get(i).getAugment() + " Prime" )
                || frameModList.getMods().get(i).getAugment().equals( "no" ) ) ) )
                mod.get(1).getItems().add(frameModList.getMods().get(i).getName());
        }
        
        for(int j = 2; j < 10; j++ )
        {        
            mod.get(j).getItems().clear();  

            for(int i = 0; i < frameModList.getMods().size(); i++)
            {
                if( frameModList.getMods().get(i).getName().equals("Empty Slot") 
                    || ( !frameModList.getMods().get(i).getSlot().equals("aura")
                    && !frameModList.getMods().get(i).getSlot().equals("arcane")
                    && ( frameModList.getMods().get(i).getAugment().equals( warframe.getValue() )
                    || warframe.getValue().equals( frameModList.getMods().get(i).getAugment() + " Prime" )
                    || frameModList.getMods().get(i).getAugment().equals( "no" ) ) ) )               
                    mod.get(j).getItems().add(frameModList.getMods().get(i).getName());
            }  
        }
        
        for( int j = 10; j < 12; j++ )
        {
            mod.get(j).getItems().clear();

            for( int i = 0; i < frameModList.getMods().size(); i++)
            {
                if( frameModList.getMods().get(i).getName().equals("Empty Slot") 
                    || ( frameModList.getMods().get(i).getSlot().equals("arcane")
                    && ( frameModList.getMods().get(i).getAugment().equals( warframe.getValue() )
                    || warframe.getValue().equals( frameModList.getMods().get(i).getAugment() + " Prime" )
                    || frameModList.getMods().get(i).getAugment().equals( "no" ) ) ) )
                    mod.get(j).getItems().add(frameModList.getMods().get(i).getName());
            }
        }
    }
    
    private void calculate()
    {
        for( int i = 0; i < frameList.getFrames().size(); i++ )
        { 
            if( frameBuild.getFrameName().equals(frameList.getFrames().get(i).getName() ))
            {                 
                frameList.getFrames().get(i).setDefault();
                
                for( int j = 0; j < frameModList.getMods().size(); j++)
                {
                    for( int k = 0; k < 10; k++ )
                    {
                        if( frameBuild.getSlotName(k)!=null && frameBuild.getSlotName(k).equals( frameModList.getMods().get(j).getName() ))
                        {
                            frameList.getFrames().get(i).setArmor( frameModList.getMods().get(j).getArmor(), frameBuild.getSlotRank(k) );
                            frameList.getFrames().get(i).setEnergy( frameModList.getMods().get(j).getEnergy(), frameBuild.getSlotRank(k) );
                            frameList.getFrames().get(i).setHealth( frameModList.getMods().get(j).getHealth(), frameBuild.getSlotRank(k) );
                            frameList.getFrames().get(i).setShield( frameModList.getMods().get(j).getShield(), frameBuild.getSlotRank(k) );
                            
                            frameList.getFrames().get(i).setDuration( frameModList.getMods().get(j).getDuration(), frameBuild.getSlotRank(k) );
                            frameList.getFrames().get(i).setEfficiency( frameModList.getMods().get(j).getEfficiency(), frameBuild.getSlotRank(k) );
                            frameList.getFrames().get(i).setRange( frameModList.getMods().get(j).getRange(), frameBuild.getSlotRank(k) );
                            frameList.getFrames().get(i).setStrength( frameModList.getMods().get(j).getStrength(), frameBuild.getSlotRank(k) );                            
                        }
                    }
                }
                
                armor.setText( String.valueOf( frameList.getFrames().get(i).getArmor() ) );
                energy.setText( String.valueOf( frameList.getFrames().get(i).getEnergy() ) );
                health.setText( String.valueOf( frameList.getFrames().get(i).getHealth() ) );
                shield.setText( String.valueOf( frameList.getFrames().get(i).getShield() ) ); 
                
                duration.setText( String.valueOf( frameList.getFrames().get(i).getDuration() ) + "%" ); 
                efficiency.setText( String.valueOf( frameList.getFrames().get(i).getEfficiency() ) + "%" ); 
                range.setText( String.valueOf( frameList.getFrames().get(i).getRange() ) + "%" );            
                strength.setText( String.valueOf( frameList.getFrames().get(i).getStrength() ) + "%" );                
                
                break;
            }
        }        
    }
    
    @FXML
    private void nameAction( ActionEvent event )
    {   
        message.setText("");
        
        if ( name.getValue() != null )
        {   
            frameBuild.setName( name.getValue() );
            
            for( int i = 0; i < frameBuilds.getFrameBuilds().size(); i++ )
            {
                if ( name.getValue().equals( frameBuilds.getFrameBuilds().get(i).getName() ) )
                {
                    frameBuild.setFrameName( frameBuilds.getFrameBuilds().get(i).getFrameName() );
                    
                    for( int j = 0; j < 12; j++ )
                    {
                        frameBuild.setSlotName( frameBuilds.getFrameBuilds().get(i).getSlotName(j), j );
                        frameBuild.setSlotRank( frameBuilds.getFrameBuilds().get(i).getSlotRank(j), j );   
                    }
                    
                    warframe.getSelectionModel().select( frameBuild.getFrameName() );
                    
                    for( int j = 0; j < 12; j++ )
                    {
                        mod.get(j).getSelectionModel().select( frameBuild.getSlotName(j) );   
                        modRank.get(j).getSelectionModel().select(String.valueOf( (int) frameBuild.getSlotRank(j) ));                     
                    }
                    
                    break;
                }
            }
        }
    }
        
    @FXML
    private void warframeAction( ActionEvent event )
    {
        message.setText("");
     
        frameBuild.setFrameName(warframe.getValue());
        
        for( int i = 0; i < frameList.getFrames().size(); i++ )
        {
            if( warframe.getValue().equals(frameList.getFrames().get(i).getName()))
            {                
                calculate();
                
                loadSlots();
            }
        }
    }
    
    @FXML
    private void modAction( ActionEvent event )
    {
        message.setText("");
       
        int l = event.getSource().toString().indexOf(",");
        int k = Integer.parseInt( event.getSource().toString().substring(15, l) );
        
        frameBuild.setSlotName(mod.get(k).getValue(), k);      
        
        modRank.get(k).getItems().clear(); 
        
        for(int i = 0; i < frameModList.getMods().size(); i++)
        {
            if( frameModList.getMods().get(i).getName().equals(mod.get(k).getValue()) )
            {
                for(int j = 0; j <= frameModList.getMods().get(i).getMaxRank(); j++)
                {
                    modRank.get(k).getItems().add(String.valueOf(j));
                }
                break;
            }
        } 
    }
    
    @FXML
    private void modRankAction( ActionEvent event )
    {
        message.setText("");
        
        int l = event.getSource().toString().indexOf("R");
        int i = Integer.parseInt( event.getTarget().toString().substring(15, l) );
        
        if( modRank.get(i).getValue() != null )
        {
            frameBuild.setSlotRank(Double.parseDouble(modRank.get(i).getValue()),i);     
            calculate();
        }   
    }
    
    @FXML
    private void saveAction ( ActionEvent event )
    {
        frameBuild.setName(name.getValue());
        
        message.setText("Saving"); 
        
        for( int k = 0; k < 12; k++ )
        {
            if( modRank.get(k).getValue() == null )
            {
                message.setText("Empty rank field warning!");
                this.slf4jLogger.info(String.format("Empty rank field warning!"));
            }
        }
            
        for( int i = 0; i < 9; i++ )
        {                
            for( int j = i+1; j < 10; j++ )
            {
                if( frameBuild.getSlotName(i).equals(frameBuild.getSlotName(j))
                    && !frameBuild.getSlotName(i).equals("Empty Slot") )
                {
                    message.setText("Duplicate warning!");  
                    this.slf4jLogger.info(String.format("Duplicate warning!"));
                }
            }
        }    
            
        if( !message.getText().equals("Duplicate warning!") && !message.getText().equals("Empty field warning!") && !message.getText().equals("Empty rank field warning!") )
        {
            frameBuilds.updateBuild(frameBuild);
            this.slf4jLogger.info(String.format("Saving"));
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }
    
    @FXML
    private void saveAsAction ( ActionEvent event )
    {   
        frameBuild.setName( saveName.getText() );
        message.setText("Saving"); 
        
        for( int k = 0; k < 12; k++ )
        {
            if( modRank.get(k).getValue() == null )
            {
                message.setText("Empty rank field warning!");
                this.slf4jLogger.info(String.format("Empty rank field warning!"));
            }
        }
            
        for( int i = 0; i < 9; i++ )
        {                
            for( int j = i+1; j < 10; j++ )
            {
                if( frameBuild.getSlotName(i).equals(frameBuild.getSlotName(j))
                    && !frameBuild.getSlotName(i).equals("Empty Slot") )
                {
                    message.setText("Duplicate warning!");  
                    this.slf4jLogger.info(String.format("Duplicate warning!"));
                }
            }
        }    
            
        if( !message.getText().equals("Duplicate warning!") && !message.getText().equals("Empty field warning!") && !message.getText().equals("Empty rank field warning!") )
        {
            frameBuilds.saveBuild(frameBuild);
            this.slf4jLogger.info(String.format("Saving"));
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }
    
    @FXML
    private void deleteAction ( ActionEvent event )
    {             
        if( !name.getSelectionModel().isEmpty() )
        {
            frameBuilds.deleteBuild(frameBuild);            
            this.slf4jLogger.info(String.format("Deleting build!"));
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }
    
    @FXML
    private void cancelAction ( ActionEvent event )
    {                    
        ((Node)(event.getSource())).getScene().getWindow().hide();       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadData();
        
        loadName();
        
        loadWarframe();
    }          
}