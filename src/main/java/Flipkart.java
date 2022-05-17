import java.util.List;

class Flipkart {

    ProductCatalog catalog;

    Flipkart(){
        catalog = new ProductCatalog();

    }
    public static void main(String[] args) {

        Customer customer = new Customer("customer","address");

        Seller seller = new Seller("electronics","electonics address");

        Flipkart flipkart = new Flipkart();

        seller.registerProduct(flipkart.catalog, new Product(
                "Mobile",10,4, Category.ELECTRONICS, seller,
                9000.0));

        List<Product> mobileList = flipkart.catalog.searchProductList("Mobile");

        Item mobileItem = new Item(mobileList.get(0),5);
        customer.addToCart(mobileItem);

        customer.placeOrder();

        System.out.println("customer"+customer);

        Shipment shipment = customer.getCurrentOrder().movetoShipment();

        System.out.println("shipment"+shipment);

        System.out.println("mobileList"+mobileList);
    }

}