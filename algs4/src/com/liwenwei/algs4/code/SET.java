/******************************************************************
 * 
 * 集合：
 * 某些符号表的用例不需要处理值，他们只需要能够将键插入表中并检测一个键在表中是否存在。
 * 
 * 它只处理表中所有键的集合，和相应的值无关。
 * 
 * @author liwenwei
 *
 ******************************************************************/
package com.liwenwei.algs4.code;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class SET<Key extends Comparable<Key>> implements Iterable<Key> {
    private TreeSet<Key> set;

    /**
     * Initializes an empty set.
     */
    public SET() {
        set = new TreeSet<Key>();
    }

    /**
     * Initializes a new set that is an independent copy of the specified set.
     *
     * @param x the set to copy
     */
    public SET(SET<Key> x) {
        set = new TreeSet<Key>(x.set);
    }

    /**
     * Adds the key to this set (if it is not already present).
     *
     * @param  key the key to add
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void add(Key key) {
        if (key == null) throw new IllegalArgumentException("called add() with a null key");
        set.add(key);
    }


    /**
     * Returns true if this set contains the given key.
     *
     * @param  key the key
     * @return {@code true} if this set contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("called contains() with a null key");
        return set.contains(key);
    }

    /**
     * Removes the specified key from this set (if the set contains the specified key).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("called delete() with a null key");
        set.remove(key);
    }

    /**
     * Returns the number of keys in this set.
     *
     * @return the number of keys in this set
     */
    public int size() {
        return set.size();
    }

    /**
     * Returns true if this set is empty.
     *
     * @return {@code true} if this set is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
 
    /**
     * Returns all of the keys in this set, as an iterator.
     * To iterate over all of the keys in a set named {@code set}, use the
     * foreach notation: {@code for (Key key : set)}.
     *
     * @return an iterator to all of the keys in this set
     */
    public Iterator<Key> iterator() {
        return set.iterator();
    }

    /**
     * Returns the largest key in this set.
     *
     * @return the largest key in this set
     * @throws NoSuchElementException if this set is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty set");
        return set.last();
    }

    /**
     * Returns the smallest key in this set.
     *
     * @return the smallest key in this set
     * @throws NoSuchElementException if this set is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty set");
        return set.first();
    }


    /**
     * Returns the smallest key in this set greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in this set greater than or equal to {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * @throws NoSuchElementException if there is no such key
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("called ceiling() with a null key");
        Key k = set.ceiling(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    /**
     * Returns the largest key in this set less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in this set table less than or equal to {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * @throws NoSuchElementException if there is no such key
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("called floor() with a null key");
        Key k = set.floor(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    /**
     * Returns the union of this set and that set.
     *
     * @param  that the other set
     * @return the union of this set and that set
     * @throws IllegalArgumentException if {@code that} is {@code null}
     */
    public SET<Key> union(SET<Key> that) {
        if (that == null) throw new IllegalArgumentException("called union() with a null argument");
        SET<Key> c = new SET<Key>();
        for (Key x : this) {
            c.add(x);
        }
        for (Key x : that) {
            c.add(x);
        }
        return c;
    }

    /**
     * Returns the intersection of this set and that set.
     *
     * @param  that the other set
     * @return the intersection of this set and that set
     * @throws IllegalArgumentException if {@code that} is {@code null}
     */
    public SET<Key> intersects(SET<Key> that) {
        if (that == null) throw new IllegalArgumentException("called intersects() with a null argument");
        SET<Key> c = new SET<Key>();
        if (this.size() < that.size()) {
            for (Key x : this) {
                if (that.contains(x)) c.add(x);
            }
        }
        else {
            for (Key x : that) {
                if (this.contains(x)) c.add(x);
            }
        }
        return c;
    }

    /**       
     * Compares this set to the specified set.
     * <p>
     * Note that this method declares two empty sets to be equal
     * even if they are parameterized by different generic types.
     * This is consistent with the behavior of {@code equals()} 
     * within Java's Collections framework.
     *       
     * @param  other the other set
     * @return {@code true} if this set equals {@code other};
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        SET that = (SET) other;
        return this.set.equals(that.set);
    }

    /**
     * This operation is not supported because sets are mutable.
     *
     * @return does not return a value
     * @throws UnsupportedOperationException if called
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("hashCode() is not supported because sets are mutable");
    }

    /**
     * Returns a string representation of this set.
     *
     * @return a string representation of this set, enclosed in curly braces,
     *         with adjacent keys separated by a comma and a space
     */
    @Override
    public String toString() {
        String s = set.toString();
        return "{ " + s.substring(1, s.length() - 1) + " }";
    }
    
}
