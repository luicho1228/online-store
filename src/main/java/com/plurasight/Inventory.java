package com.plurasight;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private ArrayList<Product> productArray;
    private HashMap<String,Product> productBySkuHashMap;
    private HashMap<String,Product> productByNameHashMap;
    private HashMap<String,Product> productByDeptHashMap;

    public Inventory(){
        productArray = new ArrayList<Product>();
        productBySkuHashMap = new HashMap<String,Product>();
        productByNameHashMap = new HashMap<String,Product>();
        productByDeptHashMap = new HashMap<String,Product>();
    }
    public Inventory(ArrayList<Product> productArray, HashMap<String, Product> productBySkuHashMap, HashMap<String, Product> productByNameHashMap, HashMap<String, Product> productByDeptHashMap) {
        this.productArray = productArray;
        this.productBySkuHashMap = productBySkuHashMap;
        this.productByNameHashMap = productByNameHashMap;
        this.productByDeptHashMap = productByDeptHashMap;
    }
    public Product getProductByIndex(int index){
        return productArray.get(index);
    }
    public Product getProductBySku(String sku){
        return productBySkuHashMap.get(sku);
    }
    public Product getProductByName(String name){
        return productByNameHashMap.get(name);
    }
    public Product getProductByDepartment(String deparment){
        return productByDeptHashMap.get(deparment);
    }

    public ArrayList getInventoryArray(){
        return productArray;
    }

    public void addProduct(Product newProduct){
        productArray.add(newProduct);
        productBySkuHashMap.put(newProduct.getSku(), newProduct);
        productByNameHashMap.put(newProduct.getName(), newProduct);
        productByDeptHashMap.put(newProduct.getDepartment(), newProduct);
    }
    public void removeProduct(Product product){
        productArray.remove(product);
        productBySkuHashMap.remove(product.getSku());
        productByNameHashMap.remove(product.getName());
        productByDeptHashMap.remove(product.getDepartment());
    }

}
