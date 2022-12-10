

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;


    public MobilePhone(String phoneNumber){
        this.myNumber=phoneNumber;
        this.myContacts=new ArrayList<Contact>();
    }
    public boolean addNewContact(Contact contact){
        int a=findContact(contact);
        if(a>=0){
            this.myContacts.add(contact);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int position=findContact(oldContact);
        if(position>=0){
            this.myContacts.set(position, newContact);
            return true;
        }
        return false;

    }
    public boolean removeContact(Contact contact){
        int position=findContact(contact);
        if(position>=0){
            this.myContacts.remove(position);
            return true;
        }
        return false;
    }


    public int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String name){
        for(int i=0;i<this.myContacts.size();i++){
            if(myContacts.get(i).getName()==name){
                return i;
            }
        }
        return -1;
    }
    private Contact queryContact(String name){
        int a=findContact(name);
        if(a>=0){
            return this.myContacts.get(a);
        }
        else{
            return null;
        }
    }
    public void printContacts(){
        for(int i=0;i<this.myContacts.size();i++){
            System.out.println(this.myContacts.get(i).getName()+" -> "+this.myContacts.get(i).getPhoneNumber());
        }
    }

}