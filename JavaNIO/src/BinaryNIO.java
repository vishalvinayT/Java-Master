import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class BinaryNIO {
    public static final int[][] matrix=matrix();
    public static final String text="Popular for its versatility 13812 and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it,131 you’ll be able to develop large systems, software, and mobile 128 applications — and even create mobile 893 apps for Android. Learn important Java coding 273 fundamentals and practice your new skills with real-world projects.";
    public static void main(String[] args){
        //writing();
        //reading();
        printMatrix(matrix);
        writeMatrix(matrix);
        System.out.println("***************************************************************************");
        printMatrix(readMatrix());


    }

    public static void reading(){
        Path path=Paths.get("D:\\Java\\JavaNIO\\IO\\binaryData.dat");
        boolean value=false;
        String mystr="";
        try(RandomAccessFile ra=new RandomAccessFile(path.toFile(),"rwd")){
            FileChannel channel=ra.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(1000000000);
            channel.read(buffer);
            buffer.flip();
            while(!value){
                try {
                    byte[] output=new byte[10];
                    buffer.get(output);
                    System.out.println(new String(output));
                    mystr+=new String(output);
                }catch (Exception d) {
                    value=false;
                }

            }

        }catch (Exception a){
            a.printStackTrace();
        }

        System.out.println(mystr);
    }

    public static void writing(){
        Path path= Paths.get("D:\\Java\\JavaNIO\\IO\\binaryData.dat");
        try(FileOutputStream file=new FileOutputStream(path.toFile())){
            String[] myarr=text.split(" ");
            for(String str:myarr){
                byte[] mystr=str.getBytes();
                byte[] delim=",".getBytes();
                FileChannel channel= file.getChannel();
                ByteBuffer buffer=ByteBuffer.allocate(mystr.length+delim.length);
                buffer.put(mystr);
                buffer.put(delim);
                buffer.flip();

                channel.write(buffer);
            }


        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static void writeMatrix(int[][] matrix){
        Path path=Paths.get("D:\\Java\\JavaNIO\\IO\\mymatrix.dat");
        try(FileOutputStream file =new FileOutputStream(path.toFile())){
            FileChannel channel=file.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(Integer.BYTES* matrix.length* matrix[0].length);
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    buffer.putInt(matrix[i][j]);
                }
            }
            buffer.flip();
            channel.write(buffer);

        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public static int[][] readMatrix(){
        int [][] mat=new int[350][170];
        Path path=Paths.get("D:\\Java\\JavaNIO\\IO\\mymatrix.dat");
        try(RandomAccessFile newfile =new RandomAccessFile(path.toFile(),"rwd")){
            FileChannel channel=newfile.getChannel();
            ByteBuffer intbuffer=ByteBuffer.allocate(Integer.BYTES* mat.length* mat[0].length);
            channel.read(intbuffer);
            intbuffer.flip();
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    mat[i][j]=intbuffer.getInt();
                }
            }

            Path copypath=Paths.get("D:\\Java\\JavaNIO\\IO\\copymatrix.dat");
            try(RandomAccessFile re=new RandomAccessFile(copypath.toFile(),"rwd")){
                FileChannel newchannel=re.getChannel();
                channel.position(0);
                long transfer=channel.transferTo(0, channel.size(), newchannel);
                //long transfer=newchannel.transferFrom(channel,0,channel.size());
            }

        }catch(Exception a){
            a.printStackTrace();
        }

        return mat;
    }


    public static int[][] matrix(){
        int[][] matrix=new int[350][170];
        Random ran=new Random();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=ran.nextInt(150,275);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }




}
