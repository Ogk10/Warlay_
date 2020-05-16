package com.mycompany.warlay.model;

/**
 * A class representing a single {@code Frame}.
 */
public class Frame {
    
    /**
     * The name of a Frame.
     */
    private String name;
    
    /**
     * The base armor of a Frame.
     */
    private double baseArmor;
    
    /**
     * The base energy of a Frame.
     */
    private double baseEnergy;
    
    /**
     * The base health of a Frame.
     */
    private double baseHealth;
    
    /**
     * The base shield of a Frame.
     */
    private double baseShield;    
    
    /**
     * The max energy of a Frame.
     */
    private double maxEnergy;
    
    /**
     * The max health of a Frame.
     */
    private double maxHealth;
    
    /**
     * The max shield of a Frame.
     */
    private double maxShield;
    
    /**
     * The armor of a Frame.
     */
    private double armor;
    
    /**
     * The energy of a Frame.
     */
    private double energy;
    
    /**
     * The health of a Frame.
     */
    private double health;
    
    /**
     * The shield of a Frame.
     */
    private double shield;
    
    /**
     * The duration of a Frame.
     */
    private double duration;
    
    /**
     * The efficiency of a Frame.
     */
    private double efficiency;
    
    /**
     * The range of a Frame.
     */
    private double range;
    
    /**
     * The strength of a Frame.
     */
    private double strength;

    /**
     * Constructor to create a {@code Frame}.
     * 
     * @param name the name of the Frame.
     * @param baseArmor the base armor value of the Frame without mods.
     * @param baseEnergy the base energy value of the Frame at without mods.
     * @param baseHealth the base health value of the Frame at without mods.
     * @param baseShield the base shield value of the Frame at without mods.
     * @param maxEnergy the max energy value of the Frame without mods.
     * @param maxHealth the max health value of the Frame without mods.
     * @param maxShield the max shield value of the Frame without mods.
     */
    public Frame(String name, double baseArmor, double baseEnergy, 
            double baseHealth, double baseShield, double maxEnergy, 
            double maxHealth, double maxShield) {
        this.name = name;
        this.baseArmor = baseArmor;
        this.baseEnergy = baseEnergy;
        this.baseHealth = baseHealth;
        this.baseShield = baseShield;
        this.maxEnergy = maxEnergy;
        this.maxHealth = maxHealth;
        this.maxShield = maxShield;
    } 
    
    /**
     * Constructor to create a Frame.
     */
    public Frame() {        
    }

    /**
     * Sets the name for this {@code Frame}.
     * 
     * @param name a {@code String} type paramater containing the name of 
     *        this {@code Frame}.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the base armor value for this {@code Frame} without mods.
     * 
     * @param baseArmor a {@code double} type paramater containing the base
     *        armor value of this {@code Frame} without mods.
     */
    public void setBaseArmor(double baseArmor) {
        this.baseArmor = baseArmor;
    }

    /**
     * Sets the base energy value for this {@code Frame} without mods.
     * 
     * @param baseEnergy a {@code double} type paramater containing the base
     *        energy value of this {@code Frame} without mods.
     */
    public void setBaseEnergy(double baseEnergy) {
        this.baseEnergy = baseEnergy;
    }

    /**
     * Sets the base health value for this {@code Frame} without mods.
     * 
     * @param baseHealth a {@code double} type paramater containing the base
     *        health value of this {@code Frame} without mods.
     */
    public void setBaseHealth(double baseHealth) {
        this.baseHealth = baseHealth;
    }

    /**
     * Sets the base shield value for this {@code Frame} without mods.
     * 
     * @param baseShield a {@code double} type paramater containing the base
     *        shield value of this {@code Frame} without mods.
     */
    public void setBaseShield(double baseShield) {
        this.baseShield = baseShield;
    }

