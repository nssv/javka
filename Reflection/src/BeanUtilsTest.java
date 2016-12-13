import org.junit.Test;

import java.util.Objects;

public class BeanUtilsTest {

    @Test
    public void transform() throws Exception {
        Person p1 = new Person("1", 11);
        Person p2 = new Person("2", 22);
        BeanUtils.transform(p1, p2);

        assert (Objects.equals(p1.toString(), p2.toString()));
    }


}