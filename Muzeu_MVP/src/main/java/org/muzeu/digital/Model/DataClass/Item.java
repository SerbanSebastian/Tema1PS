package org.muzeu.digital.Model.DataClass;


public class Item {
    private Long id;
    private String title;
    private String artist;
    private String artType;
    private int yearOfCreation;
    private String countryOfOrigin;

    public Item(){

    }

    public Item(Long id, String title, String artist, String artType,
                int yearOfCreation, String countryOfOrigin) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.artType = artType;
        this.yearOfCreation = yearOfCreation;
        this.countryOfOrigin = countryOfOrigin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
}
