package org.example;

import org.example.application.Application;

public class Main {

  private final Application application = new Application();

  public static void main(String[] args) {
    System.out.println("Hello, World!");
    Main main = new Main();
    main.application.run();
  }
}