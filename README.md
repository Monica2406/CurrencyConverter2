# CurrencyConverter2
This is a simple Currency Converter application built in Java. It allows users to convert between various currencies using predefined exchange rates. The program supports conversion between multiple currencies like USD, INR, EUR, GBP, CHF, CNY, and JPY. Users can select source and target currencies and input the amount they want to convert.
 Features
Convert between different currencies.
Support for multiple currencies: Indian Rupee (INR), US Dollar (USD), Euro (EUR), British Pound (GBP), Swiss Franc (CHF), Chinese Yuan Renminbi (CNY), and Japanese Yen (JPY).
Dynamic user interface that allows the selection of source and target currencies.
Displays the conversion rate and the converted amount.
Continues converting until the user decides to exit.
Technologies Used
Java 8
Scanner for user input.
HashMap for storing exchange rates.
ArrayList for managing the list of available currencies.
Prerequisites
Java Development Kit (JDK) version 8 or higher.
Currency Conversion Options
•	INR → USD
•	USD → INR
•	EUR → INR
•	INR → EUR
•	GBP → INR
•	INR → GBP
Available Currencies
•	Indian Rupee (INR)
•	US Dollar (USD)
•	Euro (EUR)
•	British Pound (GBP)
•	Swiss Franc (CHF)
•	Chinese Yuan Renminbi (CNY)
•	Japanese Yen (JPY)
Code Structure
•	CurrencyConverter_2.java: The main class that handles user input, currency selection, and conversion. It uses the Currency class to manage currency data and conversion logic.
•	Currency.java: The class representing individual currencies and their exchange rates. It provides methods for setting default exchange values, converting between currencies, and displaying available currencies.
Future Enhancements
•	Add more currencies and exchange rates.
•	Fetch real-time exchange rates from a public API.
•	Improve error handling and input validation.
