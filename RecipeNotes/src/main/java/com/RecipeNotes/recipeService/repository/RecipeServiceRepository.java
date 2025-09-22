package com.RecipeNotes.recipeService.repository;

import com.RecipeNotes.recipeService.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeServiceRepository extends MongoRepository<Recipe, String> {
    Recipe findByName(String name);
}
