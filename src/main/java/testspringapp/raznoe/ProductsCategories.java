package testspringapp.raznoe;

import java.util.*;
import java.util.stream.Collectors;

public class ProductsCategories {

    Map<Integer, Set<Product>> categoryToProducts = new HashMap<>();
    Map<Long, Set<Integer>> productToCategories = new HashMap<>();

    public void init(List<Product> products, List<Category> categories) {
        categories.forEach(category -> {
            if (!categoryToProducts.containsKey(category.getId())) {
                categoryToProducts.put(category.getId(), new TreeSet<>(Comparator.comparing(Product::getId)));
            }
        });

        products.forEach(product -> {
            product.getCategories().forEach(category -> {
                if (categoryToProducts.containsKey(category.getId())) {
                    categoryToProducts.get(category.getId()).add(product);
                }
            });
            productToCategories.put(product.getId(),
                    product.getCategories()
                    .stream()
                    .map(Category::getId)
                    .collect(Collectors.toSet()));
        });
    }

    public boolean isProductInCategory(Long productId, Integer categoryId) {
        return productToCategories.getOrDefault(productId, Collections.emptySet()).contains(categoryId);
    }

    public Collection<Product> getProductsByCategory(Integer CategoryId) {
        return Collections.unmodifiableCollection(categoryToProducts.getOrDefault(CategoryId, Collections.emptySet()));
    }
}
