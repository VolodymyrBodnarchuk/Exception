import java.io.*;


public class Cat {
    public static void cat(File file){
        RandomAccessFile input = null;
        String line = null;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        }catch(FileNotFoundException fnfe){
            System.err.println("File :" + file + "not Found!");
            return;
        }catch(IOException io){
            System.err.println(io.toString());
        }
        finally {
            if (input != null) {
                System.out.println("Closing...");
                try{
                input.close();
                }catch (IOException e){

                }
            }

        }

    }
}