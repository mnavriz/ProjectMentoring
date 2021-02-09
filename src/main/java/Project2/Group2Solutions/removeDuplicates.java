package Project2.Group2Solutions;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class removeDuplicates {

    /*
        Given int array

        remove the duplicated values from the array

        print non-duplicated array length

        for example:

        Array is 1,2,2,2,3,3,3,4,4,4,5,5,5

//1 2 2 2 3 3 3 4 4 4 5 5 5
        result should be 5

        NOTE: while printing the result dont use for loop
        use System.out.println(Arrays.toString(your_array_name));
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String myStr = scan.nextLine();

        String[] arr = myStr.split(" ");

        int[] useThisArray = new int[arr.length];

        for (int i = 0; i < useThisArray.length; i++) {

            int num = Integer.parseInt(arr[i]);

            useThisArray[i] = num;

        }

//        code start here
//        dont change anything before this line
//        your Array is useThisLine

        Set s = new HashSet<>();
        for(int i=0; i < useThisArray.length; i++){
            s.add(useThisArray[i]);
        }
        System.out.println(s.size());
        System.out.println(s);
    }

}
/*
    public static void main(String[] args)
    {
        int a[]={3,2,1,4,2,1};
        System.out.print("Before Sorting:");
        for (int i=0;i<a.length; i++ )
        {
            System.out.print(a[i]+"\t");
        }
        System.out.print ("\nAfter Sorting:");
        //sorting the elements
        for(int i=0;i<a.length;i++)
        {
            for(int j=i;j<a.length;j++)
            {
                if(a[i]>a[j])
                {
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }

            }
        }

        //After sorting
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+"\t");
        }
        System.out.print("\nAfter removing duplicates:");
        int b=0;
        a[b]=a[0];
        for(int i=0;i<a.length;i++)
        {
            if (a[b]!=a[i])
            {
                b++;
                a[b]=a[i];
            }
        }
        for (int i=0;i<=b;i++ )
        {
            System.out.print(a[i]+"\t");
        }
    }
}
  OUTPUT:Before Sortng:3 2 1 4 2 1 After Sorting:1 1 2 2 3 4
                Removing Duplicates:1 2 3 4
 */