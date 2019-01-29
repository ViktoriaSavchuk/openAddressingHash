import java.util.Arrays;

public class MyHashMap {
    private int freeCell = 0;
    private int size;
    private int[] keys;
    private long[] values;
    private int j = 0;

    public MyHashMap() {
        this.size = 2;
        this.size = Math.max(3 * size / 2, size) + 1;

        keys = new int[this.size];
        values = new long[this.size];
        Arrays.fill(keys, freeCell);
    }

    public MyHashMap(int size) {
        this.size = Math.max(3 * size / 2, size) + 1;
        keys = new int[this.size];
        values = new long[this.size];
        Arrays.fill(keys, freeCell);
    }

    void put(int x, int y) {

        for (int i = index(hash(x)); ; i++) {
            j++;
            if (i == size) i = 0;
            if (keys[i] == freeCell)
                keys[i] = x;
            if (keys[i] == x) {
                values[i] = y;
                return;
            }
            if (j > keys.length - 2) {
                int tempKey[];
                tempKey = Arrays.copyOf(keys, keys.length + 1);
                long tempValues[];
                tempValues = Arrays.copyOf(values, values.length + 1);
                this.size = Math.max(3 * size / 2, size) + 1;
                this.keys = new int[this.size];
                values = new long[this.size];
                keys = Arrays.copyOf(tempKey, keys.length);
                values = Arrays.copyOf(tempValues, values.length);
                return;
            }
        }
    }

    long get(int x) {
        int j = 0;
        for (int i = index(hash(x)); ; i++) {
            if (i == size) i = 0;
            if (keys[i] == freeCell) throw new RuntimeException("No such key!");
            if (keys[i] == x) return values[i];
            j++;
        }
    }


    private int hash(int x) {
        return (x >> 15) ^ x;
    }

    private int index(int hash) {
        return Math.abs(hash) % size;
    }

    int size() {
        int mapSize = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != 0 && values[i] != 0) {
                mapSize++;
            }
        }
        return mapSize;
    }

}