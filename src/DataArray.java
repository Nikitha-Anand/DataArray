import java.io.*;
import java.util.Scanner;

public class DataArray {

    public static void PrintArray(Integer[] intArray){
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] +"  ");
        }
    }

    public static Integer LinearSearch(Integer[] intArray, Integer SearchValue){
        Integer count = 0;
        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i] == SearchValue){
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Integer[] DataArray = new Integer[25];
        File file = new File("Data.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            for (int i = 0; i < 25; i++) {
                DataArray[i] = Integer.valueOf(reader.readLine());
            }
        } catch(FileNotFoundException notFoundException){
            System.out.println("File not found");
        } catch(IOException ioException){
            System.out.println("IO Exception");
        }
        PrintArray(DataArray);

        Boolean valid = false;
        Integer SearchValue = 0;
        while(!valid){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\nEnter a number to search: ");
            SearchValue = keyboard.nextInt();
            if(SearchValue >= 0 && SearchValue <= 100){
                valid = true;
            }
        }
        System.out.println("The number " + SearchValue + " is found " + LinearSearch(DataArray, SearchValue) + " times.");
    }
}
