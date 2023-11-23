package edu.hw7.task3_5;

import edu.hw7.task3.Person;
import edu.hw7.task3.PersonDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachingPersonDatabaseReadWriteLock implements PersonDatabase {
    private final Map<Integer, Person> personMap = new HashMap<>();
    private final Map<String, List<Integer>> nameIndex = new HashMap<>();
    private final Map<String, List<Integer>> addressIndex = new HashMap<>();
    private final Map<String, List<Integer>> phoneIndex = new HashMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            if (!personMap.containsKey(person.id()) && person.name() != null && person.address() != null
                && person.phoneNumber() != null) {
                personMap.put(person.id(), person);

                addToIndex(nameIndex, person.name(), person.id());
                addToIndex(addressIndex, person.address(), person.id());
                addToIndex(phoneIndex, person.phoneNumber(), person.id());
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = personMap.get(id);
            if (person != null) {
                removeFromIndex(nameIndex, person.name(), id);
                removeFromIndex(addressIndex, person.address(), id);
                removeFromIndex(phoneIndex, person.phoneNumber(), id);

                personMap.remove(id);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        return search(nameIndex, name);
    }

    @Override
    public List<Person> findByAddress(String address) {
        return search(addressIndex, address);
    }

    @Override
    public List<Person> findByPhone(String phone) {
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
        lock.readLock().lock();
        try {
            List<Integer> ids = index.get(key);
            if (ids == null) {
                return new ArrayList<>();
            }

            List<Person> result = new ArrayList<>();
            for (int id : ids) {
                result.add(personMap.get(id));
            }

            return result;
        } finally {
            lock.readLock().unlock();
        }
    }
}

