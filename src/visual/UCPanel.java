package visual;

import java.awt.event.ActionListener;
import javax.swing.Icon;

public class UCPanel extends javax.swing.JPanel {

    public UCPanel() {
        initComponents();
    }

    public void setTitle(String title) {
        lblTitle.setText(title);
    }
    
    public void setDescription(String description) {
        lblDescription.setText(description);
    }
    
    public void setSubtitle(String subtitle) {
        lblSubTitle.setText(subtitle);
    }
    
    public void setImage(Icon icon) {
        lblIcon.setIcon(icon);
    }
    
    public void setValue(String value) {
        lblValue.setText(value);
    }
    
    public void BtnView(ActionListener evt) {
        btnView.addActionListener(evt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblSubTitle = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblValue = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblSubTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTitle.setText("Title");

        lblValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        lblDescription.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDescription.setText("Description");

        btnView.setText("Visualizar");
        btnView.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValue, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btnView))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTitle))
                            .addComponent(lblDescription))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnView)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDescription)
                        .addGap(11, 11, 11)
                        .addComponent(lblValue, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnView;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblValue;
    // End of variables declaration//GEN-END:variables
}
