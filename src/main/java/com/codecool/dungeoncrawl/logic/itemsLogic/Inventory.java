package com.codecool.dungeoncrawl.logic.itemsLogic;

public class Inventory {
    private int sword = 0;
    private int shield = 0;
    private int armor = 0;
    private int legs = 0;
    private int boots = 0;
    private int key = 0;

    public void addKey(){
        this.key += key;
    }

    public void addSword(){
        this.sword += sword;
    }

    public void addShield(){
        this.shield += shield;
    }

    public void addArmor(){
        this.armor += armor;
    }

    public void addLegs(){
        this.legs += legs;
    }

    public void addBoots(){
        this.boots += boots;
    }
}
