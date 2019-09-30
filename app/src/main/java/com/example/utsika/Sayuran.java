package com.example.utsika;

import java.io.Serializable;
import java.util.List;

public class Sayuran implements Serializable {
    private String sayuran;
    private String latin;
    private List<String> vitamin;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    private String gambar;

    public String getSayuran() {
        return sayuran;
    }

    public void setSayuran(String sayuran) {
        this.sayuran = sayuran;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public List<String> getVitamin() {
        return vitamin;
    }

    public void setVitamin(List<String> vitamin) {
        this.vitamin = vitamin;
    }


}


