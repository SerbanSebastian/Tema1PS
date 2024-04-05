package org.muzeu.digital.Model.RowMapper;

import org.muzeu.digital.Model.DataClass.Item;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setId(rs.getLong("id"));
        item.setTitle(rs.getString("title"));
        item.setArtist(rs.getString("artist"));
        item.setArtType(rs.getString("art_type"));
        item.setYearOfCreation(rs.getInt("year_of_creation"));
        item.setCountryOfOrigin(rs.getString("country_of_origin"));
        return item;
    }
}
