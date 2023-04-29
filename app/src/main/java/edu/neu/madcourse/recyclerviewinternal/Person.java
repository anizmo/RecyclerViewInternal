package edu.neu.madcourse.recyclerviewinternal;

/**
 * This class represents a person with a name.
 */
public class Person {

    /**
     * The name of the person.
     */
    private final String name;

    /**
     * Constructs a person with the given name.
     *
     * @param name the name of the person
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

}

