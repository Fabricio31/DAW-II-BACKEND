package com.cibertec.edu.springbootecommercedaw.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cibertec.edu.springbootecommercedaw.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	//Añade el localhost:4200 que se establecio en archivo propierties
	@Value("${allowed.origins}")
	private String[] theAllowedOrigins;


	private EntityManager entityManager;

	// Añadiendo autowired JPA entity manager para exponer ids con rest
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	// Proteccion contra put post delete desde postman (Accesories, Product,
	// Console)
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH };

		// Deshabilitar los Metodos HTTP para product PUT POST y DELETE (Metodo
		// Refactor)
		disableHttpMethods(Accesories.class, config, theUnsupportedActions);
		disableHttpMethods(Companies.class, config, theUnsupportedActions);
		disableHttpMethods(Product.class, config, theUnsupportedActions);
		disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
		disableHttpMethods(Country.class, config, theUnsupportedActions);
		disableHttpMethods(State.class, config, theUnsupportedActions);
		disableHttpMethods(Order.class, config, theUnsupportedActions);

		/*
		 * Metodo Antiguo
		 * config.getExposureConfiguration().forDomainType(Accesories.class)
		 * .withItemExposure((metdata, httpMethods) ->
		 * httpMethods.disable(theUnsupportedActions)) .withCollectionExposure((metdata,
		 * httpMethods) -> httpMethods.disable(theUnsupportedActions));
		 */

		// Deshabilitar los Metodos HTTP para product PUT POST y DELETE
		/*
		 * config.getExposureConfiguration().forDomainType(Product.class)
		 * .withItemExposure((metdata, httpMethods) ->
		 * httpMethods.disable(theUnsupportedActions)) .withCollectionExposure((metdata,
		 * httpMethods) -> httpMethods.disable(theUnsupportedActions));
		 */

		// LLamar a un metodo interno helper = Esto va a exponer las ids
		exposeIds(config);

		//Configurar Core Mapping
		//--> antiguo: cors.addMapping("/api/**").allowedOrigins("http://localhost:4200");
		cors.addMapping(config.getBasePath()+"/**").allowedOrigins(theAllowedOrigins);
		//Con esto se puede eliminar el crossOrigins de los Jparepository

	}

	private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config,
			HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration().forDomainType(theClass)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	}

	// Exponer ids
	private void exposeIds(RepositoryRestConfiguration config) {
		// Expone Entidad ids

		// Obtener una lista de todas la entidades Manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

		// obtener una lista de todas las clases de entidades del gestor de entidades
		List<Class> entityClasses = new ArrayList<>();

		// obtener los tipos de entidad
		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}

		// exponer los identificadores de tipo entidad/dominio
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);

	}

}
