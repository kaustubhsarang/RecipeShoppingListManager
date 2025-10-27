package com.RecipeNotes.recipeService.repository;

import com.RecipeNotes.recipeService.model.Recipe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RecipeServiceRepository extends MongoRepository<Recipe, ObjectId> {
    Recipe findByName(String name);
//    Optional<Recipe> findById(ObjectId name);
}
