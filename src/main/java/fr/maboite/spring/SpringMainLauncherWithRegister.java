package fr.maboite.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.mesclasses.ClasseA;
import fr.maboite.mesclasses.ClasseB;

/**
 * Lance Spring en enregistrant chaque classe une par une ...
 * à ne pas utiliser.
 */
public class SpringMainLauncherWithRegister {

	public static void main(String[] args) {

		ClasseA instanceA = new ClasseA();
		System.out.println("J'utilise l'instance de la classeA créée grâce à mon code");
		instanceA.sayHello();

		try (AnnotationConfigApplicationContext appContext 
					= new AnnotationConfigApplicationContext()) {
			appContext.register(ClasseA.class);
			appContext.register(ClasseB.class);
			appContext.refresh();
			
			ClasseA instanceAQuiVientDeSpring = appContext.getBean(ClasseA.class);
			System.out.println("J'utilise l'instance de la classeA créée grâce à Spring");
			instanceAQuiVientDeSpring.sayHello();
			
			ClasseB instanceBQuiVientDeSpring = appContext.getBean(ClasseB.class);
			System.out.println("J'utilise l'instance de la classeB créée grâce à Spring");
			instanceBQuiVientDeSpring.sayHello();
			
			System.out.println("J'utilise l'instance de la classeB créée grâce à Spring, "
					+ " et liée à l'instance de la classe A");
			instanceAQuiVientDeSpring.getClasseB().sayHello();
			
			instanceAQuiVientDeSpring.traitementAvecClasseB();
		}
	}

}
