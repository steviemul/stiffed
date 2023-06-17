package io.steviemul.stiffed.diff;

import java.util.ArrayList;

public class DiffResult<T> extends ArrayList<DiffResultEntry<T>> {

  public static final String EQUAL = "=== ";
  public static final String LEFT = ">>> ";
  public static final String RIGHT = "<<< ";

  public DiffResult<T> left(T item) {
    add(new DiffResultEntry<>(LEFT, item));
    return this;
  }

  public DiffResult<T> equal(T item) {
    add(new DiffResultEntry<>(EQUAL, item));
    return this;
  }

  public DiffResult<T> right(T item) {
    add(new DiffResultEntry<>(RIGHT, item));
    return this;
  }
}
