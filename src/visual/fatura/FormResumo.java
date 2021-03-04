package visual.fatura;

import dao.DAOFatura;
import java.sql.Timestamp;
import modelo.Fatura;
import java.util.List;

public class FormResumo extends javax.swing.JDialog {

    private DAOFatura daoFatura;
    private Long cpf;
    
    public FormResumo(java.awt.Frame parent, boolean modal, Long cpf) {
        super(parent, modal);
        initComponents();
        
        daoFatura = new DAOFatura();
        this.cpf = cpf;
        
        atualizar();
    }

    private void atualizar() {
        List<Fatura> faturas = daoFatura.getResumo(cpf);
        for (Fatura fatura : faturas) {
            double valor = fatura.getValor();
            Timestamp data = fatura.getData();
            
            UCResumo uc = new UCResumo(valor, data);
            pnl.add(uc);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnl = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(344, 597));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(344, 597));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(344, 597));

        pnl.setMaximumSize(new java.awt.Dimension(325, 595));
        pnl.setMinimumSize(new java.awt.Dimension(325, 595));
        pnl.setLayout(new javax.swing.BoxLayout(pnl, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(pnl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl;
    // End of variables declaration//GEN-END:variables
}
