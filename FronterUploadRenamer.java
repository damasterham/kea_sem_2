import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.FilenameFilter;
import org.apache.commons.io.FilenameUtils;
import java.io.FileNotFoundException;

public class FronterUploadRenamer
{
   public static void main(String[] args)
   {
      String filePath;
      String savePath;
      String regex;
      String prefix;
      String[] extentions;
      
      File fileFolder;
      File saveFolder;
      File[] files;
      FilenameFilter filter;
      
      filePath = "";
      savePath = "";
      regex = "Exercise";
      prefix = "Chance_Meister-Ham_Exercise_";
      extentions = new String[] {"java", "txt", "pdf"};
      
      if (args.length >= 2)
      {
         filePath = args[0];
         savePath = args[1];
         
         if (args.length >= 3)
         {
            regex = args[2];
         }
         if (args.length == 4)
         {
            prefix = args[3];
         }
         if(args.length > 4)
         {
            System.out.println("Too many arguments. The program will still run but will disregard any arguments after the 4th");
         }
      }
      else
      {
         System.out.println("Error: need 2 arguments, directory and savepath");
         System.out.println("You can add aditional 2 arguments:");
         System.out.println("regex (Where it spilts the number and filetype from the rest of the file name)");
         System.out.println("prefix (Your name for the exercise ex. 'Chance_Meister-Ham_Exercise_')");
         return;
      }
      
      try
      {
         fileFolder = new File(filePath);
         saveFolder = new File(savePath);
         
         if (fileFolder.exists() && saveFolder.exists()) // checks if filepath exists
         {
            if(fileFolder.isDirectory() && saveFolder.isDirectory()) // checks if filepath is a directory
            {
               // we create a new FilenameFilter whilst overiding its accept method to check for the extension of a file
               filter = (new FilenameFilter()
               {
                  public boolean accept(File dir, String name) // Don't knoew if File parameter is neccassary
                  {
                     String ext;
                     
                     ext = FilenameUtils.getExtension(name);
                  
                     for (int i = 0; i < extentions.length; i++)
                     {
                        if (ext.equals(extentions[i]))
                        {
                           return true;
                        }
                     }
                     return false;
                  }
               });
               
               files = fileFolder.listFiles(filter); // Get array of file paths
               
               duplicateAndPrefixFiles(files, savePath, regex, prefix);
            }
            else
            {
               System.out.printf("Error: filepath is not a directory, '%s' %s '%s' %s%n", filePath, fileFolder.isDirectory(), savePath, saveFolder.isDirectory());
            }
         }
         else
         {
            System.out.printf("Error: filepath does not exist, '%s' %s '%s' %s%n", filePath, fileFolder.exists(), savePath, saveFolder.exists());
         }
      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
      
      
           
   }
   
   
   public static void duplicateAndPrefixFiles(File[] files, String savePath, String regex, String prefix)
   {
      // rename files and saves to new directory
      for (int i = 0; i < files.length; i++)
      {
         String filename;
         String fileEnd;
         String parse;
         String newFilename;
         String[] split;
         
         filename = files[i].getName().toLowerCase(); // Gets the filename
         split = filename.split(regex); // Splits the file into a String array 
         fileEnd = split[split.length-1]; // Takes the last element from the String array which should always be the numbers and extension
         
         try
         {
            parse = fileEnd.charAt(0) + "";
                        
            Integer.parseInt(parse);
            newFilename = savePath + prefix + fileEnd; // Makes a new filename with savepath, custom prefix and the file ending with exercise numebers and extention
            
            try 
            {
               duplicate(files[i], newFilename);
            }
            catch (FileNotFoundException e)
            {
               System.out.println(e.getMessage());
            }
         }
         catch (NumberFormatException e)
         {
            //System.out.println(e.getMessage());
            System.out.printf("%s does not have numbers after being split by the designated regex%n", filename);
            System.out.printf("Your file ending: '%s', desired file ending '123.txt'%n", fileEnd);
            System.out.println("The file will be disregarded, if this was a file you wanted to duplicate rename it to a proper syntax\n");
         }         
      }
   }
   
   
   public static void duplicate(File file, String newFile)throws FileNotFoundException
   {
      Scanner input;
      PrintStream output;
      
      File outputFile;
      
      try
      {
         outputFile = new File(newFile);
      
         input = new Scanner(file);
         output = new PrintStream(outputFile);
         
         while (input.hasNextLine())
         {
            output.println(input.nextLine());
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println(e.getMessage());
      }
   }
}