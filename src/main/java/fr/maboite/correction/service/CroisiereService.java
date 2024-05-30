package fr.maboite.correction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CroisiereService {

	@Autowired
	private BateauService bateauService;

	public BateauService getBateauService() {
		return bateauService;
	}

	public void setBateauService(BateauService bateauService) {
		this.bateauService = bateauService;
	}
	
	public void sayHello() {
		System.out.println("Salut du CroisiereService");
	}

}
