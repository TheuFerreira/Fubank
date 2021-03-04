package visual.fatura;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UCResumo extends javax.swing.JPanel {

    public UCResumo(double valor, Timestamp data) {
        initComponents();
        
        lblValor.setText("R$ " + valor);
        lblMonth.setText(new SimpleDateFormat("MMM yyyy").format(data));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblValor = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(300, 50));
        setMinimumSize(new java.awt.Dimension(300, 50));

        lblValor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValor.setText("R$ 0,00");

        lblMonth.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblMonth.setText("Abril");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMonth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(lblValor)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(lblMonth))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblValor;
    // End of variables declaration//GEN-END:variables
}