    /**
     * Sets the max energy value for this {@code Frame} without mods.
     * 
     * @param maxEnergy a {@code double} type paramater containing the max 
     *        energy value of this {@code Frame} without mods.
     */
    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    /**
     * Sets the max health value for this {@code Frame} without mods.
     * 
     * @param maxHealth a {@code double} type paramater containing the max 
     *        health value of this {@code Frame} without mods.
     */
    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Sets the max shield value for this {@code Frame} without mods.
     * 
     * @param maxShield a {@code double} type paramater containing the max 
     *        shield value of this {@code Frame} without mods.
     */
    public void setMaxShield(double maxShield) {
        this.maxShield = maxShield;
    }
    
    /**
     * Sets the default values for this {@code Frame} without mods.
     */
    public void setDefault()
    {
        this.armor = this.baseArmor;
        this.energy = this.maxEnergy;
        this.health = this.maxHealth;
        this.shield = this.maxShield;
        
        this.duration = 100.0;
        this.efficiency = 100.0;
        this.range = 100.0;
        this.strength = 100.0;
    }

    /**
     * Adds the effect of an armor modifier mod to this {@code Frame}.
     * 
     * @param modArmor a {@code double} type paramater containing the 
     *        armor modifier effect of the selected mod.
     * @param modRank a {@code double} type paramater containing the 
     *        rank of the selected armor modifier mod.
     * 
     * @see FrameMod
     */
    public void setArmor( double modArmor, double modRank ) {
        this.armor = this.armor + ( this.baseArmor * ( modArmor * ( 1 + modRank ) ) /100 );
    }

    /**
     * Adds the effect of an energy modifier mod to this {@code Frame}.
     * 
     * @param modEnergy a {@code double} type paramater containing the 
     *        energy modifier effect of the selected mod.
     * @param modRank a {@code double} type paramater containing the 
     *        rank of the selected energy modifier mod.
     * 
     * @see FrameMod
     */
    public void setEnergy( double modEnergy, double modRank ) {
        this.energy = this.energy + ( this.baseEnergy + ( this.baseEnergy * ( ( modEnergy * ( 1 + modRank ) ) /100 ) ) - this.baseEnergy );
    }

    /**
     * Adds the effect of a health modifier mod to this {@code Frame}.
     * 
     * @param modHealth a {@code double} type paramater containing 
     *        the health modifier effect of the selected mod.
     * @param modRank a {@code double} type paramater containing the 
     *        rank of the selected health modifier mod.
     * 
     * @see FrameMod
     */
    public void setHealth( double modHealth, double modRank ) {
        this.health = this.health + ( this.baseHealth + ( this.baseHealth * ( ( modHealth * ( 1 + modRank ) ) /100 ) ) - this.baseHealth );
    }

    /**
     * Adds the effect of a shield modifier mod to this {@code Frame}.
     * 
     * @param modShield a {@code double} type paramater containing 
     *        the shield modifier effect of the selected mod.
     * @param modRank a {@code double} type paramater containing the 
     *        rank of the selected shield modifier mod.
     * 
     * @see FrameMod
     */
    public void setShield( double modShield, double modRank ) {
        this.shield = this.shield + ( this.baseShield + ( this.baseShield * ( ( modShield * ( 1 + modRank ) ) /100 ) ) - this.baseShield );
    }

    /**
     * Adds the effect of a duration modifier mod to this {@code Frame}.
     * 
     * @param modDuration a {@code double} type paramater containing
     *        the duration modifier effect of the selected mod.
     * @param modRank a {@code double} type paramater containing the 
     *        rank of the selected duration modifier mod.
     * 
     * @see FrameMod
     */
    public void setDuration( double modDuration, double modRank ) {
        this.duration = this.duration + ( modDuration * ( 1 + modRank ) );
    }

    /**
     * Adds the effect of an efficiency modifier mod to this {@code Frame}.
     * 
     * @param modEfficiency a {@code double} type paramater containing
     *        the efficiency modifier effect of the selected mod.
     * @param modRank a {@code double} type paramater containing the 
     *        rank of the selected efficiency modifier mod.
     * 
     * @see FrameMod
     */
    public void setEfficiency( double modEfficiency, double modRank ) {
        this.efficiency = this.efficiency + ( modEfficiency * ( 1 + modRank ) );
    }

