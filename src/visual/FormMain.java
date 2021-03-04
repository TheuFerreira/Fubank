package visual;

import dao.DAOCliente;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class FormMain extends javax.swing.JFrame {

    private Cliente clienteAtual;
    private DAOCliente dao;
    
    public FormMain(Cliente cliente) {
        initComponents();
        
        dao = new DAOCliente();
        clienteAtual = cliente;
        
        ucFatura.BtnView((ActionEvent evt) -> {
            ucFaturaBtnView(evt);
        });
        
        ucConta.BtnView((ActionEvent evt) -> {
            ucContaBtnView(evt);
        });
        
        lblUsuario.setText("Olá, " + cliente.getNome() + " " + cliente.getSobrenome());
        atualizarTela();
    }

    private void atualizarTela() {
        double fatura = dao.getFatura(clienteAtual.getCPF());
        clienteAtual.setFatura(fatura);
        ucFatura.setValue("R$ " + clienteAtual.getFatura());
        
        double limite = dao.getLimite(clienteAtual.getCPF());
        clienteAtual.setLimite(limite - fatura);
        ucFatura.setSubtitle("Limite disponível R$ " + clienteAtual.getLimite());
        
        double saldo = dao.getSaldo(clienteAtual.getCPF());
        clienteAtual.setSaldo(saldo);
        ucConta.setValue("R$ " + clienteAtual.getSaldo());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ucFatura = new visual.UCPanel();
        uCPanel1 = new visual.UCPanel();
        ucConta = new visual.UCPanel();
        jPanel1 = new javax.swing.JPanel();
        menuBtnPix = new visual.UCMenuButton();
        ucPagar = new visual.UCMenuButton();
        uCConta = new visual.UCMenuButton();
        ucAjuda = new visual.UCMenuButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_fubank.png")).getImage());

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblUsuario.setText("Olá, Ferreira");

        ucFatura.setDescription("Fatura Atual");
        ucFatura.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_card.png"))); // NOI18N
        ucFatura.setSubtitle("Limite disponível R$ 500,00");
        ucFatura.setTitle("Cartão de Crédito");
        ucFatura.setValue("R$ 0,00");

        uCPanel1.setDescription("Conheça Fubank Vida: um seguro simples.");
        uCPanel1.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_secure_life.png"))); // NOI18N
        uCPanel1.setTitle("Seguro de Vida");

        ucConta.setDescription("Saldo disponível");
        ucConta.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_money.png"))); // NOI18N
        ucConta.setTitle("Conta");
        ucConta.setValue("R$ 0,00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ucFatura, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(uCPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, Short.MAX_VALUE)
            .addComponent(ucConta, javax.swing.GroupLayout.PREFERRED_SIZE, 299, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(ucFatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ucConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uCPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuBtnPix.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_pix.png"))); // NOI18N
        menuBtnPix.setTitle("Pix");
        menuBtnPix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBtnPixMouseClicked(evt);
            }
        });
        jPanel1.add(menuBtnPix);

        ucPagar.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_pay.png"))); // NOI18N
        ucPagar.setTitle("Pagar");
        ucPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucPagarMouseClicked(evt);
            }
        });
        jPanel1.add(ucPagar);

        uCConta.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_account.png"))); // NOI18N
        uCConta.setTitle("Minha Conta");
        uCConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uCContaMouseClicked(evt);
            }
        });
        jPanel1.add(uCConta);

        ucAjuda.setImage(new javax.swing.ImageIcon(getClass().getResource("/src/img_help.png"))); // NOI18N
        ucAjuda.setTitle("Me Ajuda");
        ucAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ucAjudaMouseClicked(evt);
            }
        });
        jPanel1.add(ucAjuda);

        jLayeredPane1.setLayer(lblUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ucFaturaBtnView(ActionEvent evt) {
        FormFatura formFatura = new FormFatura(null, true, clienteAtual.getCPF());
        formFatura.setLocationRelativeTo(null);
        formFatura.setResizable(false);
        formFatura.setTitle("Conta");
        formFatura.setVisible(true);
        
        atualizarTela();
    }
    
    private void ucContaBtnView(ActionEvent evt) {
        FormConta formConta = new FormConta(null, true, clienteAtual.getCPF());
        formConta.setLocationRelativeTo(null);
        formConta.setResizable(false);
        formConta.setTitle("Conta");
        formConta.setVisible(true);
        
        atualizarTela();
    }
    
    private void menuBtnPixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBtnPixMouseClicked
        FormPix pix = new FormPix(null, true, clienteAtual.getCPF());
        pix.setLocationRelativeTo(null);
        pix.setTitle("Pix");
        pix.setVisible(true);
    }//GEN-LAST:event_menuBtnPixMouseClicked

    private void ucAjudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucAjudaMouseClicked
        JOptionPane.showMessageDialog(null, "Você clicou no botão ajuda! \n"
                + "Aqui você encontrará tutoriais de como fazer empréstimos de \n"
                + "valores exorbitantes os quais você nunca conseguirá pagar. Vai \n"
                + "encontrar também maneiras de entrar no cheque especial, pagar \n"
                + "ele com a fatura do cartão para que possa pagar os juros do \n"
                + "cheque especial somados aos juros da fatura do cartão. \n"
                + "Incrível né?! Além de todas essas oportunidades imperdíveis o \n"
                + "fubank ainda conta com financiamentos automotivos com os menores \n"
                + "juros do mercado, apenas 200%! Isso mesmo, só 200% do valor do \n"
                + "seu veículo. Mas se ainda sim você não conseguir pagar suas \n"
                + "dúvidas oferecemos um recurso único que nenhum noutro banco \n"
                + "propõe. Como prova de nossa boa vontade para com nossos clientes \n"
                + "cederemos a você um agiota particular. É exatamente o que você \n"
                + "leu, um agiota particular, não é tudo que você sempre quis?! \n"
                + "E ainda tem mais! Seu agiota particular é fraco na briga e ruim \n"
                + "de tiro. Você não pode perder esta oportunidade, condições tão\n"
                + " acessíveis jamais foram vistas em quaisquer outros bancos! \n" +
"APROVEITE!!!!\n" +
"\n" +
"\n" +
"\n" +
"Obs: Oferecemos também aos nossos clientes o serviço de pistoleiro autônomo pelo \n"
                + "valor simbólico de 20% de sua dívida com o agiota.");
    }//GEN-LAST:event_ucAjudaMouseClicked

    private void ucPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucPagarMouseClicked
        Long cpf = clienteAtual.getCPF();
        double saldo = dao.getSaldo(cpf);
        double fatura = dao.getFatura(cpf);
        
        FormPagar formPagar = new FormPagar(null, true, cpf, saldo, fatura);
        formPagar.setLocationRelativeTo(null);
        formPagar.setResizable(false);
        formPagar.setTitle("Pagar");
        formPagar.setVisible(true);
        
        atualizarTela();
    }//GEN-LAST:event_ucPagarMouseClicked

    private void uCContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uCContaMouseClicked
        FormRegister form = new FormRegister(null, true);
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setTitle("Minha Conta");
        form.setDisable(clienteAtual);
        form.setVisible(true);
    }//GEN-LAST:event_uCContaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblUsuario;
    private visual.UCMenuButton menuBtnPix;
    private visual.UCMenuButton uCConta;
    private visual.UCPanel uCPanel1;
    private visual.UCMenuButton ucAjuda;
    private visual.UCPanel ucConta;
    private visual.UCPanel ucFatura;
    private visual.UCMenuButton ucPagar;
    // End of variables declaration//GEN-END:variables
}
