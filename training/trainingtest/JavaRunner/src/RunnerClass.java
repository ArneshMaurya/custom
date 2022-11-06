public class RunnerClass {
    static int a=1;
    void increceA(){
        RunnerClass.a++;
    }
    int getA(){
        return a;
    }
    public static void main(String[] args){
        RunnerClass ob = new RunnerClass();
        ob.increceA();
        ob.increceA();
        System.out.println(ob.getA());
      System.out.println("Hello");
    }
}
