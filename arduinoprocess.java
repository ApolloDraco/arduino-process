#include <LiquidCrystal.h> //the liquid crystal library contains commands for
printing to the display
LiquidCrystal lcd(13, 12, 11, 10, 9, 8); // tell the RedBoard what pins are connected to
the display
float voltage = 0; //the voltage measured from the TMP36
float degreesC = 0; //the temperature in Celsius, calculated from the voltage
float degreesF = 0; //the temperature in Fahrenheit, calculated from the
voltage
void setup() {
pinMode(2, INPUT_PULLUP);
lcd.begin(16, 2); //tell the lcd library that we are using a display that is 16
characters wide and 2 characters high
lcd.clear(); //clear the display
lcd.setCursor(0, 0);
lcd.print(" Push Button to");
lcd.setCursor(0, 1);
lcd.print("Find Temperature");
}
void loop() {
voltage = analogRead(A0) * 0.004882813; //convert the analog reading, which varies
from 0 to 1023, back to a voltage value from 0-5 volts
degreesC = (voltage - 0.5) * 100.0; //convert the voltage to a temperature in degrees
Celsius
degreesF = degreesC * (9.0 / 5.0) + 32.0;
if(digitalRead(2) == LOW) {
lcd.clear(); //clear the LCD
lcd.setCursor(0, 0); //set the cursor to the top left position
lcd.print("Degrees C: "); //print a label for the data
lcd.print(degreesC); //print the degrees Celsius
lcd.setCursor(0, 1); //set the cursor to the lower left position
lcd.print("Degrees F: "); //Print a label for the data
lcd.print(degreesF); //print the degrees Fahrenheit
delay(1000); //delay for 1 second between each reading (this makes the display less
noisy)
}
lcd.setCursor(0, 0);
lcd.print(" Push Button to ");
lcd.setCursor(0, 1);
lcd.print("Find Temperature");
}
