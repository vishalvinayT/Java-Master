import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] array=new int[4];
        array[0]=12;array[1]=23;array[2]=34;array[3]=45;
        int[] copyarr=array;
        copyarr=new int[6];
        copyarr[4]=67;
        copyarr[5]=89;
        System.out.println(Arrays.toString(copyarr));



        //generateArray("matrix");
        //writting();
//        Path despath= FileSystems.getDefault().getPath("D:\\Java\\JavaNIO\\niowrite.txt");
//        try(BufferedWriter writter=new BufferedWriter(Files.newBufferedWriter(despath))){
//            writter.write("Hello");
//            writter.writeI(123);
//            writter.write("nweqwejqjweq");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        System.out.println("Name "+String.format("%s","vishal")+"Roll No: "+String.format("%.2f",12.345325)+"Marks: "+String.format("%d",12129));
        //reading();
    }
    public static  void reading(){
        Path sourcePath= Paths.get("D:\\Java\\JavaNIO\\javades.txt");
        List<String> mystr=new ArrayList<>();
        try(Scanner scanner=new Scanner(new BufferedReader(Files.newBufferedReader(sourcePath)))){
            scanner.useDelimiter(",");
            try{
                while (scanner.hasNextLine()){
                    Object name=scanner.next();
                    System.out.println(name);
                    mystr.add((String) name);
                    scanner.skip(scanner.delimiter());
                }
            }catch(Exception r){
                r.getCause();
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void writting(){
        int[][] matrix=generateArray();
        Path file=Paths.get("D:\\Java\\JavaNIO\\matrix.txt");
        try(BufferedWriter writter=new BufferedWriter(Files.newBufferedWriter(file))){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    int val=matrix[i][j];
                    writter.write(val);
                    writter.write(",");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static int[][] generateArray(){
        Random rand=new Random();
        int[][] array=new int[370][150];
        for(int i=0;i<370;i++){
            for(int j=0;j<150;j++){
                array[i][j]=rand.nextInt(125,255);
            }
        }
        return array;
    }

    public static int[][] generateArray(String Matrix){
        Path mat=FileSystems.getDefault().getPath("matrix.txt");
        boolean run=false;
        int[][] matrix=new int[370][150];
        try(BufferedReader reader=new BufferedReader(Files.newBufferedReader(mat))){
            try {
                for(int i=0;i<matrix.length;i++){
                    for(int j=0;j<matrix[0].length;j++){
                        int val=Integer.parseInt(String.valueOf(reader.read()));
                        matrix[i][j]=val;
                    }
                }
            }catch (Exception a){
                run=true;
                a.getMessage();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matrix;
    }

}