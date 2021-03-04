package visual.fatura;

import dao.DAOFatura;
import dao.DAOSaldo;
import dao.DAOTipo;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Fatura;
import modelo.Tipo;

public class FormComprar extends javax.swing.JDialog {

    private DAOFatura daoFatura;
    private DAOTipo daoTipo;
    private Long cpf;
    private double limite;
    
    public FormComprar(java.awt.Frame parent, boolean modal, Long cpf, double limite) {
        super(parent, modal);
        initComponents();
        
        this.cpf = cpf;
        this.limite = limite;
        
        daoFatura = new DAOFatura();
        daoTipo = new DAOTipo();
        
        atualizar();
    }

    private void atualizar() {
        lstTipo.clear();
        lstTipo.addAll(daoTipo.getTudo());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lstTipo = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Tipo>())  ;
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtValor = new javax.swing.JFormattedTextField();
        cbTipo = new javax.swing.JComboBox<>();
        btnComprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Tipo da Compra:");

        jLabel2.setText("Descricao:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Valor:");

        txtDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cbTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstTipo, cbTipo);
        bindingGroup.addBinding(jComboBoxBinding);

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDescricao)
                        .addComponent(txtValor)
                        .addComponent(cbTipo, 0, 218, Short.MAX_VALUE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnComprar)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        if (txtDescricao.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Insira uma descrição", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtValor.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Insira um valor", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double valor = Double.parseDouble(txtValor.getText());
        if (valor <= 0) {
            JOptionPane.showMessageDialog(null, "O valor tem que ser maior que zero", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int index = cbTipo.getSelectedIndex();
        if (valor > limite && index != 0) {
            JOptionPane.showMessageDialog(null, "Você não possui limite suficiente para a compra", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Tipo tipo = lstTipo.get(index);
        Timestamp data = Timestamp.valueOf(LocalDateTime.now());
        daoFatura.inserir(new Fatura(txtDescricao.getText(), valor, data, cpf, tipo));
        
        JOptionPane.showMessageDialog(null, "Compra realizada com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }//GEN-LAST:event_btnComprarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.util.List<Tipo> lstTipo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtValor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
