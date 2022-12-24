import java.util.*;

import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class StocksManagement extends AdminMethod{

    static Scanner input = new Scanner(System.in); // Scanner for the user admin to have the ability to input in the console.

    //global instance of class
    BasedPath pathsEncap;
    addMessage addMsg = new addMessage();
    removeMessage removeMsg = new removeMessage();
    invalidMessage invMessage = new invalidMessage();

    //global variable
    String delimeter = ","; //for splitting purposes;
    
    static StocksManagement sManagement; // sManagement is an instance of a class called StocksManagement. 
    BufferedWriter bWriter; // BufferedWriter used to write characters to a stream.
    static boolean isValid = false; // static boolean variable called isValid that is initialized to false.

    //global paths
    Path mainProductsDB;
    Path tempProductsDB;

    Path mainQuantityDB;
    Path tempQuantityDB;

    //-----
    //output stream
    OutputStream mainProductsOutput; 
    OutputStream tempProductsOuput;
    OutputStream mainQuantityOutput;
    OutputStream tempQuantityOutput;

    //writers

    BufferedWriter mainProductsWriter, tempProductsWriter, mainQuantityWriter, tempQuantityWriter;

    //readers
    BufferedReader mainProductReader, tempProductsReader, mainQuantityReader, tempQuantityReader;

    //inputStream
    InputStream mainProductsInput, tempProductsInput, mainQuantityInput, tempQuantityInput;

    public static void main(String[] args) {

        System.out.println("=============================== Welcome Admin ==============================\n\n\n\n");

        sManagement = new StocksManagement(); // Creates a new instance of the StocksManagement class and assigns it to the sManagement variable.
        sManagement.Run(); // Call the methods on the sManagement object to perform operations on it.
        
    }

    @Override
    public void AddItem() {

        pathsEncap = new BasedPath();

        mainProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productsDB.txt");
        pathsEncap.setMainProductPath(mainProductsDB);

        tempProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productTemp.txt");
        pathsEncap.setTempProductPath(tempProductsDB);

        mainQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityDB.txt");
        pathsEncap.setMainQuantityPath(mainQuantityDB);

        tempQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityTemp.txt");
        pathsEncap.setTempQuantityPath(tempQuantityDB);


        try {

            // newOutputStream method, which creates an output stream to the file at the specified path.
            mainProductsOutput = new BufferedOutputStream(Files.newOutputStream(pathsEncap.getMainProductPath(), APPEND));
            tempProductsOuput = new BufferedOutputStream(Files.newOutputStream(pathsEncap.getTempProductPath(), APPEND));

            mainQuantityOutput = new BufferedOutputStream(Files.newOutputStream(pathsEncap.getMainQuantityPath(), APPEND));
            tempQuantityOutput = new BufferedOutputStream(Files.newOutputStream(pathsEncap.getTempQuantityPath(), APPEND));

            mainProductsWriter = new BufferedWriter(new OutputStreamWriter(mainProductsOutput));
            tempProductsWriter = new BufferedWriter(new OutputStreamWriter(tempProductsOuput));
            mainQuantityWriter = new BufferedWriter(new OutputStreamWriter(mainQuantityOutput));
            tempQuantityWriter = new BufferedWriter(new OutputStreamWriter(tempQuantityOutput));

            mainProductsInput = Files.newInputStream(pathsEncap.getMainProductPath());
            tempProductsInput = Files.newInputStream(pathsEncap.getTempProductPath());

            mainQuantityInput = Files.newInputStream(pathsEncap.getMainQuantityPath());
            tempQuantityInput = Files.newInputStream(pathsEncap.getTempQuantityPath());

            mainProductReader = new BufferedReader(new InputStreamReader(mainProductsInput));
            tempProductsReader = new BufferedReader(new InputStreamReader(tempProductsInput));

            mainQuantityReader = new BufferedReader(new InputStreamReader(mainQuantityInput));
            tempQuantityReader = new BufferedReader(new InputStreamReader(tempQuantityInput));


        } catch (IOException e1) {
            
            e1.printStackTrace();
        }

        try {

            System.out.print("What is this product? ");
            String prdName = input.next().toUpperCase();
    
            System.out.print("How many " + prdName + " you wish to add: ");
            int prdQnt = input.nextInt();

            //sulat the product name to the notepad
            mainProductsWriter.write(prdName + delimeter);
            mainProductsWriter.newLine();

            // tempProductsWriter.write(prdName + delimeter);
            // tempProductsWriter.newLine();

            //sulat the product quantity to the notepad
            mainQuantityWriter.write(prdQnt + delimeter);
            mainQuantityWriter.newLine();

            // tempQuantityWriter.write(prdQnt + delimeter);
            // tempQuantityWriter.newLine();

            mainProductsWriter.close();
            // tempProductsWriter.close();

            mainQuantityWriter.close();
            // tempQuantityWriter.close();
    
            System.out.println("+──────────────────────────────────────────────────────────────────────────+");
            System.out.println(addMsg.message());
            System.out.println("+──────────────────────────────────────────────────────────────────────────+");
            System.out.println("What do you want to do now? ");
            System.out.println("Available Options: ");
            System.out.println("1. Add more || 2. Back\n");
            int answer = input.nextInt();

            if (answer == 1) {
                AddItem();
            } else if (answer == 2){
                Run();
            } else {
                System.out.println(invMessage.message());
                Run();
            }

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

     
       
    }

    String mainProductReaderFile, tempProductReaderFile, mainQuantityReaderFile, tempQuantityReaderFile;
    // BufferedReader bReader; // used to read text from a character-input stream.
    // InputStream inputS;
    // InputStream inputS1;
    String prodName, prodQnt;
    // // Path file = Paths.get("D:\\Capstone Project\\_temp_.txt");


    @Override
    public void ViewItem() {

        pathsEncap = new BasedPath();

        mainProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productsDB.txt");
        pathsEncap.setMainProductPath(mainProductsDB);

        tempProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productTemp.txt");
        pathsEncap.setTempProductPath(tempProductsDB);

        mainQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityDB.txt");
        pathsEncap.setMainQuantityPath(mainQuantityDB);

        tempQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityTemp.txt");
        pathsEncap.setTempQuantityPath(tempQuantityDB);
        
        try {

            mainProductsInput = Files.newInputStream(pathsEncap.getMainProductPath());
            tempProductsInput = Files.newInputStream(pathsEncap.getTempProductPath());

            mainQuantityInput = Files.newInputStream(pathsEncap.getMainQuantityPath());
            tempQuantityInput = Files.newInputStream(pathsEncap.getTempQuantityPath());

            mainProductReader = new BufferedReader(new InputStreamReader(mainProductsInput));
            mainQuantityReader = new BufferedReader(new InputStreamReader(mainQuantityInput));

            tempProductsReader = new BufferedReader(new InputStreamReader(tempProductsInput));
            tempQuantityReader = new BufferedReader(new InputStreamReader(tempQuantityInput));

            System.out.println("    ========== List Of Products ==========\n");

            if ((mainProductReaderFile = mainProductReader.readLine()) == null && (mainQuantityReaderFile = mainQuantityReader.readLine()) == null && (tempProductReaderFile = tempProductsReader.readLine()) == null && (tempQuantityReaderFile = tempQuantityReader.readLine()) == null) {

                System.out.println("List is empty!");

            }else if((mainProductReaderFile = mainProductReader.readLine()) == null && (mainQuantityReaderFile = mainQuantityReader.readLine()) == null ) {

                viewProductsFromTemp();


            }else { 

                readFromDB();
                
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        }

            System.out.println("\nWhat to do now? Available Option(s): 1.Back");
            System.out.print("Choice: ");
            String choices = input.next();
            
            if (choices.equals("1")) {
                Run();
        } else {
            System.out.println(invMessage.message());
        } Run();
    }

    void viewProductsFromTemp() { // this function is for viewing the products from the temp when the product is removed from the original DB

        pathsEncap = new BasedPath();

        mainProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productsDB.txt");
        pathsEncap.setMainProductPath(mainProductsDB);

        tempProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productTemp.txt");
        pathsEncap.setTempProductPath(tempProductsDB);

        mainQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityDB.txt");
        pathsEncap.setMainQuantityPath(mainQuantityDB);

        tempQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityTemp.txt");
        pathsEncap.setTempQuantityPath(tempQuantityDB);

        try {

            mainProductsInput = Files.newInputStream(pathsEncap.getMainProductPath());
            tempProductsInput = Files.newInputStream(pathsEncap.getTempProductPath());

            mainQuantityInput = Files.newInputStream(pathsEncap.getMainQuantityPath());
            tempQuantityInput = Files.newInputStream(pathsEncap.getTempQuantityPath());

            mainProductReader = new BufferedReader(new InputStreamReader(mainProductsInput));
            mainQuantityReader = new BufferedReader(new InputStreamReader(mainQuantityInput));

            tempProductsReader = new BufferedReader(new InputStreamReader(tempProductsInput));
            tempQuantityReader = new BufferedReader(new InputStreamReader(tempQuantityInput));

            while((tempProductReaderFile = tempProductsReader.readLine()) != null && (tempQuantityReaderFile = tempQuantityReader.readLine()) != null) {

                String[] prodNameData = tempProductReaderFile.split(delimeter);
                String[] prodQuantityData = tempQuantityReaderFile.split(delimeter);
                
                prodName = prodNameData[0];
                prodQnt = prodQuantityData[0];

                System.out.println("==========================================");
                System.out.println("Product Name: " + prodName + "\nProduct Quantity: " + prodQnt );
                System.out.println("==========================================");
                System.out.println();

            }
            



        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    void readFromDB() { //reads the productDB.txt and quantityDB.txt

        pathsEncap = new BasedPath();

        mainProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productsDB.txt");
        pathsEncap.setMainProductPath(mainProductsDB);

        tempProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productTemp.txt");
        pathsEncap.setTempProductPath(tempProductsDB);

        mainQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityDB.txt");
        pathsEncap.setMainQuantityPath(mainQuantityDB);

        tempQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityTemp.txt");
        pathsEncap.setTempQuantityPath(tempQuantityDB);

        try {

            mainProductsInput = Files.newInputStream(pathsEncap.getMainProductPath());
            tempProductsInput = Files.newInputStream(pathsEncap.getTempProductPath());

            mainQuantityInput = Files.newInputStream(pathsEncap.getMainQuantityPath());
            tempQuantityInput = Files.newInputStream(pathsEncap.getTempQuantityPath());

            mainProductReader = new BufferedReader(new InputStreamReader(mainProductsInput));
            tempProductsReader = new BufferedReader(new InputStreamReader(tempProductsInput));

            mainQuantityReader = new BufferedReader(new InputStreamReader(mainQuantityInput));
            tempQuantityReader = new BufferedReader(new InputStreamReader(tempQuantityInput));

            System.out.println("==========================================\n");

            while((mainProductReaderFile = mainProductReader.readLine()) != null &&
            (mainQuantityReaderFile = mainQuantityReader.readLine()) != null ) {

            String[] prodNameData = mainProductReaderFile.split(delimeter);
            String[] prodQuantityData = mainQuantityReaderFile.split(delimeter);
                
            prodName = prodNameData[0];
            prodQnt = prodQuantityData[0];

            System.out.println("Product Name: " + prodName + "\nProduct Quantity: " + prodQnt );
            System.out.println();

            }

            //the second loop is for displaying the products from the product temp and quantity temp txt
            while((tempProductReaderFile = tempProductsReader.readLine()) != null && (tempQuantityReaderFile = tempQuantityReader.readLine()) != null) {

                String[] prodNameDataTemp = tempProductReaderFile.split(delimeter);
                String[] prodQuantityDataTemp = tempQuantityReaderFile.split(delimeter);
                    
                prodName = prodNameDataTemp[0];
                prodQnt = prodQuantityDataTemp[0];
    
                // System.out.println("==========================================");
                System.out.println("Product Name: " + prodName + "\nProduct Quantity: " + prodQnt );
                // System.out.println("==========================================");
                System.out.println();

            }

            System.out.println("==========================================");
        } catch (IOException e) {
            
            e.printStackTrace();
        }

    }

    @Override
    public void RemoveItem() {

        pathsEncap = new BasedPath();

        mainProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productsDB.txt");
        pathsEncap.setMainProductPath(mainProductsDB);

        tempProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productTemp.txt");
        pathsEncap.setTempProductPath(tempProductsDB);

        mainQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityDB.txt");
        pathsEncap.setMainQuantityPath(mainQuantityDB);

        tempQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityTemp.txt");
        pathsEncap.setTempQuantityPath(tempQuantityDB);

            File mainProductFile = new File("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productsDB.txt");
            pathsEncap.setMainProductFile(mainProductFile);

            File tempProductFile = new File("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productTemp.txt");
            pathsEncap.setTempProductFile(tempProductFile);

            File mainQuantityFile = new File("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityDB.txt");
            pathsEncap.setMainQuantityFile(mainQuantityFile);

            File tempQuantityFile = new File("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityTemp.txt");
            pathsEncap.setTempQuantityFile(tempQuantityFile);


        try {
                
            System.out.print("Enter the product you wish to remove: ");

            String lineToRemove = input.next().toUpperCase();

            // PrintWriter mainProductOut = new PrintWriter(new FileWriter(pathsEncap.getMainProductFile()));
            // PrintWriter tempProductOut = new PrintWriter(new FileWriter(pathsEncap.getTempProductFile()));

            // PrintWriter mainQuantityOut = new PrintWriter(new FileWriter(pathsEncap.getMainQuantityFile()));
            // PrintWriter tempQuantityOut = new PrintWriter(new FileWriter(pathsEncap.getTempQuantityFile()));

            // BufferedReader prodReader = new BufferedReader(new FileReader(pathsEncap.getTempProductFile()));
            // BufferedReader quantReader = new BufferedReader(new FileReader(pathsEncap.getTempQuantityFile()));

            // BufferedWriter prodWriter = new BufferedWriter(new FileWriter(pathsEncap.getMainProductFile()));
            // BufferedWriter quantWriter = new BufferedWriter(new FileWriter(pathsEncap.getMainQuantityFile()));

            BufferedReader prodMainReader = new BufferedReader(new FileReader(pathsEncap.getMainProductFile()));
            BufferedReader quantMainReader = new BufferedReader(new FileReader(pathsEncap.getMainQuantityFile()));

            BufferedWriter prodMainWriter = new BufferedWriter(new FileWriter(pathsEncap.getTempProductFile()));
            BufferedWriter quantMainWriter = new BufferedWriter(new FileWriter(pathsEncap.getTempQuantityFile()));

            // PrintWriter used to write text to a character-output stream.
            // FileWriter a class that is used to write characters to the file.

            String currentLine, currentLine1;

        //     while((currentLine = prodReader.readLine()) != null ) {
        //     // trim newline when comparing with lineToRemove
        //     String trimmedLine = currentLine.trim();
        //     if(trimmedLine.equals(lineToRemove + ",")) continue;
        //     prodWriter.write(currentLine + "\n");
        //  }

        //  while((currentLine = quantReader.readLine()) != null ) {
        //     // trim newline when comparing with lineToRemove
        //     String trimmedLine = currentLine.trim();
        //     if(trimmedLine == Integer.toString(3)) continue;
        //     quantWriter.write(currentLine + "\n");
        //  }

        while((currentLine = prodMainReader.readLine()) != null ) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove+ ",")) continue;
            prodMainWriter.write(currentLine + "\n");
        }

        while((currentLine1 = quantMainReader.readLine()) != null ) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine1.trim();
            if(trimmedLine == Integer.toString(3)) continue;
            quantMainWriter.write(currentLine1 + "\n");
        }

        prodMainReader.close(); 
        prodMainWriter.close();

        quantMainReader.close();
        quantMainWriter.close();

        boolean successful = tempProductFile.renameTo(mainProductFile);
        boolean successful1 = tempQuantityFile.renameTo(mainQuantityFile);

         BufferedWriter deleteFromDb = Files.newBufferedWriter(pathsEncap.getMainProductPath()); //deleting from original DB when product is removed
         deleteFromDb.write("");
         deleteFromDb.flush();

         BufferedWriter deleteFromQuantityDb = Files.newBufferedWriter(pathsEncap.getMainQuantityPath());
         deleteFromQuantityDb.write("");
         deleteFromQuantityDb.flush();
             
        // this block of code reads the lines of a file and writes them to an output stream,
        // except for a specific line that contains a given string.
            
        // pathsEncap.getTempProductFile().renameTo(pathsEncap.getMainProductFile()); // Renames the file denoted by this abstract pathname.
        //pathsEncap.getTempQuantityFile().renameTo(pathsEncap.getMainQuantityFile());
        
}
         catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }finally {
            System.out.println(removeMsg.message());
        }

         //boolean successful = pathsEncap.renameTo();
        RunS();
        
    }

    @Override
    public void Exit() {
        System.out.println("Thank you.");
        System.exit(0);
        
    }

    @Override
    public void Run() {

        boolean isValid = true;
            
                do {

                System.out.println("Choose Option: ");
                System.out.println("+───────────────+─────────────────────────────+────────────────+───────────+");
                System.out.println("|1. Add Item    |2. View Item Existing Item   |3. Remove Item  | 4. Exit   |");
                System.out.println("+───────────────+─────────────────────────────+────────────────+───────────+");
                System.out.print("|Choice: ");
                String choices = input.next();
                System.out.println("+───────────────+─────────────────────────────+────────────────+───────────+");

                if (choices.equals("1")) {

                    isValid = true;
                    sManagement.AddItem();
                }
                else if (choices.equals("2")) {

                    isValid = true;
                    sManagement.ViewItem();
                }
                else if (choices.equals("3")) {

                    isValid = true;
                    sManagement.RemoveItem();
                }
                else if (choices.equals("4")) {

                    isValid = true;
                    sManagement.Exit();
                }else { 

                    isValid = false;
                    System.out.println("Invalid Input. Please try again with numbers 1 - 4\n");
                }

                } while (isValid == false);
        
    }

    void readUpdatedDB() { //read the productTemp.txt and quantityTemp.txt

        pathsEncap = new BasedPath();

        mainProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productsDB.txt");
        pathsEncap.setMainProductPath(mainProductsDB);

        tempProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productTemp.txt");
        pathsEncap.setTempProductPath(tempProductsDB);

        mainQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityDB.txt");
        pathsEncap.setMainQuantityPath(mainQuantityDB);

        tempQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityTemp.txt");
        pathsEncap.setTempQuantityPath(tempQuantityDB);

        try {

            String updatedMainProductReader;

            mainProductsInput = Files.newInputStream(pathsEncap.getMainProductPath());
            tempProductsInput = Files.newInputStream(pathsEncap.getTempProductPath());

            mainQuantityInput = Files.newInputStream(pathsEncap.getMainQuantityPath());
            tempQuantityInput = Files.newInputStream(pathsEncap.getTempQuantityPath());

            mainProductReader = new BufferedReader(new InputStreamReader(mainProductsInput));
            tempProductsReader = new BufferedReader(new InputStreamReader(tempProductsInput));

            mainQuantityReader = new BufferedReader(new InputStreamReader(mainQuantityInput));
            tempQuantityReader = new BufferedReader(new InputStreamReader(tempQuantityInput));

            System.out.println("==========================================\n");

            while((mainProductReaderFile = mainProductReader.readLine()) != null &&
            (mainQuantityReaderFile = mainQuantityReader.readLine()) != null ) {

            String[] prodNameData = mainProductReaderFile.split(delimeter);
            String[] prodQuantityData = mainQuantityReaderFile.split(delimeter);
                
            prodName = prodNameData[0];
            prodQnt = prodQuantityData[0];

            System.out.println("Product Name: " + prodName + "\nProduct Quantity: " + prodQnt );
            System.out.println();

            }

            //the second loop is for displaying the products from the product temp and quantity temp txt
            while((tempProductReaderFile = tempProductsReader.readLine()) != null && (tempQuantityReaderFile = tempQuantityReader.readLine()) != null) {

                String[] prodNameDataTemp = tempProductReaderFile.split(delimeter);
                String[] prodQuantityDataTemp = tempQuantityReaderFile.split(delimeter);
                    
                prodName = prodNameDataTemp[0];
                prodQnt = prodQuantityDataTemp[0];
    
                // System.out.println("==========================================");
                System.out.println("Product Name: " + prodName + "\nProduct Quantity: " + prodQnt );
                // System.out.println("==========================================");
                System.out.println();

            }

            System.out.println("==========================================");
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    void viewUpdatedItem() {

        pathsEncap = new BasedPath();

        mainProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productsDB.txt");
        pathsEncap.setMainProductPath(mainProductsDB);

        tempProductsDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\productTemp.txt");
        pathsEncap.setTempProductPath(tempProductsDB);

        mainQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityDB.txt");
        pathsEncap.setMainQuantityPath(mainQuantityDB);

        tempQuantityDB = Paths.get("C:\\Users\\joshu\\Downloads\\Capstone-Project-main\\Capstone Project\\quantityTemp.txt");
        pathsEncap.setTempQuantityPath(tempQuantityDB);
        
        try {

            mainProductsInput = Files.newInputStream(pathsEncap.getMainProductPath());
            tempProductsInput = Files.newInputStream(pathsEncap.getTempProductPath());

            mainQuantityInput = Files.newInputStream(pathsEncap.getMainQuantityPath());
            tempQuantityInput = Files.newInputStream(pathsEncap.getTempQuantityPath());

            mainProductReader = new BufferedReader(new InputStreamReader(mainProductsInput));
            tempProductsReader = new BufferedReader(new InputStreamReader(tempProductsInput));

            mainQuantityReader = new BufferedReader(new InputStreamReader(mainQuantityInput));
            tempQuantityReader = new BufferedReader(new InputStreamReader(tempQuantityInput));

            System.out.println("    ========== List Of Products ==========\n");

            if ((mainProductReaderFile = mainProductReader.readLine()) == null && (mainQuantityReaderFile = mainQuantityReader.readLine()) == null && (tempProductReaderFile = tempProductsReader.readLine()) == null && (tempQuantityReaderFile = tempQuantityReader.readLine()) == null) {

                System.out.println("List is empty!");

            }else if((mainProductReaderFile = mainProductReader.readLine()) == null && (mainQuantityReaderFile = mainQuantityReader.readLine()) == null ) {

               
                viewProductsFromTemp();
                

            }else { 

                readUpdatedDB();
                
            }


        } catch (Exception e) {
            
            e.printStackTrace();
        }

            System.out.println("\nWhat to do now? Available Option(s): 1.Back");
            System.out.print("Choice: ");
            String choices = input.next();
            
            if (choices.equals("1")) {
                RunS();
        } else {
            System.out.println(invMessage.message());
        } RunS();

    }

    private void RunS() {

        boolean isValid = true;
            
                do {

                System.out.println("Choose Option: ");
                System.out.println("+───────────────+─────────────────────────────+────────────────+───────────+");
                System.out.println("|1. Add Item    |2. View Item Existing Item   |3. Remove Item  | 4. Exit   |");
                System.out.println("+───────────────+─────────────────────────────+────────────────+───────────+");
                System.out.print("|Choice: ");
                String choices = input.next();
                System.out.println("+───────────────+─────────────────────────────+────────────────+───────────+");

                if (choices.equals("1")) {

                    isValid = true;
                    sManagement.AddItem();
                }
                else if (choices.equals("2")) {

                    isValid = true;
                    sManagement.viewUpdatedItem();
                }
                else if (choices.equals("3")) {

                    isValid = true;
                    sManagement.RemoveItem();
                }
                else if (choices.equals("4")) {

                    isValid = true;
                    sManagement.Exit();
                }else { 

                    isValid = false;
                    System.out.println("Invalid Input. Please try again with numbers 1 - 4\n");
                }

                } while (isValid == false);

    }
    
}
