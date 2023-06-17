package io.steviemul.stiffed.diff;

import org.junit.jupiter.api.Test;

import java.util.List;

import static io.steviemul.stiffed.diff.DiffResultAnnotator.annotate;

class DiffTest {

  @Test
  void test_basicDiff() {

    // Given
    List<String> left = List.of("Line 1", "Line 2", "Line 4", "Line 5");
    List<String> right = List.of("Line 1", "Line 3", "Line 4", "Line 6", "Line 7");

    Diff<String> diff = new Diff<>(left, right);

     // When
    DiffResult<String> result = diff.getDiff();

    // Then
    annotate(result);
  }
}