package stack;

public class MyStack<T> implements StackADT{
    private T[] dataSource;
    private int top;
    private int size;

    public MyStack(T[] source, int size){
        this.dataSource= (T[]) source;
        this.top=-1;
        this.size=size;
    }

    public T[] getDataSource() {
        return dataSource;
    }

    public int getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(top<0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if(this.top==this.size-1){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void push(Object value) {
        if(!this.isFull()){
            dataSource[++top]= (T) value;
        }
        else{
            throw new StackOverflowError();
        }

    }

    @Override
    public void pop() {
        if(!isEmpty()){
            top--;
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public Object peek(int position) {
        int index=top-position+1;
        if(index<=top && index>=0 ){
            return (T) dataSource[index];
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    public Object stackTop(){
        if(!isEmpty()){
            return dataSource[top];
        }else{
            throw new NullPointerException();
        }
    }

    public Object stackBottom(){
        if (!isEmpty()){
            return dataSource[0];
        }
        else{
            throw new NullPointerException();
        }
    }


    public void peekAll(){
        for(int i=1;i<=top+1;i++){
            System.out.println(this.peek(i));
        }
    }
}
