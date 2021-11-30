package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void createTestByName(){
        Recipe recipe = new Recipe("Gulyas leves");

        assertEquals("Gulyas leves", recipe.getName());
        assertNull(recipe.getDescription());
        assertEquals(0,recipe.getIngredients().size());
    }

    @Test
    void createTestByNameAndDescriptionTest(){
        Recipe recipe = new Recipe("Gulyas leves","Nagyon finom");

        assertEquals("Gulyas leves", recipe.getName());
        assertEquals("Nagyon finom", recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void addOneIngredient(){
        Recipe recipe = new Recipe("Gulyas leves","Nagyon finom");
        recipe.addIngredients("Marha hus");

        assertEquals(1,recipe.getIngredients().size());
        assertEquals("Marha hus", recipe.getIngredients().get(0));
    }

    @Test
    void addMoreThanOneIngredients(){
        Recipe recipe = new Recipe("Gulyas leves","Nagyon finom");
        recipe.addIngredients("Marha hus", "Hagyma", "Krumpli");

        assertEquals(3,recipe.getIngredients().size());
        assertEquals("Krumpli", recipe.getIngredients().get(2));
    }



}