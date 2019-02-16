package frc.robot;

public class Utils {

    public static double clamp(double value, double min, double max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        }
        return value;
    }

	public static double linearMap(double input, double inLow, double inHigh, double outLow, double outHigh) {
        // If the low and high values are the same, assume low.
        if (inLow == inHigh) {
            return outLow;
        }

        // Calculate the percentage, scale up, and apply the offset
        return (((input - inLow) / (inHigh - inLow)) * (outHigh - outLow)) + outLow;
	}
}