package io.steviemul.stiffed.diff;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DiffResultEntry<T> {

  private final String equality;
  private final T item;
}
