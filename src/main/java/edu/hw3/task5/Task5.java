package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task5 {
    private Task5() {
    }

    @SuppressWarnings("MultipleStringLiterals")
    private static List<Contact> parseContacts(String[] names, String order) {
        if (names == null || order == null || !order.equals("ASC") && !order.equals("DESC")) {
            return Collections.emptyList();
        }

        List<Contact> contacts = new ArrayList<>();

        for (String name : names) {
            if (name != null) {
                String[] partsOfName = name.split(" ");
                contacts.add(new Contact(partsOfName[0], partsOfName.length > 1 ? partsOfName[1] : ""));
            }
        }

        Collections.sort(contacts, (o1, o2) -> {
            String compareParam1 = o1.lastName.equals("") ? o1.firstName : o1.lastName;
            String compareParam2 = o2.lastName.equals("") ? o2.firstName : o2.lastName;
            if (order.equals("DESC")) {
                return compareParam2.compareToIgnoreCase(compareParam1);
            }
            return compareParam1.compareToIgnoreCase(compareParam2);
        });

        return contacts;
    }

    public static List<Contact> runTask5(String[] names, String order) {
        return parseContacts(names, order);
    }

    public static class Contact {
        private String firstName;
        private String lastName;

        Contact(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override public String toString() {
            return firstName + " " + lastName;
        }
    }
}
