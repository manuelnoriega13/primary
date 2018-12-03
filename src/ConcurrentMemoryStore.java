import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentMemoryStore implements IConcurrentMemoryStore {

    private List<Item> itemList = new ArrayList<>();

    @Override
    public void store(String key, Item item) throws IllegalArgumentException {
        Item check = getItem(key);
        if (check == null){
            item.setKey(key);
            itemList.add(item);
        }
    }

    @Override
    public void update(String key, int value1, int value2) {
        Item item = getItem(key);
        item.setValue1(value1);
        item.setValue2(value2);
    }

    @Override
    public Iterator<Item> valueIterator() {

        Iterator<Item> itemIterator = itemList.iterator();
        return itemIterator;
    }

    @Override
    public void remove(String key) {
        Item item = getItem(key);
        itemList.remove(item);
    }

    @Override
    public Item getItem(String key) {
        for (Item item : itemList) {
            if (item.getKey().equals(key))
                return item;
        }
        return null;
    }

}
