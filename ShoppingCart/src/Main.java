import java.util.Map;

public class Main {
    private static stockList stockList=new stockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);



        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket, "car", 1);


        sellItem(timsBasket, "car", 1);


        sellItem(timsBasket, "car", 1);


        sellItem(timsBasket, "spanner", 5);


        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);

        Basket customer=new Basket("customer");
        sellItem(customer,"juice",2);
        sellItem(customer,"cup",10);
        sellItem(customer,"bread",1);
        sellItem(customer,"phone",3);
        sellItem(customer,"towel",5);

        removeItem(customer,"juice",1);
        removeItem(customer,"phone",1);
        removeItem(customer,"towel",3);

        checkOut(customer);
        System.out.println(stockList);
    }

    public static int sellItem(Basket basket, String item, int quantity){
        if(item!=null && quantity>0){
            StockItem stock= stockList.Items().get(item);
            if(stock==null){
                System.out.println("Item not available");
            }
            else{
                int val=stockList.reserveStock(item,quantity);
                if(val!=0){
                    return basket.addToBasket(stock,quantity);
                }
            }
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        if(item!=null && quantity>0){
            StockItem stock= stockList.Items().get(item);
            if(stock==null){
                System.out.println("Item not available");
            }
            else{
                int val=stockList.unreserveStock(item,quantity);
                if(val!=0){
                    return basket.removeFromBasket(stock,quantity);
                }
            }
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for (Map.Entry<StockItem,Integer> item: basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }

        basket.clearBasket();
    }
}