package visual;

import dao.DAOCliente;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class FormRegister extends javax.swing.JDialog {

    public FormRegister(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setDisable(Cliente cliente) {
        txtCpf.setEnabled(false);
        txtNome.setEnabled(false);
        txtSenha.setEnabled(false);
        txtSobrenome.setEnabled(false);
        btnRegistrar.setVisible(false);
        
        txtCpf.setText(cliente.getCPF().toString());
        txtNome.setText(cliente.getNome());
        txtSobrenome.setText(cliente.getSobrenome());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtSobrenome = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CPF:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Sobrenome:");

        jLabel4.setText("Senha:");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome)
                    .addComponent(txtSobrenome)
                    .addComponent(txtSenha)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        String text = txtCpf.getText();
        text = text.replace('-', ' ');
        text = text.replace('.', ' ');
        text = text.replaceAll("\\s+","");
        
        if (text.length() == 0) {
            JOptionPane.showMessageDialog(null, "O CPF precisa ser preenchido", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtNome.getText().length() < 3) {
            JOptionPane.showMessageDialog(null, "O nome precisa de pelo menos 3 caracteres", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtSobrenome.getText().length() < 3) {
            JOptionPane.showMessageDialog(null, "O sobrenome precisa de pelo menos 3 caracteres", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtSenha.getText().length() < 3) {
            JOptionPane.showMessageDialog(null, "A senha precisa de pelo menos 3 caracteres", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Long cpf = Long.parseLong(text);
        DAOCliente dao = new DAOCliente();
        if (dao.existe(cpf)) {
            JOptionPane.showMessageDialog(null, "Ja existe um usuario com esse CPF", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Cliente cliente = new Cliente(cpf, txtNome.getText(), txtSobrenome.getText(), txtSenha.getText());
        dao.inserir(cliente);
        
        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
        dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables
}
