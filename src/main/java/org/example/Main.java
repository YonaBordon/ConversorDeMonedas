package org.example;

import org.example.application.Application;

public class Main {

  private final Application application = new Application();

  public static void main(String[] args) {
    Main main = new Main();
    main.application.run();
  }
}