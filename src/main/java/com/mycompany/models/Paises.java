/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

/**
 *
 * @author Helder Castrillon
 */
public  class Paises {
    private String countryid;
    private String countryname;
    private int regionid;
    //rest api
    public Paises(){
    }
    //
    public Paises( String id, String nombre, int region) {
        this.countryid = id;
        this.countryname = nombre;
        this.regionid = region;
    }

    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }
    
    
}
