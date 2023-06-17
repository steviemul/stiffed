package io.steviemul.stiffed.diff;

public class DiffResultAnnotator {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public static void annotate(DiffResult<?> result) {

    for (int i=1; i <= result.size(); i++) {
      DiffResultEntry<?> entry = result.get(i-1);

      if ((i < result.size()) && entriesConflict(entry, result.get(i))) {
        ansiOut(ANSI_RED, entryConflictsAsString(entry, result.get(i++)));
      }
      else if (DiffResult.EQUAL.equals(entry.getEquality())) {
        ansiOut(ANSI_GREEN, entryAsString(entry));
      }
      else if (DiffResult.LEFT.equals(entry.getEquality())) {
        ansiOut(ANSI_BLUE, entryAsString(entry));
      }
      else if (DiffResult.RIGHT.equals(entry.getEquality())) {
        ansiOut(ANSI_BLUE, entryAsString(entry));
      }
    }
  }

  private static boolean entriesConflict(DiffResultEntry<?> entry1, DiffResultEntry<?> entry2) {

    if (DiffResult.LEFT.equals(entry1.getEquality()) && DiffResult.RIGHT.equals(entry2.getEquality())) {
      return true;
    }
    else if (DiffResult.LEFT.equals(entry2.getEquality()) && DiffResult.RIGHT.equals(entry1.getEquality())) {
      return true;
    }

    return false;
  }

  public static String entryConflictsAsString(DiffResultEntry<?> entry1, DiffResultEntry<?> entry2) {
    return entry1.getItem() + " !== " + entry2.getItem();
  }

  public static String entryAsString(DiffResultEntry<?> entry) {
    return entry.getEquality() + " " + entry.getItem();
  }

  public static void ansiOut(String colorCode, String value) {

    System.out.println(colorCode
        + value
        + ANSI_RESET);
  }
}
