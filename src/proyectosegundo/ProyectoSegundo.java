
package proyectosegundo;
/*
Grupo #4
Integrantes:
*  Ivonne Roxana Minchala Plúas 
 * Joseph Gabriel García Camacho 
 * Marcos Adonis Merchan Mendoza 
 * Alexander Jesús Zambrano Narváez
*/
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