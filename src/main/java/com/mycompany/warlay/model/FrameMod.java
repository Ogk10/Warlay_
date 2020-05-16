package com.mycompany.warlay.model;

/**
 * <p>
 * A class representing a single {@code FrameMod} for Warframe builds.</p>
 * 
 * <p>
 * Mods are upgrade modules for Warframes, increasing stats or giving new 
 * features boosting the combat capabilities.</p>
 */
public class FrameMod {
    
    /**
     * The name of the FrameMod.
     */
    private String name;
    
    /**
     * The slot type of the FrameMod.
     */
    private String slot;
    
    /**
     * The augment of the FrameMod.
     */
    private String augment;
    
    /**
     * The polarity of the FrameMod.
     */
    private String polarity;
    
    /**
     * The misc type of the FrameMod.
     */
    private boolean misc;
    
    /**
     * The armor effect of the FrameMod.
     */
    private double armor;
    
    /**
     * The energy effect of the FrameMod.
     */
    private double energy;
    
    /**
     * The health effect of the FrameMod.
     */
    private double health;
    
    /**
     * The shield effect of the FrameMod.
     */
    private double shield;
    
    /**
     * The duration effect of the FrameMod.
     */
    private double duration;
    
    /**
     * The efficiency effect of the FrameMod.
     */
    private double efficiency;
    
    /**
     * The range effect of the FrameMod.
     */
    private double range;
    
    /**
     * The strength effect of the FrameMod.
     */
    private double strength;
    
    /**
     * The base cost of the FrameMod.
     */
    private double baseCost;
    
    /**
     * The max rank of the FrameMod.
     */
    private int maxRank;

    /**
     * Constructor to create a {@code FrameMod}.
     * 
     * @param name the name of the mod.
     * @param slot the slot type of the mod.
     * @param augment the augment of the mod.
     * @param polarity the polarity of the mod.
     * @param misc mod type in other category.
     * @param armor the armor effect of the mod.
     * @param energy the energy effect of the mod.
     * @param health the health effect of the mod.
     * @param shield the shield effect of the mod.
     * @param duration the duration effect of the mod.
     * @param efficiency the efficiency effect of the mod.
     * @param range the range effect of the mod.
     * @param strength the strength effect of the mod.
     * @param baseCost the base cost of the mod.
     * @param maxRank the maximum rank of the mod.
     */
    public FrameMod(String name, String slot, String augment, String polarity, 
            boolean misc, double armor, double energy, double health, 
            double shield, double duration, double efficiency, double range, 
            double strength, double baseCost, int maxRank) {
        this.name = name;
        this.slot = slot;
        this.augment = augment;
        this.polarity = polarity;
        this.misc = misc;
        this.armor = armor;
        this.energy = energy;
        this.health = health;
        this.shield = shield;
        this.duration = duration;
        this.efficiency = efficiency;
        this.range = range;
        this.strength = strength;
        this.baseCost = baseCost;
        this.maxRank = maxRank;
    }
    
    /**
     * Constructor to create a {@code FrameMod}.
     */
    public FrameMod() {        
    }

    /**
     * Sets the name for this {@code FrameMod}.
     * 
     * @param name a {@code String} type paramater containing the name of 
     *        this {@code FrameMod}.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>
     * Sets the slot type of this {@code FrameMod}.</p>
     * 
     * <p>
     * {@code FrameMod} can be normal, aura, arcane and exilus type. Aura mods 
     * are only usable in the aura slot. Exilus mods can be used in the exilus 
     * slot or in the normal slots. Arcanes are only usable in the arcane 
     * slots. Normal mods are usable in normal slots only.</p>
     * 
     * @param slot a {@code String} type paramater containing the type 
     *        of this {@code FrameMod}.
     * 
     * @see FrameBuild
     */
    public void setSlot(String slot) {
        this.slot = slot;
    }

    /**
     * <p>
     * Sets the augment of this {@code FrameMod}.</p>
     * 
     * <p>
     * Augment mods are exclusive mods for certain Warframes.</p>
     * 
     * @param augment a {@code String} type paramater containing the augment 
     *        of this {@code FrameMod}.
     */
    public void setAugment(String augment) {
        this.augment = augment;
    }
    
    /**
     * Sets the polarity of this {@code FrameMod}.
     * 
     * @param polarity a {@code String} type paramater containing the polarity
     *        of this {@code FrameMod}.
     */
    public void setPolarity(String polarity) {
        this.polarity = polarity;
    }
    
    /**
     * Sets this {@code FrameMod} to be misc or not.
     * 
     * @param misc a {@code boolean} type paramater deciding the type 
     *        of this {@code FrameMod}. 
     */
    public void setMisc(boolean misc) {
        this.misc = misc;
    }
    
    /**
     * Sets the armor modifier effect of this {@code FrameMod}.
     * 
     * @param armor a {@code double} type paramater containing the 
     *        armor modifier effect of this {@code FrameMod}.
     */
    public void setArmor(double armor) {
        this.armor = armor;
    }
    
