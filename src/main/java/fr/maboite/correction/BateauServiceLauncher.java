package fr.maboite.correction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.correction.service.BateauService;
import fr.maboite.correction.service.CroisiereService;


/**
 * Lancer Spring en scannant un package
 * et tous ses sous packages pour trouver
 * des classes annotées que Spring va instancier.
 */
public class BateauServiceLauncher {

	public static void main(String[] args) {

		
		//Charge le contexte Spring en scannant le package
		try (AnnotationConfigApplicationContext appContext 
					= new AnnotationConfigApplicationContext("fr.maboite.correction.service")) {
			
		//Récupère les instances
		BateauService bateauService = appContext.getBean(BateauService.class);
		bateauService.sayHello();
		
		//Les instances sont liées entre elles (merci @Autowired )
		CroisiereService croisiereService = appContext.getBean(CroisiereService.class);
		croisiereService.sayHello();
		croisiereService.getBateauService().sayHello();
		
		}
	}			

}
