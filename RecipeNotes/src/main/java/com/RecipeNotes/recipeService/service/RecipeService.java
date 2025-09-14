package com.RecipeNotes.recipeService.service;


import com.RecipeNotes.recipeService.dto.RecipeRequest;
import com.RecipeNotes.recipeService.model.Recipe;
import com.RecipeNotes.recipeService.repository.RecipeServiceRepository;
import org.springframework.stereotype.Service;


@Service
public class RecipeService {
    private RecipeServiceRepository recipeServiceRepository;

    public RecipeService(RecipeServiceRepository recipeServiceRepository) {
        this.recipeServiceRepository = recipeServiceRepository;
    }

    public void addRecipe(RecipeRequest recipeRequest) {
        Recipe recipe = Recipe.builder()
                .name(recipeRequest.getName())
                .description(recipeRequest.getDescription())
                .ingredients(recipeRequest.getIngredients())
                .instructions(recipeRequest.getInstructions())
                .cuisine(recipeRequest.getCuisine())
                .cookingTime(recipeRequest.getCookingTime())
                .servings(recipeRequest.getServings())
                .build();
        recipeServiceRepository.save(recipe);
    }
    public Recipe getRecipeById(String id) {
        return recipeServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));
    }
}
