package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {

    public static class Task {
        private String text;
        private boolean done;

        public Task(String text) {
            this.text = text;
            this.done = false;
        }

        public String getText() {
            return text;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }

    private final List<Task> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(new Task(item));
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public List<String> getAll() {
        return items.stream()
                .map(t -> t.isDone() ? "[X] " + t.getText() : t.getText())
                .collect(Collectors.toList());
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public boolean markDone(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).setDone(true);
            return true;
        }
        return false;
    }

    public List<String> search(String query) {
        List<String> result = new ArrayList<>();
        if (query == null || query.isEmpty()) {
            return result;
        }
        String lowerQuery = query.toLowerCase();
        for (Task t : items) {
            if (t.getText().toLowerCase().contains(lowerQuery)) {
                result.add(t.isDone() ? "[X] " + t.getText() : t.getText());
            }
        }
        return result;
    }
}