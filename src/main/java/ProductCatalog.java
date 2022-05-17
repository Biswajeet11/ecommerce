import java.util.*;

public class ProductCatalog implements  Searchable{
   List<Product> productList;
   List<Category> categoryList;
   Map<String,List<Product>> categoryProductMap;
   Map<String,List<Seller>> productSellerMap;
   Map<String,List<Product>> searchProductMap;

    public ProductCatalog() {
        this.productList = new ArrayList<>();
        this.categoryList =  new ArrayList<>();
        this.categoryProductMap = new HashMap<>();
        this.productSellerMap = new HashMap<>();
        this.searchProductMap = new HashMap<>();
    }

    public void addCategory(Category category){
        this.categoryList.add(category);
        this.updateProductCategoryMap();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
        this.updateProductCategoryMap(product);
        this.updateProductSeller(product);
        this.updateSearchProductMap(product);
    }


    public void updateProductCategoryMap() {
        for(Category c: categoryList ){
            categoryProductMap.put(c.name().toLowerCase(),new ArrayList<>());
        }
    }

    public void updateProductCategoryMap(Product product) {
        if(categoryProductMap.containsKey(product.getCategory())){
            categoryProductMap.get(product.getCategory()).add(product);
        }
        else {
            List<Product> newProductList = new ArrayList<>();
            newProductList.add(product);
            categoryProductMap.put(product.getCategory().toString(), newProductList);
        }
    }

    public void updateProductSeller(Product product) {
        if(productSellerMap.containsKey(product.getProductId())){
           productSellerMap.get(product.getProductId()).add(product.getSeller());
        }
        else {
            List<Seller> newSellerList = new ArrayList<>();
            productSellerMap.put(product.getProductId(), newSellerList);
        }
    }

    public void updateSearchProductMap(Product product){
        String newProduct = product.getProductName().toLowerCase();
        Set<String> productKeys = searchProductMap.keySet();
        boolean isSimilar = false;
        for(String key: productKeys) {

            if(searchProductMap.containsKey(newProduct) || searchProductMap.containsKey(key.toLowerCase())){
                isSimilar = true;
                searchProductMap.get(key).add(product);
            }
        }

        if(!isSimilar){
            List<Product> newProductList = new ArrayList<Product>();
            newProductList.add(product);
            searchProductMap.put(product.getProductName().toLowerCase(), newProductList);
        }
    }
    
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Map<String, List<Product>> getCategoryProductMap() {
        return categoryProductMap;
    }

    public void setCategoryProductMap(Map<String, List<Product>> categoryProductMap) {
        this.categoryProductMap = categoryProductMap;
    }

    public Map<String, List<Seller>> getProductSellerMap() {
        return productSellerMap;
    }

    public void setProductSellerMap(Map<String, List<Seller>> productSellerMap) {
        this.productSellerMap = productSellerMap;
    }

    public void updateProductQuantity(Product product, int size) {
        for(Product prod: productList){
           if(prod.getProductId() == product.getProductId()){
               product.setQuantity(size);
           }
        }
    }

    public void removeProduct(Product product){
        productList.remove(product);
    }

    @Override
    public List<Product> searchProductList(String productName) {
        return searchProductMap.get(productName.toLowerCase());
    }

    @Override
    public List<Product> searchCategoryList(String categoryName) {
        return categoryProductMap.get(categoryName.toLowerCase());
    }
}
