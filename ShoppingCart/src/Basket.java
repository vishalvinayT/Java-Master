import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private String name;
    private Map<StockItem,Integer> basket;
    public Basket(String name){
        this.name=name;
        this.basket=new HashMap<>();
    }

    public int addToBasket(StockItem item,int quantity){
        if(item!=null && quantity>0){
            int value=this.basket.getOrDefault(item,0);
            if(quantity>0){
                quantity+=value;
                basket.put(item,quantity);
                return value;
            }
        }
        return 0;
    }

    public int removeFromBasket(StockItem item,int quantity){
        if(item!=null && quantity>0){
            int value=this.basket.getOrDefault(item,0);
            int newval=value-quantity;
            if(newval>0){
                basket.put(item,newval);
                return value;
            }
            else if (quantity==value) {
                basket.remove(item);
                return 0;
            }
        }
        return 0;
    }


    public void clearBasket(){
        basket.clear();
    }
    public Map<StockItem,Integer> Items(){
        return Collections.unmodifiableMap(this.basket);
    }

    @Override
    public String toString(){
        double total=0;
        for(Map.Entry<StockItem,Integer> item: basket.entrySet() ){
            double price=item.getKey().getPrice()*item.getValue();
            System.out.println(item.getKey().getName()+" quantity ordered: "+item.getValue()+" price: "+String.format("%.2f",price));
            total+=price;
        }
        return "Total Price of Items: "+String.format("%.2f",total);
    }
}
