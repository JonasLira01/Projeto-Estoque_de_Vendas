package Generics;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    private List<T> elements;

    public PrintService() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T first() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(0);
    }

    public List<T> getElements() {
        return elements;
    }
}
