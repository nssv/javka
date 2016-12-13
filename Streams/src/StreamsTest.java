import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class StreamsTest {

    @org.junit.Test
    public void getStream() throws Exception {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("1", 11);
        Person p2 = new Person("2", 22);
        list.add(p1);
        list.add(p2);

        assert (Objects.equals((Streams
                        .of(list)
                        .filter(p -> p.getAge() < 30)
                        .transform(p -> new Person(((Person) p).getName(), ((Person) p).getAge()))
                        .toMap(p -> p.getName(), p -> p.getAge()).get("1")).toString(),
                "11")
        );
    }
}