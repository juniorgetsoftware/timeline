package br.com.timeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timeline.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