    /**
     * Sets the energy modifier effect of this {@code FrameMod}.
     * 
     * @param energy a {@code double} type paramater containing the 
     *        energy modifier effect of this {@code FrameMod}.
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }
    
    /**
     * Sets the health modifier effect of this {@code FrameMod}.
     * 
     * @param health a {@code double} type paramater containing the 
     *        health modifier effect of this {@code FrameMod}.
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * Sets the shield modifier effect of this {@code FrameMod}.
     * 
     * @param shield a {@code double} type paramater containing the 
     *        shield modifier effect of this {@code FrameMod}.
     */
    public void setShield(double shield) {
        this.shield = shield;
    }

    /**
     * Sets the duration modifier effect of this {@code FrameMod}.
     * 
     * @param duration a {@code double} type paramater containing the 
     *        duration modifier effect of this {@code FrameMod}.
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Sets the efficiency modifier effect of this {@code FrameMod}.
     * 
     * @param efficiency a {@code double} type paramater containing the 
     *        efficiency modifier effect of this {@code FrameMod}.
     */
    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    /**
     * Sets the range modifier effect of this {@code FrameMod}.
     * 
     * @param range a {@code double} type paramater containing the 
     *        range modifier effect of this {@code FrameMod}.
     */
    public void setRange(double range) {
        this.range = range;
    }

    /**
     * Sets the strength modifier effect of this {@code FrameMod}.
     * 
     * @param strength a {@code double} type paramater containing the 
     *        strength modifier effect of this {@code FrameMod}.
     */
    public void setStrength(double strength) {
        this.strength = strength;
    }
    
    /**
     * Sets the base cost of this {@code FrameMod}.
     * 
     * @param baseCost a {@code double} type paramater containing the base cost 
     *        of this {@code FrameMod}.
     */
    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    /**
     * Sets the max rank for this {@code FrameMod}.
     * 
     * @param maxRank a {@code double} type paramater containing the max rank
     *        of this {@code FrameMod}.
     */
    public void setMaxRank(int maxRank) {
        this.maxRank = maxRank;
    }
    
    /**
     * Returns the name of this {@code FrameMod}.
     * 
     * @return a {@code String} containing the name of this {@code FrameMod}.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the slot type of this {@code FrameMod}.
     * 
     * @return a {@code String} containing the type of this {@code FrameMod}.
     */
    public String getSlot() {
        return slot;
    }

    /**
     * Returns the augment of this {@code FrameMod}.
     * 
     * @return a {@code String} containing the augment of this {@code FrameMod}.
     */
    public String getAugment() {
        return augment;
    }

    /**
     * Returns the polarity of this {@code FrameMod}.
     * 
     * @return a {@code String} containing the polarity of this {@code FrameMod}.
     */
    public String getPolarity() {
        return polarity;
    }

    /**
     * Determines if this {@code FrameMod} is misc or not.
     * 
     * @return a {@code true} if {@code FrameMod} is misc; 
     *        {@code false} otherwise.
     */
    public boolean isMisc() {
        return misc;
    }

    /**
     * Returns the armor effect of this {@code FrameMod} on a {@code Frame}.
     * 
     * @return a {@code double} containing the armor effect of 
     *         this {@code FrameMod}.
     * 
     * @see Frame
     */
    public double getArmor() {
        return armor;
    }

    /**
     * Returns the energy effect of this {@code FrameMod} on a {@code Frame}.
     * 
     * @return a {@code double} containing the energy effect of 
     *         this {@code FrameMod}.
     * 
     * @see Frame
     */
    public double getEnergy() {
        return energy;
    }
    
    /**
     * Returns the health effect of this {@code FrameMod} on a {@code Frame}.
     * 
     * @return a {@code double} containing the health effect of 
     *         this {@code FrameMod}.
     * 
     * @see Frame
     */
    public double getHealth() {
        return health;
    }
  
    /**
     * Returns the shield effect of this {@code FrameMod} on a {@code Frame}.
     * 
     * @return a {@code double} containing the shield effect of 
     *         this {@code FrameMod}.
     * 
     * @see Frame
     */
    public double getShield() {
        return shield;
    }

    /**
     * Returns the duration effect of this {@code FrameMod} on a {@code Frame}.
     * 
     * @return a {@code double} containing the duration effect of 
     *         this {@code FrameMod}.
     * 
     * @see Frame
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Returns the efficiency effect of this {@code FrameMod} on a {@code Frame}.
     * 
     * @return a {@code double} containing the efficiency effect of 
     *         this {@code FrameMod}.
     * 
     * @see Frame
     */
    public double getEfficiency() {
        return efficiency;
    }

    /**
     * Returns the range effect of this {@code FrameMod} on a {@code Frame}.
     * 
     * @return a {@code double} containing the range effect of 
     *         this {@code FrameMod}.
     * 
     * @see Frame
     */
    public double getRange() {
        return range;
    }

    /**
     * Returns the strength effect of this {@code FrameMod} on a {@code Frame}.
     * 
     * @return a {@code double} containing the strength effect of 
     *         this {@code FrameMod}.
     * 
     * @see Frame
     */
    public double getStrength() {
        return strength;
    }

    /**
     * Returns the base cost of this {@code FrameMod}.
     * 
     * @return a {@code double} containing the base cost of
     *         this {@code FrameMod}.
     */
    public double getBaseCost() {
        return baseCost;
    }    

    /**
     * Return the maximum rank of this {@code FrameMod}.
     * 
     * @return a {@code double} containing the maximum rank of
     *         this {@code FrameMod}.
     */
    public int getMaxRank() {
        return maxRank;
    }
}