package lambda;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda{
    public static String str = "Java is the best";
    public static Integer[] arr = {12,15,1,2,10,17,22};
    public static List <Integer> listInt = Arrays.asList(12,15,1,2,10,17,22);
    public static List<String> listString = Arrays.asList("asd","rty","erty","asdfg","axc","Atf");
    public static int sum;
    public static double d;
    public static int n;



    public static void main(String[] args) {
//      ex.2 - работает возвращает индекс найденного числа.
        n = 12;
        System.out.println(search((arr,n) -> Arrays.asList(arr).indexOf(n), arr, n));
        n = 2;
        System.out.println(search((arr,n) -> Arrays.asList(arr).indexOf(n), arr, n));
        n = 3;
        System.out.println(search((arr,n) -> Arrays.asList(arr).indexOf(n), arr, n));

//      ex.3 работает - переворачивает строку

        StringBuilder strB = new StringBuilder(str);
        System.out.println(reverse(a -> a.reverse().toString(), strB));

//      ex.4  работает - ищет максимум

        System.out.println(maximum(arr -> Collections.max(Arrays.asList(arr)), arr));

//      var2. - не работает
//      System.out.println(maximum(arr -> Arrays.asList(arr).stream().max(Integer::max).get(), arr));

//      var3.- не работает
//      System.out.println(maximum(arr -> Arrays.stream(arr).max(), arr));

//      var4. - не работает
//      System.out.println(maximum(arr -> (Arrays.stream(arr).max(Integer::compareTo)),arr));


//      ex.5 работает - находит среднеарифметический дабл

        System.out.println(average(listInt -> {
            for (int i : listInt) sum += i;
            return d = sum / listInt.size();
        }, listInt));

//      ex.6 работает - ищет слова длинной 3 буквы с а.
        
        System.out.println(search(listString -> listString.stream().filter(x -> x.toCharArray().length == 3 && x.toCharArray()[0] == 'a').collect(Collectors.toList()), listString));

    }

//    ex.2
    public static int search(BiFunction<Integer[], Integer, Integer> e, Integer[] list, Integer n){
        return e.apply(list, n);
    }

//      ex.3
    public static String reverse(Function<StringBuilder, String> e, StringBuilder strB) {
        return e.apply(strB);
    }

//      ex.4
    public static Integer maximum(Function<Integer[], Integer> e, Integer[] arr) {
        return e.apply(arr);
    }

//      ex.5
    public static Double average(Function <List<Integer>, Double> e, List <Integer> listInt){
        return e.apply(listInt);
  }

//      ex.6
    public static List<String> search(UnaryOperator<List<String>> e, List<String> list){
        return e.apply(list);
    }
}



//    @Override
//    public int compare(Integer o1, Integer o2) {
//        return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
//    }




