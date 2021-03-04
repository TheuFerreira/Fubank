package visual;

import java.awt.event.ActionListener;
import javax.swing.Icon;
import modelo.Pix;

public class UCPix extends javax.swing.JPanel {

    private Pix pix;
    
    public UCPix(String titulo, String chave, Icon icone) {
        initComponents();
        
        lblTitulo.setText(titulo);
        lblChave.setText(chave);
        lblIcone.setIcon(icone);
    }

    public Pix getPix() {
        return pix;
    }

    public void setPix(Pix pix) {
        this.pix = pix;
    }
    
    public void BtnDeletar(ActionListener evt) {
        btnDeletar.addActionListener(evt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblChave = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        lblIcone = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(324, 73));
        setMinimumSize(new java.awt.Dimension(324, 73));

        lblTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTitulo.setText("E-mail");

        lblChave.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lblChave.setText("matheus.44300@gmail.com");

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/img_trash.png"))); // NOI18N

        lblIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/img_email.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(lblChave, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblChave))
                    .addComponent(lblIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JLabel lblChave;
    private javax.swing.JLabel lblIcone;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
