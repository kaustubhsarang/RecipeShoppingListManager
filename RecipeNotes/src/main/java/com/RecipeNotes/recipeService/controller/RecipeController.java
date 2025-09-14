package com.RecipeNotes.recipeService.controller;

import com.RecipeNotes.recipeService.dto.RecipeRequest;
import com.RecipeNotes.recipeService.dto.RecipeResponse;
import com.RecipeNotes.recipeService.model.Recipe;
import com.RecipeNotes.recipeService.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecipe(@RequestBody RecipeRequest recipeRequest) {
        recipeService.addRecipe(recipeRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getRecipeById(@PathVariable String id) {
        Recipe recipe = recipeService.getRecipeById(id);
        RecipeResponse recipeResponse = RecipeResponse.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .description(recipe.getDescription())
                .ingredients(recipe.getIngredients())
                .instructions(recipe.getInstructions())
                .cuisine(recipe.getCuisine())
                .cookingTime(recipe.getCookingTime())
                .servings(recipe.getServings())
                .build();
        return recipeResponse.toString();
    }

}
