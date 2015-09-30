package com.uc.ehome.models;

/**
 * Created by Stephanie Lyn on 9/22/2015.
 */
public class DrawerItems {
    int icon;
    String label;

    public DrawerItems(int icon, String label) {
        this.icon = icon;
        this.label = label;
    }

    public int getIcon() { return icon; }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
