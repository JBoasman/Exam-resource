import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FavouriteList {
    private List<Item> items = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public FavouriteList() {}

//    Item getItem(String id, String name) {
//        // TODO - The logic to check whether the instance field `items` contains
//        // an item with the same id and name, and return it if found.
//
//        return null;  // return null if not found
//    }


    public void addItem(Item item) {
        // adds the `item` to the list of items if it is non-null and no items with the same id exists.
        // If successfully added, notify the observers with the "added" event.
        if (item == null) {
            return;
        }
        for (Item existing : items) {
            if (Objects.equals(existing.getId(), item.getId())) {
                return;
            }
        }
        this.items.add(item);
        this.notify("added", item);

    }

    public void removeItem(Item item) {
        // removes the given `item` from the list of items if an item with the same id and name exists.
        // If successfully removed, notify the observers with the "removed" event.
        if (item == null) {
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            Item existing = items.get(i);
            if (Objects.equals(existing.getId(), item.getId())
                    && Objects.equals(existing.getName(), item.getName())) {
                items.remove(i);
                this.notify("removed", existing);
                return;
            }
        }
    }

    public void attach(Observer o) {
        // adds `o` to the list of observers if it is not null and not already present.
        if (o != null && !observers.contains(o)) {
            this.observers.add(o);
        }
    }

    public void detach(Observer o) {
        // removes `o` if it is present in the instance field `observers`.
        if (o != null) {
            this.observers.remove(o);
        }
    }

    public void notify(String event, Item item) {
        for (Observer o : this.observers) {
            o.update(event, item);
        }
    }

}
