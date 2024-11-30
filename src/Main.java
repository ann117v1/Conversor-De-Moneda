import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RequestHttp requestHttp = new RequestHttp();

        try {
            // Obtener las tasas de conversión desde la API
            JsonObject conversionRates = requestHttp.getConversionRates();
            Converted converted = new Converted(conversionRates);

            int opcion = 0;
            while (opcion != 7) {
                System.out.println("************************************************");
                System.out.println("Sea bienvenido/a al Converson de Monedas!!");
                System.out.println(" ");
                System.out.println(" ");

                System.out.println("Elija una opción para convertir:");
                System.out.println(" ");
                System.out.println("1. Dólar a Peso Argentino (USD a ARS)");
                System.out.println("2. Peso Argentino a Dólar (ARS a USD)");
                System.out.println("3. Dólar a Real (USD a BRL)");
                System.out.println("4. Real a Dólar (BRL a USD)");
                System.out.println("5. Dólar a Peso Colombiano (USD a COP)");
                System.out.println("6. Peso Colombiano a Dólar (COP a USD)");
                System.out.println("7. Salir");
                System.out.println("Elija una opcion que sea valida para evitar errores de programa :]");
                System.out.println("************************************************");

                opcion = scanner.nextInt();

                if (opcion == 7) {
                    System.out.println("Saliendo del programa.");
                    break;
                }

                System.out.print("Ingrese el monto a convertir: ");
                double monto = scanner.nextDouble();

                switch (opcion) {
                    case 1:
                        System.out.println(" ");
                        System.out.println("El valor de:" + monto + "USD" + " corresponde al valor final de:" + monto * converted.getUsdToArs() + "ARS");
                        System.out.println(" ");
                        break;
                    case 2:
                        System.out.println(" ");
                        System.out.println("El valor de:" + monto + "ARS" + " corresponde al valor final de:" + monto * converted.getArsToUsd() + "USD");
                        System.out.println(" ");
                        break;
                    case 3:
                        System.out.println(" ");
                        System.out.println("El valor de:" + monto + "USD" + " corresponde al valor final de:" + monto * converted.getUsdToBrl() + "BRL");
                        System.out.println(" ");
                        break;
                    case 4:
                        System.out.println(" ");
                        System.out.println("El valor de:" + monto + "BRL" + " corresponde al valor final de:" + monto * converted.getBrlToUsd() + "USD");
                        System.out.println(" ");
                        break;
                    case 5:
                        System.out.println(" ");
                        System.out.println("El valor de:" + monto + "USD" + " corresponde al valor final de:" + monto * converted.getUsdToCop() + "COP");
                        System.out.println(" ");
                        break;
                    case 6:
                        System.out.println(" ");
                        System.out.println("El valor de:" + monto + "COP" + " corresponde al valor final de:" + monto * converted.getCopToUsd() + "USD");
                        System.out.println(" ");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
            scanner.close();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener los datos de la API: " + e.getMessage());
        }
    }
}
