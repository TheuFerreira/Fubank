package visual.saldo;

import dao.DAOSaldo;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import modelo.Saldo;
import modelo.Tipo;

public class FormCreditor extends javax.swing.JDialog {

    private Long cpf;
    private double saldo;
    
    public FormCreditor(java.awt.Frame parent, boolean modal, Long cpf, double saldo) {
        super(parent, modal);
        initComponents();
        
        this.cpf = cpf;
        this.saldo = saldo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.text.MaskFormatter maskData = null;
        try {
            maskData = new javax.swing.text.MaskFormatter("###.###.###-##");
            maskData.setPlaceholderCharacter('_');
        } catch (Exception e){}
        txtTelefone = new javax.swing.JFormattedTextField(maskData);
        jLabel1 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Telefone:");

        btnAdicionar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAdicionar.setText("Adicionar Crédito");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Valor:");

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionar)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txtValor))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnAdicionar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        
        String text = txtTelefone.getText();
        
        text = text.replace('(', ' ');
        text = text.replace(')', ' ');
        text = text.replace('-', ' ');
        text = text.replaceAll("\\s+","");
        
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
        
        if (text.length() < 11) {
            JOptionPane.showMessageDialog(null, "Insira um número de telefone!!!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtValor.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Insirar um valor!!!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double valor = Double.parseDouble(txtValor.getText());
        
        if (saldo < valor) {
            JOptionPane.showMessageDialog(null, "Você não possui dinheiro suficiente!!!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Saldo s = new Saldo(txtTelefone.getText(), valor, date, cpf, new Tipo(4));
        new DAOSaldo().inserir(s);
        
        JOptionPane.showMessageDialog(null, "Recarga Efetuada!!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
