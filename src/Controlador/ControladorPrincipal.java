
package Controlador;

import Vista.DiseñoPrincipal;
import Vista.DiseñoProducto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ControladorPrincipal implements ActionListener {
    private DiseñoPrincipal frmPri;
    private DiseñoProducto frmpro;

    public ControladorPrincipal(DiseñoPrincipal frmPri, DiseñoProducto frmPro) {
        this.frmPri = frmPri;
        this.frmpro = frmPro;
        this.frmPri.menu_productos.addActionListener(this);
        this.frmPri.menu_salir.addActionListener(this);        
    }
public void inicar(){
    frmpro.setTitle("Producto");
    frmPri.setTitle("Principal");
    frmPri.setLocationRelativeTo(null);
    frmpro.setLocationRelativeTo(null);
    
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frmPri.menu_productos){
            frmpro.setVisible(true);
            //frmPri.dispose();
        }
        
        if(e.getSource()==frmPri.menu_salir){
        System.exit(0);
        }
    }
}
