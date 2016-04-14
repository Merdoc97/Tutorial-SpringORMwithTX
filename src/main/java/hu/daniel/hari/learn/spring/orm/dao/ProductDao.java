package hu.daniel.hari.learn.spring.orm.dao;

import hu.daniel.hari.learn.spring.orm.model.Coffe;
import hu.daniel.hari.learn.spring.orm.model.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ProductDao  {

	@PersistenceContext
	private EntityManager em;

	public void persist(Product product) {
		em.persist(product);
	}

	public void persistCoffe(Coffe coffe){
		em.persist(coffe);
	}
	public List<Product> findAll() {
		return em.createQuery("select p from Product p").getResultList();
	}

	public List<Coffe>getCoffe(){return em.createQuery("select c from Coffe c").getResultList();}

}
