package com.currencyConverter_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter_2 {

    public static class Currency {

        private String name;
        private String shortName;
        private HashMap<String, Double> exchangeValues;

        // Constructor
        public Currency(String nameValue, String shortNameValue) {
            this.name = nameValue;
            this.shortName = shortNameValue;
            this.exchangeValues = new HashMap<>();
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public HashMap<String, Double> getExchangeValues() {
            return exchangeValues;
        }

        public void setExchangeValues(String key, Double value) {
            this.exchangeValues.put(key, value);
        }

        // Set default values for a currency
        public void defaultValues() {
            switch (this.name) {
	            case "Indian Rupee":
	                this.exchangeValues.put("USD", 0.013);
	                this.exchangeValues.put("EUR", 0.012);
	                this.exchangeValues.put("GBP", 0.0098);
	                this.exchangeValues.put("CHF", 0.013);
	                this.exchangeValues.put("CNY", 0.085);
	                this.exchangeValues.put("JPY", 1.64);
	                this.exchangeValues.put("INR", 1.00);
	                break;
                case "US Dollar":
                    this.exchangeValues.put("USD", 1.00);
                    this.exchangeValues.put("EUR", 0.93);
                    this.exchangeValues.put("GBP", 0.66);
                    this.exchangeValues.put("CHF", 1.01);
                    this.exchangeValues.put("CNY", 6.36);
                    this.exchangeValues.put("JPY", 123.54);
                    this.exchangeValues.put("INR", 74.85);
                    break;
                case "Euro":
                    this.exchangeValues.put("USD", 1.073);
                    this.exchangeValues.put("EUR", 1.00);
                    this.exchangeValues.put("GBP", 0.71);
                    this.exchangeValues.put("CHF", 1.08);
                    this.exchangeValues.put("CNY", 6.83);
                    this.exchangeValues.put("JPY", 132.57);
                    this.exchangeValues.put("INR", 80.42);
                    break;
                case "British Pound":
                    this.exchangeValues.put("USD", 1.51);
                    this.exchangeValues.put("EUR", 1.41);
                    this.exchangeValues.put("GBP", 1.00);
                    this.exchangeValues.put("CHF", 1.52);
                    this.exchangeValues.put("CNY", 9.60);
                    this.exchangeValues.put("JPY", 186.41);
                    this.exchangeValues.put("INR", 102.34);
                    break;
                case "Swiss Franc":
                    this.exchangeValues.put("USD", 0.99);
                    this.exchangeValues.put("EUR", 0.93);
                    this.exchangeValues.put("GBP", 0.66);
                    this.exchangeValues.put("CHF", 1.00);
                    this.exchangeValues.put("CNY", 6.33);
                    this.exchangeValues.put("JPY", 122.84);
                    this.exchangeValues.put("INR", 74.23);
                    break;
                case "Chinese Yuan Renminbi":
                    this.exchangeValues.put("USD", 0.16);
                    this.exchangeValues.put("EUR", 0.15);
                    this.exchangeValues.put("GBP", 0.11);
                    this.exchangeValues.put("CHF", 0.16);
                    this.exchangeValues.put("CNY", 1.00);
                    this.exchangeValues.put("JPY", 19.41);
                    this.exchangeValues.put("INR", 11.76);
                    break;
                case "Japanese Yen":
                    this.exchangeValues.put("USD", 0.008);
                    this.exchangeValues.put("EUR", 0.007);
                    this.exchangeValues.put("GBP", 0.005);
                    this.exchangeValues.put("CHF", 0.008);
                    this.exchangeValues.put("CNY", 0.051);
                    this.exchangeValues.put("JPY", 1.000);
                    this.exchangeValues.put("INR", 0.61);
                    break;
                
                default:
                    throw new IllegalArgumentException("Unknown currency: " + this.name);
            }
        }

        // Initialize currencies
        public static ArrayList<Currency> init() {
            ArrayList<Currency> currencies = new ArrayList<>();
            currencies.add(new Currency("Indian Rupee", "INR"));
            currencies.add(new Currency("US Dollar", "USD"));
            currencies.add(new Currency("Euro", "EUR"));
            currencies.add(new Currency("British Pound", "GBP"));
            currencies.add(new Currency("Swiss Franc", "CHF"));
            currencies.add(new Currency("Chinese Yuan Renminbi", "CNY"));
            currencies.add(new Currency("Japanese Yen", "JPY"));
            

            for (Currency currency : currencies) {
                currency.defaultValues();
            }

            return currencies;
        }

        // Convert a currency to another
        public static Double convert(Double amount, Double exchangeValue) {
            return Math.round(amount * exchangeValue * 100.0) / 100.0;
        }
    }

    public static void main(String[] args) {
        ArrayList<Currency> currencies = Currency.init();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available currencies:");
        for (int i = 0; i < currencies.size(); i++) {
            System.out.printf("%d. %s (%s)%n", i + 1, currencies.get(i).getName(), currencies.get(i).getShortName());
        }

        while (true) {
            System.out.print("\nEnter the number corresponding to the source currency: ");
            int sourceIndex = scanner.nextInt() - 1;
            System.out.print("Enter the number corresponding to the target currency: ");
            int targetIndex = scanner.nextInt() - 1;

            if (sourceIndex < 0 || sourceIndex >= currencies.size() || targetIndex < 0 || targetIndex >= currencies.size()) {
                System.out.println("Invalid selection. Please try again.");
                continue;
            }

            System.out.print("Enter the amount to convert: ");
            double amount = scanner.nextDouble();

            Currency sourceCurrency = currencies.get(sourceIndex);
            Currency targetCurrency = currencies.get(targetIndex);
            Double exchangeRate = sourceCurrency.getExchangeValues().get(targetCurrency.getShortName());

            if (exchangeRate == null) {
                System.out.println("Conversion rate not available.");
            } else {
                Double convertedAmount = Currency.convert(amount, exchangeRate);
                System.out.printf("%.2f %s = %.2f %s%n", amount, sourceCurrency.getShortName(), convertedAmount, targetCurrency.getShortName());
            }

            System.out.print("Do you want to perform another conversion? (yes/no): ");
            scanner.nextLine(); // Consume newline
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Currency Converter!");
    }
}
