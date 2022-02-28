/**
*The program calculates and presents the charging time for an electric car in a table depending on different combinations of current and voltage.
* 
* pseudokod for project:
* 1. Inititate constants and variables,
* 2. calculates charging powers in kW and charging time
* 3. the calculations for charging power and charging time are rounded to two decimals
* 4. Print the table
*
* @author Johanna Petersson, ojoepe-5
*/

class Main 
{
  public static void main(String[] args) 
  {
    //sets storage power of car batteri
    float STORAGE_POWER = 35.8f; 

    //Initiate tre currents as constants
    int CURRENT_LOW = 10;
    int CURRENT_MEDIUM = 16;
    int CURRENT_HIGH = 32;

    //Initiate two voltage as constants
    int VOLTAGE_SINGEL = 230;
    int VOLTAGE_THREE = 400;

    //Initiate constant and variable for recalculation of charging power and time
    int NO_OF_DECIMALS = 2;
    double scale;
    
    //Inititae variables for charging power
    float chargeLowSingel;
    double chargeMediumSingel;
    double chargeLowThree;
    double chargeMediumThree;
    double chargeHighThree;

    //Initiate variables for carging time
    double timeLowSingel;
    double timeMediumSingel;
    double timeLowThree;
    double timeMediumThree;
    double timeHighThree;


    
    //calculates the charging power (in kW) for singel phase voltage
    chargeLowSingel = (CURRENT_LOW * VOLTAGE_SINGEL)/1000F;
    chargeMediumSingel = (CURRENT_MEDIUM * VOLTAGE_SINGEL)/1000F;
    
    //calculates the charging power (in kW) for three phase voltage
    chargeLowThree = (CURRENT_LOW * VOLTAGE_THREE * Math.sqrt(3))/1000F;
    chargeMediumThree = (CURRENT_MEDIUM * VOLTAGE_THREE * Math.sqrt(3))/1000F;
    chargeHighThree = (CURRENT_HIGH * VOLTAGE_THREE * Math.sqrt(3))/1000F;


    
    //calculates the 5 carging times
    timeLowSingel = STORAGE_POWER / chargeLowSingel;
    timeMediumSingel = STORAGE_POWER / chargeMediumSingel;
    timeLowThree = STORAGE_POWER / chargeLowThree;
    timeMediumThree = STORAGE_POWER / chargeMediumThree;
    timeHighThree = STORAGE_POWER/ chargeHighThree;


    
    //Recalulates the charging power and charging time to two decimals
    scale = Math.pow(10, NO_OF_DECIMALS); 
    
    //Recalulations of charging power
    chargeMediumSingel = Math.round(chargeMediumSingel * scale) / scale;
    chargeLowThree = Math.round(chargeLowThree * scale) / scale;
    chargeMediumThree = Math.round(chargeMediumThree * scale) / scale;
    chargeHighThree = Math.round(chargeHighThree * scale) / scale;

    
    
    //Recalulations of charging Time
    timeLowSingel = Math.round(timeLowSingel * scale) / scale;
    timeMediumSingel = Math.round(timeMediumSingel * scale) / scale;
    timeLowThree = Math.round(timeLowThree * scale) / scale;
    timeMediumThree = Math.round(timeMediumThree * scale) / scale;
    timeHighThree = Math.round(timeHighThree * scale) / scale;


    
    //Print the table
    System.out.print("Batteri " + STORAGE_POWER + "(kWh)\n");
    System.out.print("Ström(A) \t Spänning(V) \t Laddeffekt (kW) \t Laddningstid(h)\n"); //prints the labels for the columns
    System.out.print(CURRENT_LOW + "\t\t\t\t" + VOLTAGE_SINGEL + "\t\t\t\t" + chargeLowSingel + "\t\t\t\t\t" + timeLowSingel + "\n");
    System.out.print(CURRENT_MEDIUM + "\t\t\t\t" + VOLTAGE_SINGEL + "\t\t\t\t" + chargeMediumSingel + "\t\t\t\t" + timeMediumSingel + "\n");
    System.out.print(CURRENT_LOW + "\t\t\t\t" + VOLTAGE_THREE + "\t\t\t\t" + chargeLowThree + "\t\t\t\t" + timeLowThree + "\n"); 
    System.out.print(CURRENT_MEDIUM + "\t\t\t\t" + VOLTAGE_THREE + "\t\t\t\t" + chargeMediumThree + "\t\t\t\t" + timeMediumThree + "\n"); 
    System.out.print(CURRENT_HIGH + "\t\t\t\t" + VOLTAGE_THREE + "\t\t\t\t" + chargeHighThree + "\t\t\t\t" + timeHighThree + "\n");

  }
}
