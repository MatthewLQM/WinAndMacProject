package com.matthew.springbootgradle.hello;

/**
 * @author matthewlqm
 * Create Time : 2019/2/1 3:28 PM
 */
public class Greeting {

    /** The unique id of greeting */
    private final long id;

    /** The content of greeting  */
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
