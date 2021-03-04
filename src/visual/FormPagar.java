package visual;

import dao.DAOFatura;
import dao.DAOSaldo;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import modelo.Fatura;
import modelo.Saldo;

public class FormPagar extends javax.swing.JDialog {

    private Long cpf;
    private double limite;
    private double saldo;
    private double fatura;
    
    public FormPagar(java.awt.Frame parent, boolean modal, Long cpf, double saldo, double fatura) {
        super(parent, modal);
        initComponents();
        
        this.cpf = cpf;
        this.saldo = saldo;
        this.fatura = fatura;
        
        lblSaldo.setText("Saldo atual: R$ " + saldo);
        lblFatura.setText("Fatura atual: R$ " + fatura);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblSaldo = new javax.swing.JLabel();
        lblFatura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Você estará pagando a sua fatura com o seu saldo disponível no aplicativo fubank!!!!");

        txtValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Valor:");

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblSaldo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSaldo.setText("Fatura Atual");

        lblFatura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFatura.setText("Fatura atual: R$ 000000,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFatura)
                            .addComponent(lblSaldo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtValor.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Você precisa inserir um valor", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double valor = Double.parseDouble(txtValor.getText());
        if (valor <= 0) {
            JOptionPane.showMessageDialog(null, "Valor precisa ser maior que zero", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (valor > saldo || valor > fatura) {
            JOptionPane.showMessageDialog(null, "O valor não pode ser maior que a fatura e nem o saldo", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Timestamp data = Timestamp.valueOf(LocalDateTime.now());
        new DAOFatura().inserir(new Fatura(valor, data, cpf));
        new DAOSaldo().inserir(new Saldo(valor, data, cpf));
        
        JOptionPane.showMessageDialog(null, "Fatura Paga", "Informação", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFatura;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
