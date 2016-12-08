package PECS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {

        destination.addAll(source);

    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }


    public static <T> int indexOf(List<? extends T> source, T o) {

        return source.indexOf(o);
    }


    public static <T> List limit(List<? extends T> source, int size) {
        return source.subList(0, size);
    }


    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }


    public static <T> void removeAll(List<? extends T> removeFrom, List<? super T> c2) {
        c2.removeAll(removeFrom);
    }


    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        for (T aC1 : c2) {
            if (!c1.contains(aC1)) return false;
        }
        return true;
    }


    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T aC2 : c2) {
            if (c1.contains(aC2)) return true;
        }

        return false;
    }


    public static <T extends Comparable> List<T> range(List<? extends T> list, Object min, Object max) {
        List<T> newlist = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(min) == 1 && list.get(i).compareTo(max) == -1) newlist.add(list.get(i));
        }
        return newlist;
    }


    public static <T extends Comparable> List<T> range(List<? extends T> list, Object min, Object max, Comparator comparator) {
        List<T> newlist = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            if (comparator.compare(list.get(i), min) == 1 && comparator.compare(list.get(i), max) == -1)
                newlist.add(list.get(i));
        }
        return newlist;

    }


}
