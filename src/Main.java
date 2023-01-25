import java.util.Vector;
import java.io.*;


class ListOfNumbers {
    private Vector<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new Vector<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.addElement(Integer.valueOf(i));
            this.readList("infile.txt");
            this.writeList();
        }
    }

    public void readList(String fileName){
        String line = null;
        try{
            RandomAccessFile file = new RandomAccessFile(fileName,"r");
            while((line = file.readLine()) != null) {
                Integer i = Integer.valueOf(Integer.parseInt(line));
                System.out.println(i);
                list.addElement(i);
            }

        }catch (FileNotFoundException fnfe){
            System.err.println("File: " + fileName + "not found.");
        }catch(IOException io){
            System.err.println(io.toString());
        }

    }
    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));

            for (int i = 0; i < list.size(); i++)
                out.println("Value at: " + i + " = " + list.elementAt(i));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {

        new ListOfNumbers();
        new Cat();

    }
}