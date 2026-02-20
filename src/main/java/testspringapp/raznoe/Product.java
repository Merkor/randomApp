package testspringapp.raznoe;

import java.util.List;

public interface Product {
    Long getId();
    String getName();
    List<Category> getCategories();
}
