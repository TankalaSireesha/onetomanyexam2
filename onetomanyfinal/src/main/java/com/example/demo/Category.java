package com.example.demo;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Category {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		
		private Integer id;
		private String fName;
		private String lName;
			
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="cate_pro_id")
		private List<Product>product;

			public Category() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Category(Integer id, String fName, String lName, List<Product> product) {
				super();
				this.id = id;
				this.fName = fName;
				this.lName = lName;
				this.product = product;
			}

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getfName() {
				return fName;
			}

			public void setfName(String fName) {
				this.fName = fName;
			}

			public String getlName() {
				return lName;
			}

			public void setlName(String lName) {
				this.lName = lName;
			}

			public List<Product> getProduct() {
				return product;
			}

			public void setProduct(List<Product> product) {
				this.product = product;
			}
		
		
}
