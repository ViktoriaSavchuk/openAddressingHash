import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

public class MyHashMapTest {

    private final MyHashMap map = new MyHashMap();
    private final MyHashMap expected = new MyHashMap();

    @Before
    public void before() {
        map.put(2, 3000);
        map.put(3, 2000);
        map.put(4, 1000);
    }

    @Test
    public void put() {
        map.put(1, 4000);

        assertNotNull(map.get(1));
        assertEquals(map.get(1), 4000);
    }

    @Test
    public void get() {
        assertNotNull(map.get(2));
    }

    @Test(expected = RuntimeException.class)
    public void getShouldFailWithInvalidKey() {
        assertNull(map.get(111));
    }

    @Test
    public void  autoResize(){
        map.put(5,9000);
        assertEquals(map.get(5), 9000);
    }

    @Test
    public void size() {
        assertEquals(3, map.size());
    }
}