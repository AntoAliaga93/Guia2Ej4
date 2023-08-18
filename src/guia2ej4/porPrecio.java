/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia2ej4;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anto
 */
public class porPrecio extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int filas, int columnas){
         return false;   
        }
    };
    /**
     * Creates new form porPrecio
     */
    public porPrecio() {
        initComponents();
        crearEncabezado();
        cargarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtMin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtMax = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaP = new javax.swing.JTable();

        jLabel1.setText("Listado por Precio");

        jLabel2.setText("Entre $:");

        jtMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtMinKeyReleased(evt);
            }
        });

        jLabel3.setText("y");

        jtMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtMaxKeyReleased(evt);
            }
        });

        jtTablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtTablaP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMinKeyReleased
        calcular();
    }//GEN-LAST:event_jtMinKeyReleased

    private void jtMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMaxKeyReleased
        calcular();
    }//GEN-LAST:event_jtMaxKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtMax;
    private javax.swing.JTextField jtMin;
    private javax.swing.JTable jtTablaP;
    // End of variables declaration//GEN-END:variables
    private void crearEncabezado(){
        modelo.addColumn("Código");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        jtTablaP.setModel(modelo);
    
    }
    private void cargarLista(){
        modelo.setRowCount(0);
        for (Producto p : Supermercado.lista) {
            modelo.addRow(new Object[]{p.getCodigo(),p.getDescripcion(),p.getPrecio(),p.getStock()});
        }
    
    }
    private void calcular(){
        double min,max;
        try{
        if(jtMin.getText().isEmpty()){
            min = 0;
        }else{
             min = Double.parseDouble(jtMin.getText());
        }
        
        if(jtMax.getText().isEmpty()){
            max = Double.MAX_VALUE;
        }else{
             max = Double.parseDouble(jtMax.getText());
        }
        modelo.setRowCount(0);//para setear las filas en 0 
        for (Producto p : Supermercado.lista) {
            if(p.getPrecio()>=min && (p.getPrecio()<=max) ){
                modelo.addRow(new Object[]{p.getCodigo(),p.getDescripcion(),p.getPrecio(),p.getStock()});
            }
        }
        }catch(NumberFormatException nf){
            JOptionPane.showMessageDialog(this,"Ingrese sólo números");
            //Esto es para que las celdas esten vacias
            jtMin.setText("");
            jtMax.setText("");
        }
    }
}