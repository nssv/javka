package CountMap;

import java.util.Map;
import java.util.TreeMap;

public class CountMapClass<T> implements CountMap<T> {
    private Map<Object, Integer> cmap = new TreeMap();

    @Override
    public void add(T o) {
        cmap.putIfAbsent(o, 0);
        cmap.put(o, cmap.get(o) + 1);

    }

    @Override
    public int getCount(T o) {

        return cmap.get(o);

    }

    @Override
    public int remove(T o) {
        int i = cmap.get(o);
        cmap.put(o, cmap.get(o) - 1);
        if (cmap.get(o) == 0) cmap.remove(o);
        return i;
    }

    @Override
    public int size() {
        return cmap.size();
    }

    @Override
    public Map toMap() {

        return new TreeMap(cmap);
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        for (Object o : source.toMap().entrySet()) {
            cmap.putIfAbsent(((Map.Entry) o).getKey(), (Integer) ((Map.Entry) o).getValue());
            cmap.put(((Map.Entry) o).getKey(), cmap.get(((Map.Entry) o).getKey()) + 1);
        }

    }


    @Override
    public void toMap(Map destination) {
        destination = new TreeMap(cmap);

    }
}
