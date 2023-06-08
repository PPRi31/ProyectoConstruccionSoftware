
package proyectosegundo;

import Visual.frmIngreso;


public class ProyectoSegundo {

    public static void main(String[] args) {
      
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmIngreso().setVisible(true);
             
            }
        });
    }
}