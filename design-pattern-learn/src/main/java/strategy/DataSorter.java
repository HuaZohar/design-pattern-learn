package strategy;

/**
 * @author zzh
 */
public class DataSorter {


    public static void sort(Object[] a) {

        for (int i = a.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                Comparable o1 = (Comparable) a[j];
                Comparable o2 = (Comparable) a[j + 1];
                if (o1.compareTo(o2) == 1) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    private static void swap(Object[] a, int x, int y) {
        Object tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void p(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
