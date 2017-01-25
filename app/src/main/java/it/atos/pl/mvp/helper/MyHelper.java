package it.atos.pl.mvp.helper;

/**
 * Created by Karol Maciejewski_ on 02.09.2016.
 */
public class MyHelper {

    private static MyHelper INSTANCE;

    public MyHelper(){

    }

    public static int silnia(int n){

        if(n==1) {
            return 1;
        }else{
            return n * silnia(n-1);
        }

    }





    public static void setItem(){

    }
}