    /**
     * Adds the effect of an range modifier mod to this {@code Frame}.
     * 
     * @param modRange a {@code double} type paramater containing
     *        the range modifier effect of the selected mod.
     * @param modRank a {@code double} type paramater containing the 
     *        rank of the selected range modifier mod.
     * 
     * @see FrameMod
     */
    public void setRange( double modRange, double modRank ) {
        this.range = this.range + ( modRange * ( 1 + modRank ) );
    }

    /**
     * Adds the effect of a strength modifier mod to this {@code Frame}.
     * 
     * @param modStrength a {@code double} type paramater containing
     *        the strength modifier effect of the selected mod.
     * @param modRank a {@code double} type paramater containing the 
     *        rank of the selected strength modifier mod.
     * 
     * @see FrameMod
     */
    public void setStrength( double modStrength, double modRank ) {
        this.strength = this.strength + ( modStrength * ( 1 + modRank ) );
    }

    /**
     * Returns the name of this {@code Frame}.
     * 
     * @return a {@code String} containing the name of this {@code Frame}.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the base armor value of this {@code Frame}.
     * 
     * @return a {@code double} containing the base armor of this {@code Frame}.
     */
    public double getBaseArmor() {
        return baseArmor;
    }

    /**
     * Returns the base energy value of this {@code Frame} without mods.
     * 
     * @return a {@code double} containing the base energy of this {@code Frame}.
     */
    public double getBaseEnergy() {
        return baseEnergy;
    }

    /**
     * Returns the base health value of this {@code Frame} without mods.
     * 
     * @return a {@code double} containing the base health of this {@code Frame}.
     */
    public double getBaseHealth() {
        return baseHealth;
    }

    /**
     * Returns the base shield value of this {@code Frame} without mods.
     * 
     * @return a {@code double} containing the base shield of this {@code Frame}.
     */
    public double getBaseShield() {
        return baseShield;
    }

    /**
     * Returns the max energy value of this {@code Frame} without mods.
     * 
     * @return a {@code double} containing the max energy of this {@code Frame}.
     */
    public double getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * Returns the max health value of this {@code Frame} without mods.
     * 
     * @return a {@code double} containing the max health of this {@code Frame}.
     */
    public double getMaxHealth() {
        return maxHealth;
    }

    /**
     * Returns the max shield value of this {@code Frame} without mods.
     * 
     * @return a {@code double} containing the max shield of this {@code Frame}.
     */
    public double getMaxShield() {
        return maxShield;
    }

    /**
     * Returns the armor value of this {@code Frame} with mods.
     * 
     * @return a {@code double} containing the armor of this {@code Frame}.
     */
    public double getArmor() {
        return armor;
    }

    /**
     * Returns the energy value of this {@code Frame} with mods.
     * 
     * @return a {@code double} containing the energy of this {@code Frame}.
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * Returns the health value of this {@code Frame} with mods.
     * 
     * @return a {@code double} containing the health of this {@code Frame}.
     */
    public double getHealth() {
        return health;
    }

    /**
     * Returns the shield value of this {@code Frame} with mods.
     * 
     * @return a {@code double} containing the shield of this {@code Frame}.
     */
    public double getShield() {
        return shield;
    }
    
    /**
     * Returns the duration value of this {@code Frame} with mods.
     * 
     * @return a {@code double} containing the duration of this {@code Frame}.
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Returns the efficiency value of this {@code Frame} with mods.
     * 
     * @return a {@code double} containing the efficiency of this {@code Frame}.
     */
    public double getEfficiency() {
        return efficiency;
    }

    /**
     * Returns the range value of this {@code Frame} with mods.
     * 
     * @return a {@code double} containing the range of this {@code Frame}.
     */
    public double getRange() {
        return range;
    }

    /**
     * Returns the strength value of this {@code Frame} with mods.
     * 
     * @return a {@code double} containing the strength of this {@code Frame}.
     */
    public double getStrength() {
        return strength;
    }    
}