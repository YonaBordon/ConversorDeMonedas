package org.example.utils;

public class Screens {

  public static void screenWelcome() {
    System.out.println("*********************************************");
    System.out.println("           Bienvenido a la aplicación         ");
    System.out.println("*********************************************");
  }

  public static void screenMenu() {
    System.out.println("*********************************************");
    System.out.println("                   Menú                      ");
    System.out.println("*********************************************");
    System.out.println("1. Realizar conversión predefinida");
    System.out.println("2. Realizar conversión personalizada");
    System.out.println("*********************************************");
    System.out.println("Seleccione una opción:");
  }

  public static void screenSpecificCurrencies() {
    System.out.println("*********************************************");
    System.out.println("       Monedas específicas disponibles        ");
    System.out.println("*********************************************");
    System.out.println("ARS - Peso argentino");
    System.out.println("BOB - Boliviano boliviano");
    System.out.println("USD - Dólar estadounidense");
    System.out.println("CLP - Peso chileno");
    System.out.println("MXN - Peso mexicano");
    System.out.println("BRL - Real brasileño");
    System.out.println("*********************************************");
  }

  public static void screenPredefinedConversions() {
    System.out.println("*********************************************");
    System.out.println("     Conversión de divisas predefinida       ");
    System.out.println("*********************************************");
    System.out.println("1. USD -> ARS (Dólar estadounidense a Peso argentino)");
    System.out.println("2. ARS -> USD (Peso argentino a Dólar estadounidense)");
    System.out.println("3. USD -> BRL (Dólar estadounidense a Real brasileño)");
    System.out.println("4. BRL -> USD (Real brasileño a Dólar estadounidense)");
    System.out.println("5. USD -> MXN (Dólar estadounidense a Peso mexicano)");
    System.out.println("6. MXN -> USD (Peso mexicano a Dólar estadounidense)");
    System.out.println("*********************************************");
    System.out.println("Seleccione una opción:");
  }
}
