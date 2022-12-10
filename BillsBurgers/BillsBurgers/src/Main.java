public class Main {
    public static void main(String[] args) {

        Hamburger hamburger=new Hamburger("garlic","Chicken");
        hamburger.setBaseprice();
        hamburger.setCount();
        hamburger.setAddonsPrice();
        hamburger.add("tomatoes");
        hamburger.add("onions");
        hamburger.add("lettuce");
        hamburger.add("salad");
        hamburger.add("onions");
        System.out.println(hamburger.getBaseprice());
        System.out.println(hamburger.getAddonsPrice());
        System.out.println(hamburger.getTotalPrice());


        HealthyBurger healthyBurger=new HealthyBurger();
        healthyBurger.setBaseprice();
        healthyBurger.setCount();
        healthyBurger.add("tomatoes");
        healthyBurger.add("onions");
        healthyBurger.add("egg");
        healthyBurger.add("extrasalad");
        healthyBurger.add("extrasalad");
        healthyBurger.add("tomatoes");
        healthyBurger.add("salad");
        System.out.println(healthyBurger.getBaseprice());
        System.out.println(healthyBurger.getAddonsPrice());
        System.out.println(healthyBurger.getTotalPrice());
    }
}