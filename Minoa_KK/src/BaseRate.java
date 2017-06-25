public class BaseRate {
    
    public float amount = 100;
    
    public void create() {
        System.out.println("Object created");
    }
    
    public void destroy(){
        System.out.println("Object Destroyed");
    }
    
    public float Getbaserate(){
        BaseRate br = new BaseRate();
        return br.amount ;
    }
}