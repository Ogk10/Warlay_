package com.mycompany.warlay.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class representing the {@code FrameBuilds}.
 */
public class FrameBuilds {
    
    /**
     * Logger for this class.
     */
    private final Logger slf4jLogger = LoggerFactory.getLogger(FrameBuilds.class);
    
    /**
     * A list to store every FrameBuild.
     */
    public List<FrameBuild> frameBuilds;

    /**
     * Creating a new {@code ArrayList} for the {@code FrameBuilds}.
     */
    public FrameBuilds() {
        frameBuilds = new ArrayList<>();
    }
    
    /**
     * Loads every {@code FrameBuild} from a {@code Warframes.xml} into
     * a {@code FrameBuild} list.
     */
    public void loadFrameBuild()
    {
        frameBuilds.clear();
        
        try{
            File inputFile = new File("Saves/Warframes.xml");            
            
            File directory = new File("Saves");
            
            if( !directory.exists() )
            {
                directory.mkdir();
                
                if( !inputFile.exists() )
                {   
                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                    Document doc = docBuilder.newDocument();
                    Element warframes = doc.createElement("warframes");
                    doc.appendChild(warframes);

                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult( inputFile );

                    transformer.transform( source, result );
                }
            }   
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);

            doc.normalize();

            NodeList nodeList = doc.getElementsByTagName("warframe");

            for( int i = 0; i < nodeList.getLength(); i++ ) {
                
                FrameBuild frameBuild = new FrameBuild();

                Node node = nodeList.item(i);
                Element element = (Element) node;

                frameBuild.setName(element.getAttribute("name"));  

                frameBuild.setFrameName(element.getElementsByTagName("warframename").item(0).getTextContent());

                for( int j = 0; j < 12; j++ )
                {
                    frameBuild.setSlotName(element.getElementsByTagName("mod" + j).item(0).getTextContent(),j);
                    frameBuild.setSlotRank(Double.parseDouble(element.getElementsByTagName("mod" + j + "rank").item(0).getTextContent()),j);
                }     
                frameBuilds.add(frameBuild);
            }            
        }
        catch (IOException | NumberFormatException | ParserConfigurationException | TransformerException | DOMException | SAXException e) 
        {
            this.slf4jLogger.warn(String.format("Exception Error!"));
        }
    }
    
    /**
     * Saves a {@code FrameBuild} from a {@code FrameBuild} list into
     * the {@code Warframes.xml}.
     * 
     * @param frameBuild the {@code FrameBuild} to be saved.
     */
    public void saveBuild(FrameBuild frameBuild)
    {
        try {
		String filepath = "Saves/Warframes.xml";            
                
                frameBuilds.add(frameBuild);
                
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(filepath);
                
		Node warframes = doc.getFirstChild();

		Element frame = doc.createElement("warframe");
		warframes.appendChild(frame);

		Attr attr = doc.createAttribute("name");
		attr.setValue(frameBuilds.get(frameBuilds.size()-1).getName());
		frame.setAttributeNode(attr);

		Element frameName = doc.createElement("warframename");
		frameName.appendChild(doc.createTextNode(frameBuilds.get(frameBuilds.size()-1).getFrameName()));
		frame.appendChild(frameName);
                
                        
                for( int i = 0; i < 12; i++ )
                {                    
                    Element mod = doc.createElement("mod" + i);
                    mod.appendChild(doc.createTextNode(frameBuilds.get(frameBuilds.size()-1).getSlotName(i)));
                    frame.appendChild(mod);

                    Element modRank = doc.createElement("mod" + i + "rank");
                    modRank.appendChild(doc.createTextNode(Double.toString(frameBuilds.get(frameBuilds.size()-1).getSlotRank(i))));
                    frame.appendChild(modRank);
                }
                
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filepath));
                
		transformer.transform(source, result);  
        } 
        catch (IOException | ParserConfigurationException | TransformerException | DOMException | SAXException e) 
        {
            this.slf4jLogger.warn(String.format("Exception Error!"));
        }
    }
    
    /**
     * Replaces a {@code FrameBuild} from a {@code FrameBuild} list in 
     * the {@code Warframes.xml}.
     * 
     * @param frameBuild the {@code FrameBuild} to be replaced.
     */
    public void updateBuild(FrameBuild frameBuild)
    {        
        try {
		String filepath = "Saves/Warframes.xml";                
                
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(filepath);
                                
                for( int i = 0; i < frameBuilds.size(); i++ )
                {
                    if( frameBuilds.get(i).getName().equals( frameBuild.getName() ))
                    {
                        frameBuilds.remove(i);
                        
                        frameBuilds.add(frameBuild);
                        
                        Node frame = doc.getElementsByTagName("warframe").item(i);

                        NamedNodeMap attr = frame.getAttributes();
                        Node nodeAttr = attr.getNamedItem("name");                        
                        
                        if( nodeAttr.getTextContent().equals(frameBuild.getName()) )
                        {
                            Node frameName = doc.getElementsByTagName("warframename").item(i);
                            frameName.setTextContent( frameBuild.getFrameName() );
                            
                            for( int j = 0; j < 12; j++ )
                            {          
                                Node mod = doc.getElementsByTagName("mod" + j).item(i);
                                mod.setTextContent( frameBuild.getSlotName(j) );    
                                
                                Node modRank = doc.getElementsByTagName("mod" + j + "rank").item(i);
                                modRank.setTextContent( Double.toString(frameBuild.getSlotRank(j)) );      
                            }
                        }
                    }
                }
                
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filepath));
                
		transformer.transform(source, result);  
        } 
        catch (IOException | ParserConfigurationException | TransformerException | DOMException | SAXException e) 
        {
            this.slf4jLogger.warn(String.format("Exception Error!"));
        }
    }
    
    /**
     * Deletes a {@code FrameBuild} from a {@code FrameBuild} list and from
     * the {@code Warframes.xml}.
     * 
     * @param frameBuild the {@code FrameBuild} to be deleted.
     */
    public void deleteBuild(FrameBuild frameBuild)
    {        
        try {
		String filepath = "Saves/Warframes.xml";                
                
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(filepath);
                                
                for( int i = 0; i < frameBuilds.size(); i++ )
                {
                    if( frameBuilds.get(i).getName().equals( frameBuild.getName() ))
                    {
                        frameBuilds.remove(i);
                                                
                        Node frame = doc.getElementsByTagName("warframe").item(i);

                        NamedNodeMap attr = frame.getAttributes();
                        Node nodeAttr = attr.getNamedItem("name");                        
                        
                        if( nodeAttr.getTextContent().equals(frameBuild.getName()) )
                        {
                            Node parent = frame.getParentNode();
                            
                            parent.removeChild( frame );
                            
                            parent.normalize();
                        }
                    }
                }
                
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filepath));
                
		transformer.transform(source, result);  
        } 
        catch (IOException | ParserConfigurationException | TransformerException | DOMException | SAXException e) 
        {
            this.slf4jLogger.warn(String.format("Exception Error!"));
        }
    }

    /**
     * Returns the list of {@code FrameBuilds}.
     * 
     * @return a {@code List} containing every {@code FrameBuild} from 
     *         the database.
     */
    public List<FrameBuild> getFrameBuilds() {
        return Collections.unmodifiableList(frameBuilds);
    }    
}