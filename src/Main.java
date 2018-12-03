import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            ConcurrentMemoryStore concurrentMemoryStore = new ConcurrentMemoryStore();
            Item item1 = new Item();
            item1.setValue1(1);
            item1.setValue2(2);

            Item item2 = new Item();
            item2.setValue1(21);
            item2.setValue2(22);

            Item item3 = new Item();
            item3.setValue1(13);
            item3.setValue2(13);

            concurrentMemoryStore.store("key", item1);
            concurrentMemoryStore.store("key2", item2);
            concurrentMemoryStore.store("key3", item3);
            Iterator<Item> itemIterator = concurrentMemoryStore.valueIterator();
            concurrentMemoryStore.update("key", 99999, 99992);
            concurrentMemoryStore.store("key3", item3);
            concurrentMemoryStore.remove("key");


            Run1();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public static void Run1() {
        Integer array1[][] = {{10, 20, 5, 7, 9}, {20, 30, 70, 3, 8, 100}, {13, 11, 12, 15, 19}};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                list.add(array1[i][j]);
            }
        }
        Integer[] arrayFinal = list.toArray(new Integer[list.size()]);
        Arrays.sort(arrayFinal);


        Iterator<Integer> it = Arrays.asList(arrayFinal).iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void init() {

    }
}
