import java.awt.Container;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.*;

public class InterfaceGrafica extends JFrame implements ActionListener {
    ConexaoBancoDeDados objBancoDeDados;
    private JButton btnInserir;
    private JButton btnRemover;
    private JButton btnAlterar;
    private JButton btnPesquisar;
    private JLabel lblNome;
    private JLabel lblEndereco;
    private JLabel lblTelefone;
    private JLabel lblResultadoPesquisa;
    private JLabel lblMensagem;
    private JLabel lblTelefoneEmergencia;
    private JLabel lblContatoEmergencia;
    private JLabel lblCPF;
    private JLabel lblSangue;
    private JLabel lblFator;
    private JLabel lblCurso;
    private JLabel lblid;
    private String[] tiposSangue = {"A", "B", "AB", "O"};
    private String[] tiposFator = {"+", "-"};
    private String[] tiposCurso = {"Direito", "Ciência da computação", "Sistemas da Informacao", "Medicina", "Psicologia", "Nutricao"};
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtContatoEmergencia;
    private JTextField txtid;
    private JFormattedTextField txtTelefone;
    private JFormattedTextField txtTelefoneEmergencia;
    private JFormattedTextField txtCPF;
    private JComboBox cmbSangue;
    private JComboBox cmbFator;
    private JComboBox cmbCurso;
    private JTextArea listaPesquisaBancoDeDados;
    private JScrollPane scrollPesquisaBancoDedados;
    private Container janelaprincipal;

