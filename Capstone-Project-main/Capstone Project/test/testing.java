package test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.*;

public class testing {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        encap cap = new encap();

        Path testPath = Paths.get("D:\\Capstone Project\\productsDB.txt");
        cap.setPath(testPath);

        try {
            
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(cap.getPath(), APPEND));
            BufferedWriter testWriter = new BufferedWriter(new OutputStreamWriter(output));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            testWriter.write(name);
            testWriter.close();
            output.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

      

        

        
    }
    
}
