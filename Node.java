import java.util.ArrayList;

public class TreasureCoordinates {

    // Main method to determine possible coordinates from the input string of digits
    public ArrayList<String> determineCoordinates(String coordinatesInput) {
        ArrayList<String> possibleCoordinatesList = new ArrayList<>();

        // Remove the parentheses
        String digits = coordinatesInput.substring(1, coordinatesInput.length() - 1);
        int numLength = digits.length();

        // Loop through the possible x-coordinate split points
        for (int xSplit = 1; xSplit < numLength; xSplit++) {
            String possibleX = digits.substring(0, xSplit);
            String possibleY = digits.substring(xSplit);

            // Generate valid coordinates without any decimal point in x or y
            if (isValidWholeNumber(possibleX) && isValidWholeNumber(possibleY)) {
                possibleCoordinatesList.add("(" + possibleX + ", " + possibleY + ")");
            }

            // Loop through possible decimal placements in the y-coordinate
            for (int yDecimalPlace = 1; yDecimalPlace < possibleY.length(); yDecimalPlace++) {
                String wholePartY = possibleY.substring(0, yDecimalPlace);
                String decimalPartY = possibleY.substring(yDecimalPlace);

                // Check and add valid combinations for whole x and decimal y
                if (isValidWholeNumber(possibleX) && isValidDecimal(wholePartY, decimalPartY)) {
                    possibleCoordinatesList.add("(" + possibleX + ", " + wholePartY + "." + decimalPartY + ")");
                }
            }

            // Loop through possible decimal placements in the x-coordinate
            for (int xDecimalPlace = 1; xDecimalPlace < possibleX.length(); xDecimalPlace++) {
                String wholePartX = possibleX.substring(0, xDecimalPlace);
                String decimalPartX = possibleX.substring(xDecimalPlace);

                // Check and add valid combinations for decimal x and whole y
                if (isValidDecimal(wholePartX, decimalPartX) && isValidWholeNumber(possibleY)) {
                    possibleCoordinatesList.add("(" + wholePartX + "." + decimalPartX + ", " + possibleY + ")");
                }

                // Check and add valid combinations for decimal x and decimal y
                for (int yDecimalPlace = 1; yDecimalPlace < possibleY.length(); yDecimalPlace++) {
                    String wholePartY2 = possibleY.substring(0, yDecimalPlace);
                    String decimalPartY2 = possibleY.substring(yDecimalPlace);

                    if (isValidDecimal(wholePartX, decimalPartX) && isValidDecimal(wholePartY2, decimalPartY2)) {
                        possibleCoordinatesList.add("(" + wholePartX + "." + decimalPartX + ", " + wholePartY2 + "." + decimalPartY2 + ")");
                    }
                }
            }
        }

        return possibleCoordinatesList;
    }

    // Helper method to check if a string represents a valid whole number (without leading zeros)
    private boolean isValidWholeNumber(String numberStr) {
        if (numberStr.length() > 1 && numberStr.startsWith("0")) {
            return false; // Invalid if leading zero
        }
        return true;
    }

    // Helper method to check if a string represents a valid decimal number
    private boolean isValidDecimal(String wholePart, String decimalPart) {
        if (!isValidWholeNumber(wholePart)) {
            return false; // Whole part of decimal cannot have leading zero unless it's "0"
        }
        if (decimalPart.endsWith("0")) {
            return false; // Decimal part cannot have trailing zero
        }
        return true;
    }
}
