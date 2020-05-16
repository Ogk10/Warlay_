package com.mycompany.warlay.model;

/**
 * <p>
 * A class representing a single {@code FrameBuild}.</p>
 * 
 * <p>
 * A {@code FrameBuild} has 12 slots for 12 {@code FrameMod}. 1 aura slot, 
 * 1 exilus slot, 2 arcane slot and 8 normal slot. It only needs the name and 
 * the rank of the {@code FrameMod}, and the name of the used {@code Frame}. 
 * It's not necessary to use every slot.</p>
 * 
 * @see Frame
 * @see FrameMod
 */
public class FrameBuild {
    
    /**
     * The name of the FrameBuild.
     */
    public String name;
    
    /**
     * The name of a Frame in the FrameBuild.
     */
    public String frameName;
    
    /**
     * The name of the mods in the FrameBuild.
     */
    public String[] slotName = new String[12];
    
    /**
     * The rank of the mods in the FrameBuild.
     */
    public double[] slotRank = new double[12];

    /**
     * Constructor to create a {@code FrameBuild}.
     * 
     * @param name  the name of the FrameBuild.
     * @param frameName the name of the used Frame.
     * @param slotName the name of the used FrameMods.
     * @param slotRank the rank of the used FrameMods.
     */
    public FrameBuild(String name, String frameName, String[] slotName, double[] slotRank) {
        this.name = name;
        this.frameName = frameName;
        this.slotName = slotName;
        this.slotRank = slotRank;
    }

    /**
     * Constructor to create a {@code FrameBuild}.
     */
    public FrameBuild(){        
    }            

    /**
     * Sets the name for this {@code FrameBuild}.
     * 
     * @param name a {@code String} type paramater containing the name of 
     *        this {@code FrameBuild}.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the name of the used {@code Frame} for this {@code FrameBuild}.
     * 
     * @param frameName a {@code String} type paramater containing the name of 
     *        a {@code Frame}.
     */
    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }
    
    /**
     * Sets the name of a used {@code FrameMod} for this {@code FrameBuild}.
     * 
     * @param slotName a {@code double} type paramater containing the name of a
     *        used {@code FrameMod} in a given {@code slot}.
     * @param i an {@code int} type paramater containing the index of the used 
     *        {@code slot}.
     */
    public void setSlotName(String slotName, int i) {
        this.slotName[i] = slotName;
    }

     /**
     * Sets the name of a used {@code FrameMod} for this {@code FrameBuild}.
     * 
     * @param slotRank a {@code double} type paramater containing the rank of a
     *        used {@code FrameMod} in a given {@code slot}.
     * @param i an {@code int} type paramater containing the index of the used 
     *        {@code slot}.
     */
    public void setSlotRank(double slotRank, int i) {
        this.slotRank[i] = slotRank;
    }
    
    /**
     * Returns the name of this {@code FrameBuild}.
     * 
     * @return a {@code String} containing the name of this {@code FrameBuild}.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the name of the used {@code Frame}.
     * 
     * @return a {@code String} containing the name of the used {@code Frame}.
     */
    public String getFrameName() {
        return frameName;
    }

    /**
     * Returns the name of the used {@code FrameMod} in a given {@code slot}.
     * 
     * @param i the {@code int} index of the used {@code slot}.
     * @return a {@code String} containing the name of the 
     *         used {@code FrameMod} in a given {@code slot}.
     */
    public String getSlotName(int i) {
        return slotName[i];
    }

    /**
     * Returns the rank of the used {@code FrameMod} in a given {@code slot}.
     * 
     * @param i the {@code int} index of the used {@code slot}.
     * @return a {@code double} containing the name of the 
     *         used {@code FrameMod} in a given {@code slot}.
     */
    public double getSlotRank(int i) {
        return slotRank[i];
    }
}