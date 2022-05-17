import java.util.ArrayList;
import java.util.List;

public class Seller extends User {

    List<Product> productList;

    public Seller(String name, String address) {
        super(name,address);
        this.productList = new ArrayList<>();
    }


    void registerProduct(ProductCatalog productCatalog, Product product) {
        productList.add(product);
        productCatalog.addProduct(product);
        productCatalog.addCategory(product.getCategory());
        product.setSeller(product.getSeller());
        System.out.println("register"+productCatalog.getProductList());
    }

    void updateProductQuantity(ProductCatalog productCatalog, Product product, int size) {
        productCatalog.updateProductQuantity(product,size);
    }

    void removeProduct(ProductCatalog catalog, Product product){

    }


}
