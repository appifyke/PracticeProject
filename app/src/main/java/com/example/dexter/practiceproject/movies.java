package com.example.dexter.practiceproject;

/**
 * Created by Dexter on 27-May-16.
 * Store information on movies.
 */
public class movies {
    private String name;
    private String genre;
    private int icon;

    public movies(String name, String genre, int icon) {
        super();
        this.name = name;
        this.genre = genre;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {

        return genre;
    }

    public int getIcon() {

        return icon;
    }
}
