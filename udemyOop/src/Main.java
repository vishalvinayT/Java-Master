public class Main {
    public static void main(String[] args){
        suv mysuv=new suv("bLack","tata",20);
        mysuv.getPrice();
        suv getsuv= new suv("yellow","tata",21);
        getsuv.getPrice();

        room room =new room(500,1000,1200);
        electric electric=new electric(room);
        electric.getBulbpos();
        furniture furniture=new furniture(electric);
        furniture.getbed();
        printer printer=new printer(10,0,false);
        printer.fillToner(20);
        System.out.println("toner level"+printer.getTonerLevel());
        printer.simualatePrinting(100);
        System.out.println("Pages pRinted :"+printer.getTonerLevel());

        printer myprinter=new printer(90,30,true);
        myprinter.simualatePrinting(51);
        System.out.println("Myprinter printed pages "+myprinter.getPrintedPages());
    }



}
