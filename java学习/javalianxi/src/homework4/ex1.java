package homework4;
import java.util.*;
public class ex1 {
    public static void main( String[] args ) {
        // create a list and intialize it
        Double[] data = { new Double( 3.45 ),  new Double( -0.2 ),
                new Double( 100.3 ),  new Double( 89.67 ),
                new Double( 20.3 ),  new Double( 83.7 ),
                new Double( 10.9 ),  new Double( 43.58 ),
                new Double( 11.0 ),  new Double( 23.132 )
        };
        List<Double> list = Arrays.asList( data );

        // iterate to display the set values
        Iterator<Double> i1 = list.iterator();

        System.out.println("未排序数字:");
        while( i1.hasNext() )
            System.out.println( i1.next()+" " );
        System.out.println();
        // sort the list
        System.out.println("已排序数字:");
        Collections.sort( list );
        // iterate to display the sorted values
        for (Double aDouble : list) System.out.println(aDouble + " ");
        System.out.println();

        int index;
        index = Collections.binarySearch(
                list, new Double( 11.0) );
        System.out.println( "Search for 11.0 returns " + index );
        index = Collections.binarySearch(
                list, new Double( 12.0) );
        System.out.println( "Search for 12.0 returns " + index );
    }
}
