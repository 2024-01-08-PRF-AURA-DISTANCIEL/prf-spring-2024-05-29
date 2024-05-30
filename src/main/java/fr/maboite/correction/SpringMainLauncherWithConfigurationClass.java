package fr.maboite.correction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.mesclasses.ClasseA;
import fr.maboite.mesclasses.ClasseB;
import fr.maboite.mesclasses.ClasseC;

/**
 * Lancer Spring en lisant une classe de configuration et tous ses sous packages
 * pour trouver des classes annotées que Spring va instancier.
 */
public class SpringMainLauncherWithConfigurationClass {

	public static void main(String[] args) {

		ClasseA instanceA = new ClasseA();
		System.out.println("J'utilise l'instance de la classeA créée grâce à mon code");
		instanceA.sayHello();

		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				MaClasseDeConfiguration.class)) {

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

			ClasseC instanceCQuiVientDeSpring = appContext.getBean(ClasseC.class);
			if (instanceCQuiVientDeSpring == null) {
				System.out.println("Je ne trouve pas d'instance de classe C");
			} else {
				System.out.println("J'ai trouvé une instance avec le nom : " + instanceCQuiVientDeSpring.getNom());
			}

		}
	}

}
