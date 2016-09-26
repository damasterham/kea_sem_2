import java.util.Arrays;

public class MyArrayList
{
   private final int SIZE = 10;
       
   private int size;
   private int[] list = new int[SIZE];
   
   public MyArrayList()
   {
      size = SIZE;
   
      for (int i = 0; i < size; i++)
      {
         list[i] = i;
      }
   }
   
   
   private void resize()
   {
      int nsize = list.length + SIZE;
      int[] nList = new int[nsize];
   
      for (int i = 0; i < list.length; i++)
      {
         nList[i] = list[i];    
      }
      
      /*for (int i = list.length; i < nsize; i++)
      {
         nList[i] = 0;
      }*/
      
      list = nList;
   
      //list = Arrays.copyOf(list, size);
   }

   
   public void add(int item)
   {
      if (list.length <= size)
      {
         resize();
      }
      
      list[size] =  item;
      
      size++;
   }
   
   public void dump()
   {
      for (int i = 0; i < size; i++)
      {
         System.out.print(i+"="+list[i]+";");
      }
      
      System.out.println();
   }
 
   
   public static void main(String[] args)
   {
      MyArrayList list = new MyArrayList();
      
      list.dump();
      
      list.add(30);
      list.add(31);
      
      list.dump();
   }
   
}