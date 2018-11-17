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
    private int price;
    private int qua;
        
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

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }


    @Override
    public String toString(){
        return name + " " + price + " " + qua;
    }
    
}
