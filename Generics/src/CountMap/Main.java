package CountMap;

public class Main {

    public static void main(String[] args) {
        CountMapClass map = new CountMapClass();
        map.add(10);

        map.add(10);

        map.add(5);

        map.add(6);

        map.add(5);

        map.add(10);

        int count = map.getCount(5); // 2

        int count1 = map.getCount(6); // 1

        int count2 = map.getCount(10); // 3

        System.out.println(map.getCount(5) + " " + map.getCount(6) + " " + map.getCount(10));
    }

}
