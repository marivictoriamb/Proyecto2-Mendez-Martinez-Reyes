package colaimpresion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
* Descripcion: Interfaz de Manejo Documentos
* @autor: Maria Martinez
* @version: 20/11/23
*/
public class ManejoDocumentos extends javax.swing.JFrame {
    private Usuarios usuarios;
    private Documento [] documentos;
    private NodoUsuario usuario;
    private Cronometro tiempo = new Cronometro();
    
    private TablaDeDispersion tabla = new TablaDeDispersion();
    private MonticuloBinario monticulo = new MonticuloBinario();
    
    /**
     * Descripcion: Contructor de la interfaz Main
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    public ManejoDocumentos() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        usuarios = new Usuarios();
        documentos = new Documento[1];
        usuario = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo1 = new javax.swing.JLabel();
        Return = new javax.swing.JButton();
        boxSize = new javax.swing.JComboBox<>();
        TextNombre = new javax.swing.JTextField();
        boxTipo = new javax.swing.JComboBox<>();
        AgregarDocumento = new javax.swing.JButton();
        boxUsuarios = new javax.swing.JComboBox<>();
        boxDocumentos = new javax.swing.JComboBox<>();
        EliminarDocumento = new javax.swing.JButton();
        MandarCola = new javax.swing.JButton();
        EscogerUsuario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo1.setFont(new java.awt.Font("Shree Devanagari 714", 0, 36)); // NOI18N
        Titulo1.setForeground(new java.awt.Color(255, 255, 255));
        Titulo1.setText("Documentos");
        getContentPane().add(Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 210, 50));

        Return.setBackground(new java.awt.Color(204, 255, 255));
        Return.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Return.setForeground(new java.awt.Color(0, 0, 51));
        Return.setText("<-");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });
        getContentPane().add(Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 50, -1));

        getContentPane().add(boxSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 163, -1));

        TextNombre.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        TextNombre.setText("Agregar nombre del documento");
        TextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNombreActionPerformed(evt);
            }
        });
        getContentPane().add(TextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 233, -1));

        boxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoActionPerformed(evt);
            }
        });
        getContentPane().add(boxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 167, -1));

        AgregarDocumento.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        AgregarDocumento.setText("Agregar");
        AgregarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarDocumentoActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        boxUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(boxUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 163, -1));

        boxDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDocumentosActionPerformed(evt);
            }
        });
        getContentPane().add(boxDocumentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 170, -1));

        EliminarDocumento.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        EliminarDocumento.setText("Eliminar");
        EliminarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarDocumentoActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, -1));

        MandarCola.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        MandarCola.setText("Mandar a la Cola de Impresion");
        MandarCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MandarColaActionPerformed(evt);
            }
        });
        getContentPane().add(MandarCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        EscogerUsuario.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        EscogerUsuario.setText("Escoger Usuario");
        EscogerUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscogerUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(EscogerUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jButton1.setFont(new java.awt.Font("Shree Devanagari 714", 0, 10)); // NOI18N
        jButton1.setText("Ver Documentos de Usuarios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 170, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imagen6.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Descripcion: Llama y muestra la interfaz Main
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        /**
        * Descripcion: El main de la interfaz principal
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main main = new Main();
                main.setTabla(tabla);
                main.setMonticulo(monticulo);
                main.setUsuarios(usuarios);
                main.setTiempo(tiempo);
                main.setVisible(true);
            }
        });

        // Ocultar esta interfaz
        this.setVisible(false);
    }//GEN-LAST:event_ReturnActionPerformed

    private void boxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxTipoActionPerformed

    /**
     * Descripcion: Agrega un documento a un usuario escogido en un combobox
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    private void AgregarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarDocumentoActionPerformed
       
        if (usuario != null){
            String nombre = TextNombre.getText();
            TextNombre.setText("Agregar nombre del documento");

            if (boxTipo.getSelectedItem() ==  null){
                JOptionPane.showMessageDialog(null, "\nError!\nSeleccione el tipo de documento");
            } else if (boxSize.getSelectedItem() == null){
                JOptionPane.showMessageDialog(null, "\nError!\nSeleccione el tamaño del documento");
            } else {
                String tipo = boxTipo.getSelectedItem().toString().replaceAll("\\p{C}", "");
                String size = boxSize.getSelectedItem().toString().replaceAll("\\p{C}", "");

                if (nombre.contains(" ") || nombre.isEmpty()==true || nombre.length()<2 || nombre.contains("\\p{C}")){
                    JOptionPane.showMessageDialog(null, "\nError!\nIndique un nombre con el formato correcto!");
                } else if (nombre.length() > 15){
                    JOptionPane.showMessageDialog(null, "\nError!\nEl nombre del documento debe tener menos de 15 caracteres");
                } else if (usuarios.BuscarDocumento(usuario.getNombreUsuario(), nombre) != null){
                    JOptionPane.showMessageDialog(null, "\nError!\nDocumento con Nombre Existente!");
                } else {
                    int s = Integer.parseInt(size);
                    usuarios.AgregarDoc(usuario.getNombreUsuario(), nombre, tipo, s);
                    JOptionPane.showMessageDialog(null, "\nDocumento Agregado Exitosamente!");
                }
            }
            
            documentos = usuario.getDocumentos();
            LlenarboxSizeActionPerformed(evt);
            LlenarboxTiposActionPerformed(evt);
            LlenarboxDocumentosActionPerformed(evt);
            
        } else {
            JOptionPane.showMessageDialog(null, "Error! \n Seleccione un usuario");
        }
    }//GEN-LAST:event_AgregarDocumentoActionPerformed

    private void TextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNombreActionPerformed

    private void boxDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDocumentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxDocumentosActionPerformed

    /**
     * Descripcion: Elimina un documento escogido en un combobox
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    private void EliminarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarDocumentoActionPerformed
        if (usuario != null){ 
            if (boxDocumentos.getSelectedItem()!=  null){
                String doc= boxDocumentos.getSelectedItem().toString().replaceAll("\\p{C}", "");
                Documento documento = usuarios.BuscarDocumento(usuario.getNombreUsuario(), doc);
                
                if (documento.isEncolado()){
                    int input = JOptionPane.showConfirmDialog(null, "\nDicho documento se encuentra en la cola de impresion, desea eliminarlo de la cola?");
                    
                    if (input == 0){
                        int pos = tabla.SearchDocumento(usuario.getNombreUsuario(), documento.getNombreDocumento(), monticulo.Peek());
                        monticulo.EliminarDocumento(pos);
                        usuarios.ChequearDoc(usuario.getNombreUsuario(), doc, false);
                        usuarios.Dead(usuario.getNombreUsuario());
                    }
                    
                } else{
                    usuarios.EliminarDoc(usuario.getNombreUsuario(), doc);
                }
   
                documentos = usuario.getDocumentos();
                LlenarboxDocumentosActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(null, "Error! \n Cargue los documentos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error! \n Seleccione un usuario");
        }
    }//GEN-LAST:event_EliminarDocumentoActionPerformed

    /**
     * Descripcion: Manda a la cola de impresion el documento escogido en un combobox
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    private void MandarColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MandarColaActionPerformed
        if (usuario != null){ 
            if (boxDocumentos.getSelectedItem()!=  null){
                String doc= boxDocumentos.getSelectedItem().toString().replaceAll("\\p{C}", "");
                
                int prioridad = JOptionPane.showConfirmDialog(null, "Dicho documento tiene prioridad? ");
                float tiempo = this.tiempo.TiempoActual();

                if (prioridad == 0){
                    
                    tiempo = tiempo - tiempo*usuario.CalcularPrioridad();
                    
                } 
                
                int t = (int) tiempo;
                Documento documento = usuario.MandarDocumento(doc);
                    
                if (documento == null){
                    JOptionPane.showMessageDialog(null, "\nNo se pudo agregar el documento");
                } else {
                    monticulo.Insertar(documento.getNombreDocumento(), documento.getTipoDocumento(), documento.getTamaño(), t, documento);
                    tabla.Agregar(usuario.getNombreUsuario(), usuario.getTipo(), documento);
                    usuarios.ChequearDoc(usuario.getNombreUsuario(), documento.getNombreDocumento(), true);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Error! \n Cargue los documentos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error! \n Seleccione un usuario");
        }
    }//GEN-LAST:event_MandarColaActionPerformed

    /**
     * Descripcion: Escoge un un usuario del combobox y busca el objeto NodoUsuario
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    private void EscogerUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscogerUsuarioActionPerformed
        if (boxUsuarios.getSelectedItem()!=  null){
            String user= boxUsuarios.getSelectedItem().toString().replaceAll("\\p{C}", "");
            this.usuario = usuarios.Buscar(user);
            documentos = this.usuario.getDocumentos();
          
            LlenarboxDocumentosActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(null, "Error! \n Cargue los usuarios");
        }
    }//GEN-LAST:event_EscogerUsuarioActionPerformed

    /**
     * Descripcion: Llama y muestra la interfaz de VistaDocumentos
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (usuario != null){
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    VistaDocumentos vista = new VistaDocumentos();
                    vista.setUsuarios(usuarios);
                    vista.setUsuario(usuario);
                    vista.setTabla(tabla);
                    vista.setMonticulo(monticulo);
                    vista.setTiempo(tiempo);
                    vista.LlenadoTabla(evt);
                    vista.setVisible(true);
                }
            });

        // Ocultar esta interfaz
            this.setVisible(false);
        } else {
           JOptionPane.showMessageDialog(null, "\nERROR!\nEscoga un usuario");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boxUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxUsuariosActionPerformed
    
    /**
     * Descripcion: Llena un combobox con los usuarios registrados
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    public void LlenarboxActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (usuarios.getNombres().length != 0){
            boxUsuarios.removeAllItems();
            NodoUsuario [] users = usuarios.getNombres();

                for (int i = 0; i < users.length; i++) {
                    boxUsuarios.addItem(users[i].getNombreUsuario().replaceAll("\\p{C}", ""));
                }
        }
    }   
    
    /**
     * Descripcion: Llena un combobox con las opciones de tipo de documento
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    public void LlenarboxTiposActionPerformed(java.awt.event.ActionEvent evt) {                                          
        boxTipo.removeAllItems();
        boxTipo.addItem("PDF");
        boxTipo.addItem("CSV");
        boxTipo.addItem("PNG");
        boxTipo.addItem("JPG");
        boxTipo.addItem("PPT");
        boxTipo.addItem("WORD");
    }  
    
    /**
     * Descripcion: Llena un combobox con las opciones de tamano de documentos
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    public void LlenarboxSizeActionPerformed(java.awt.event.ActionEvent evt) {                                          
        boxSize.removeAllItems();
        boxSize.addItem("1");
        boxSize.addItem("2");
        boxSize.addItem("3");
        boxSize.addItem("4");
        boxSize.addItem("5");
    }  
    
    /**
     * Descripcion: Llena un combobox con los documentos de un usuario escogido
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    public void LlenarboxDocumentosActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (documentos.length != 0){
            boxDocumentos.removeAllItems();
                for (int i = 0; i < documentos.length; i++) {
                    if (usuario.isDead()){
                        if (documentos[i].isEncolado()){
                            boxDocumentos.addItem(documentos[i].getNombreDocumento().replaceAll("\\p{C}", ""));
                        }
                    } else{
                        boxDocumentos.addItem(documentos[i].getNombreDocumento().replaceAll("\\p{C}", ""));
                    }
                }
        } else {
            boxDocumentos.removeAllItems();
        }
    }  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManejoDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManejoDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManejoDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManejoDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManejoDocumentos().setVisible(true);
            }
        });
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
    public TablaDeDispersion getTabla() {
        return tabla;
    }

    public void setTabla(TablaDeDispersion tabla) {
        this.tabla = tabla;
    }
    
    public MonticuloBinario getMonticulo() {
        return monticulo;
    }

    public void setMonticulo(MonticuloBinario monticulo) {
        this.monticulo = monticulo;
    }

    public Cronometro getTiempo() {
        return tiempo;
    }

    public void setTiempo(Cronometro tiempo) {
        this.tiempo = tiempo;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarDocumento;
    private javax.swing.JButton EliminarDocumento;
    private javax.swing.JButton EscogerUsuario;
    private javax.swing.JButton MandarCola;
    private javax.swing.JButton Return;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JLabel Titulo1;
    private javax.swing.JComboBox<String> boxDocumentos;
    private javax.swing.JComboBox<String> boxSize;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JComboBox<String> boxUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
