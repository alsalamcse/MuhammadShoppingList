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
     */
    public product(){
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean iscompleted() {
        return iscompleted;
    }

    public void setIscompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    @Override
    public String toString() {
        return "product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", iscompleted=" + iscompleted +
                ", imgpath='" + imgpath + '\'' +
                ", keyid='" + keyid + '\'' +
                '}';
    }
}
