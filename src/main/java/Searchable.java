import java.util.List;

public interface Searchable {

    public List<Product> searchProductList(String productName);

    public List<Product> searchCategoryList(String categoryName);

}
