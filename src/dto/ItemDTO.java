/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package dto;

public class ItemDTO {

    private String ItemID;
    private String name;
    private double price;
    private int qtyOnHand;

    public ItemDTO() {
    }

    public ItemDTO(String itemID, String name, double price, int qtyOnHand) {
        ItemID = itemID;
        this.name = name;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
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

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "ItemID='" + ItemID + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
