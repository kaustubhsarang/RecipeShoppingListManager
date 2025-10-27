package com.RecipeNotes.recipeService.service;


import com.RecipeNotes.recipeService.dto.RecipeRequest;
import com.RecipeNotes.recipeService.model.Recipe;
import com.RecipeNotes.recipeService.repository.RecipeServiceRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeServiceRepository recipeServiceRepository;

    public void addRecipe(RecipeRequest recipeRequest) {
        System.out.println("kausti");
        Recipe recipe = Recipe.builder()
                .name(recipeRequest.getName())
                .description(recipeRequest.getDescription())
                .ingredients(recipeRequest.getIngredients())
                .instructions(recipeRequest.getInstructions())
                .cuisine(recipeRequest.getCuisine())
                .cookingTime(recipeRequest.getCookingTime())
                .servings(recipeRequest.getServings())
                .build();
        try{
            recipeServiceRepository.save(recipe);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public Recipe getRecipeById(String id) {
        ObjectId objectId = new ObjectId(id);
        return recipeServiceRepository.findById(objectId)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));
    }

    public Recipe getRecipeByName(String name) {
        Recipe recipe =  recipeServiceRepository.findByName(name);
        return recipe;
    }
}
