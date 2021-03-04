package visual;

import dao.DAOCliente;
import dao.DAOFatura;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Fatura;
import modelo.Tipo;
import visual.fatura.FormComprar;
import visual.fatura.FormResumo;

public class FormFatura extends javax.swing.JDialog {

    private DAOCliente daoCliente;
    private DAOFatura dao;
    private Long cpf;
    private double limite;
    private double fatura;
    
    public FormFatura(java.awt.Frame parent, boolean modal, Long cpf) {
        super(parent, modal);
        initComponents();
        
        daoCliente = new DAOCliente();
        dao = new DAOFatura();
        this.cpf = cpf;
        
        atualizarTela();
    }

    private void atualizarTela() {
        List<Fatura> faturas = dao.getTudo(cpf);
        pnlFaturas.removeAll();
        for (Fatura fatura : faturas) {
            String descricao = fatura.getDescricao();
            Timestamp data = fatura.getData();
            double valor = fatura.getValor();
            
            Tipo tipo = fatura.getTipo();
            UCSaldo uc = new UCSaldo(tipo, descricao, data, valor);
            
            pnlFaturas.add(uc);
        }
        
        fatura = daoCliente.getFatura(cpf);
        lblSaldo.setText("R$ " + fatura);
        
        limite = daoCliente.getLimite(cpf);
        limite -= fatura;
        lblLimite.setText("Limite disponível R$ " + limite);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlFaturas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblLimite = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ucPagar = new visual.UCMenuButton();
        ucResumo = new visual.UCMenuButton();
        ucLimite = new visual.UCMenuButton();
        ucCompra = new visual.UCMenuButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(344, 597));
        setMinimumSize(new java.awt.Dimension(344, 597));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlFaturas.setLayout(new javax.swing.BoxLayout(pnlFaturas, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(pnlFaturas);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Fatura atual");

        lblSaldo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSaldo.setText("R$ 7,85");

        lblLimite.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblLimite.setText("Limite disponível R$ 400,00");

        ucPagar.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_pay_2.png"))); // NOI18N
        ucPagar.setTitle("Pagar fatura");
        ucPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucPagarMouseClicked(evt);
            }
        });
        jPanel1.add(ucPagar);

        ucResumo.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_document.png"))); // NOI18N
        ucResumo.setTitle("Resumo");
        ucResumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucResumoMouseClicked(evt);
            }
        });
        jPanel1.add(ucResumo);

        ucLimite.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_limit.png"))); // NOI18N
        ucLimite.setTitle("Pedir limite");
        ucLimite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucLimiteMouseClicked(evt);
            }
        });
        jPanel1.add(ucLimite);

        ucCompra.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_buy.png"))); // NOI18N
        ucCompra.setTitle("Comprar");
        ucCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucCompraMouseClicked(evt);
            }
        });
        jPanel1.add(ucCompra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblSaldo)
                            .addComponent(lblLimite))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLimite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ucResumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucResumoMouseClicked
        FormResumo form = new FormResumo(null, true, cpf);
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setTitle("Resumo das Faturas");
        form.setVisible(true);
    }//GEN-LAST:event_ucResumoMouseClicked

    private void ucLimiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucLimiteMouseClicked
        String value = "";
        value = JOptionPane.showInputDialog(null, "Informe o novo limite", "Limite", JOptionPane.QUESTION_MESSAGE);
        if (value == null)
            return;
        
        double valor = -1;
        double limiteTotal = daoCliente.getLimite(cpf);
        while (valor <= 0 || limiteTotal >= valor) {
            try {
                valor = Double.parseDouble(value);
                
                if (valor <= 0) {
                    JOptionPane.showMessageDialog(null, "Valor não pode ser menor ou igual a zero", "ERRO", JOptionPane.ERROR_MESSAGE);
                    value = JOptionPane.showInputDialog(null, "Informe o novo limite", "Limite", JOptionPane.QUESTION_MESSAGE);
                
                    if (value == null)
                        return;
                } else if (limiteTotal >= valor) {
                    JOptionPane.showMessageDialog(null, "Valor tem que ser maior que o limite atual", "ERRO", JOptionPane.ERROR_MESSAGE);
                    value = JOptionPane.showInputDialog(null, "Informe o novo limite", "Limite", JOptionPane.QUESTION_MESSAGE);
                
                    if (value == null)
                        return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor não corresponde a um numero", "ERRO", JOptionPane.ERROR_MESSAGE);
                value = JOptionPane.showInputDialog(null, "Informe o novo limite", "Limite", JOptionPane.QUESTION_MESSAGE);
            }
        }
        
        daoCliente.atualizarLimite(cpf, valor);
        JOptionPane.showMessageDialog(null, "Limite aceito e ja disponivel", "Informacao", JOptionPane.INFORMATION_MESSAGE);
        
        atualizarTela();
    }//GEN-LAST:event_ucLimiteMouseClicked

    private void ucCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucCompraMouseClicked
        FormComprar formComprar = new FormComprar(null, true, cpf, limite);
        formComprar.setTitle("Comprar");
        formComprar.setLocationRelativeTo(null);
        formComprar.setResizable(false);
        formComprar.setVisible(true);
        
        atualizarTela();
    }//GEN-LAST:event_ucCompraMouseClicked

    private void ucPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucPagarMouseClicked
        JOptionPane.showMessageDialog(null, "Boleta enviada para o seu e-mail para efetuar o pagamento", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ucPagarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JPanel pnlFaturas;
    private visual.UCMenuButton ucCompra;
    private visual.UCMenuButton ucLimite;
    private visual.UCMenuButton ucPagar;
    private visual.UCMenuButton ucResumo;
    // End of variables declaration//GEN-END:variables
}
