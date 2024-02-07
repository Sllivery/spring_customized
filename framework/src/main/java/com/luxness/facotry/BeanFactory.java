package com.luxness.facotry;

/**
 * The top interface should only focus on simple, direct method that I want
 * And declare multi interfaces which contain different methods to make those functionality fine-grained
 * Subclasses would implement multi interfaces
 *
 * getBean is the core desirable method that clients want
 * The client uses getBean() to get a Bean class without creating manually
 */
public interface BeanFactory {
    Object getBean(String name);
}
