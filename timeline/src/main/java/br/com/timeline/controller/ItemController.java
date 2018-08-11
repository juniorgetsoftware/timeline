package br.com.timeline.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.timeline.entity.Item;
import br.com.timeline.service.ItemService;
import br.com.timeline.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@ViewScoped
public class ItemController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{itemService}")
	private ItemService itemService;

	private List<Item> itens;

	private Item item = new Item();

	@PostConstruct
	public void loadChecks() {
		itens = itemService.findAll();
	}

	public void save() {
		itemService.save(item);
		itens = itemService.findAll();
		FacesUtil.addMsgInfo("item-msg", "Item cadastrado com sucesso!", item.toString());
		item = new Item();
	}

	public void update() {
		itemService.save(item);
		itens = itemService.findAll();
		FacesUtil.addMsgInfo("item-msg", "Item editado com sucesso!", item.toString());
		item = new Item();
	}

	public void remove(Item item) {
		itemService.remove(item);
		itens = itemService.findAll();
		FacesUtil.addMsgAtencao("item-msg", "O item foi removido!", item.toString());
	}

	public void clear() {
		item = new Item();
	}
}
