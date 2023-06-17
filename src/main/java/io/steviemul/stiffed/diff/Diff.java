package io.steviemul.stiffed.diff;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Diff<T extends Comparable<T>> {

  private final List<T> left;
  private final List<T> right;

  public DiffResult<T> getDiff() {

    DiffResult<T> results = new DiffResult<>();

    int[][] lcs = getLcs();

    int i=0, j=0;

    while (i < left.size() && j < right.size()) {
      if (left.get(i).compareTo(right.get(j)) == 0) {
        results.equal(left.get(i));
        i++;
        j++;
      }
      else if (lcs[i+1][j] >= lcs[i][j+1]) {
        results.left(left.get(i++));
      }
      else {
        results.right(right.get(j++));
      }
    }

    while (i < left.size() || j < right.size()) {
      if (i == left.size()) {
        results.right(right.get(j++));
      }
      else if (j == right.size()) {
        results.left(left.get(i++));
      }
    }

    return results;
  }

  private int[][] getLcs() {

    int [][]lcs = new int[left.size()+1][right.size() + 1];

    for (int i = left.size()-1; i>=0; i--) {
      for (int j = right.size()-1; j >=0; j--) {
        if (left.get(i).compareTo(right.get(j)) == 0) {
          lcs[i][j] = lcs[i+1][j+1] + 1;
        }
        else {
          lcs[i][j] = Math.max(lcs[i+1][j], lcs[i][j+1]);
        }
      }
    }

    return lcs;
  }

}
