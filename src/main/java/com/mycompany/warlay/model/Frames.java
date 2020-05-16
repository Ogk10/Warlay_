package com.mycompany.warlay.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * A class representing the {@code Frames}.
 */
public class Frames {
    
    /**
     * Logger for this class.
     */
    private final Logger slf4jLogger = LoggerFactory.getLogger(Frames.class);
    
    /**
     * A list to store every Frame.
     */
    private List<Frame> frames;

    /**
     * Creating a new {@code ArrayList} for the {@code Frames}.
     */
    public Frames() {
        frames = new ArrayList<>();
    }
    
    /**
     * Loads every {@code Frame} from a {@code Frames.xml} into 
     * a {@code Frame} list.
     */
    public void loadFrames()
    {
        frames.clear();
        
        try{
            InputStream inputFile = getClass().getClassLoader().getResourceAsStream("data/Frames.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
        
            doc.normalize();
        
            NodeList nodeList = doc.getElementsByTagName("frame");
        
            for(int i=0; i<nodeList.getLength(); i++) {
                
                Frame frame = new Frame();
            
                Node node = nodeList.item(i);
                Element element = (Element) node;
            
                frame.setName(element.getAttribute("name"));  
                                
                frame.setBaseArmor(Double.parseDouble(element.getElementsByTagName("baseArmor").item(0).getTextContent()));
                
                frame.setBaseEnergy(Double.parseDouble(element.getElementsByTagName("baseEnergy").item(0).getTextContent()));
                
                frame.setBaseHealth(Double.parseDouble(element.getElementsByTagName("baseHealth").item(0).getTextContent()));
                
                frame.setBaseShield(Double.parseDouble(element.getElementsByTagName("baseShield").item(0).getTextContent())); 
                
                frame.setMaxEnergy(Double.parseDouble(element.getElementsByTagName("maxEnergy").item(0).getTextContent())); 
                
                frame.setMaxHealth(Double.parseDouble(element.getElementsByTagName("maxHealth").item(0).getTextContent())); 
                
                frame.setMaxShield(Double.parseDouble(element.getElementsByTagName("maxShield").item(0).getTextContent()));  
                            
                frames.add(frame);
            }   
        } 
        catch (IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e) 
        {
            this.slf4jLogger.warn(String.format("Exception Error!"));
        }
    }
    
    /**
     * Returns the list of {@code Frames}.
     * 
     * @return a {@code List} containing every {@code Frame} from 
     *         the database.
     */
    public List<Frame> getFrames() {
        return Collections.unmodifiableList(frames);
    }    
}