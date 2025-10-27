package com.RecipeNotes.recipeService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(value = "recipes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Recipe {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private String instructions;
    private String cuisine;
    private int cookingTime; // in minutes
    private int servings; // number of servings
    private ArrayList<Ingredient> ingredients; // Comma-separated list of ingredients
}
