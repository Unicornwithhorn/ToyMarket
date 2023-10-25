package Toy;

public class Toy {
    int uid;
    String name;
    float frequency;
    int count;

    public Toy(String name, float frequency) {
        this.uid = 0;
        this.count = 0;
        this.name = name;
        this.frequency = frequency;
    }
    public Toy(int uid, String name, float frequency) {
        this.uid = uid;
        this.count = 0;
        this.name = name;
        this.frequency = frequency;
    }

    public void setUid(int newUid){
        this.uid = newUid;
    }

    public int getUid(){
        return uid;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setCount(int count){this.count =count; }

    public void setFrequency(float frequency){
        this.frequency = frequency;
    }
    public float getFrequency(){
        return frequency;
    }
}
