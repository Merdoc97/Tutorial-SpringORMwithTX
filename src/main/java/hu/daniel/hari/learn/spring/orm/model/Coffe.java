package hu.daniel.hari.learn.spring.orm.model;

import javax.persistence.*;

/**
 * Created by 123 on 14.04.2016.
 */
@Entity
@Table(name = "coffe",schema = "testdb")
public class Coffe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coffe_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @Column(name = "product_id",insertable = false,updatable = false)
    private int product_id;

    public Coffe(Product product, String name) {
        this.product = product;
        this.name = name;
    }

    public Coffe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
