package com.RecipeNotes.recipeService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediant {
    String ingredientName;
    String quantity;
    String unit; // e.g., grams, cups, tablespoons
}
