package com.mycompany.warlay.controller;

import com.mycompany.warlay.model.FrameBuild;
import com.mycompany.warlay.model.FrameBuilds;
import com.mycompany.warlay.model.FrameMods;
import com.mycompany.warlay.model.Frames;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewWarframeController implements Initializable {
    
    /**
     * Logger for this class.
     */
    private final Logger slf4jLogger = LoggerFactory.getLogger(NewWarframeController.class);
    
    FrameMods frameModList = new FrameMods(); 
    Frames frameList = new Frames();
    
    FrameBuilds frameBuilds = new FrameBuilds();
    
    FrameBuild frameBuild = new FrameBuild();
    
    @FXML
    private ComboBox<String> warframe = new ComboBox<>();
    
    @FXML
    private TextField name;
    
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
    
    private void loadData() {
        frameModList.loadFrameMods();
        
        frameList.loadFrames();
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

        for( int i = 0; i < frameModList.getMods().size(); i++)
        {
            if( frameModList.getMods().get(i).getName().equals("Empty Slot") 
                || ( frameModList.getMods().get(i).getSlot().equals("aura")
                && ( frameModList.getMods().get(i).getAugment().equals( warframe.getValue() )
                || warframe.getValue().equals( frameModList.getMods().get(i).getAugment() + " Prime" )
                || frameModList.getMods().get(i).getAugment().equals( "no" ) ) ) )
                mod.get(0).getItems().add(frameModList.getMods().get(i).getName());
        }
        
        mod.get(1).getItems().clear();

        for( int i = 0; i < frameModList.getMods().size(); i++)
        {
            if( frameModList.getMods().get(i).getName().equals("Empty Slot") 
                || ( frameModList.getMods().get(i).getSlot().equals("exilus")
                && ( frameModList.getMods().get(i).getAugment().equals( warframe.getValue() )
                || warframe.getValue().equals( frameModList.getMods().get(i).getAugment() + " Prime" )
                || frameModList.getMods().get(i).getAugment().equals( "no" ) ) ) )
                mod.get(1).getItems().add(frameModList.getMods().get(i).getName());
        }
        
        for( int j = 2; j < 10; j++ )
        {
            mod.get(j).getItems().clear();

            for( int i = 0; i < frameModList.getMods().size(); i++)
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
    private void warframeAction( ActionEvent event )
    {
        message.setText("");
        
        frameBuild.setFrameName(warframe.getValue());
        
        for( int i = 0; i < frameList.getFrames().size(); i++ )
        {
            if( warframe.getValue().equals(frameList.getFrames().get(i).getName()))
            {               
                armor.setText( String.valueOf( frameList.getFrames().get(i).getBaseArmor() ) );
                energy.setText( String.valueOf( frameList.getFrames().get(i).getMaxEnergy() ) );
                health.setText( String.valueOf( frameList.getFrames().get(i).getMaxHealth() ) );
                shield.setText( String.valueOf( frameList.getFrames().get(i).getMaxShield() ) );
                
                duration.setText("100.0%");
                efficiency.setText("100.0%");
                range.setText("100.0%");  
                strength.setText("100.0%");    
                
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
        
        frameBuild.setSlotName( mod.get(k).getValue(),k ); 

        modRank.get(k).getItems().clear(); 

        for(int i = 0; i < frameModList.getMods().size(); i++)
        {
            if( frameModList.getMods().get(i).getName().equals(mod.get(k).getValue()) )
            {
                for(int j = 0; j <= frameModList.getMods().get(i).getMaxRank(); j++)
                {
                    modRank.get(k).getItems().add(String.valueOf(j));
                }
            }
        }         
    }
    
    @FXML
    private void modRankAction( ActionEvent event )
    {    
        message.setText("");
        
        int l = event.getSource().toString().indexOf("R");
        int i = Integer.parseInt( event.getSource().toString().substring(15, l) );
        
        if( modRank.get(i).getValue() != null )
        {
            frameBuild.setSlotRank( Double.parseDouble( modRank.get(i).getValue() ),i );
            calculate();
        }   
    }
    
    @FXML
    private void saveAction ( ActionEvent event )
    {
        frameBuild.setName(name.getText());
        
        message.setText("Saving");    
        
        if( frameBuild.getName() == null || frameBuild.getFrameName() == null || 
            frameBuild.getName().isEmpty() || frameBuild.getFrameName().isEmpty() )
        {
            message.setText("Empty field warning!");            
            this.slf4jLogger.warn(String.format("Empty field warning!"));
        }
        else
        {   
            for( int k = 0; k < 12; k++ )
            {
                if( modRank.get(k).getValue() == null )
                {
                    message.setText("Empty rank field warning!");     
                    this.slf4jLogger.warn(String.format("Empty rank field warning!"));
                }
            }
            
            for( int i = 0; i < 12; i++ )
            {
                if( frameBuild.getSlotName(i) == null )
                {
                    message.setText("Empty field warning!");                      
                    this.slf4jLogger.warn(String.format("Empty field warning!"));
                }
            }

            for( int i = 0; i < 9; i++ )
            {                
                for( int j = i+1; j < 10; j++ )
                {
                    if( frameBuild.getSlotName(i) != null
                        && !frameBuild.getSlotName(i).equals("Empty Slot")
                        && frameBuild.getSlotName(j) != null
                        && frameBuild.getSlotName(i).equals(frameBuild.getSlotName(j)) )
                    {
                        message.setText("Duplicate warning!");
                        this.slf4jLogger.warn(String.format("Duplicate warning!"));
                    }
                }
            }
        }
        
        if( !message.getText().equals("Duplicate warning!") && !message.getText().equals("Empty field warning!") && !message.getText().equals("Empty rank field warning!") )
        {
            frameBuilds.saveBuild(frameBuild);                    
            this.slf4jLogger.warn(String.format("Saving"));
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
        
        loadWarframe();        
    }          
}