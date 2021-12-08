package com.example.persianpoems;

public class Items {
    private String poem;
    private String poet;
    private String genre;

    public Items (String poem, String poet, String genre) {
        this.poem=poem;
        this.poet=poet;
        this.genre=genre;
    }
    public void changePoemText(String text) {
        poem=text;
    }

    public String getGenre() {
        return genre;
    }

    public String getPoem() {
        return poem;
    }

    public String getPoet() {
        return poet;
    }
}
