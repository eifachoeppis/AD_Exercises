package ch.hslu.ad.sw14.kmp;

public class KmpDemo {

    private KmpDemo(){

    }

    public static void main(String[] args){
        KmpAlgorithmus.kmpSearch("gugus", "ANANAS");
        KmpAlgorithmus.kmpSearch("gugus", "EISBEIN");
    }
}
