package test;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ArrayList<String> tedang=new ArrayList<>();

        tedang.add("Nishe");
        tedang.add("Other Whores");
        tedang.add("Always Nishe");

        int i=0;
        for (String x:tedang){
            if (i==1){
                tedang.remove(x);
            }
            i++;
        }

        for (String x:tedang){
            System.out.println(x);
        }

    }
}
