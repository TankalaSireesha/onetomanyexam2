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
public class CategoryCon {
		@Autowired
		private CategoryRepo cr;
		
		@GetMapping("/api/categories/{pageNo}/{pageSize}")
		public List<Category>getAll(@PathVariable int pageNo,@PathVariable int pageSize){
			PageRequest p1=PageRequest.of(pageNo, pageNo);
			Page<Category>p2=cr.findAll(p1);
			return p2.toList();
		}
		
		@GetMapping("/api/categories/sorting")
		public List<Category>getAll(){
			return cr.findAll(Sort.by(Direction.ASC, "fName"));
		}
		@GetMapping("/api/categories/{id}")
		public Optional<Category> getById(@PathVariable Integer id){
			return cr.findById(id);
		}
		@PostMapping("/api/categories")
		public Category c(@RequestBody Category c1) {
			return cr.save(c1);
		}
		@PutMapping("/api/categories/{id}")
		public Category u(@PathVariable Integer id,@RequestBody Category c2) {
			return cr.findById(id).map(e->{e.setfName(c2.getfName());
			return cr.save(e);
				
			}).orElse(null);
		}
		@DeleteMapping("/api/categories/{id}")
		public void d(@PathVariable Integer id) {
			cr.deleteById(id);
		}
}
