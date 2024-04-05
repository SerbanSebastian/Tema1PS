package org.muzeu.digital.Model.Query;

public class ItemQueries {
    //INSERT
    public static final String INSERT_ITEM_QUERY = "INSERT INTO Items (title, artist, art_type, year_of_creation, country_of_origin) VALUES (:title, :artist, :artType, :yearOfCreation, :countryOfOrigin)";

    //SELECT
    public static final String SELECT_ALL_ITEMS_QUERY = "SELECT * FROM Items";
    public static final String GET_ID_BY_ITEM_TITLE_QUERY = "SELECT id FROM Items where title = :title";

    //UPDATE
    public static final String UPDATE_ITEM_QUERY = "UPDATE Items SET title = :title, artist = :artist, art_type = :artType, year_of_creation = :yearOfCreation, country_of_origin = :countryOfOrigin WHERE id = :id";

    //DELETE
    public static final String DELETE_ITEM_QUERY = "DELETE FROM Items WHERE title = :title";
}
