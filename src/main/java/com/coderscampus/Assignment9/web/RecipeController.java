package com.coderscampus.Assignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.FileService;

@RestController
public class RecipeController {

	@Autowired
	private FileService fileService;

	@GetMapping("/all-recipes")
	public List<Recipe> getRecipes() throws IOException {
		List<Recipe> recipes = fileService.getRecipes();
		return recipes;
	}

	@GetMapping("/gluten-free")
	private List<Recipe> getGlutenFree() throws IOException {
		
		List<Recipe> glutenFree = fileService.getRecipes()
				.stream()
				.filter(x->x.getGlutenFree())
				.collect(Collectors.toList());
//		System.out.println(glutenFree.toString());
		return glutenFree;
	}
	
	@GetMapping("/vegan")
	private List<Recipe> getVegan() throws IOException {
		List<Recipe> veganRecipes = fileService.getRecipes()
				.stream()
				.filter(x->x.getVegan())
				.collect(Collectors.toList());
		return veganRecipes;
	}
	
	@GetMapping("/vegan-and-gluten-free")
	private List<Recipe> getVeganAndGlutenFree() throws IOException {
		List<Recipe> veganAndGlutenFreeRecipes = fileService.getRecipes()
				.stream()
				.filter(x->x.getGlutenFree() && x.getVegan())
				.collect(Collectors.toList());
		System.out.println(veganAndGlutenFreeRecipes.size());
		return veganAndGlutenFreeRecipes;
	}
	
	@GetMapping("/vegetarian")
	private List<Recipe> getVegetarian() throws IOException {
		List<Recipe> vegetarian = fileService.getRecipes()
				.stream()
				.filter(x->x.getVegetarian())
				.collect(Collectors.toList());
		System.out.println(vegetarian.size());
		return vegetarian;
	}
	
	@GetMapping("/salmon")
	private List<Recipe> getSalmon() throws IOException {
		List<Recipe> salmonRecipes = fileService.getRecipes()
				.stream()
				.filter(x->x.getTitle().contains("Salmon"))
				.collect(Collectors.toList());
		System.out.println(salmonRecipes.size());
		return salmonRecipes;
	}

}
