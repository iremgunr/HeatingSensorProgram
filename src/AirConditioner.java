public class AirConditioner {
    public String name;
    public Boolean summerMode;
    public Boolean active;
    public Integer upperLimit;
    public Integer lowerLimit;
    public AirConditioner(String id ) {
        this.name = id;
        summerMode=true;
        active=false;
        upperLimit=Integer.MAX_VALUE;
        lowerLimit=Integer.MIN_VALUE;

    }
    public void temperatureChanged(int temperature) {
        if (summerMode) {         // cools above limit
            if (temperature>upperLimit){
                if(active)
                    active = true;
                System.out.println("["+this.name+"] ACTIVATE COOLER (exceeded limit "+ upperLimit);
            }
            else{
                if(!active)
                    active = false;
                System.out.println("["+this.name+"] DEACTIVE COOLER (dropped limit "+ lowerLimit);
            }
        } else if (!summerMode) {
            if (temperature>upperLimit){
                if(active)
                    active = false;
                System.out.println("["+this.name+"] DEACTIVE HEATER (exceeded limit "+ upperLimit);
            }
            else{
                if(!active)
                    active = true;
                System.out.println("["+this.name+"] ACTIVE HEATER (dropped limit "+ lowerLimit);
            }
        }

    }
}
