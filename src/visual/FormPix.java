package visual;

import dao.DAOPix;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import modelo.Pix;

public class FormPix extends javax.swing.JDialog {

    private DAOPix dao;
    private Long cpf;
    
    public FormPix(java.awt.Frame parent, boolean modal, Long cpf) {
        super(parent, modal);
        initComponents();
        
        dao = new DAOPix();
        
        this.cpf = cpf;
        atualizarTela();
    }

    private void atualizarTela() {
        List<Pix> pixs = dao.getTudo(cpf);
        int count = pixs.size();
        
        lblQuantidade.setText(count + " de 5 chaves");
        btnRegistrar.setEnabled(count < 5);
        pnlChaves.removeAll();
        
        for (Pix p : pixs) {
            
            int idPixTipo = p.getPixTipo().getIdPixTipo();
            Icon icone = null;
            switch (idPixTipo) {
                case 1:
                    icone = new ImageIcon(getClass().getResource("/src/img_email.png"));
                    break;
                case 2:
                    icone = new ImageIcon(getClass().getResource("/src/img_cpf.png"));
                    break;
                case 3:
                    icone = new ImageIcon(getClass().getResource("/src/img_guid.png"));
                    break;
                case 4:
                    icone = new ImageIcon(getClass().getResource("/src/img_telephone.png"));
                    break;
                default:
                    break;
            }
            
            UCPix ucpx = new UCPix(p.getPixTipo().getDescricao(), p.getChave(), icone);
            ucpx.BtnDeletar((ActionEvent evt) -> {
                dao.remover(p);
                atualizarTela();
            });
            pnlChaves.add(ucpx);
        }
        pnlChaves.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblQuantidade = new javax.swing.JLabel();
        pnlChaves = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(344, 527));

        lbl.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl.setText("Minhas chaves");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Gerencie suas chaves Pix.");

        btnRegistrar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/img_add.png"))); // NOI18N
        btnRegistrar.setText("Registrar chave");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblQuantidade.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lblQuantidade.setText("2 de 5 chaves");

        pnlChaves.setMaximumSize(new java.awt.Dimension(0, 343));
        pnlChaves.setMinimumSize(new java.awt.Dimension(0, 343));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuantidade)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlChaves, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuantidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlChaves, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 155, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        FormAddPix addPix = new FormAddPix(null, true, cpf);
        addPix.setLocationRelativeTo(null);
        addPix.setResizable(false);
        addPix.setTitle("Adicionar Pix");
        addPix.setVisible(true);
        
        atualizarTela();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JPanel pnlChaves;
    // End of variables declaration//GEN-END:variables
}
