package ch.hslu.ad.sw07.balls;

import java.util.ArrayList;

public final class DemoBalls {
    private DemoBalls() {}

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            final Thread thread = new Thread(new Ball(), "Ball number: " + i);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        Canvas.getCanvas().setVisible(false);
    }
}

/*
Reflektion
    Gemeinsame Resource: Canvas

    Beobachtung: Punkte "blinken"

    Erklärung: Canvas wird immer komplett neu gezeichnet

    Wieso Threads: Damit Balls unabhängig von einander verschoben werden können

    Wie erzeugt: Threads werden in DemoBalls mit Runnable Ball erstellt

    Wann sterben die Threads: Wenn die run() Methode fertig ist

    Wie wird die Darstellung der Bälle aktualisiert? Die Bälle werden im synchronized Context aktualisiert (Canvas clear
                                                     und dann alle neu gezeichnet.)
 */