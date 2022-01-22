package com.shopify.jeanhoang.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shopify.jeanhoang.beans.Item;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertItem() {


		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query="INSERT INTO item(name) VALUES ('hat')";


		int rowsAffected = jdbc.update(query, namedParameters);

		if(rowsAffected>0) {
			System.out.println("An item was inserted in DB");
		}


	}


	public void insertItem(Item item) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query="INSERT INTO item(name) VALUES (:name)";
		
		namedParameters.addValue("name", item.getName());

		int rowsAffected = jdbc.update(query, namedParameters);

		if(rowsAffected>0) {
			System.out.println("An item was inserted in DB");
		}

	}
	

	public List<Item> getList(){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM item";

		return jdbc.query(query, namedParameters,new BeanPropertyRowMapper<Item>(Item.class));
		
	}
	
	
	public void deleteItem(Long ID) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "DELETE FROM item WHERE id = :id";
		
		namedParameters.addValue("id", ID);
		
		int rowsAffected = jdbc.update(query, namedParameters);
		
		if(rowsAffected > 0) {
			System.out.println("Item with id (" + ID + ") has been deleted.");
		}
		
	}
	
	
	
	public List<Item> getItemByID(Long ID){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query= "SELECT * FROM item WHERE id = :id";
		
		namedParameters.addValue("id", ID);
		
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Item>(Item.class));
		
	}


}
