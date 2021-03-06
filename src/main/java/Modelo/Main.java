package Modelo;

import Controler.Tela;

public class Main {

    /**
     * @param args the command line arguments
     */

    // Factory = FactoryElemento.java
    // Bridge = SaveLoad.java
    // Proxy = ReplaceElement package
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela tTela = new Tela();
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
            }
        });
    }
}
