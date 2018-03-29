package br.com.timeline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timeline.entity.Item;
import br.com.timeline.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	public void save(Item item) {
		itemRepository.save(item);
	}

	public void remove(Item item) {
		itemRepository.delete(item);
	}

}
