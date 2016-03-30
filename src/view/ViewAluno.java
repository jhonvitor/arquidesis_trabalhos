package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ViewAluno extends JFrame implements ActionListener, ItemListener,
		MouseListener {
	private static final long serialVersionUID = 1L;

	private JPanel caixaCurso, caixaMatricula, caixa, caixaRadio;
	private JRadioButton rbCurso, rbMatricula;
	private ButtonGroup radiogroup;

	private String opcao[];
	private JComboBox<String> cbCurso;
	private String lingua, pais;

	// JLabel Entrada
	private JLabel lImgCurso, lNomeCursoEntrada;

	// JLabel Curso
	private JLabel lCodCurso, lCurso, lDataIni, lDataAs, lHoraIni, lHoraAs,
			lQtdVaga, lValor, lMatEndNlab, lLivroEndSoft;

	// Jlabel Matricula
	private JLabel lcodMat, lDataMat, lDataCancelamentoMat, lValorMat,
			lTipPgMat, lstatusMat, lCpfMat, lCursoMat, lCodCursoMat;

	// JTextField CURSO
	private JTextField tCod, tHoraIni, tHoraFin, tQtdVaga, tValor, tMatEndNlab,
			tLivroEndSoft, tCpfMat, tCursoMat, tCodCursoMat,
			tDataCancelamentoMat, tDataIni, tDataFin;

	// JTextFiel Matricula
	private JTextField tcodMat, tValorMat, tStatusPgMat, tstatusMat, tDataMat;

	private JButton bLogof, bImgBra, bImgUsa, bImgEspa;

	private JMenuBar barra;
	private JMenu ajuda, idiomas, relatorio, arquivo;
	private JMenuItem manual, sobre, port, ingl, espa, pagina, config, senha;

	private ImageIcon imgCurso;

	private JTable tabelaCurso, tabelaMatricula;
	private JScrollPane scrollPaneCurso, scrollPaneMatricula;
	private ResourceBundle rb = null;

	// Metodo para INTERNACIONALIZACAO
	public void escolhaIdioma(String lingua, String pais) {

		this.lingua = lingua;
		this.pais = pais;

		Locale.setDefault(new Locale(lingua, pais));
		Locale locale = Locale.getDefault();
		rb = ResourceBundle.getBundle("properties.Aluno", locale);

		// INTERNACIONALIZACAO RadioButton

		rbCurso.setText(rb.getString("ptelaAluno.rbutton.curso"));
		rbMatricula.setText(rb.getString("ptelaAluno.rbutton.matricula"));

		// INTERNACIONALIZAÇÃO TELA INICIAL
		lNomeCursoEntrada.setText(rb.getString("ptelaAluno.label.inicio"));

		// INTERNACIONALIZAÇÃO curso

		lCurso.setText(rb.getString("ptelaAluno.label.curso"));
		lDataIni.setText(rb.getString("ptelaAluno.label.data"));
		lDataAs.setText(rb.getString("ptelaAluno.label.dataas"));
		lHoraIni.setText(rb.getString("ptelaAluno.label.horario"));
		lHoraAs.setText(rb.getString("ptelaAluno.label.horarioas"));
		lQtdVaga.setText(rb.getString("ptelaAluno.label.qtdvagas"));
		lCodCurso.setText(rb.getString("ptelaAluno.label.codigocurso"));
		lValor.setText(rb.getString("ptelaAluno.label.valor"));
		if (cbCurso.getSelectedItem().equals("Informática")) {
			lLivroEndSoft.setText(rb.getString("ptelaAluno.label.software"));
			lMatEndNlab.setText(rb.getString("ptelaAluno.label.numlab"));
		} else if (cbCurso.getSelectedItem().equals("Artes")) {
			lLivroEndSoft.setText(rb.getString("ptelaAluno.label.livro"));
			lMatEndNlab.setText(rb.getString("ptelaAluno.label.material"));
		}

		// INTERNACIONALIZACAO Panel Matricula
		lcodMat.setText(rb.getString("ptelaAluno.label.matricula"));
		lDataMat.setText(rb.getString("ptelaAluno.label.datamat"));
		lDataCancelamentoMat.setText(rb
				.getString("ptelaAluno.label.datacancel"));
		lValorMat.setText(rb.getString("ptelaAluno.label.valormat"));
		lTipPgMat.setText(rb.getString("ptelaAluno.label.tipopg"));
		lstatusMat.setText(rb.getString("ptelaAluno.label.statusmat"));
		lCpfMat.setText(rb.getString("ptelaAluno.label.cpfalu"));
		lCursoMat.setText(rb.getString("ptelaAluno.label.cursomat"));
		lCodCursoMat.setText(rb.getString("ptelaAluno.label.codmat"));

		// INTERNACIONALIZACAO Titulo
		setTitle(rb.getString("ptelaAluno.title.titulo"));

		// INTERNACIONALIZACAO Menu
		arquivo.setText(rb.getString("ptelaAluno.menu.arquivo"));
		ajuda.setText(rb.getString("ptelaAluno.menu.ajuda"));
		idiomas.setText(rb.getString("ptelaAluno.menu.idioma"));

		relatorio.setText(rb.getString("ptelaAluno.menu.relatorio"));
		pagina.setText(rb.getString("ptelaAluno.menu.gerarrelatorio"));
		config.setText(rb.getString("ptelaAluno.menu.configrelatorio"));
		senha.setText(rb.getString("ptelaAluno.menu.alterarsenha"));
		port.setText(rb.getString("ptelaAluno.menu.portugues"));
		ingl.setText(rb.getString("ptelaAluno.menu.ingles"));
		espa.setText(rb.getString("ptelaAluno.menu.espanhol"));
		manual.setText(rb.getString("ptelaAluno.menu.manual"));
		sobre.setText(rb.getString("ptelaAluno.menu.sobre"));

	}

	public ViewAluno(String lingua, String pais) {
		super(
				".:: Acesso Aluno ::.     Sistema Integrado para Cursos Presenciais.");
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"imgs/Fundo2.png"))));
		// Container telaAluno = getContentPane();
		// telaAluno.setLayout(null);
		setLayout(null);

		// Instancia o JPANEL CAIXA
		caixa = new JPanel(null);
		caixa.setBounds(100, 20, 1100, 640);
		caixa.setVisible(true);
		caixa.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		// telaAluno.add(caixa);
		add(caixa);

		// Instancia o JPANEL CAIXA Matricula
		caixaMatricula = new JPanel(null);
		caixaMatricula.setBounds(100, 20, 1100, 640);
		caixaMatricula.setVisible(false);
		caixaMatricula.setBorder(BorderFactory.createLineBorder(new Color(0, 0,
				0)));
		// telaAluno.add(caixaMatricula);
		add(caixaMatricula);

		// Instancia o JPANEL CAIXA Curso
		caixaCurso = new JPanel(null);
		caixaCurso.setBounds(100, 20, 1100, 640);
		caixaCurso.setVisible(false);
		caixaCurso
				.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		// telaAluno.add(caixaCurso);
		add(caixaCurso);

		// Instancia o JPANEL CAIXA RADIO
		caixaRadio = new JPanel(null);
		caixaRadio.setBounds(80, 30, 900, 50);
		caixaRadio.setVisible(true);
		caixaRadio
				.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		caixaRadio.setLayout(new FlowLayout(FlowLayout.CENTER));
		caixa.add(caixaRadio);

		// Cria MENU
		barra = new JMenuBar();
		setJMenuBar(barra);

		ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic('j');

		idiomas = new JMenu("Idiomas");
		idiomas.setMnemonic('I');

		relatorio = new JMenu("Relatório");
		relatorio.setMnemonic('R');

		arquivo = new JMenu("Arquivo");
		arquivo.setMnemonic('A');

		senha = new JMenuItem("Alterar Senha");
		manual = new JMenuItem("Manual");
		sobre = new JMenuItem("Sobre");
		pagina = new JMenuItem("Gerar Relatório");
		config = new JMenuItem("Configurar Relatório");
		port = new JMenuItem("Português");
		ingl = new JMenuItem("Inglês");
		espa = new JMenuItem("Espanhol");

		barra.add(arquivo);
		barra.add(idiomas);
		barra.add(ajuda);

		arquivo.add(relatorio);
		arquivo.add(senha);
		relatorio.add(pagina);
		relatorio.add(config);
		ajuda.add(manual);
		ajuda.add(sobre);
		idiomas.add(port);
		idiomas.add(ingl);
		idiomas.add(espa);

		// Botao icone Logout
		bLogof = new JButton();
		bLogof.setBounds(1250, 20, 110, 27);
		bLogof.setIcon(new ImageIcon(getClass().getResource("imgs/logout4.png")));
		bLogof.setToolTipText("Logoff");
		bLogof.setBorderPainted(false);
		bLogof.setContentAreaFilled(false);
		bLogof.setFocusPainted(false);
		bLogof.setOpaque(false);
		bLogof.addMouseListener(this);
		add(bLogof);

		// Botao icone Bandeira Brasil
		bImgBra = new JButton();
		bImgBra.setBounds(1200, 610, 60, 60);
		bImgBra.setIcon(new ImageIcon(getClass().getResource("imgs/br.png")));
		bImgBra.setToolTipText("Português");
		bImgBra.setBorderPainted(false);
		bImgBra.setContentAreaFilled(false);
		bImgBra.setFocusPainted(false);
		bImgBra.setOpaque(false);
		bImgBra.addMouseListener(this);
		add(bImgBra);

		// Botao icone Bandeira Estados Unidos
		bImgUsa = new JButton();
		bImgUsa.setBounds(1253, 610, 60, 60);
		bImgUsa.setIcon(new ImageIcon(getClass().getResource("imgs/eua.png")));
		bImgUsa.setToolTipText("Inglês");
		bImgUsa.setBorderPainted(false);
		bImgUsa.setContentAreaFilled(false);
		bImgUsa.setFocusPainted(false);
		bImgUsa.setOpaque(false);
		bImgUsa.addMouseListener(this);
		add(bImgUsa);

		// Botao icone Bandeira Espanha
		bImgEspa = new JButton();
		bImgEspa.setBounds(1306, 610, 60, 60);
		bImgEspa.setIcon(new ImageIcon(getClass().getResource("imgs/es.png")));
		bImgEspa.setToolTipText("Espanhol");
		bImgEspa.setBorderPainted(false);
		bImgEspa.setContentAreaFilled(false);
		bImgEspa.setFocusPainted(false);
		bImgEspa.setOpaque(false);
		bImgEspa.addMouseListener(this);
		add(bImgEspa);

		// RadioButon
		rbCurso = new JRadioButton("Curso     ", false);
		rbCurso.setFont(new Font("", Font.BOLD, 23));
		rbCurso.setFocusPainted(false);
		rbCurso.addItemListener(this);

		rbMatricula = new JRadioButton("Matricula     ", false);
		rbMatricula.setFont(new Font("", Font.BOLD, 23));
		rbMatricula.setFocusPainted(false);
		rbMatricula.addItemListener(this);

		radiogroup = new ButtonGroup();
		radiogroup.add(rbCurso);
		radiogroup.add(rbMatricula);

		caixaRadio.add(rbCurso);
		caixaRadio.add(rbMatricula);

		opcao = new String[] { "Artes", "Informática" };

		// ##########################################
		// # Inserindo os elementos no JPANEL CAIXA #
		// ##########################################
		imgCurso = new ImageIcon(this.getClass().getResource("imgs/curso2.png"));
		lImgCurso = new JLabel(imgCurso);
		lImgCurso.setBounds(240, 200, 600, 200);
		lImgCurso.setBorder(null);
		caixa.add(lImgCurso);

		// JLabel Nome Curso
		lNomeCursoEntrada = new JLabel();
		lNomeCursoEntrada.setText("SISTEMA INTEGRADO PARA CURSOS PRESENCIAIS");
		lNomeCursoEntrada.setFont(new Font("", Font.BOLD, 35));
		lNomeCursoEntrada.setBounds(130, 360, 900, 150);
		caixa.add(lNomeCursoEntrada);

		// ################################################
		// # Inserindo os elementos no JPANEL CAIXA CURSO #
		// ################################################

		// JLabel e JTextField CURSO
		lCurso = new JLabel();
		lCurso.setText("Curso:");
		lCurso.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCurso.setBounds(85, 85, 80, 50);
		caixaCurso.add(lCurso);

		cbCurso = new JComboBox<String>(opcao);
		cbCurso.setBounds(190, 95, 315, 25);
		caixaCurso.add(cbCurso);

		// JLabel e JTextField DATA
		lDataIni = new JLabel();
		lDataIni.setText("Data:");
		lDataIni.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDataIni.setBounds(85, 135, 80, 50);
		caixaCurso.add(lDataIni);

		tDataIni = new JTextField();
		tDataIni.setBounds(190, 145, 145, 25);
		tDataIni.setEditable(false);
		caixaCurso.add(tDataIni);

		lDataAs = new JLabel();
		lDataAs.setText("à");
		lDataAs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDataAs.setBounds(345, 135, 20, 50);
		caixaCurso.add(lDataAs);

		tDataFin = new JTextField();
		tDataFin.setBounds(360, 145, 145, 25);
		tDataFin.setEditable(false);
		caixaCurso.add(tDataFin);

		// JLabel e JTextField HORARIO
		lHoraIni = new JLabel();
		lHoraIni.setText("Horário:");
		lHoraIni.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lHoraIni.setBounds(85, 185, 80, 50);
		caixaCurso.add(lHoraIni);

		tHoraIni = new JTextField();
		tHoraIni.setBounds(190, 195, 145, 25);
		tHoraIni.setEditable(false);
		caixaCurso.add(tHoraIni);

		lHoraAs = new JLabel();
		lHoraAs.setText("à");
		lHoraAs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lHoraAs.setBounds(345, 185, 20, 50);
		caixaCurso.add(lHoraAs);

		tHoraFin = new JTextField();
		tHoraFin.setBounds(360, 195, 145, 25);
		tHoraFin.setEditable(false);
		caixaCurso.add(tHoraFin);

		// JLabel e JTextField QUANTIDADE DE VAGAS
		lQtdVaga = new JLabel();
		lQtdVaga.setText("QTD. Vagas:");
		lQtdVaga.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lQtdVaga.setBounds(85, 235, 100, 50);
		caixaCurso.add(lQtdVaga);

		tQtdVaga = new JTextField();
		tQtdVaga.setBounds(190, 245, 145, 25);
		tQtdVaga.setEditable(false);
		caixaCurso.add(tQtdVaga);

		// JLabel e JTextField CODIGO
		lCodCurso = new JLabel();
		lCodCurso.setText("Código:");
		lCodCurso.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCodCurso.setBounds(85, 285, 80, 50);
		caixaCurso.add(lCodCurso);

		tCod = new JTextField();
		tCod.setBounds(190, 295, 315, 25);
		tCod.setEditable(false);
		caixaCurso.add(tCod);

		// JLabel e JTextField LIVROS
		lLivroEndSoft = new JLabel();
		lLivroEndSoft.setText("Livros:");
		lLivroEndSoft.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lLivroEndSoft.setBounds(570, 85, 80, 50);
		caixaCurso.add(lLivroEndSoft);

		tLivroEndSoft = new JTextField();
		tLivroEndSoft.setBounds(650, 95, 315, 25);
		tLivroEndSoft.setEditable(false);
		caixaCurso.add(tLivroEndSoft);

		// JLabel e JTextField MATERIAL
		lMatEndNlab = new JLabel();
		lMatEndNlab.setText("Material:");
		lMatEndNlab.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lMatEndNlab.setBounds(570, 135, 120, 50);
		caixaCurso.add(lMatEndNlab);

		tMatEndNlab = new JTextField();
		tMatEndNlab.setBounds(650, 145, 315, 25);
		tMatEndNlab.setEditable(false);
		caixaCurso.add(tMatEndNlab);

		// JLabel e JTextField VALOR
		lValor = new JLabel();
		lValor.setText("Valor: R$");
		lValor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lValor.setBounds(570, 185, 80, 50);
		caixaCurso.add(lValor);

		tValor = new JTextField();
		tValor.setBounds(650, 195, 145, 25);
		tValor.setEditable(false);
		caixaCurso.add(tValor);

		// instancia tabela
		tabelaCurso = new JTable();
		scrollPaneCurso = new JScrollPane();// Cria um scroll para a tabela

		tabelaCurso.setGridColor(Color.BLACK);
		tabelaCurso.setBorder(new LineBorder(Color.BLACK));
		tabelaCurso.setShowGrid(true);
		// tabela.setModel(conteudoTabela); adiciona o obj na tabela
		tabelaCurso.setSize(840, 800);

		scrollPaneCurso.getViewport().setVisible(true);
		scrollPaneCurso.getViewport().setBorder(null);
		scrollPaneCurso.setBounds(10, 350, 1080, 280);
		caixaCurso.add(scrollPaneCurso);
		scrollPaneCurso.getViewport().add(tabelaCurso);

		// ##############################################
		// # Inserindo os elementos no JPANEL Matriucla #
		// ##############################################

		// JLabel e JTextField CODIGO ALUNO
		lcodMat = new JLabel();
		lcodMat.setText("Matricula:");
		lcodMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lcodMat.setBounds(85, 85, 150, 50);
		caixaMatricula.add(lcodMat);

		tcodMat = new JTextField();
		tcodMat.setBounds(220, 95, 290, 25);
		tcodMat.setEditable(false);
		caixaMatricula.add(tcodMat);

		// JLabel e JTextField data matricula
		lDataMat = new JLabel();
		lDataMat.setText("Data Matricula:");
		lDataMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDataMat.setBounds(85, 135, 150, 50);
		caixaMatricula.add(lDataMat);

		tDataMat = new JTextField();
		tDataMat.setBounds(220, 145, 290, 25);
		tDataMat.setEditable(false);
		caixaMatricula.add(tDataMat);

		// JLabel e JTextField valor
		lValorMat = new JLabel();
		lValorMat.setText("Valor Matricula: R$");
		lValorMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lValorMat.setBounds(85, 185, 150, 50);
		caixaMatricula.add(lValorMat);

		tValorMat = new JTextField();
		tValorMat.setBounds(220, 195, 290, 25);
		tValorMat.setEditable(false);
		caixaMatricula.add(tValorMat);

		// JLabel e JTextField Tipo Pagamento
		lTipPgMat = new JLabel();
		lTipPgMat.setText("Tipo Pagamento:");
		lTipPgMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lTipPgMat.setBounds(85, 235, 150, 50);
		caixaMatricula.add(lTipPgMat);

		tStatusPgMat = new JTextField();
		tStatusPgMat.setBounds(220, 245, 290, 25);
		tStatusPgMat.setEditable(false);
		caixaMatricula.add(tStatusPgMat);

		// JLabel e JTextField Cpf do Aluno
		lCpfMat = new JLabel();
		lCpfMat.setText("Cpf Aluno:");
		lCpfMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCpfMat.setBounds(570, 85, 150, 50);
		caixaMatricula.add(lCpfMat);

		tCpfMat = new JTextField();
		tCpfMat.setBounds(690, 95, 290, 25);
		tCpfMat.setEditable(false);
		caixaMatricula.add(tCpfMat);

		// JLabel e JTextField Curso Matricula
		lCursoMat = new JLabel();
		lCursoMat.setText("Curso:");
		lCursoMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCursoMat.setBounds(570, 135, 150, 50);
		caixaMatricula.add(lCursoMat);

		tCursoMat = new JTextField();
		tCursoMat.setBounds(690, 145, 100, 25);
		tCursoMat.setEditable(false);
		caixaMatricula.add(tCursoMat);

		lCodCursoMat = new JLabel();
		lCodCursoMat.setText("código:");
		lCodCursoMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCodCursoMat.setBounds(795, 135, 80, 50);
		caixaMatricula.add(lCodCursoMat);

		tCodCursoMat = new JTextField();
		tCodCursoMat.setBounds(850, 145, 130, 25);
		tCodCursoMat.setEditable(false);
		caixaMatricula.add(tCodCursoMat);

		// JLabel e JTextField Matricula
		lstatusMat = new JLabel();
		lstatusMat.setText("Status Matricula:");
		lstatusMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lstatusMat.setBounds(570, 185, 150, 50);
		caixaMatricula.add(lstatusMat);

		tstatusMat = new JTextField();
		tstatusMat.setBounds(690, 195, 290, 25);
		tstatusMat.setEditable(false);
		caixaMatricula.add(tstatusMat);

		// JLabel e JTextField data cancelamento matricula
		lDataCancelamentoMat = new JLabel();
		lDataCancelamentoMat.setText("Data Cancelam.:");
		lDataCancelamentoMat
				.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDataCancelamentoMat.setBounds(570, 235, 150, 50);
		caixaMatricula.add(lDataCancelamentoMat);

		tDataCancelamentoMat = new JTextField();
		tDataCancelamentoMat.setBounds(690, 245, 290, 25);
		tDataCancelamentoMat.setEditable(false);
		caixaMatricula.add(tDataCancelamentoMat);

		// instancia tabela
		tabelaMatricula = new JTable();
		scrollPaneMatricula = new JScrollPane();// Cria um scroll para a tabela

		tabelaMatricula.setGridColor(Color.BLACK);
		tabelaMatricula.setBorder(new LineBorder(Color.BLACK));
		tabelaMatricula.setShowGrid(true);
		// tabela.setModel(conteudoTabela); adiciona o obj na tabela
		tabelaMatricula.setSize(840, 800);

		scrollPaneMatricula.getViewport().setVisible(true);
		scrollPaneMatricula.getViewport().setBorder(null);
		scrollPaneMatricula.setBounds(10, 350, 1080, 280);
		caixaMatricula.add(scrollPaneMatricula);
		scrollPaneMatricula.getViewport().add(tabelaMatricula);

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("imgs/logo2.png"))
				.getImage());
		setVisible(true);

		// Altera os rotulos do formulario de curso Artes e Informatica
		this.lingua = lingua;
		this.pais = pais;

		cbCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = "";
				if (lingua.equals("pt")) {
					content = (String) cbCurso.getSelectedItem();
					if (content.equals("Informática")) {
						lMatEndNlab.setText("Num. Lab:");
						lLivroEndSoft.setText("Softwares:");
					} else if (content.equals("Artes")) {
						lMatEndNlab.setText("Materiais:");
						lLivroEndSoft.setText("Livros:");
					}
				} else if (lingua.equals("en")) {
					content = (String) cbCurso.getSelectedItem();
					if (content.equals("Informática")) {
						lMatEndNlab.setText("Num Lab:");
						lLivroEndSoft.setText("Softwares:");
					} else if (content.equals("Artes")) {
						lMatEndNlab.setText("Materials:");
						lLivroEndSoft.setText("Books:");
					}
				} else if (lingua.equals("es")) {
					content = (String) cbCurso.getSelectedItem();
					if (content.equals("Informática")) {
						lMatEndNlab.setText("Núm. Lab:");
						lLivroEndSoft.setText("Softwares:");
					} else if (content.equals("Artes")) {
						lMatEndNlab.setText("Materiales:");
						lLivroEndSoft.setText("Libros:");
					}
				}
			}
		});
		escolhaIdioma(lingua, pais);
	}

	public void actionPerformed(ActionEvent arg0) {

	}

	// Acao do Radio Button, realizando a troca do Jpanel
	public void itemStateChanged(ItemEvent evt) {

		if (evt.getSource() == rbCurso) {
			caixaCurso.setVisible(true);
			caixa.setVisible(false);
			caixaMatricula.setVisible(false);
			caixa.add(caixaRadio);
			caixaCurso.add(caixaRadio);

		} else if (evt.getSource() == rbMatricula) {
			caixa.setVisible(false);
			caixaCurso.setVisible(false);
			caixaMatricula.setVisible(true);

			caixaMatricula.add(caixaRadio);

		}

	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == bImgBra) {
			lingua = "pt";
			escolhaIdioma("pt", "BR");
		} else if (arg0.getSource() == bImgUsa) {
			lingua = "en";
			escolhaIdioma("en", "US");
		} else if (arg0.getSource() == bImgEspa) {
			lingua = "es";
			escolhaIdioma("es", "ES");
		}

		if (arg0.getSource() == bLogof) {
			int resp;
			String texto = "";

			if (lingua.equals("pt")) {
				texto = "Deseja Deslogar do Sistema?";

			} else if (lingua.equals("es")) {
				texto = "¿Quiere Salir del Sistema?";

			} else if (lingua.equals("en")) {

				texto = "Want you to logout of the system?";
			}

			resp = JOptionPane.showConfirmDialog(null, texto, "LOGOFF",
					JOptionPane.YES_NO_OPTION);
			if (resp == 0) {
				dispose();
				new ViewLogin(lingua, pais);

			}
		}

		repaint();
	}

	public void mouseEntered(MouseEvent arg1) {
		if (arg1.getSource() == bImgBra) {
			bImgBra.setIcon(new ImageIcon(getClass().getResource(
					"imgs/brHover.png")));
		} else if (arg1.getSource() == bImgUsa) {
			bImgUsa.setIcon(new ImageIcon(getClass().getResource(
					"imgs/euaHover.png")));
		} else if (arg1.getSource() == bImgEspa) {
			bImgEspa.setIcon(new ImageIcon(getClass().getResource(
					"imgs/esHover.png")));
		}

		if (arg1.getSource() == bLogof) {
			bLogof.setBounds(1230, 20, 110, 27);
		}

		repaint();
	}

	public void mouseExited(MouseEvent arg2) {
		if (arg2.getSource() == bImgBra) {
			bImgBra.setIcon(new ImageIcon(getClass().getResource("imgs/br.png")));
		} else if (arg2.getSource() == bImgUsa) {
			bImgUsa.setIcon(new ImageIcon(getClass()
					.getResource("imgs/eua.png")));
		} else if (arg2.getSource() == bImgEspa) {
			bImgEspa.setIcon(new ImageIcon(getClass()
					.getResource("imgs/es.png")));
		}

		if (arg2.getSource() == bLogof) {
			bLogof.setBounds(1250, 20, 110, 27);
		}

		repaint();
	}

	public void mousePressed(MouseEvent arg3) {
		if (arg3.getSource() == bImgBra) {
			bImgBra.setIcon(new ImageIcon(getClass().getResource("imgs/br.png")));
		} else if (arg3.getSource() == bImgUsa) {
			bImgUsa.setIcon(new ImageIcon(getClass()
					.getResource("imgs/eua.png")));
		} else if (arg3.getSource() == bImgEspa) {
			bImgEspa.setIcon(new ImageIcon(getClass()
					.getResource("imgs/es.png")));
		}

		if (arg3.getSource() == bLogof) {
			bLogof.setBounds(1250, 20, 110, 27);
		}
		repaint();
	}

	public void mouseReleased(MouseEvent arg4) {
		if (arg4.getSource() == bImgBra) {
			bImgBra.setIcon(new ImageIcon(getClass().getResource(
					"imgs/brHover.png")));
		} else if (arg4.getSource() == bImgUsa) {
			bImgUsa.setIcon(new ImageIcon(getClass().getResource(
					"imgs/euaHover.png")));
		} else if (arg4.getSource() == bImgEspa) {
			bImgEspa.setIcon(new ImageIcon(getClass().getResource(
					"imgs/esHover.png")));
		}

		if (arg4.getSource() == bLogof) {
			bLogof.setBounds(1230, 20, 110, 27);
		}
		repaint();
	}
}
