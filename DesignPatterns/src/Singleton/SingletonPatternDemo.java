package Singleton;

//Created by DaMasterHam on 06-10-2016.
//
public class SingletonPatternDemo {
    public static void main(String[] args) {

        //illegal construct
        //Compile Time Error: The constructor Singleton.SingleObject() is not visible
        //Singleton.SingleObject object = new Singleton.SingleObject();

        //Get the only object available
        SingleObject object = SingleObject.getInstance();

        //show the message
        object.showMessage();
    }
}