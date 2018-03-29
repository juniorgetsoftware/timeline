package br.com.timeline.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timeline.entity.Item;
import br.com.timeline.repository.ItemRepository;

@Service
public class InitDbService {

	@Autowired
	private ItemRepository itemRepository;

	@PostConstruct
	public void init() {
		System.out.println("=== STARTANDO BANCO DE DADOS ===");
		
		{
			Item item = new Item();
			item.setTitulo("Brasil X Suíça");
			item.setDescricao("Segunda partida do grupo E");
			item.setData(stringParaData("17/06/2018 15:00"));
			itemRepository.save(item);
		}
		{
			Item item = new Item();
			item.setTitulo("Brasil X Costa Rica");
			item.setDescricao("Terceira partida do grupo E");
			item.setData(stringParaData("22/06/2018 09:00"));
			itemRepository.save(item);
		}
		{
			Item item = new Item();
			item.setTitulo("Sérvia X Brasil ");
			item.setDescricao("Sexta partida do grupo E");
			item.setData(stringParaData("27/06/2018 15:00"));
			itemRepository.save(item);
		}
		 

		System.out.println("=== FINALIZANDO INSERÇÕES NO BANCO DE DADOS ===");
	}

	private Date stringParaData(String data) {
		Date d = null;
		try {
			d = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
}
