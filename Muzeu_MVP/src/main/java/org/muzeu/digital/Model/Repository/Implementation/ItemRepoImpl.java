package org.muzeu.digital.Model.Repository.Implementation;

import org.muzeu.digital.Model.Connection.DBDirectConnection;
import org.muzeu.digital.Model.DataClass.Item;
import org.muzeu.digital.Model.Repository.ItemRepo;
import org.muzeu.digital.Model.RowMapper.ItemRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.Collection;
import java.util.Map;

import static org.muzeu.digital.Model.Query.ItemQueries.*;

public class ItemRepoImpl implements ItemRepo<Item> {
    private final NamedParameterJdbcTemplate connection = DBDirectConnection.getInstance();

    @Override
    public Item create(Item item) throws Exception {
        try {
            connection.update(INSERT_ITEM_QUERY, getParameterSource(item));
            return item;
        } catch (Exception e) {
            throw new Exception("An error occurred while adding the item!");
        }
    }

    @Override
    public Collection<Item> getAllItems() throws Exception {
        try {
            return connection.query(SELECT_ALL_ITEMS_QUERY, new ItemRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new Exception("There are no items registered!");
        } catch (Exception e) {
            throw new Exception("An error occurred while trying to get all the items!");
        }
    }

    @Override
    public Item update(Item item, String title) throws Exception {
        try {
            Long id = connection.queryForObject(GET_ID_BY_ITEM_TITLE_QUERY, Map.of("title", title), Long.class);
            connection.update(UPDATE_ITEM_QUERY, getParameterSource(item, id));
            return item;
        } catch (Exception e) {
            throw new Exception("An error occurred while trying to update the item!");
        }
    }

    @Override
    public Boolean delete(String title) throws Exception {
        try {
            connection.update(DELETE_ITEM_QUERY, Map.of("title", title));
            return true;
        } catch (Exception e) {
            throw new Exception("An error occurred while trying to delete the item with title: " + title);
        }
    }

    private Map<String, Object> getParameterSource(Item item) {
        return Map.of(
                "title", item.getTitle(),
                "artist", item.getArtist(),
                "artType", item.getArtType(),
                "yearOfCreation", item.getYearOfCreation(),
                "countryOfOrigin", item.getCountryOfOrigin()
        );
    }

    private SqlParameterSource getParameterSource(Item item, Long id){
        return new MapSqlParameterSource()
                .addValue("title", item.getTitle())
                .addValue("artist", item.getArtist())
                .addValue("artType", item.getArtType())
                .addValue("yearOfCreation", item.getYearOfCreation())
                .addValue("countryOfOrigin", item.getCountryOfOrigin())
                .addValue("id", id);
    }
}
