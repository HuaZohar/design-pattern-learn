package cn.hqlearn.strategy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

/*        int[] a = {new Integer(1), new Integer(5), new Integer(4), new Integer(6), new Integer(2), new Integer(90)};
        DataSorter.sort(a);
        DataSorter.p(a);*/

        Cat[] cat = {new Cat(1, 8), new Cat(4, 9), new Cat(3, 3), new Cat(2, 2)};


//        Arrays.sort(cat);


        DataSorter.sort(cat);
        DataSorter.p(cat);

    }
}
