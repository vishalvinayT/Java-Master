public class printer {
    private int tonerLevel;
    private int printedPages;
    private boolean isDuplex;
    public printer(int tonerLevel, int printedPages, boolean isDuplex){
        this.printedPages=printedPages;
        this.isDuplex=isDuplex;
        if(tonerLevel>=0 && tonerLevel<=100){
            this.tonerLevel=tonerLevel;
        }
    }
    public void fillToner(int val){
        if(val>=0 && val<=100){
            this.tonerLevel+=val;
        }
        else{
            System.out.println("fill properly");
        }
    }

    public int getTonerLevel(){
        return this.tonerLevel;
    }
    public int getPrintedPages(){
        return this.printedPages;
    }
    public boolean getIsDuplex(){
        return this.isDuplex;
    }

    public void simualatePrinting(int val2){
        System.out.println("Printing Started");
        if (val2>0 && this.isDuplex==true){
            this.printedPages=(int) Math.ceil((this.printedPages+val2)/2);
        }
        else if(val2>0){
            this.printedPages+=val2;

        }
        else{
            System.out.println("Enter proper pages");

        }


    }
}
