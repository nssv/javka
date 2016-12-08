package PECS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class CollectionUtilsTest {
    @Test
    public void testAddAll() {
        List<Integer> source = Arrays.asList(2, 2, 3, 4, 5);
        List<Number> destination = new ArrayList<>(Arrays.asList(1, 2));
        CollectionUtils.<Number>addAll(source, destination);
        assertEquals(7, destination.size());
    }

    @Test
    public void testNewArrayLis() {
        List list = CollectionUtils.<Number>newArrayList();
        list.add(4);
        list.add(2.1);
        assertTrue(Integer.class == list.get(0).getClass() && Double.class == list.get(1).getClass());
    }

    @Test
    public void testIndexOf() {
        assertEquals(3, CollectionUtils.indexOf(Arrays.asList(2, 3, 5.1, 7), (Number) 7));
    }



    @Test
    public void testIndexOfNotExisted() {
        assertEquals(-1, CollectionUtils.indexOf(Arrays.asList(1, 4), 2));
    }

    @Test
    public void testLimit() {
        List<Number> list = CollectionUtils.<Number>limit(Arrays.asList(1, 2, 3, 4), 2);

        assertEquals(Arrays.asList(1, 2), list);
    }


    @Test
    public void testContainsAllTrue() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> subList = Arrays.asList(1, 2, 3);
        assertTrue(CollectionUtils.<Integer>containsAll(list, subList));
    }

    @Test
    public void testContainsAllFalse() {
        List<Number> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> subList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertFalse(CollectionUtils.<Number>containsAll(list, subList));
    }


}