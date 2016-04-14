package hu.daniel.hari.learn.spring.orm.model;

import javax.persistence.*;

@Entity
@Table(name = "product",schema = "testdb")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",nullable = false)
	private Integer id;
	@Column(name = "name")
	private String name;

	public Product() {
	}
	public Product(String name){
		this.name=name;
	}

	public Product(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

}
