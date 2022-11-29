package com.zharif.gui.Pendataan;

public class user {
    private String Nomer;
    private String Jenis;
    private String ATM;
    private String Name;
    private String Picture;

    public user() {
    }

    public user(String nomer, String jenis, String ATM, String name, String picture) {
        Nomer = nomer;
        Jenis = jenis;
        this.ATM = ATM;
        Name = name;
        Picture = picture;
    }

    public String getNomer() {
        return Nomer;
    }

    public void setNomer(String nomer) {
        Nomer = nomer;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String jenis) {
        Jenis = jenis;
    }

    public String getATM() {
        return ATM;
    }

    public void setATM(String ATM) {
        this.ATM = ATM;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    @Override
    public String toString() {
        return ("\nNo Kartu = " + Nomer + "\nJenis ATM = " + Jenis + "\nBank = " + ATM +
        "\nNama Pemilik = " + Name + "\nNama File Gambar = " + Picture);
    }
}

