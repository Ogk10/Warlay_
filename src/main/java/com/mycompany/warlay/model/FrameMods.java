package com.mycompany.warlay.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class representing the {@code FrameMods}.
 */
public class FrameMods {
    
    /**
     * Logger for this class.
     */
    private final Logger slf4jLogger = LoggerFactory.getLogger(FrameMods.class);
    
    /**
     * A list to store every FrameMod.
     */
    private List<FrameMod> mods;

    /**
     * Creating a new {@code ArrayList} for the {@code FrameMods}.
     */
    public FrameMods() {
        mods = new ArrayList<>();
    }
    
    /**
     * Loads every {@code FrameMod} from a {@code FrameMods.xml} into
     * a {@code FrameMod} list.
     */
    public void loadFrameMods()
    {
        mods.clear();
        
        try{
            InputStream inputFile = getClass().getClassLoader().getResourceAsStream("data/FrameMods.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
        
            doc.normalize();
        
            NodeList nodeList = doc.getElementsByTagName("framemod");
        
            for(int i=0; i<nodeList.getLength(); i++) {
                
                FrameMod mod = new FrameMod();
            
                Node node = nodeList.item(i);
                Element element = (Element) node;
            
                mod.setName(element.getAttribute("name"));  
                
                mod.setSlot(element.getElementsByTagName("slot").item(0).getTextContent()); 
                
                mod.setAugment(element.getElementsByTagName("augment").item(0).getTextContent()); 
                
                mod.setPolarity(element.getElementsByTagName("polarity").item(0).getTextContent()); 
                
                mod.setMisc(Boolean.valueOf(element.getElementsByTagName("misc").item(0).getTextContent()));   
                
                mod.setArmor(Double.parseDouble(element.getElementsByTagName("armor").item(0).getTextContent()));  
                
                mod.setEnergy(Double.parseDouble(element.getElementsByTagName("energy").item(0).getTextContent()));  
                
                mod.setHealth(Double.parseDouble(element.getElementsByTagName("health").item(0).getTextContent())); 
                
                mod.setShield(Double.parseDouble(element.getElementsByTagName("shield").item(0).getTextContent()));
                
                mod.setDuration(Double.parseDouble(element.getElementsByTagName("duration").item(0).getTextContent()));
                
                mod.setEfficiency(Double.parseDouble(element.getElementsByTagName("efficiency").item(0).getTextContent()));
                
                mod.setRange(Double.parseDouble(element.getElementsByTagName("range").item(0).getTextContent()));
                
                mod.setStrength(Double.parseDouble(element.getElementsByTagName("strength").item(0).getTextContent()));
                
                mod.setBaseCost(Double.parseDouble(element.getElementsByTagName("basecost").item(0).getTextContent()));
                
                mod.setMaxRank(Integer.parseInt(element.getElementsByTagName("maxrank").item(0).getTextContent()));
                            
                mods.add(mod);
            }   
        } 
        catch (IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException exception) 
        {
            this.slf4jLogger.warn(String.format("Exception Error!"));
        }
    }

    /**
     * Returns the list of {@code FrameMods}.
     * 
     * @return a {@code List} containing every {@code FrameMod} from 
     *         the database.
     */
    public List<FrameMod> getMods() {
        return Collections.unmodifiableList(mods);
    }    
}