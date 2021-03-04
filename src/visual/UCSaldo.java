package visual;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import modelo.Tipo;

public class UCSaldo extends javax.swing.JPanel {

    public UCSaldo(Tipo tipo, String descricao, Timestamp date, double valor) {
        initComponents();
        lblTitulo.setText(tipo.getTitulo());
        lblDescricao.setText(descricao);
        lblMonth.setText(new SimpleDateFormat("dd MMM").format(date));
        lblValor.setText("R$ " + valor);
        
        int idTipo = tipo.getIdTipo();
        switch (idTipo) {
            case 1: // Deposito recebido
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_card_2.png")));
                break;
            case 2: // Transferencia enviada
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_pay_1.png")));
                break;
            case 3: // Transferência Recebida
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_receive.png")));
                break;
            case 4: // Recarga Efetuada
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_phone.png")));
                break;
            case 5: // Fatura Paga
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_pay_2.png")));
                break;
            case 6: // Supermercado
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_buy.png")));
                break;
            case 7: // Saúde
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_heart.png")));
                break;
            case 8: // Educação
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_books.png")));
                break;
            case 9: // Restaurante
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_food.png")));
                break;
            case 10: // Serviços
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_work.png")));
                break;
            case 11: // Eletrônicos
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_gamepad.png")));
                break;
            case 12: // Outros
                lblIcone.setIcon(new ImageIcon(getClass().getResource("/src/img_others.png")));
                break;
            default:
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcone = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(300, 62));
        setMinimumSize(new java.awt.Dimension(300, 62));
        setPreferredSize(new java.awt.Dimension(300, 62));

        lblIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/img_phone.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblTitulo.setText("Recarga Efetuada");

        lblDescricao.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblDescricao.setText("(33) 999839479");

        lblMonth.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblMonth.setText("14 FEV");

        lblValor.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValor.setText("R$50,00");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(lblMonth))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValor)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitulo)
                            .addComponent(lblMonth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescricao)
                            .addComponent(lblValor))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblIcone;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    // End of variables declaration//GEN-END:variables
}
