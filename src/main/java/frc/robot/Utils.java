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
    
    /**
     * Performs a P-control (rate limiter) on the given values.
     * @param actual The previously output value, or the amount you last sent from this command.
     * @param command The command value, or the amount you're aiming for.
     * @param maxRate The proportional rate, or the maximum amount the output value is allowed to change per frame.
     * @return The new output value.
     */
    public static double rateLimit(double actual, double command, double maxRate) {
        maxRate = Math.abs(maxRate);

        if (Math.abs(actual - command) < maxRate) {
            return command;
        }
        
        if (command > actual) {
            return actual + maxRate;
        } else if (command < actual) {
            return actual - maxRate;
        } else {
            // Equal
            return actual;
        }
    }
}