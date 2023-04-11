#include <LiquidCrystal.h>

// create an instance of the LiquidCrystal library, and specify the pin connections to the display
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

// variables to store the measured temperature in Celsius and Fahrenheit
float degreesC = 0;
float degreesF = 0;

void setup() {
  pinMode(2, INPUT_PULLUP);

  // initialize the display with 16 columns and 2 rows
  lcd.begin(16, 2);
  lcd.clear(); // clear the display
  lcd.setCursor(0, 0);
  lcd.print(" Push Button to");
  lcd.setCursor(0, 1);
  lcd.print("Find Temperature");
}

void loop() {
  // read the voltage from the TMP36 temperature sensor and convert it to Celsius and Fahrenheit
  float voltage = analogRead(A0) * 0.004882813; // convert the analog reading to a voltage value from 0-5 volts
  degreesC = (voltage - 0.5) * 100.0; // convert the voltage to a temperature in degrees Celsius
  degreesF = degreesC * (9.0 / 5.0) + 32.0; // convert the temperature to degrees Fahrenheit

  // check if the button is pressed
  if (digitalRead(2) == LOW) {
    // if the button is pressed, display the temperature readings on the LCD
    lcd.clear(); // clear the LCD
    lcd.setCursor(0, 0); // set the cursor to the top left position
    lcd.print("Degrees C: "); // print a label for the data
    lcd.print(degreesC); // print the degrees Celsius
    lcd.setCursor(0, 1); // set the cursor to the lower left position
    lcd.print("Degrees F: "); // print a label for the data
    lcd.print(degreesF); // print the degrees Fahrenheit
    delay(1000); // delay for 1 second between each reading (this makes the display less noisy)
  }

  // display a message prompting the user to press the button to display the temperature readings
  lcd.setCursor(0, 0);
  lcd.print(" Push Button to ");
  lcd.setCursor(0, 1);
  lcd.print("Find Temperature");
}
