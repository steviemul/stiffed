package io.steviemul.stiffed;

import io.steviemul.stiffed.apapter.FileContentsAdapter;
import io.steviemul.stiffed.diff.Diff;
import io.steviemul.stiffed.diff.DiffResult;
import io.steviemul.stiffed.diff.DiffResultAnnotator;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

@Slf4j
public class Main {

  public static void main(String[] args) {

    try {
      List<String> leftLines = FileContentsAdapter.linesToList(new File(args[0]));
      List<String> rightLines = FileContentsAdapter.linesToList(new File(args[1]));

      Diff<String> diff = new Diff<>(leftLines, rightLines);

      DiffResult<String> diffResult = diff.getDiff();

      DiffResultAnnotator.annotate(diffResult);
    }
    catch (Exception e) {
      log.error("Error diffing files.", e);
    }

  }
}
