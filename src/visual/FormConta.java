package visual;

import dao.DAOCliente;
import dao.DAOSaldo;
import java.sql.Timestamp;
import java.util.List;
import modelo.Saldo;
import modelo.Tipo;
import visual.saldo.FormCreditor;
import visual.saldo.FormDepositar;
import visual.saldo.FormReceber;
import visual.saldo.FormTransferir;

public class FormConta extends javax.swing.JDialog {

    private DAOCliente daoCliente;
    private DAOSaldo dao;
    private Long cpf;
    private double saldo;
   
    public FormConta(java.awt.Frame parent, boolean modal, Long cpf) {
        super(parent, modal);
        initComponents();
        
        daoCliente = new DAOCliente();
        dao = new DAOSaldo();
        this.cpf = cpf;
        
        atualizarTela();
    }

    private void atualizarTela() {
        List<Saldo> saldos = dao.getTudo(cpf);
        pnlSaldos.removeAll();
        for (Saldo saldo : saldos) {
            String descricao = saldo.getDescricao();
            Timestamp data = saldo.getData();
            double valor = saldo.getValor();
            
            Tipo tipo = saldo.getTipo();
            UCSaldo uc = new UCSaldo(tipo, descricao, data, valor);
            
            pnlSaldos.add(uc);
        }
        
        saldo = daoCliente.getSaldo(cpf);
        lblSaldo.setText("R$ " + saldo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlSaldos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ucDepositar = new visual.UCMenuButton();
        ucReceber = new visual.UCMenuButton();
        ucTransferir = new visual.UCMenuButton();
        ucCredito = new visual.UCMenuButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(344, 597));
        setMinimumSize(new java.awt.Dimension(344, 597));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlSaldos.setLayout(new javax.swing.BoxLayout(pnlSaldos, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(pnlSaldos);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Saldo disponível");

        lblSaldo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSaldo.setText("R$ 7,85");

        ucDepositar.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_card_2.png"))); // NOI18N
        ucDepositar.setTitle("Depositar");
        ucDepositar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucDepositarMouseClicked(evt);
            }
        });
        jPanel1.add(ucDepositar);

        ucReceber.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_receive.png"))); // NOI18N
        ucReceber.setTitle("Receber");
        ucReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucReceberMouseClicked(evt);
            }
        });
        jPanel1.add(ucReceber);

        ucTransferir.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_pay_1.png"))); // NOI18N
        ucTransferir.setTitle("Transferir");
        ucTransferir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucTransferirMouseClicked(evt);
            }
        });
        jPanel1.add(ucTransferir);

        ucCredito.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_phone.png"))); // NOI18N
        ucCredito.setTitle("Recarga");
        ucCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucCreditoMouseClicked(evt);
            }
        });
        jPanel1.add(ucCredito);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblSaldo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ucDepositarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucDepositarMouseClicked
        FormDepositar formDialog = new FormDepositar(null, true, cpf);
        formDialog.setLocationRelativeTo(null);
        formDialog.setTitle("Depositar");
        formDialog.setResizable(false);
        formDialog.setVisible(true);
        
        atualizarTela();
    }//GEN-LAST:event_ucDepositarMouseClicked

    private void ucReceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucReceberMouseClicked
        FormReceber formDialog = new FormReceber(null, true, cpf);
        formDialog.setLocationRelativeTo(null);
        formDialog.setTitle("Receber");
        formDialog.setResizable(false);
        formDialog.setVisible(true);
        
        atualizarTela();
    }//GEN-LAST:event_ucReceberMouseClicked

    private void ucTransferirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucTransferirMouseClicked
        FormTransferir formDialog = new FormTransferir(null, true, cpf, saldo);
        formDialog.setLocationRelativeTo(null);
        formDialog.setTitle("Transferir");
        formDialog.setResizable(false);
        formDialog.setVisible(true);
        
        atualizarTela();
    }//GEN-LAST:event_ucTransferirMouseClicked

    private void ucCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucCreditoMouseClicked
        FormCreditor formDialog = new FormCreditor(null, true, cpf, saldo);
        formDialog.setLocationRelativeTo(null);
        formDialog.setTitle("Credito");
        formDialog.setResizable(false);
        formDialog.setVisible(true);
        
        atualizarTela();
    }//GEN-LAST:event_ucCreditoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JPanel pnlSaldos;
    private visual.UCMenuButton ucCredito;
    private visual.UCMenuButton ucDepositar;
    private visual.UCMenuButton ucReceber;
    private visual.UCMenuButton ucTransferir;
    // End of variables declaration//GEN-END:variables
}
