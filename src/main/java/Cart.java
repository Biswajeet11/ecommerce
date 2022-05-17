import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> itemList;

    public Cart() {
        this.itemList = new ArrayList<>();
    }

    public void addToCart(Item item) {
        itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void updateCart(Item item, int size){
        int index = itemList.indexOf(item);
        itemList.get(index).updateCount(size);
    }

    public void removeItem(Item item){
        itemList.remove(item);
    }

    public void clearCart(){
        itemList.clear();
    }


}
