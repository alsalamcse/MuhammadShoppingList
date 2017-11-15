package com.awad.hamudi.muhammadshoppinglist.data;

/**
 * Created by user on 15/11/2017.
 */

public class product
{
    /**
     * the name of
     */
    private String name;
    /**
     * the price
     */
    private double price;
    private double amount;
    /**
     * if the product is bought
     */
    private boolean iscompleted;
    /**
     * the path of products image
     */
    private String imgpath;
    /**
     * a special key or id unique for each product (primary key)
     */
    private String keyid;
    /**
     * building object
     * @param name
     * @param price
     * @param amount
     */
    public product(String name, double price, double amount){
        this.name= name;
        this.price=price;
        this.amount=amount;
        iscompleted=false;
        imgpath=null;
    }
    public product (String name, double price, double amount, boolean iscompleted, String imgpath, String keyid){
        this.name= name;
        this.price=price;
        this.amount=amount;
        this.iscompleted= iscompleted;
        this.imgpath= imgpath;
        this.keyid= keyid;
    }

}
