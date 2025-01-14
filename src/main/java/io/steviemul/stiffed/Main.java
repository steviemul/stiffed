package io.steviemul.stiffed;

import io.steviemul.stiffed.apapter.FileContentsAdapter;
import io.steviemul.stiffed.diff.Diff;
import io.steviemul.stiffed.diff.DiffResult;
import io.steviemul.stiffed.diff.DiffResultAnnotator;

import java.io.File;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    try {

      if (args.length < 2) {
        System.err.println("You must specify 2 files for diffing");
        System.exit(1);
      }

      List<String> leftLines = FileContentsAdapter.linesToList(new File(args[0]));
      List<String> rightLines = FileContentsAdapter.linesToList(new File(args[1]));

      Diff<String> diff = new Diff<>(leftLines, rightLines);

      DiffResult<String> diffResult = diff.getDiff();

      DiffResultAnnotator.annotate(diffResult);
    }
    catch (Exception e) {
      System.err.println("Error diffing files." + e.getMessage());
    }

  }
}
