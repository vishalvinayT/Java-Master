
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist=new Playlist("MyPlayList");
        playlist.addSong("KGF","toofan");
        playlist.addSong("Bahu","intro");
        playlist.addSong("Sham","rathalu");
        playlist.addSong("Sham","dead");
        LinkedList<Song> songs=playlist.getSongs();
        ListIterator<Song> i=songs.listIterator();
        while(i.hasNext()){
            Song song=i.next();
            System.out.println("Song:"+ song.getName()+" Duration: "+song.getDuration());
        }
        menu();
        play(songs);

    }

    public static void menu(){
        System.out.println("1. Quit");
        System.out.println("2. Next Song");
        System.out.println("3. Previous Song");
        System.out.println("4. Replay Song");
        System.out.println("5. Remove Song");
    }

    public static void play(LinkedList<Song> songs){
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> song= songs.listIterator();
        Scanner scanner=new Scanner(System.in);
        while(!quit){
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Quitted");
                    quit=true;

                    break;
                case 2:
                    if(forward==false){
                        if(song.hasNext()){
                            song.next();
                            forward=true;
                        }
                    }
                    if(song.hasNext()){
                        Song mysong=song.next();
                        System.out.println("song:"+mysong.getName()+" Duration "+mysong.getDuration());
                    }
                    else{
                        System.out.println("no forward");
                        forward=false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(song.hasPrevious()){
                            song.previous();
                            forward=false;
                        }
                    }
                    if(song.hasPrevious()){
                        Song mySong=song.previous();
                        System.out.println("song:"+mySong.getName()+" Duration "+mySong.getDuration());
                    }
                    else{
                        System.out.println("no forward");
                        forward=true;
                    }
                    break;
            }
        }
    }
}