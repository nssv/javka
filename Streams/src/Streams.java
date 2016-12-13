import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Streams<T> {

    List<T> list;

    Streams(List<? extends T> list) {
        this.list = new ArrayList<T>();
        for (T o : list) {
            this.list.add(o);
        }
    }

    static <T> Streams<T> of(List<T> list) {
        return new Streams(list);
    }

    Streams<T> filter(Filter<? super T> f) {
        List<T> newList = new ArrayList<>();

        for (T o : list) {
            if (f.fit(o)) {
                newList.add(o);
            }
        }
        list = newList;
        return this;
    }


    Streams<T> transform(Transform<? extends T> t) {
        List<T> newList = new ArrayList<>();

        for (T o : list) {
            newList.add(t.transform(o));
        }

        list = newList;
        return this;
    }


    public Map<Object, Object> toMap(Maps<T> key, Maps<T> val) {
        Map hashMap = new HashMap();

        for (T o : list) {
            hashMap.put(key.some(o), val.some(o));
        }
        return hashMap;
    }


}
