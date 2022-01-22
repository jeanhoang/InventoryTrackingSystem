package com.shopify.jeanhoang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopify.jeanhoang.beans.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
