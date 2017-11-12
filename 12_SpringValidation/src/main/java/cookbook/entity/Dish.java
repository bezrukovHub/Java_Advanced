package cookbook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by koko on 30.09.16.
 */
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String recipe;
    private String story;

    public Dish() {
    }

    public Dish(String name, String recipe, String story) {
        this.name = name;
        this.recipe = recipe;
        this.story = story;
    }

    public Dish(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
    
    

}
