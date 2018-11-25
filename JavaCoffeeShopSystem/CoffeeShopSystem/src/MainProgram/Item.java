/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

/**
 *
 * @author Ronaldo
 */
public class Item {
    
    private String name;
    private String unit;
    private int id;
    private int qty;
    private int price;
    
    public Item(){
        
    }
    
    public Item(int id, String name, int qty, String unit, int price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.unit = unit;
        this.price = price;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
}
