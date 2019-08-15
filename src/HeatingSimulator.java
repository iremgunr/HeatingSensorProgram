public class HeatingSimulator {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor("Sensor", 0);
        AirConditioner mainAC = new AirConditioner("Main AC");
        AirConditioner bathAC = new AirConditioner("Bath AC");
        mainAC.upperLimit=20;
        bathAC.upperLimit=30;
        sensor.addObserver(mainAC);
        sensor.addObserver(bathAC);
        int energyUsed = simulate(sensor, Data.ISTANBUL_SUMMER_HOURLY_TEMPS);
        System.out.printf("Istanbul domestic AC daily summer energy usage: %d units\n", energyUsed);
    }
    private static int simulate(TemperatureSensor sensor, int[] hourlyTemperatures) {
        System.out.println("\nStart simulation ..");
        int usage = 0;
        for (int h = 0; h < hourlyTemperatures.length; ++h ){
            System.out.printf("At %d O'Clock: ", h);
            sensor.setTemperature( hourlyTemperatures[h] );
            for (AirConditioner ac : sensor.observers){
                if( ac != null){
                    ++usage;
                }
            }
        }
        return  usage;
    }
}
