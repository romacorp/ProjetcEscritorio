
package projetcescritorio;

import Controlador.ControladorPrincipal;
import Controlador.ControladorProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.DiseñoPrincipal;
import Vista.DiseñoProducto;
import Modelo.conexion;


public class Mainc {
   
   public static void main(String[] args) {
        Producto pro =new Producto();
        ConsultasProducto proC = new ConsultasProducto();
        DiseñoPrincipal frmPri = new DiseñoPrincipal();
        DiseñoProducto frmPro = new DiseñoProducto();
        
        ControladorPrincipal ctrlPri = new   ControladorPrincipal(frmPri,frmPro);
        ControladorProducto ctrlPro = new ControladorProducto(pro, frmPro, proC, frmPri);
        frmPri.setVisible(true);     
              
        } 
    
}
