package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CachingPersonDatabase implements PersonDatabase {
    private final Map<Integer, Person> personMap = new HashMap<>();
    private final Map<String, List<Integer>> nameIndex = new HashMap<>();
    private final Map<String, List<Integer>> addressIndex = new HashMap<>();
    private final Map<String, List<Integer>> phoneIndex = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        if (!personMap.containsKey(person.id()) && person.name() != null && person.address() != null
            && person.phoneNumber() != null) {
            personMap.put(person.id(), person);

            addToIndex(nameIndex, person.name(), person.id());
            addToIndex(addressIndex, person.address(), person.id());
            addToIndex(phoneIndex, person.phoneNumber(), person.id());
        }
    }

    @Override
    public synchronized void delete(int id) {
        Person person = personMap.get(id);
        if (person != null) {
            removeFromIndex(nameIndex, person.name(), id);
            removeFromIndex(addressIndex, person.address(), id);
            removeFromIndex(phoneIndex, person.phoneNumber(), id);

            personMap.remove(id);
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return search(nameIndex, name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return search(addressIndex, address);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return search(phoneIndex, phone);
    }

    private void addToIndex(Map<String, List<Integer>> index, String key, int id) {
        index.computeIfAbsent(key, k -> new ArrayList<>()).add(id);
    }

    private void removeFromIndex(Map<String, List<Integer>> index, String key, int id) {
        List<Integer> ids = index.get(key);
        if (ids != null) {
            ids.remove(Integer.valueOf(id));
            if (ids.isEmpty()) {
                index.remove(key);
            }
        }
    }

    private List<Person> search(Map<String, List<Integer>> index, String key) {
        List<Integer> ids = index.get(key);
        if (ids == null) {
            return new ArrayList<>();
        }

        return ids.stream().map(personMap::get).collect(Collectors.toList());
    }
}