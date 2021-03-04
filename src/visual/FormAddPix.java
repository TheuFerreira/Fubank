package visual;

import dao.DAOPixTipo;
import dao.DAOPix;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;
import modelo.Pix;
import modelo.PixTipo;

public class FormAddPix extends javax.swing.JDialog {

    private DAOPixTipo daoTipo;
    private DAOPix daoPix;
    private Long cpf;
    
    public FormAddPix(java.awt.Frame parent, boolean modal, Long cpf) {
        super(parent, modal);
        initComponents();
        
        this.cpf = cpf;
        
        daoTipo = new DAOPixTipo();
        daoPix = new DAOPix();
    
        lstPixTipo.addAll(daoTipo.getTudo());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lstPixTipo = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<PixTipo>())  ;
        cbPixTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbPixTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstPixTipo, cbPixTipo);
        bindingGroup.addBinding(jComboBoxBinding);

        cbPixTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPixTipoItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Tipo do Pix:");

        btnAdicionar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Chave:");

        txtChave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnAdicionar)
                        .addGap(0, 122, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChave))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPixTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPixTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnAdicionar)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        int index = cbPixTipo.getSelectedIndex();
        PixTipo pixTipo = lstPixTipo.get(index);
        
        String chave = txtChave.getText();
        chave = chave.replace('(', ' ');
        chave = chave.replace(')', ' ');
        chave = chave.replace('-', ' ');
        if (pixTipo.getIdPixTipo() == 1)
            chave = chave.replace('.', ' ');
        chave = chave.replaceAll("\\s+","");

        if (chave.length() == 0) {
            JOptionPane.showMessageDialog(null, "Insira uma chave!!!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (daoPix.existe(chave)) {
            JOptionPane.showMessageDialog(null, "Chave já existente!!!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Pix pix = new Pix(chave, cpf, pixTipo);
        daoPix.inserir(pix);
        dispose();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void cbPixTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPixTipoItemStateChanged
        txtChave.setText("");
        txtChave.setEnabled(true);
        int index = cbPixTipo.getSelectedIndex();
        if (index == 1) {
            txtChave.setText(cpf.toString());
            txtChave.setEnabled(false);
        } else if (index == 2) {
            UUID uuid = UUID.randomUUID();
            txtChave.setText(uuid.toString());
            txtChave.setEnabled(false);
        }
    }//GEN-LAST:event_cbPixTipoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JComboBox<String> cbPixTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.util.List<PixTipo> lstPixTipo;
    private javax.swing.JTextField txtChave;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
