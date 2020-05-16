package modeltest;

import com.mycompany.warlay.model.Frame;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

public class FrameTest {
    
    private Frame frame;
    
    public FrameTest() {        
    }
    
    @BeforeClass
    public static void setUpClass(){
    }
    
    @Before
    public void setUp(){
        this.frame = new Frame();
        //Ash
        this.frame.setBaseArmor(65);
        this.frame.setBaseEnergy(100);
        this.frame.setBaseHealth(150);
        this.frame.setBaseShield(100);
        this.frame.setMaxEnergy(150);
        this.frame.setMaxHealth(450);
        this.frame.setMaxShield(300);
    }
    
    @org.junit.Test
    public void testArmor()
    {  
        this.frame.setDefault();
        
        this.frame.setArmor( 10.0, 10 ); //Steel Fiber, rank 10
        assertEquals( 136.5, this.frame.getArmor(), 0.001 );
        
        this.frame.setArmor( 7.5, 5 );   //Steel Fiber, rank 10  + Armored Agility, rank 5
        assertEquals( 165.75, this.frame.getArmor(), 0.001 );     
        
        this.frame.setArmor( 7.5, 5 );   //Steel Fiber, rank 10  + Armored Agility, rank 5 + Gladiator Aegis, rank 5
        assertEquals( 195.0, this.frame.getArmor(), 0.001 );   
        
        this.frame.setDefault();
        
        this.frame.setArmor( 7.5, 5 );   //Armored Agility, rank 5
        assertEquals( 94.25, this.frame.getArmor(), 0.001 );
    }
    
    @org.junit.Test
    public void testEnergy()
    {
		this.frame.setDefault();
		
		this.frame.setEnergy( 25.0, 4 ); //Flow, rank 4
		assertEquals( 275.0, this.frame.getEnergy(), 0.001 );
		
		this.frame.setDefault();
		
		this.frame.setEnergy( 25.0, 5 ); //Flow, rank 5
		assertEquals( 300.0, this.frame.getEnergy(), 0.001 );
		
		this.frame.setDefault();
		
		this.frame.setEnergy( 25.0, 10 ); //Primed Flow, rank 10
		assertEquals( 425.0, this.frame.getEnergy(), 0.001 );
	}
    
    @org.junit.Test
    public void testHealth()
    {
		this.frame.setDefault();
		
		this.frame.setHealth( 40.0, 10 ); //Vitality, rank 10
		assertEquals( 1110.0, this.frame.getHealth(), 0.001 );
		
		this.frame.setHealth( 20.0, 5 ); //Vitality, rank 10 + Vigor, rank 5
		assertEquals( 1290.0, this.frame.getHealth(), 0.001 );
		
		this.frame.setDefault();
		this.frame.setHealth( 20.0, 10 ); //Primed Vigor, rank 10
		assertEquals( 780.0, this.frame.getHealth(), 0.001 );
		
		this.frame.setHealth( 40.0, 7 ); //Primed Vigor, rank 10 + Vitality, rank 7
		assertEquals( 1260.0, this.frame.getHealth(), 0.001 );
	}
    
    @org.junit.Test
    public void testShield()
    {
		this.frame.setDefault();
		
		this.frame.setShield( 40.0, 10 ); //Redirection rank 10
		assertEquals( 740.0, this.frame.getShield(), 0.001 );
		
		this.frame.setShield( 20.0, 10 ); //Redirection rank 10 + Primed Vigor rank 10
		assertEquals( 960.0, this.frame.getShield(), 0.001 );
		
		this.frame.setShield( 30.0, 5 ); //Redirection rank 10 + Primed Vigor rank 10 + Augur Accord 
		assertEquals( 1140.0, this.frame.getShield(), 0.001 );			
		
		this.frame.setDefault();
		
		this.frame.setShield( 20.0, 10 ); //Primed Vigor rank 10
		assertEquals( 520.0, this.frame.getShield(), 0.001 );
	}
    
    @org.junit.Test
    public void testDuration()
    {
		this.frame.setDefault();
		
		this.frame.setDuration( -10.0, 5 ); //Fleeting Expertise rank 5
		assertEquals( 40.0, this.frame.getDuration(), 0.001 );
		
		this.frame.setDuration( 5.0, 5 ); //Fleeting Expertise rank 5 + Continuity rank 5
		assertEquals( 70.0, this.frame.getDuration(), 0.001 );
		
		this.frame.setDefault();		
		
		this.frame.setDuration( -10.0, 5 ); //Fleeting Expertise rank 5
		
		this.frame.setDuration( -2.5, 10 ); //Fleeting Expertise rank 5 + Transient Fortitude rank 10
		assertEquals( 12.5, this.frame.getDuration(), 0.001 );	
	}
    
    @org.junit.Test
    public void testEfficiency()
    {
		this.frame.setDefault();
		
		this.frame.setEfficiency( 10.0, 5 ); //Fleeting Expertise rank 5
		assertEquals( 160.0, this.frame.getEfficiency(), 0.001 );
		
		this.frame.setEfficiency( 5.0, 5 ); //Fleeting Expertise rank 5 + Streamline rank 5
		assertEquals( 190.0, this.frame.getEfficiency(), 0.001 );
		
		this.frame.setEfficiency( -5.0, 10 ); //Fleeting Expertise rank 5 + Streamline rank 5 + Blind Rage rank 10
		assertEquals( 135.0, this.frame.getEfficiency(), 0.001 );
		
		this.frame.setDefault();
		
		this.frame.setEfficiency( -5.0, 10 ); //Blind Rage rank 10
		assertEquals( 45.0, this.frame.getEfficiency(), 0.001 );
	}
    
    @org.junit.Test
    public void testRange()
    {
		this.frame.setDefault();
		
		this.frame.setRange( 7.5, 5 ); //Stretch rank 5
		assertEquals( 145.0, this.frame.getRange(), 0.001 );
		
		this.frame.setRange( 15.0, 5 ); //Stretch rank 5 + Overextended rank 5
		assertEquals( 235.0, this.frame.getRange(), 0.001 );
		
		this.frame.setDefault();
		
		this.frame.setRange( 5.0, 5 ); //Augur Reach 5
		assertEquals( 130.0, this.frame.getRange(), 0.001 );
	}
    
    @org.junit.Test
    public void testStrength()
    {
		this.frame.setDefault();
		
		this.frame.setStrength( 5.0, 5 ); //Intensify rank 5
		assertEquals( 130.0, this.frame.getStrength(), 0.001 );
		
		this.frame.setStrength( -10.0, 5 ); //Intensify rank 5 + Overextended rank 5
		assertEquals( 70.0, this.frame.getStrength(), 0.001 );
		
		this.frame.setStrength( 9.0, 10 ); //Intensify rank 5 + Overextended rank 5 + Blind Rage rank 10
		assertEquals( 169.0, this.frame.getStrength(), 0.001 );
		
		this.frame.setStrength( 4.0, 5 ); //Intensify rank 5 + Overextended rank 5 + Blind Rage rank 10 + Augur Secrets rank 5
		assertEquals( 193.0, this.frame.getStrength(), 0.001 );
		
		this.frame.setStrength( 5.0, 10 ); //Intensify rank 5 + Overextended rank 5 + Blind Rage rank 10 + Augur Secrets rank 5 + Transient Fortitude rank 10
		assertEquals( 248.0, this.frame.getStrength(), 0.001 );
	}
}