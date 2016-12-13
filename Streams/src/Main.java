import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        Person p1 = new Person("Alex", 11);
        Person p2 = new Person("Max", 22);

        list.add(p1);
        list.add(p2);


        System.out.println(Streams.of(list).filter(p -> p.getAge() < 30)
                .transform(p -> new Person(((Person) p).getName(), ((Person) p).getAge()))
                .toMap(p -> p.getName(), p -> p.getAge())
        );
    }
}
