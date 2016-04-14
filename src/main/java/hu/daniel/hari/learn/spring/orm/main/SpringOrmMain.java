package hu.daniel.hari.learn.spring.orm.main;

import hu.daniel.hari.learn.spring.orm.model.Coffe;
import hu.daniel.hari.learn.spring.orm.model.Product;
import hu.daniel.hari.learn.spring.orm.service.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Arrays;
import java.util.List;

public class SpringOrmMain {
	
	public static void main(String[] args) {
		
		//Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		
		//Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
		ProductService productService = ctx.getBean(ProductService.class);
		
		//Do some data operation
		
		productService.add(new Product("Bulb"));
		productService.add(new Product("Dijone mustard"));
		Product product=new Product("coffe");
		productService.add(product);
		productService.persistCoffe(new Coffe(product,"milkCoffe"));
		List<Coffe>coffeList=productService.getCoffe();
		System.out.println(coffeList);
		System.out.println("listAll: " + productService.listAll());
		
		//Test transaction rollback (duplicated key)
		
		try {
			productService.addAll(Arrays.asList(new Product("Book"), new Product("Soap"), new Product("Computer")));
		} catch (DataAccessException dataAccessException) {
		} catch (Exception e) {

		}

		//Test element list after rollback
		System.out.println("listAll: " + productService.listAll());
		
		ctx.close();
		
	}
}