    public InterfaceGrafica() {
        setSize(900, 600);
        setTitle("Conexão com banco de dados");
        janelaprincipal = getContentPane();
        janelaprincipal.setLayout(null);

        txtNome = new JTextField();
        txtEndereco = new JTextField();
        txtContatoEmergencia = new JTextField();
        txtid = new JTextField();

        btnInserir = new JButton("Inserir");
        btnRemover = new JButton("Remover");
        btnAlterar = new JButton("Alterar");
        btnPesquisar = new JButton("Pesquisar");

        lblSangue = new JLabel("Tipo Sanguineo");
        cmbSangue = new JComboBox(tiposSangue);
        lblFator = new JLabel("Fator RH");
        cmbFator = new JComboBox(tiposFator);
        lblCurso = new JLabel("Curso");
        cmbCurso = new JComboBox(tiposCurso);


        lblMensagem = new JLabel(" ----");
        lblNome = new JLabel("Nome");
        lblEndereco = new JLabel("Endereço");
        lblTelefone = new JLabel("Telefone");
        lblContatoEmergencia = new JLabel("Contato emergencia");
        lblResultadoPesquisa = new JLabel("Resultado da Pesquisa no Bando de Dados");
        lblTelefoneEmergencia = new JLabel("Telefone emergencial: ");
        lblid = new JLabel("ID");

        listaPesquisaBancoDeDados = new JTextArea();
        scrollPesquisaBancoDedados = new JScrollPane(listaPesquisaBancoDeDados);

        try {
            txtTelefoneEmergencia = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            txtTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lblCPF = new JLabel("CPF");
        try {
            txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        btnInserir.setBounds(10, 420, 90, 40);
        btnRemover.setBounds(102, 420, 95, 40);
        btnAlterar.setBounds(10, 470, 90, 40);
        btnPesquisar.setBounds(102, 470, 95, 40);

        lblMensagem.setBounds(50, 385, 250, 20);
        lblNome.setBounds(10, 40, 80, 20);
        lblEndereco.setBounds(10, 85, 100, 20);
        lblTelefone.setBounds(10, 130, 100, 20);
        lblCPF.setBounds(10, 175, 100, 20);
        txtCPF.setBounds(110, 175, 100, 20);
        lblResultadoPesquisa.setBounds(480, 5, 300, 20);
        scrollPesquisaBancoDedados.setBounds(420, 25, 450, 235);
        cmbSangue.setBounds(110, 210, 100, 20);
        cmbFator.setBounds(110,245,100,20);
        cmbCurso.setBounds(110,280,100,20);
        lblSangue.setBounds(10, 210, 100, 20);
        lblFator.setBounds(10, 245, 100, 20);
        lblCurso.setBounds(10, 280, 100, 20);
        lblContatoEmergencia.setBounds(10,315,150,20);
        txtContatoEmergencia.setBounds(160,315,150,25);
        lblTelefoneEmergencia.setBounds(10, 350, 150, 20);
        txtTelefoneEmergencia.setBounds(160, 350, 150, 25);

        txtNome.setBounds(100, 40, 200, 25);
        txtEndereco.setBounds(100, 85, 200, 25);
        txtTelefone.setBounds(100, 130, 200, 25);

        lblid.setBounds(220, 420, 20, 20);
        txtid.setBounds(240, 420, 20, 20);


        janelaprincipal.add(btnInserir);
        janelaprincipal.add(btnRemover);
        janelaprincipal.add(btnAlterar);
        janelaprincipal.add(btnPesquisar);
        janelaprincipal.add(lblEndereco);
        janelaprincipal.add(lblNome);
        janelaprincipal.add(lblTelefone);
        janelaprincipal.add(lblResultadoPesquisa);
        janelaprincipal.add(scrollPesquisaBancoDedados);
        janelaprincipal.add(txtNome);
        janelaprincipal.add(txtEndereco);
        janelaprincipal.add(txtTelefone);
        janelaprincipal.add(lblMensagem);
        janelaprincipal.add(lblTelefoneEmergencia);
        janelaprincipal.add(lblContatoEmergencia);
        janelaprincipal.add(cmbSangue);
        janelaprincipal.add(cmbCurso);
        janelaprincipal.add(cmbFator);
        janelaprincipal.add(lblCPF);
        janelaprincipal.add(txtCPF);
        janelaprincipal.add(txtContatoEmergencia);
        janelaprincipal.add(lblSangue);
        janelaprincipal.add(lblCurso);
        janelaprincipal.add(lblFator);
        janelaprincipal.add(txtTelefoneEmergencia);
        janelaprincipal.add(lblid);
        janelaprincipal.add(txtid);

        setVisible(true);

        btnInserir.addActionListener(this);
        btnRemover.addActionListener(this);
        btnAlterar.addActionListener(this);
        btnPesquisar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Inserir")) {
            String tiposSangue = cmbSangue.getSelectedItem().toString();
            String tiposFator = cmbFator.getSelectedItem().toString();
            String tiposCurso = cmbCurso.getSelectedItem().toString();
            Matricula objeto = new Matricula(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtContatoEmergencia.getText(), txtTelefoneEmergencia.getText(), txtCPF.getText(), tiposSangue, tiposFator, tiposCurso);
            try {
                ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
                String mensagem = objBancoDeDados.InserirDados(objeto, tiposSangue, tiposFator, tiposCurso);

                lblMensagem.setText(mensagem);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("Remover")) {
            String tiposSangue = cmbSangue.getSelectedItem().toString();
            String tiposFator = cmbFator.getSelectedItem().toString();
            String tiposCurso = cmbCurso.getSelectedItem().toString();
            Matricula objeto = new Matricula(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtContatoEmergencia.getText(), txtTelefoneEmergencia.getText(), txtCPF.getText(), tiposSangue, tiposFator, tiposCurso);
            try {
                ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
                int id = Integer.parseInt(txtid.getText());
                String mensagem = objBancoDeDados.RemoverDados(id);
                lblMensagem.setText(mensagem);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("Alterar")) {
            String tiposSangue = cmbSangue.getSelectedItem().toString();
            String tiposFator = cmbFator.getSelectedItem().toString();
            String tiposCurso = cmbCurso.getSelectedItem().toString();
            Matricula objeto = new Matricula(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtContatoEmergencia.getText(), txtTelefoneEmergencia.getText(), txtCPF.getText(), tiposSangue, tiposFator, tiposCurso);
            try {
                ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
                int id = Integer.parseInt(txtid.getText());
                String mensagem = objBancoDeDados.AlterarDados(objeto, id);
                lblMensagem.setText(mensagem);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("Pesquisar")) {
            try {
                ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
                ArrayList<String> relatorioBancoDeDados = objBancoDeDados.Relatorio();

                listaPesquisaBancoDeDados.setText("");
                for (String texto : relatorioBancoDeDados) {
                    listaPesquisaBancoDeDados.append(texto + "\n\n");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}