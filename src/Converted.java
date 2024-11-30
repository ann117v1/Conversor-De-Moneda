import com.google.gson.JsonObject;

public class Converted {
    private final double usdToArs;
    private final double arsToUsd;
    private final double usdToBrl;
    private final double brlToUsd;
    private final double usdToCop;
    private final double copToUsd;

    // Constructor que recibe un JsonObject con las tasas de conversión
    public Converted(JsonObject conversionRates) {
        this.usdToArs = conversionRates.get("ARS").getAsDouble();
        this.arsToUsd = 1 / this.usdToArs;

        this.usdToBrl = conversionRates.get("BRL").getAsDouble();
        this.brlToUsd = 1 / this.usdToBrl;

        this.usdToCop = conversionRates.get("COP").getAsDouble();
        this.copToUsd = 1 / this.usdToCop;
    }

    // Métodos getter para obtener las tasas de conversión
    public double getUsdToArs() {
        return usdToArs;
    }

    public double getArsToUsd() {
        return arsToUsd;
    }

    public double getUsdToBrl() {
        return usdToBrl;
    }

    public double getBrlToUsd() {
        return brlToUsd;
    }

    public double getUsdToCop() {
        return usdToCop;
    }

    public double getCopToUsd() {
        return copToUsd;
    }
}
