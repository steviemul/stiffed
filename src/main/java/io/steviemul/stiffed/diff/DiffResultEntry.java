package io.steviemul.stiffed.diff;

public class DiffResultEntry<T> {

  private final String equality;
  private final T item;

  public DiffResultEntry(String equality, T item) {
    this.equality = equality;
    this.item = item;
  }

  public String getEquality() {
    return this.equality;
  }

  public T getItem() {
    return this.item;
  }
}
