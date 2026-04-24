package com.plurasight;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private ArrayList<Product> productArray;
    private HashMap<Integer,Product> productByIdHashMap;
    private HashMap<String,Product> productByNameHashMap;
    private HashMap<String,Product> productByDeptHashMap;

    public Inventory(){
        productArray = new ArrayList<Product>();
        productByIdHashMap = new HashMap<Integer,Product>();
        productByNameHashMap = new HashMap<String,Product>();
        productByDeptHashMap = new HashMap<String,Product>();
    }
    public Inventory(ArrayList<Product> productArray, HashMap<Integer, Product> productByIdHashMap, HashMap<String, Product> productByNameHashMap, HashMap<String, Product> productByDeptHashMap) {
        this.productArray = productArray;
        this.productByIdHashMap = productByIdHashMap;
        this.productByNameHashMap = productByNameHashMap;
        this.productByDeptHashMap = productByDeptHashMap;
    }
    public Product getProductByIndex(int index){
        return productArray.get(index);
    }
    public Product getProductById(int id){
        return productByIdHashMap.get(id);
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
        productByIdHashMap.put(newProduct.getId(), newProduct);
        productByNameHashMap.put(newProduct.getName(), newProduct);
        productByDeptHashMap.put(newProduct.getDepartment(), newProduct);
    }
    public void removeProduct(Product product){
        productArray.remove(product);
        productByIdHashMap.remove(product.getId());
        productByNameHashMap.remove(product.getName());
        productByDeptHashMap.remove(product.getDepartment());
    }

}
