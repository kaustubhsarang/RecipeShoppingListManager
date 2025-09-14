package com.RecipeNotes.recipeService.dto;

import com.RecipeNotes.recipeService.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequest {
    private String name;
    private String description;
    private ArrayList<Ingredient> ingredients;
    private String instructions;
    private String cuisine;
    private int cookingTime; // in minutes
    private int servings; // number of servings
}
