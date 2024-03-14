
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.DiseñoProducto;
import Vista.DiseñoPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorProducto implements ActionListener {
   private Producto pro;
   private DiseñoProducto frmpro;
   private ConsultasProducto proC;
   private DiseñoPrincipal frmPri;

    public ControladorProducto(Producto pro, DiseñoProducto frmPro, ConsultasProducto proC, DiseñoPrincipal frmPri) {
        this.pro = pro;
        this.frmpro = frmPro;
        this.proC = proC;
        this.frmpro.btn_agregar.addActionListener((ActionListener) this);
        this.frmpro.btn_buscar.addActionListener((ActionListener) this);
        this.frmpro.btn_eliminar.addActionListener((ActionListener) this);
        this.frmpro.btn_limpiar.addActionListener((ActionListener) this);
        this.frmpro.btn_modificar.addActionListener((ActionListener) this);
        this.frmpro.btn_panelPrincipal.addActionListener((ActionListener) this);
        this.frmPri = frmPri;
    }   
    
    @Override

       public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmpro.btn_panelPrincipal) {
            frmPri.setVisible(true); // Mostrar la vista principal
            frmpro.setVisible(false); // Ocultar la vista de productos
        }  
       
        /////// boton agregar//////
        if(e.getSource()==frmpro.btn_agregar){
            pro.setCodigo(frmpro.txt_codigo.getText());
            pro.setNombre(frmpro.txt_nombre.getText());
            pro.setPrecio(Integer.parseInt(frmpro.txt_precio.getText()));
            if(proC.registrar(pro)){
                JOptionPane.showMessageDialog(null,"Producto agregado correctamente");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al agregar el producto");
                limpiar();
            }
            
        }        
        /////// fin agregar //////
                
        /////// boton modificar //////
        if(e.getSource()==frmpro.btn_modificar){
            pro.setId(Integer.parseInt(frmpro.txt_id.getText()));
            pro.setCodigo(frmpro.txt_codigo.getText());
            pro.setNombre(frmpro.txt_nombre.getText());
            pro.setPrecio(Integer.parseInt(frmpro.txt_precio.getText()));
            if(proC.modificar(pro)){
                JOptionPane.showMessageDialog(null,"Producto modificado correctamente");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al modificar el producto");
                limpiar();
            }
        }
         /////// boton eliminar //////
        if(e.getSource()==frmpro.btn_eliminar){
            pro.setId(Integer.parseInt(frmpro.txt_id.getText()));
            if(proC.eliminar(pro)){
                JOptionPane.showMessageDialog(null,"Producto eliminado correctamente");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar el producto");
                limpiar();
            }
        }
        /////// boton buscar //////
        if(e.getSource()==frmpro.btn_buscar){
            pro.setId(Integer.parseInt(frmpro.txt_id.getText()));
            if(proC.buscar(pro)){                
              frmpro.txt_id.setText(String.valueOf(pro.getId()));
              frmpro.txt_codigo.setText(pro.getCodigo());
              frmpro.txt_nombre.setText(pro.getNombre());
              frmpro.txt_precio.setText(String.valueOf(pro.getPrecio()));              
            }else{
                JOptionPane.showMessageDialog(null,"Error al buscar el producto, intente de nuevo");
                limpiar();
            }
        }// fin buscar/////
        
        ///Limpiar
        if(e.getSource()==frmpro.btn_limpiar){
        limpiar();
        } 
    }// fin limpiar
         
    
    private void limpiar() {
       frmpro.txt_codigo.setText(null);
       frmpro.txt_id.setText(null);
       frmpro.txt_nombre.setText(null);
       frmpro.txt_precio.setText(null);
       
    }
    
 
    
}
