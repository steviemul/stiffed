package io.steviemul.stiffed.apapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileContentsAdapter {

  public static List<String> linesToList(File file) throws IOException {
    return Files.lines(file.toPath()).collect(Collectors.toList());
  }
}
