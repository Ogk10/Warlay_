package com.mycompany.warlay.controller;

import com.mycompany.warlay.model.FrameBuild;
import com.mycompany.warlay.model.FrameBuilds;
import com.mycompany.warlay.model.FrameMods;
import com.mycompany.warlay.model.Frames;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OverlayController {

    FrameMods frameModList = new FrameMods(); 
    Frames frameList = new Frames();
    
    FrameBuilds frameBuilds = new FrameBuilds();
    
    FrameBuild frameBuild = new FrameBuild();
    
    Stage overlay = new Stage();
    
    VBox box = new VBox();   
    
    private void loadData() 
    {
        frameModList.loadFrameMods();
        
        frameList.loadFrames();
        
        frameBuilds.loadFrameBuild();     
    }
    
    public void showOverlay(String warframe, int fontSize, int x, int y )
    {   
        Text frameStats = new Text();
        
        loadData();
        
        for( int i = 0; i < frameBuilds.getFrameBuilds().size(); i++ )    
        {
            if( warframe.equals( frameBuilds.getFrameBuilds().get(i).getName() ))
            {   
                for( int j = 0; j < frameList.getFrames().size(); j++ )
                {
                    if( frameBuilds.getFrameBuilds().get(i).getFrameName().equals(frameList.getFrames().get(j).getName() ))
                    {   
                        frameList.getFrames().get(j).setDefault();
                            
                        for( int l = 0; l < 10; l++ )
                        {
                            for( int k = 0; k < frameModList.getMods().size(); k++ )
                            {
                                if( frameBuilds.getFrameBuilds().get(i).getSlotName(l).equals( frameModList.getMods().get(k).getName() ))
                                {
                                    frameList.getFrames().get(j).setArmor( frameModList.getMods().get(k).getArmor(), frameBuilds.getFrameBuilds().get(i).getSlotRank(l));
                                    frameList.getFrames().get(j).setEnergy( frameModList.getMods().get(k).getEnergy(), frameBuilds.getFrameBuilds().get(i).getSlotRank(l) );
                                    frameList.getFrames().get(j).setHealth( frameModList.getMods().get(k).getHealth(), frameBuilds.getFrameBuilds().get(i).getSlotRank(l) );
                                    frameList.getFrames().get(j).setShield( frameModList.getMods().get(k).getShield(), frameBuilds.getFrameBuilds().get(i).getSlotRank(l) );
                                       
                                    frameList.getFrames().get(j).setDuration( frameModList.getMods().get(k).getDuration(), frameBuilds.getFrameBuilds().get(i).getSlotRank(l) );
                                    frameList.getFrames().get(j).setEfficiency( frameModList.getMods().get(k).getEfficiency(), frameBuilds.getFrameBuilds().get(i).getSlotRank(l) );
                                    frameList.getFrames().get(j).setRange( frameModList.getMods().get(k).getRange(), frameBuilds.getFrameBuilds().get(i).getSlotRank(l) );
                                    frameList.getFrames().get(j).setStrength( frameModList.getMods().get(k).getStrength(), frameBuilds.getFrameBuilds().get(i).getSlotRank(l) );
                                }
                            }                                
                        }    
                        /*    
                        frameStats.setText("  " + frameBuilds.getFrameBuilds().get(i).getFrameName() + "  \n  "
                            + frameBuilds.getFrameBuilds().get(i).getName() + "  \n" +
                            "  ARMOR\t\t\t"  + frameList.getFrames().get(j).getArmor()  + "  \n" +
                            "  ENERGY\t\t\t" + frameList.getFrames().get(j).getEnergy() + "  \n" +
                            "  HEALTH\t\t" + frameList.getFrames().get(j).getHealth() + "  \n" +                    
                            "  SHIELD\t\t\t" + frameList.getFrames().get(j).getShield() + "  \n\n"+
                            "  DURATION\t\t" + frameList.getFrames().get(j).getDuration() + "%  \n" +
                            "  EFFICIENCY\t\t" + frameList.getFrames().get(j).getEfficiency() + "%  \n" +
                            "  RANGE\t\t\t" + frameList.getFrames().get(j).getRange() + "%  \n" +
                            "  STRENGTH\t\t" + frameList.getFrames().get(j).getStrength() + "%  \n");*/
                        
                        frameStats.setText("  " + frameBuilds.getFrameBuilds().get(i).getName() + "  \n" +
                            "  DURATION\t\t" + frameList.getFrames().get(j).getDuration() + "%  \n" +
                            "  EFFICIENCY\t\t" + frameList.getFrames().get(j).getEfficiency() + "%  \n" +
                            "  RANGE\t\t\t" + frameList.getFrames().get(j).getRange() + "%  \n" +
                            "  STRENGTH\t\t" + frameList.getFrames().get(j).getStrength() + "%  \n");
                        break;
                    }                
                }
                    
                for( int j = 0; j < 10; j++)
                {
                    if( !frameBuilds.getFrameBuilds().get(i).getSlotName(j).equals("Empty Slot") )
                        frameStats.setText( frameStats.getText() + "  \n  " + frameBuilds.getFrameBuilds().get(i).getSlotName(j) + " R" + (int)frameBuilds.getFrameBuilds().get(i).getSlotRank(j) + " " );
                }
                    
                if( !frameBuilds.getFrameBuilds().get(i).getSlotName(10).equals("Empty Slot") 
                    || !frameBuilds.getFrameBuilds().get(i).getSlotName(11).equals("Empty Slot") )
                    frameStats.setText( frameStats.getText() + "\n" );
                {    
                    for( int j = 10; j < 12; j++)
                    {
                        if( !frameBuilds.getFrameBuilds().get(i).getSlotName(j).equals("Empty Slot") )
                            frameStats.setText( frameStats.getText() + "  \n  " + frameBuilds.getFrameBuilds().get(i).getSlotName(j) + " R" + (int)frameBuilds.getFrameBuilds().get(i).getSlotRank(j) + " " );
                    }    
                }
                break;
            }
        }
        
        frameStats.setStyle( "-fx-stroke: black;" +
                             "-fx-stroke-width: 1;" +
                             "-fx-font-weight: bold;"  );
        
        frameStats.setFill(Color.WHITE);
        frameStats.setFont( Font.font ( "Insaniburger with Cheese", fontSize ) );                                                
        
        box.getChildren().add( frameStats );
                
        overlay.setX( x );
        overlay.setY( y );          
                    
        Scene scene = new Scene( box );  
        scene.setCursor(Cursor.NONE);
        scene.setFill(null);
        
        overlay.setScene(scene);
        overlay.setResizable(false);
        overlay.setTitle("Overlay");
        
        overlay.show(); 
    }       
}