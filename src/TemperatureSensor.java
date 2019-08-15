public class TemperatureSensor {
    static final String DEGREE = "\u00b0";
    String name;
    int temperature;
    int numObservers;
    AirConditioner[] observers;
    public TemperatureSensor(String s, int temp) {
        this.name = s;
        this.temperature = temp;
        numObservers = 0;
        observers = new AirConditioner[10];

        System.out.printf("[%s] new obj, temp=%d%s\n", name, temperature, DEGREE);
    }


    public void setTemperature(int newVal) {
        if(newVal==temperature){
            System.out.println("["+this.name+"] temp "+temperature + " " + DEGREE);
        }
        else if(newVal!=temperature){
            if (newVal>temperature){
                System.out.println("["+this.name+"] temp "+temperature + " " + DEGREE + ", up...");
                informObservers();
            }
            else {
                System.out.println("["+this.name+"] temp "+temperature + " " + DEGREE + ", down...");
                informObservers();
            }
        }
    }


    public void addObserver(AirConditioner ac) {
        System.out.printf("[%s] adding observer %s\n", name, ac.name);
        if (numObservers!=10){
            observers[numObservers] = ac;
            System.out.println("["+name+"] adding observer" + ac.name);
            numObservers++;
        }
        else
        {
            System.out.println("["+name+"] can't adding observer.Array is full ..");
        }
    }

    private void informObservers() {

        System.out.printf(".. informing %d observers\n", numObservers);

        if(observers[numObservers]!=null){
            observers[numObservers].temperatureChanged(temperature);
        }
        else
            System.out.println("Object not created.");
    }

}


