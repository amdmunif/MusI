package com.munif.musi.model;

import java.io.Serializable;

/**
 * Created by Ahmad Munif on 7/15/2017.
 */

public class Museum implements Serializable{
    private String id;
    private String name;
    private String alamat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
