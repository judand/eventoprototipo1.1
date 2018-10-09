package com.example.prototipo1.eventoprototipo11;

public class ItemEvent {
    private String mtitle;
    private String mimageurl;
    private String mlugar;

    public ItemEvent(String title, String imageurl, String lugar){
        mtitle=title;
        mimageurl=imageurl;
        mlugar=lugar;
    }

    public String getMimageurl() {
        return mimageurl;
    }

    public String getMtitle() {
        return mtitle;
    }

    public String getMlugar() {
        return mlugar;
    }
}
