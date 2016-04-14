package hu.daniel.hari.learn.spring.orm.service;

import hu.daniel.hari.learn.spring.orm.dao.ProductDao;
import hu.daniel.hari.learn.spring.orm.model.Coffe;
import hu.daniel.hari.learn.spring.orm.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional(rollbackFor = Exception.class)
	public void add(Product product) {
		productDao.persist(product);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void addAll(Collection<Product> products) throws Exception {
		for (Product product : products) {
			productDao.persist(product);
		}
		throw new Exception();
	}
	@Transactional(rollbackFor = Exception.class)
	public void persistCoffe(Coffe coffe){
		productDao.persistCoffe(coffe);
	}

	@Transactional(readOnly = true)
	public List<Coffe>getCoffe(){
		return productDao.getCoffe();
	}

	@Transactional(readOnly = true)
	public List<Product> listAll() {
		return productDao.findAll();

	}

}
