package fr.maboite.correction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.maboite.mesclasses.ClasseC;

@Configuration
@ComponentScan("fr.maboite.mesclasses")
public class MaClasseDeConfiguration {
	
	/**
	 * Cette méthode n'est pas utilisée par Spring
	 */
	public void toto() {
		System.out.println("toto");
	}
	
	/**
	 * Cette méthode va être utilisée par Spring
	 * pour placer dans son contexte une instance
	 * configurée avec des algorithmes. 
	 * de ClasseC (on pourra la récupérer après).
	 * @return
	 */
	@Bean
	public ClasseC generationClasseC() {
		ClasseC instanceDeClasseC = new ClasseC();
		// du code compliqué
		instanceDeClasseC.setNom("Ce nom a été généré par la méthode generationClasseC");
		return instanceDeClasseC;
	}

}
