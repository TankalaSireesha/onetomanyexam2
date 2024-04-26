package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCont {
	@Autowired
	private ProductRepo cr;
	
	@GetMapping("/api/products/{pageNo}/{pageSize}")
	public List<Product>getAll(@PathVariable int pageNo,@PathVariable int pageSize){
		PageRequest p1=PageRequest.of(pageNo, pageNo);
		Page<Product>p2=cr.findAll(p1);
		return p2.toList();
	}
	
	@GetMapping("/api/products/sorting")
	public List<Product>getAll(){
		return cr.findAll(Sort.by(Direction.ASC, "fName"));
	}
	@GetMapping("/api/products/{id}")
	public Optional<Product> getById(@PathVariable Integer id){
		return cr.findById(id);
	}
	@PostMapping("/api/products")
	public Product c(@RequestBody Product c1) {
		return cr.save(c1);
	}
	@PutMapping("/Product/{id}")
	public Product u(@PathVariable Integer id,@RequestBody Product c2) {
		return cr.findById(id).map(e->{e.setfName(c2.getfName());
		return cr.save(e);
			
		}).orElse(null);
	}
	@DeleteMapping("/api/products/{id}")
	public void d(@PathVariable Integer id) {
		cr.deleteById(id);
	}
}
