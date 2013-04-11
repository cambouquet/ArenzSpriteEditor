package com.arenz.spriteeditor.controller.file;

import java.io.*;

public class ImageFileFilter implements FileFilter
{
  private final String[] acceptedFileExtensions = 
    new String[] {"jpg", "png", "gif"};

  public boolean accept(File file)
  {
    for (String extension : acceptedFileExtensions)
    {
      if (file.getName().toLowerCase().endsWith(extension))
      {
        return true;
      }
    }
    return false;
  }
}