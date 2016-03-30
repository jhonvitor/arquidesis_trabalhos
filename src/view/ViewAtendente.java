package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import model.entidade.AlunoEntidade;
import model.entidade.CursoEntidade;

import com.toedter.calendar.JDateChooser;

import config.ValidarCpf;
import control.AtendenteControl;

public class ViewAtendente extends JFrame implements ActionListener,
		ItemListener, MouseListener, KeyListener, WindowListener {

	private static final long serialVersionUID = 1L;

	private JPanel caixa, caixa2, caixaAlu, caixaMat;
	private JRadioButton rbCurso, rbAluno, rbMatricula;
	private ButtonGroup radiogroup;
	private String opcao[];
	// JLabel Curso
	private JLabel lCod, lCurso, lDataIni, lDataAs, lHoraIni, lHoraAs,
			lQtdVaga, lValor, lMatEndNlab, lLivroEndSoft;
	// JLabel Aluno
	private JLabel lCodAlu, lNomeAlu, lEndAlu, lDataNascAlu, lEmailAlu, lRgAlu,
			lCpfAlu, lNumEndAlu, lComplemento, lTelRes, lTelCel;
	// Jlabel Matricula
	private JLabel lcodMat, lDataMat, lDataCancelamentoMat, lValorMat,
			lTipPgMat, lstatusMat, lCpfMat, lCursoMat, lCodCursoMat;
	// JTextField CURSO
	private JTextField tCod, tHoraIni, tHoraFin, tQtdVaga, tValor, tMatEndNlab,
			tLivroEndSoft, tCpfMat, tCursoMat, tCodCursoMat,
			tDataCancelamentoMat;
	// JTextField Aluno
	private JTextField tCodAlu, tNomeAlu, tEndAlu, tEmailAlu, tRgAlu, tCpfAlu,
			tNumEndAlu, tComplemento, tTelRes, tTelCel;
	// JTextFiel Matricula
	private JTextField tcodMat, tValorMat, tStatusPgMat, tstatusMat, tDataMat;
	private JComboBox<String> cbCurso;
	private JDateChooser dDataIni, dDataFin, dDataNascAlu;
	private JButton bLogof, bCadastrar, bAlterar, bLimpar, bDelEndCancel,
			bImgBra, bImgUsa, bImgEspa;
	private JMenuBar barra;
	private JMenu ajuda, idiomas, relatorio, arquivo;
	private JMenuItem manual, sobre, port, ingl, espa, pagina, config, senha;
	private final JTable tabela, tabelaAlu, tabelaMat, tabelaCurso;
	private JScrollPane scrollPane, scrollPaneAlu, scrollPaneMat,
			scrollPaneCurso;
	private ResourceBundle rb = null;
	private ImageIcon imgDisquete, lixeira, borracha, teclado;
	private String lingua, pais;

	private ViewTabelaAluno conteudoTabela;
	private ArrayList<AlunoEntidade> arAlu;

	private ViewTabelaCurso conteudoTabelaCurso;
	private ArrayList<CursoEntidade> arCur;

	// private String language;

	// Metodo para INTERNACIONALIZACAO
	public void escolhaIdioma(String lingua, String pais) {

		this.lingua = lingua;
		this.pais = pais;

		Locale.setDefault(new Locale(lingua, pais));
		Locale locale = Locale.getDefault();
		rb = ResourceBundle.getBundle("properties.Atendente", locale);

		// INTERNACIONALIZACAO RadioButton
		rbAluno.setText(rb.getString("ptelaAtendente.rbutton.aluno"));
		rbCurso.setText(rb.getString("ptelaAtendente.rbutton.curso"));
		rbMatricula.setText(rb.getString("ptelaAtendente.rbutton.matricula"));

		// INTERNACIONALIZACAO Panel Curso
		lCurso.setText(rb.getString("ptelaAtendente.label.curso"));
		lDataIni.setText(rb.getString("ptelaAtendente.label.data"));
		lDataAs.setText(rb.getString("ptelaAtendente.label.dataas"));
		lHoraIni.setText(rb.getString("ptelaAtendente.label.horario"));
		lHoraAs.setText(rb.getString("ptelaAtendente.label.horarioas"));
		lQtdVaga.setText(rb.getString("ptelaAtendente.label.qtdvagas"));
		lCod.setText(rb.getString("ptelaAtendente.label.codigocurso"));
		lValor.setText(rb.getString("ptelaAtendente.label.valor"));
		if (cbCurso.getSelectedItem().equals("Informática")) {
			lLivroEndSoft
					.setText(rb.getString("ptelaAtendente.label.software"));
			lMatEndNlab.setText(rb.getString("ptelaAtendente.label.numlab"));
		} else if (cbCurso.getSelectedItem().equals("Artes")) {
			lLivroEndSoft.setText(rb.getString("ptelaAtendente.label.livro"));
			lMatEndNlab.setText(rb.getString("ptelaAtendente.label.material"));
		}

		// INTERNACIONALIZACAO Painel Aluno
		lCodAlu.setText(rb.getString("ptelaAtendente.label.codigoaluno"));
		lNomeAlu.setText(rb.getString("ptelaAtendente.label.nome"));
		lEndAlu.setText(rb.getString("ptelaAtendente.label.endereco"));
		lDataNascAlu.setText(rb
				.getString("ptelaAtendente.label.datanascimento"));
		lEmailAlu.setText(rb.getString("ptelaAtendente.label.email"));
		lRgAlu.setText(rb.getString("ptelaAtendente.label.rg"));
		lCpfAlu.setText(rb.getString("ptelaAtendente.label.cpf"));
		lNumEndAlu.setText(rb.getString("ptelaAtendente.label.numero"));
		lComplemento.setText(rb.getString("ptelaAtendente.label.comlermento"));

		// INTERNACIONALIZACAO Panel Matricula
		lcodMat.setText(rb.getString("ptelaAtendente.label.matricula"));
		lDataMat.setText(rb.getString("ptelaAtendente.label.datamat"));
		lDataCancelamentoMat.setText(rb
				.getString("ptelaAtendente.label.datacancel"));
		lValorMat.setText(rb.getString("ptelaAtendente.label.valormat"));
		lTipPgMat.setText(rb.getString("ptelaAtendente.label.tipopg"));
		lstatusMat.setText(rb.getString("ptelaAtendente.label.statusmat"));
		lCpfMat.setText(rb.getString("ptelaAtendente.label.cpfalu"));
		lCursoMat.setText(rb.getString("ptelaAtendente.label.cursomat"));
		lCodCursoMat.setText(rb.getString("ptelaAtendente.label.codmat"));

		// INTERNACIONALIZACAO Botoes Laterais
		bCadastrar.setText(rb.getString("ptelaAtendente.button.cadastrar"));
		bAlterar.setText(rb.getString("ptelaAtendente.button.alterar"));
		if (rbMatricula.isSelected()) {
			bDelEndCancel.setText(rb
					.getString("ptelaAtendente.button.cancelar"));
		} else {
			bDelEndCancel.setText(rb.getString("ptelaAtendente.button.apagar"));
		}
		bLimpar.setText(rb.getString("ptelaAtendente.button.limpar"));

		// INTERNACIONALIZACAO Titulo
		setTitle(rb.getString("ptelaAtendente.title.titulo"));

		// INTERNACIONALIZACAO Menu
		arquivo.setText(rb.getString("ptelaAtendente.menu.arquivo"));
		ajuda.setText(rb.getString("ptelaAtendente.menu.ajuda"));
		idiomas.setText(rb.getString("ptelaAtendente.menu.idioma"));

		relatorio.setText(rb.getString("ptelaAtendente.menu.relatorio"));
		pagina.setText(rb.getString("ptelaAtendente.menu.gerarrelatorio"));
		config.setText(rb.getString("ptelaAtendente.menu.configrelatorio"));
		senha.setText(rb.getString("ptelaAtendente.menu.alterarsenha"));
		port.setText(rb.getString("ptelaAtendente.menu.portugues"));
		ingl.setText(rb.getString("ptelaAtendente.menu.ingles"));
		espa.setText(rb.getString("ptelaAtendente.menu.espanhol"));
		manual.setText(rb.getString("ptelaAtendente.menu.manual"));
		sobre.setText(rb.getString("ptelaAtendente.menu.sobre"));
	}

	// Metodo Construtor
	public ViewAtendente(String lingua, String pais) {
		super(
				".:: Acesso Atendente ::.     Sistema Integrado para Cursos Presenciais.");
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"imgs/Fundo.png"))));

		// Retira a Funcao do Botao fechar da janela
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		setLayout(null);

		// setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("imgs/logo2.png"))
				.getImage());
		setVisible(true);

		// Instancia o JPANEL CAIXA (PANEL CURSO)
		caixa = new JPanel(null);
		caixa.setBounds(50, 20, 1100, 640);
		caixa.setVisible(false);
		caixa.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		add(caixa);

		// Instancia o JPANEL CAIXA ALUNO
		caixaAlu = new JPanel(null);
		caixaAlu.setBounds(50, 20, 1100, 640);
		caixaAlu.setVisible(true);
		caixaAlu.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		add(caixaAlu);

		// INSTANIA O JPANEL CAIXA MATRICULA
		caixaMat = new JPanel(null);
		caixaMat.setBounds(50, 20, 1100, 640);
		caixaMat.setVisible(false);
		caixaMat.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		add(caixaMat);

		// Instancia o JPANEL CAIXA2 (PANEL RADIO BUTTON)
		caixa2 = new JPanel(null);
		caixa2.setBounds(80, 30, 900, 50);
		caixa2.setVisible(true);
		caixa2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		caixa2.setLayout(new FlowLayout(FlowLayout.CENTER));
		caixaAlu.add(caixa2);

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
		config = new JMenuItem("configurar Relatório");
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
		bLogof.setToolTipText("Português");
		bLogof.setBorderPainted(false);
		bLogof.setContentAreaFilled(false);
		bLogof.setFocusPainted(false);
		bLogof.setOpaque(false);
		bLogof.addMouseListener(this);
		add(bLogof);

		// Botao icone Bandeira Brasil
		bImgBra = new JButton();
		bImgBra.setBounds(1170, 610, 60, 60);
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
		bImgUsa.setBounds(1230, 610, 60, 60);
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
		bImgEspa.setBounds(1290, 610, 60, 60);
		bImgEspa.setIcon(new ImageIcon(getClass().getResource("imgs/es.png")));
		bImgEspa.setToolTipText("Espanhol");
		bImgEspa.setBorderPainted(false);
		bImgEspa.setContentAreaFilled(false);
		bImgEspa.setFocusPainted(false);
		bImgEspa.setOpaque(false);
		bImgEspa.addMouseListener(this);
		add(bImgEspa);

		// RadioButon
		rbAluno = new JRadioButton("Aluno     ", true);
		rbAluno.setFont(new Font("", Font.BOLD, 23));
		rbAluno.setFocusPainted(false);
		rbAluno.addItemListener(this);
		rbCurso = new JRadioButton("Curso     ", false);
		rbCurso.setFont(new Font("", Font.BOLD, 23));
		rbCurso.setFocusPainted(false);
		rbCurso.addItemListener(this);
		rbMatricula = new JRadioButton("Matrícula     ", false);
		rbMatricula.setFont(new Font("", Font.BOLD, 23));
		rbMatricula.setFocusPainted(false);
		rbMatricula.addItemListener(this);

		radiogroup = new ButtonGroup();

		radiogroup.add(rbAluno);
		radiogroup.add(rbCurso);
		radiogroup.add(rbMatricula);

		caixa2.add(rbAluno);
		caixa2.add(rbCurso);
		caixa2.add(rbMatricula);

		// ##########################################
		// # Inserindo os elementos no JPANEL CAIXA #
		// ##########################################

		// JLabel e JTextField CURSO
		lCurso = new JLabel();
		lCurso.setText("Curso:");
		lCurso.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCurso.setBounds(85, 85, 80, 50);
		caixa.add(lCurso);

		opcao = new String[] { "Artes", "Informática" };
		cbCurso = new JComboBox<String>(opcao);
		cbCurso.setBounds(190, 95, 315, 25);
		caixa.add(cbCurso);

		// JLabel e JTextField DATA
		lDataIni = new JLabel();
		lDataIni.setText("Data:");
		lDataIni.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDataIni.setBounds(85, 135, 80, 50);
		caixa.add(lDataIni);

		dDataIni = new JDateChooser();
		dDataIni.setBounds(190, 145, 140, 25);
		caixa.add(dDataIni);

		lDataAs = new JLabel();
		lDataAs.setText("à");
		lDataAs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDataAs.setBounds(340, 135, 15, 50);
		caixa.add(lDataAs);

		dDataFin = new JDateChooser();
		dDataFin.setBounds(365, 145, 140, 25);
		caixa.add(dDataFin);

		// JLabel e JTextField HORARIO
		lHoraIni = new JLabel();
		lHoraIni.setText("Horário:");
		lHoraIni.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lHoraIni.setBounds(85, 185, 80, 50);
		caixa.add(lHoraIni);

		tHoraIni = new JTextField();
		tHoraIni.setBounds(190, 195, 140, 25);
		caixa.add(tHoraIni);

		lHoraAs = new JLabel();
		lHoraAs.setText("à");
		lHoraAs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lHoraAs.setBounds(340, 185, 15, 50);
		caixa.add(lHoraAs);

		tHoraFin = new JTextField();
		tHoraFin.setBounds(365, 195, 140, 25);
		caixa.add(tHoraFin);

		// JLabel e JTextField QUANTIDADE DE VAGAS
		lQtdVaga = new JLabel();
		lQtdVaga.setText("QTD. Vagas:");
		lQtdVaga.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lQtdVaga.setBounds(85, 235, 100, 50);
		caixa.add(lQtdVaga);

		tQtdVaga = new JTextField();
		tQtdVaga.setBounds(190, 245, 145, 25);
		caixa.add(tQtdVaga);

		// JLabel e JTextField CODIGO
		lCod = new JLabel();
		lCod.setText("Código:");
		lCod.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCod.setBounds(85, 285, 80, 50);
		caixa.add(lCod);

		tCod = new JTextField();
		tCod.setBounds(190, 295, 315, 25);
		tCod.setEditable(true);
		caixa.add(tCod);

		// JLabel e JTextField LIVROS
		lLivroEndSoft = new JLabel();
		lLivroEndSoft.setText("Livros:");
		lLivroEndSoft.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lLivroEndSoft.setBounds(570, 85, 80, 50);
		caixa.add(lLivroEndSoft);

		tLivroEndSoft = new JTextField();
		tLivroEndSoft.setBounds(650, 95, 315, 25);
		caixa.add(tLivroEndSoft);

		// JLabel e JTextField MATERIAL
		lMatEndNlab = new JLabel();
		lMatEndNlab.setText("Materiais:");
		lMatEndNlab.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lMatEndNlab.setBounds(570, 135, 120, 50);
		caixa.add(lMatEndNlab);

		tMatEndNlab = new JTextField();
		tMatEndNlab.setBounds(650, 145, 315, 25);
		caixa.add(tMatEndNlab);

		// JLabel e JTextField VALOR
		lValor = new JLabel();
		lValor.setText("Valor: R$");
		lValor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lValor.setBounds(570, 185, 80, 50);
		caixa.add(lValor);

		tValor = new JTextField();
		tValor.setBounds(650, 195, 145, 25);
		caixa.add(tValor);

		// instancia tabela
		tabela = new JTable();
		scrollPane = new JScrollPane();// Cria um scroll para a tabela

		tabela.setGridColor(Color.BLACK);
		tabela.setBorder(new LineBorder(Color.BLACK));
		tabela.setShowGrid(true);
		tabela.setSize(840, 800);

		scrollPane.getViewport().setVisible(true);
		scrollPane.getViewport().setBorder(null);
		scrollPane.setBounds(10, 350, 1080, 280);
		// caixa.add(scrollPane);
		scrollPane.getViewport().add(tabela);

		// Busca de Metodo para Carregar Tabela todos Alunos
		setCarregaTabelaAluno("all");

		tabelaCurso = new JTable();
		scrollPaneCurso = new JScrollPane();// Cria um scroll para a tabela

		tabelaCurso.setGridColor(Color.BLACK);
		tabelaCurso.setBorder(new LineBorder(Color.BLACK));
		tabelaCurso.setShowGrid(true);
		tabelaCurso.setSize(840, 800);

		scrollPaneCurso.getViewport().setVisible(true);
		scrollPaneCurso.getViewport().setBorder(null);
		scrollPaneCurso.setBounds(10, 350, 1080, 280);

		scrollPaneCurso.getViewport().add(tabelaCurso);
		caixa.add(scrollPaneCurso);

		// caixa.add(scrollPane);

		setCarregaTabelaCurso("all");

		// Evento do Mouse para tabela ITERATIVA
		tabela.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				// Aluno
				if (arAlu.size() > 0) {

					int row = tabela.rowAtPoint(evt.getPoint());
					AlunoEntidade al = new AlunoEntidade();
					int total = conteudoTabela.getRowCount();
					al = conteudoTabela.getAluno(row);
					if (row >= 0 && row < total) {
						tNomeAlu.setText("" + al.getNome());
						tEndAlu.setText(al.getEnd());
						tComplemento.setText(al.getComp());
						tNumEndAlu.setText(al.getNum());
						tEmailAlu.setText("" + al.getEmail());
						tTelRes.setText("" + al.getTelRes());
						tTelCel.setText("" + al.getTelCel());
						tRgAlu.setText("" + al.getRg());
						tCpfAlu.setText("" + al.getCpf());
						tCodAlu.setText("" + al.getCod());

						// converte data
						Date data = null;
						String dataTexto = new String(al.getDataNasc());
						SimpleDateFormat format = new SimpleDateFormat(
								"dd/MM/yyyy");

						format.setLenient(false);
						try {
							data = format.parse(dataTexto);
							dDataNascAlu.setDate(data);
						} catch (ParseException ex) {

							// mantem txt em branco
						}
						// fim conversao

					} else {
						JOptionPane.showMessageDialog(null, "Clicou fora");
					}
				}// fim if

			}// fim metodo
		});

		tabelaCurso.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (arCur.size() > 0) {

					int row = tabelaCurso.rowAtPoint(evt.getPoint());
					CursoEntidade cur = new CursoEntidade();
					int total = conteudoTabelaCurso.getRowCount();
					cur = conteudoTabelaCurso.getCurso(row);
					if (row >= 0 && row < total) {

						tCod.setText("" + cur.getCodgoCurso());
						tHoraIni.setText(cur.getHoraIni());
						tHoraFin.setText(cur.getHoraFim());
						tQtdVaga.setText("" + cur.getQdtVagas());
						tValor.setText("" + cur.getValor());
						tMatEndNlab.setText(cur.getMateriais());
						tLivroEndSoft.setText(cur.getLivros());

						if (cur.getCurso().equals("Informática")) {
							cbCurso.setSelectedIndex(0);
						} else {
							cbCurso.setSelectedIndex(1);
						}

						// converte data
						Date data = null, data1 = null;

						String dataTexto = new String(cur.getDataFim());
						String dataTexto1 = new String(cur.getDataIni());

						SimpleDateFormat format = new SimpleDateFormat(
								"dd/MM/yyyy");

						format.setLenient(false);
						try {
							data = format.parse(dataTexto);
							dDataFin.setDate(data);

							data1 = format.parse(dataTexto1);
							dDataIni.setDate(data1);
						} catch (ParseException ex) {

							// mantem txt em branco
						}
						// fim conversao

					} else {
						JOptionPane.showMessageDialog(null, "Clicou fora");
					}
				}
			}
		});

		// ##########################################
		// # Inserindo os elementos no JPANEL ALUNO #
		// ##########################################

		// JLabel e JTextField NOME ALUNO
		lNomeAlu = new JLabel();
		lNomeAlu.setText("Nome:");
		lNomeAlu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lNomeAlu.setBounds(85, 85, 80, 50);
		caixaAlu.add(lNomeAlu);

		tNomeAlu = new JTextField();
		tNomeAlu.setBounds(190, 95, 315, 25);
		caixaAlu.add(tNomeAlu);

		// JLabel e JTextField Endereco
		lEndAlu = new JLabel();
		lEndAlu.setText("Endereço:");
		lEndAlu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lEndAlu.setBounds(85, 135, 100, 50);
		caixaAlu.add(lEndAlu);

		tEndAlu = new JTextField();
		tEndAlu.setBounds(190, 145, 315, 25);
		caixaAlu.add(tEndAlu);

		// JLabel e JTextField Data Complemento
		lNumEndAlu = new JLabel();
		lNumEndAlu.setText("Número:");
		lNumEndAlu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lNumEndAlu.setBounds(85, 185, 80, 50);
		caixaAlu.add(lNumEndAlu);

		tNumEndAlu = new JTextField();
		tNumEndAlu.setBounds(190, 195, 60, 25);
		caixaAlu.add(tNumEndAlu);

		lComplemento = new JLabel();
		lComplemento.setText("Complemento:");
		lComplemento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lComplemento.setBounds(255, 185, 120, 50);
		caixaAlu.add(lComplemento);

		tComplemento = new JTextField();
		tComplemento.setBounds(360, 195, 145, 25);
		caixaAlu.add(tComplemento);

		// JLabel e JTextField Data Nascimento
		lDataNascAlu = new JLabel();
		lDataNascAlu.setText("Data Nasc.:");
		lDataNascAlu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDataNascAlu.setBounds(85, 235, 100, 50);
		caixaAlu.add(lDataNascAlu);

		dDataNascAlu = new JDateChooser();
		dDataNascAlu.setBounds(190, 245, 315, 25);
		caixaAlu.add(dDataNascAlu);

		// JLabel e JTextField CODIGO ALUNO
		lCodAlu = new JLabel();
		lCodAlu.setText("Código:");
		lCodAlu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCodAlu.setBounds(85, 285, 80, 50);
		caixaAlu.add(lCodAlu);

		tCodAlu = new JTextField();
		tCodAlu.setBounds(190, 295, 315, 25);
		tCodAlu.setEditable(false);
		caixaAlu.add(tCodAlu);

		// JLabel e JTextField E-MAIL
		lEmailAlu = new JLabel();
		lEmailAlu.setText("E-MAIL:");
		lEmailAlu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lEmailAlu.setBounds(570, 85, 80, 50);
		caixaAlu.add(lEmailAlu);

		tEmailAlu = new JTextField();
		tEmailAlu.setBounds(650, 95, 315, 25);
		caixaAlu.add(tEmailAlu);

		// JLabel e JTextField Tlefone Residencial
		lTelRes = new JLabel();
		lTelRes.setText("Tel. RES:");
		lTelRes.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lTelRes.setBounds(570, 135, 120, 50);
		caixaAlu.add(lTelRes);

		tTelRes = new JTextField();
		tTelRes.setBounds(650, 145, 315, 25);
		caixaAlu.add(tTelRes);

		// JLabel e JTextField Telefone Cel
		lTelCel = new JLabel();
		lTelCel.setText("Tel. CEL:");
		lTelCel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lTelCel.setBounds(570, 185, 80, 50);
		caixaAlu.add(lTelCel);

		tTelCel = new JTextField();
		tTelCel.setBounds(650, 195, 315, 25);
		caixaAlu.add(tTelCel);

		// JLabel e JTextField RG
		lRgAlu = new JLabel();
		lRgAlu.setText("RG:");
		lRgAlu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lRgAlu.setBounds(570, 235, 120, 50);
		caixaAlu.add(lRgAlu);

		tRgAlu = new JTextField();
		tRgAlu.setBounds(650, 245, 315, 25);
		caixaAlu.add(tRgAlu);

		// JLabel e JTextField CPF
		lCpfAlu = new JLabel();
		lCpfAlu.setText("CPF:");
		lCpfAlu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCpfAlu.setBounds(570, 285, 80, 50);
		caixaAlu.add(lCpfAlu);

		tCpfAlu = new JTextField() {
			private static final long serialVersionUID = 1L;

			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		tCpfAlu.addKeyListener(this);
		tCpfAlu.setBounds(650, 295, 315, 25);
		caixaAlu.add(tCpfAlu);

		// instancia tabela ALUNO
		tabelaAlu = new JTable();
		scrollPaneAlu = new JScrollPane();// Cria um scroll para a tabela

		tabelaAlu.setGridColor(Color.BLACK);
		tabelaAlu.setBorder(new LineBorder(Color.BLACK));
		tabelaAlu.setShowGrid(true);
		// tabelaAlu.setModel(); adiciona o obj na tabela
		tabelaAlu.setSize(840, 800);

		scrollPaneAlu.getViewport().setVisible(true);
		scrollPaneAlu.getViewport().setBorder(null);
		scrollPaneAlu.setBounds(10, 350, 1080, 280);
		caixaAlu.add(scrollPaneAlu);
		scrollPaneAlu.getViewport().add(tabela);

		// ##############################################
		// # Inserindo os elementos no JPANEL Matriucla #
		// ##############################################

		// JLabel e JTextField CODIGO ALUNO
		lcodMat = new JLabel();
		lcodMat.setText("Matrícula:");
		lcodMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lcodMat.setBounds(85, 85, 150, 50);
		caixaMat.add(lcodMat);

		tcodMat = new JTextField();
		tcodMat.setBounds(220, 95, 290, 25);
		tcodMat.setEditable(false);
		caixaMat.add(tcodMat);

		// JLabel e JTextField data matricula
		lDataMat = new JLabel();
		lDataMat.setText("Data Matrícula:");
		lDataMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDataMat.setBounds(85, 135, 150, 50);
		caixaMat.add(lDataMat);

		tDataMat = new JTextField();
		tDataMat.setBounds(220, 145, 290, 25);
		tDataMat.setEditable(false);
		caixaMat.add(tDataMat);

		// JLabel e JTextField valor
		lValorMat = new JLabel();
		lValorMat.setText("Valor Matrícula: R$");
		lValorMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lValorMat.setBounds(85, 185, 150, 50);
		caixaMat.add(lValorMat);

		tValorMat = new JTextField();
		tValorMat.setBounds(220, 195, 290, 25);
		caixaMat.add(tValorMat);

		// JLabel e JTextField Tipo Pagamento
		lTipPgMat = new JLabel();
		lTipPgMat.setText("Tipo Pagamento:");
		lTipPgMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lTipPgMat.setBounds(85, 235, 150, 50);
		caixaMat.add(lTipPgMat);

		tStatusPgMat = new JTextField();
		tStatusPgMat.setBounds(220, 245, 290, 25);
		caixaMat.add(tStatusPgMat);

		// JLabel e JTextField Cpf do Aluno
		lCpfMat = new JLabel();
		lCpfMat.setText("Cpf Aluno:");
		lCpfMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCpfMat.setBounds(570, 85, 150, 50);
		caixaMat.add(lCpfMat);

		tCpfMat = new JTextField();
		tCpfMat.setBounds(690, 95, 290, 25);
		caixaMat.add(tCpfMat);

		// JLabel e JTextField Curso Matricula
		lCursoMat = new JLabel();
		lCursoMat.setText("Curso:");
		lCursoMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCursoMat.setBounds(570, 135, 150, 50);
		caixaMat.add(lCursoMat);

		tCursoMat = new JTextField();
		tCursoMat.setBounds(690, 145, 100, 25);
		caixaMat.add(tCursoMat);

		lCodCursoMat = new JLabel();
		lCodCursoMat.setText("código:");
		lCodCursoMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCodCursoMat.setBounds(795, 135, 80, 50);
		caixaMat.add(lCodCursoMat);

		tCodCursoMat = new JTextField();
		tCodCursoMat.setBounds(850, 145, 130, 25);
		caixaMat.add(tCodCursoMat);

		// JLabel e JTextField Matricula
		lstatusMat = new JLabel();
		lstatusMat.setText("Status Matrícula:");
		lstatusMat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lstatusMat.setBounds(570, 185, 150, 50);
		caixaMat.add(lstatusMat);

		tstatusMat = new JTextField();
		tstatusMat.setBounds(690, 195, 290, 25);
		tstatusMat.setEditable(false);
		caixaMat.add(tstatusMat);

		// JLabel e JTextField data cancelamento matricula
		lDataCancelamentoMat = new JLabel();
		lDataCancelamentoMat.setText("Data Cancel.:");
		lDataCancelamentoMat
				.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDataCancelamentoMat.setBounds(570, 235, 150, 50);
		caixaMat.add(lDataCancelamentoMat);

		tDataCancelamentoMat = new JTextField();
		tDataCancelamentoMat.setBounds(690, 245, 290, 25);
		tDataCancelamentoMat.setEditable(false);
		caixaMat.add(tDataCancelamentoMat);

		// instancia tabela
		tabelaMat = new JTable();
		scrollPaneMat = new JScrollPane();// Cria um scroll para a tabela

		tabelaMat.setGridColor(Color.BLACK);
		tabelaMat.setBorder(new LineBorder(Color.BLACK));
		tabelaMat.setShowGrid(true);
		// tabela.setModel(conteudoTabela); adiciona o obj na tabela
		tabelaMat.setSize(840, 800);

		scrollPaneMat.getViewport().setVisible(true);
		scrollPaneMat.getViewport().setBorder(null);
		scrollPaneMat.setBounds(10, 350, 1080, 280);
		caixaMat.add(scrollPaneMat);
		scrollPane.getViewport().add(tabelaMat);

		// ###################
		// # Botoes Laterais #
		// ###################

		imgDisquete = new ImageIcon(this.getClass().getResource(
				"imgs/disq2.png"));
		bCadastrar = new JButton(imgDisquete);
		bCadastrar.setText("Cadastrar");
		bCadastrar.setBounds(1160, 150, 200, 60);
		bCadastrar.setFocusPainted(false);
		bCadastrar.addActionListener(this);
		add(bCadastrar);

		teclado = new ImageIcon(this.getClass()
				.getResource("imgs/teclado5.png"));
		bAlterar = new JButton(teclado);
		bAlterar.setText("Cadastrar");
		bAlterar.setBounds(1160, 240, 200, 60);
		bAlterar.setFocusPainted(false);
		bAlterar.addActionListener(this);
		add(bAlterar);

		lixeira = new ImageIcon(this.getClass().getResource("imgs/lixeira.png"));
		bDelEndCancel = new JButton(lixeira);
		bDelEndCancel.setText("Apagar");
		bDelEndCancel.setBounds(1160, 330, 200, 60);
		bDelEndCancel.setFocusPainted(false);
		bDelEndCancel.addActionListener(this);
		add(bDelEndCancel);

		borracha = new ImageIcon(this.getClass().getResource("imgs/erase.png"));
		bLimpar = new JButton(borracha);
		bLimpar.setText("Limpar");
		bLimpar.setBounds(1160, 420, 200, 60);
		bLimpar.setFocusPainted(false);
		bLimpar.addActionListener(this);
		add(bLimpar);

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

		// ACAO DO BOTAO CADASTRAR e ALTERAR(ALUNO)
		if (arg0.getSource() == bCadastrar || arg0.getSource() == bAlterar) {
			String opc = null;
			if (arg0.getSource() == bCadastrar) {
				opc = "CAD";
			} else {
				opc = "ALT";
			}

			if (rbAluno.isSelected()) {
				String dataNasc = "";
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				if (dDataNascAlu.getDate() != null) {
					dataNasc = sdf.format(dDataNascAlu.getDate());
				}

				// SELECIONA TODOS OS CAMPOS NAO PREENCHIDOS
				if (tNomeAlu.getText().toString().equals("")) {
					setBorderRed(tNomeAlu);
				} else {
					setBorderBlack(tNomeAlu);
				}
				if (tEndAlu.getText().toString().equals("")) {
					setBorderRed(tEndAlu);
				} else {
					setBorderBlack(tEndAlu);
				}
				if (tNumEndAlu.getText().toString().equals("")) {
					setBorderRed(tNumEndAlu);
				} else {
					setBorderBlack(tNumEndAlu);
				}
				if (tComplemento.getText().toString().equals("")) {
					setBorderRed(tComplemento);
				} else {
					setBorderBlack(tComplemento);
				}
				if (tEmailAlu.getText().toString().equals("")) {
					setBorderRed(tEmailAlu);
				} else {
					setBorderBlack(tEmailAlu);
				}
				if (tTelRes.getText().toString().equals("")) {
					setBorderRed(tTelRes);
				} else {
					setBorderBlack(tTelRes);
				}
				if (tTelCel.getText().toString().equals("")) {
					setBorderRed(tTelCel);
				} else {
					setBorderBlack(tTelCel);
				}
				if (tRgAlu.getText().toString().equals("")) {
					setBorderRed(tRgAlu);
				} else {
					setBorderBlack(tRgAlu);
				}
				if (tCpfAlu.getText().toString().equals("")) {
					setBorderRed(tCpfAlu);
				} else {
					setBorderBlack(tCpfAlu);
				}

				if (dataNasc.equals("")) {
					dDataNascAlu.setBorder(BorderFactory
							.createLineBorder(Color.RED));
					dDataNascAlu.setBorder(BorderFactory.createCompoundBorder(
							dDataNascAlu.getBorder(),
							BorderFactory.createEmptyBorder(5, 5, 5, 5)));
					dDataNascAlu.setBounds(190, 245, 315, 35);
				} else {
					dDataNascAlu.setBorder(null);
					dDataNascAlu.setBounds(190, 245, 315, 25);
				}

				if (tNomeAlu.getText().toString().equals("")
						|| tEndAlu.getText().toString().equals("")
						|| tNumEndAlu.getText().toString().equals("")
						|| tComplemento.getText().toString().equals("")
						|| tComplemento.getText().toString().equals("")
						|| tEmailAlu.getText().toString().equals("")
						|| tTelRes.getText().toString().equals("")
						|| tTelCel.getText().toString().equals("")
						|| tRgAlu.getText().toString().equals("")
						|| tCpfAlu.getText().toString().equals("")
						|| dataNasc.equals("")) {

					if (lingua.equals("pt")) {
						JOptionPane.showMessageDialog(null,
								"Preencha todos os campos selecionados",
								"WARNING", JOptionPane.WARNING_MESSAGE);
					} else if (lingua.equals("en")) {
						JOptionPane.showMessageDialog(null,
								"Fill in all selected fields", "WARNING",
								JOptionPane.WARNING_MESSAGE);
					} else if (lingua.equals("es")) {
						JOptionPane.showMessageDialog(null,
								"Rellene todos los campos seleccionados",
								"WARNING", JOptionPane.WARNING_MESSAGE);
					}

				} else {
					AtendenteControl at = new AtendenteControl();
					boolean cpfValido = ValidarCpf.isCPF(tCpfAlu.getText()
							.toString());

					String retorno = null;
					if (cpfValido) {
						try {
							if (opc.equals("CAD")) {
								retorno = at.setCadAluno(0, tNomeAlu.getText()
										.toString(), tEndAlu.getText()
										.toString(), tNumEndAlu.getText()
										.toString(), tComplemento.getText()
										.toString(), dataNasc, tEmailAlu
										.getText().toString(), tTelRes
										.getText().toString(), tTelCel
										.getText().toString(), tRgAlu.getText()
										.toString(), tCpfAlu.getText()
										.toString());
							} else if (opc.equals("ALT")) {
								retorno = at.setAlterarAluno(0, tNomeAlu
										.getText().toString(), tEndAlu
										.getText().toString(), tNumEndAlu
										.getText().toString(), tComplemento
										.getText().toString(), dataNasc,
										tEmailAlu.getText().toString(), tTelRes
												.getText().toString(), tTelCel
												.getText().toString(), tRgAlu
												.getText().toString(), tCpfAlu
												.getText().toString());

							}

						} catch (Exception e) {
							if (lingua.equals("pt")) {
								JOptionPane
										.showMessageDialog(
												null,
												"Erro de Conexão com o Banco de Dados\nContate seu Administrador",
												"ERROR",
												JOptionPane.ERROR_MESSAGE);
							} else if (lingua.equals("en")) {
								JOptionPane
										.showMessageDialog(
												null,
												"Connection error with the database\nContact your Administrator",
												"ERROR",
												JOptionPane.ERROR_MESSAGE);
							} else if (lingua.equals("es")) {
								JOptionPane
										.showMessageDialog(
												null,
												"Error de conexión con la base de datos\nPóngase en contacto con su Administrador",
												"ERROR",
												JOptionPane.ERROR_MESSAGE);
							}

						}
						if (!retorno.equals(null)) {
							if (!retorno.equals("") && !retorno.equals("ok")
									&& !retorno.equals("exist")) {
								JOptionPane.showMessageDialog(null, retorno,
										"ERROR", JOptionPane.ERROR_MESSAGE);
							} else if (retorno.equals("exist")
									&& lingua.equals("pt")) {
								JOptionPane
										.showMessageDialog(
												null,
												"Detectado cpf ja cadastrado no sistema",
												"ERROR",
												JOptionPane.ERROR_MESSAGE);
							} else if (retorno.equals("exist")
									&& lingua.equals("en")) {
								JOptionPane
										.showMessageDialog(
												null,
												"Detected cpf already registered in the system",
												"ERROR",
												JOptionPane.ERROR_MESSAGE);
							} else if (retorno.equals("exist")
									&& lingua.equals("es")) {
								JOptionPane
										.showMessageDialog(
												null,
												"Detectado cpf ya registrado en el sistema",
												"ERROR",
												JOptionPane.ERROR_MESSAGE);
							} else if (lingua.equals("pt")) {
								JOptionPane.showMessageDialog(null,
										"Operação Concluída", "MESSAGE",
										JOptionPane.PLAIN_MESSAGE);
								setCleam();
								setCarregaTabelaAluno("all");
							} else if (lingua.equals("en")) {
								JOptionPane.showMessageDialog(null,
										"Operation Completed", "MESSAGE",
										JOptionPane.PLAIN_MESSAGE);
								setCleam();
								setCarregaTabelaAluno("all");
							} else if (lingua.equals("es")) {
								JOptionPane.showMessageDialog(null,
										"Operación Completada", "MESSAGE",
										JOptionPane.PLAIN_MESSAGE);
								setCleam();
								setCarregaTabelaAluno("all");
							}
						}
					} else {
						if (lingua.equals("pt")) {
							JOptionPane.showMessageDialog(null,
									"Numero de CPF Invalido", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (lingua.equals("en")) {
							JOptionPane.showMessageDialog(null,
									"Number of ID Invalid", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (lingua.equals("es")) {
							JOptionPane.showMessageDialog(null,
									"Número de CPF no válido", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				}

			} else if (rbCurso.isSelected()) {
				AtendenteControl at = new AtendenteControl();
				boolean retorno;

				String dataIniCurso = "";
				String dataFimCurso = "";
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				// Alterando formato da data para dd/MM/yyyy tipo String
				if (dDataIni.getDate() != null) {
					dataIniCurso = sdf.format(dDataIni.getDate());
				}

				// Alterando formato da data para dd/MM/yyyy tipo String
				if (dDataFin.getDate() != null) {
					dataFimCurso = sdf.format(dDataFin.getDate());
				}

				int codigo = Integer.parseInt(tCod.getText().toString());
				int vagas = Integer.parseInt(tQtdVaga.getText().toString());
				double valor = Double.parseDouble(tValor.getText().toString());

				try {
					if (opc.equals("CAD")) {
						retorno = at.setCadCurso(0, cbCurso.getSelectedItem()
								.toString(), dataIniCurso, dataFimCurso,
								tHoraIni.getText().toString(), tHoraFin
										.getText().toString(), vagas,
								tLivroEndSoft.getText().toString(), tMatEndNlab
										.getText().toString(), valor);
						if (retorno) {
							JOptionPane.showMessageDialog(null,
									"Cadastrado com Sucesso");
						}

					} else if (opc.equals("ALT")) {
						retorno = at.setAlterarCurso(codigo, cbCurso
								.getSelectedItem().toString(), dataIniCurso,
								dataFimCurso, tHoraIni.getText().toString(),
								tHoraFin.getText().toString(), vagas,
								tLivroEndSoft.getText().toString(), tMatEndNlab
										.getText().toString(), valor);
						if (retorno) {
							JOptionPane.showMessageDialog(null,
									"Alterado com Sucesso");
						}
					}

				} catch (Exception e) {
					JOptionPane
							.showMessageDialog(
									null,
									"Erro de Conexão com o Banco de Dados\nContate seu Administrador",
									"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}

			// ACAO BOTAO LIMPAR
		} else if (arg0.getSource() == bLimpar) {
			setCleam();

			// Acao BOTAO DELETAR
		} else if (arg0.getSource() == bDelEndCancel) {
			if (rbAluno.isSelected()) {
				if (!tCpfAlu.getText().toString().equals("")) {

					boolean result = new AtendenteControl()
							.setDelAlunoCpf(tCpfAlu.getText().toString());
					setBorderBlack(tNomeAlu);
					setBorderBlack(tEndAlu);
					setBorderBlack(tNumEndAlu);
					setBorderBlack(tComplemento);
					setBorderBlack(tEmailAlu);
					setBorderBlack(tTelRes);
					setBorderBlack(tTelCel);
					setBorderBlack(tRgAlu);
					setBorderBlack(tCpfAlu);
					dDataNascAlu.setBorder(null);
					dDataNascAlu.setBounds(190, 245, 315, 25);
					if (result) {
						if (lingua.equals("pt")) {
							JOptionPane.showMessageDialog(null,
									"Aluno Deletado do Sistema com sucesso");
							setCarregaTabelaAluno("all");
						} else if (lingua.equals("en")) {
							JOptionPane.showMessageDialog(null,
									"Deleted student successfully System");
							setCarregaTabelaAluno("all");
						} else if (lingua.equals("es")) {
							JOptionPane
									.showMessageDialog(null,
											"Estudiante eliminado correctamente Sistema");
							setCarregaTabelaAluno("all");
						}

					} else {
						if (lingua.equals("pt")) {
							JOptionPane.showMessageDialog(null,
									"CPF Não foi encontrado no Banco de Dados");
							setCarregaTabelaAluno("all");
						} else if (lingua.equals("en")) {
							JOptionPane.showMessageDialog(null,
									"ID was not found in the database");
							setCarregaTabelaAluno("all");
						} else if (lingua.equals("es")) {
							JOptionPane.showMessageDialog(null,
									"CPF no se encontró en la base de datos");
							setCarregaTabelaAluno("all");
						}
					}
				} else {
					setBorderRed(tCpfAlu);
					setBorderBlack(tNomeAlu);
					setBorderBlack(tEndAlu);
					setBorderBlack(tNumEndAlu);
					setBorderBlack(tComplemento);
					setBorderBlack(tEmailAlu);
					setBorderBlack(tTelRes);
					setBorderBlack(tTelCel);
					setBorderBlack(tRgAlu);
					dDataNascAlu.setBorder(null);
					dDataNascAlu.setBounds(190, 245, 315, 25);
					if (lingua.equals("pt")) {
						JOptionPane.showMessageDialog(null,
								"Preencha todos os campos selecionados",
								"WARNING", JOptionPane.WARNING_MESSAGE);
					} else if (lingua.equals("en")) {
						JOptionPane.showMessageDialog(null,
								"Fill in all selected fields", "WARNING",
								JOptionPane.WARNING_MESSAGE);
					} else if (lingua.equals("es")) {
						JOptionPane.showMessageDialog(null,
								"Rellene todos los campos seleccionados",
								"WARNING", JOptionPane.WARNING_MESSAGE);
					}

				}

			} else if (rbCurso.isSelected()) {

				if (tCod.getText() != "") {
					int codigo = Integer.parseInt(tCod.getText());
					boolean result = new AtendenteControl().setDelCurso(codigo);

					if (result) {
						JOptionPane.showMessageDialog(null,
								"Deletado Com Sucesso");
					}
				}
			}
		}
	}

	public void setCleam() {
		tCodAlu.setText("");
		tNomeAlu.setText("");
		tEndAlu.setText("");
		tNumEndAlu.setText("");
		tComplemento.setText("");
		dDataNascAlu.setDate(null);
		tEmailAlu.setText("");
		tTelRes.setText("");
		tTelCel.setText("");
		tRgAlu.setText("");
		tCpfAlu.setText("");
		setCarregaTabelaAluno("all");
	}

	// Acao do Radio Button, realizando a troca do Jpanel
	public void itemStateChanged(ItemEvent evt) {

		if (evt.getSource() == rbAluno) {
			caixaAlu.setVisible(true);
			caixa.setVisible(false);
			caixaMat.setVisible(false);
			caixaAlu.add(caixa2);
			if (lingua.equals("pt")) {
				bDelEndCancel.setText("Apagar");
			} else if (lingua.equals("en")) {
				bDelEndCancel.setText("Delete");
			} else if (lingua.equals("es")) {
				bDelEndCancel.setText("Borrar");
			}
		} else if (evt.getSource() == rbCurso) {
			caixa.setVisible(true);
			caixaAlu.setVisible(false);
			caixaMat.setVisible(false);
			caixa.add(caixa2);
			if (lingua.equals("pt")) {
				bDelEndCancel.setText("Apagar");
			} else if (lingua.equals("en")) {
				bDelEndCancel.setText("Delete");
			} else if (lingua.equals("es")) {
				bDelEndCancel.setText("Borrar");
			}
		} else if (evt.getSource() == rbMatricula) {
			caixaMat.setVisible(true);
			caixaAlu.setVisible(false);
			caixa.setVisible(false);
			caixaMat.add(caixa2);
			if (lingua.equals("pt")) {
				bDelEndCancel.setText("Cancelar");
			} else if (lingua.equals("en")) {
				bDelEndCancel.setText("Cancel");
			} else if (lingua.equals("es")) {
				bDelEndCancel.setText("Cancelar");
			}
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

	public void keyPressed(KeyEvent arg5) {
	}

	public void keyReleased(KeyEvent arg6) {
		if (!tCpfAlu.getText().toString().equals("")) {

			// cria um ArrayList tipado, que recebe objeto de alunos
			arAlu = new ArrayList<AlunoEntidade>();
			arAlu = new AtendenteControl().setBuscAlunoCpf(tCpfAlu.getText()
					.toString());
			conteudoTabela = new ViewTabelaAluno(arAlu);
			tabela.setModel(conteudoTabela);
			tabela.repaint();

		} else {
			setCarregaTabelaAluno("all");
		}
		if (!tCod.getText().toString().equals("")) {

			// cria um ArrayList tipado, que recebe objeto de alunos
			arCur = new ArrayList<CursoEntidade>();
			arCur = new AtendenteControl().setBuscCursoCod(Integer
					.parseInt(tCod.getText()));
			conteudoTabelaCurso = new ViewTabelaCurso(arCur);
			tabelaCurso.setModel(conteudoTabelaCurso);
			tabelaCurso.repaint();

		} else {
			setCarregaTabelaAluno("all");
		}
	}

	public void keyTyped(KeyEvent arg7) {
	}

	// ALTERA AS BORDAS DOS TEXTFIELD PARA VERMELHO
	public void setBorderRed(JTextField val) {

		val.setBorder(BorderFactory.createLineBorder(Color.RED));
		val.setBorder(BorderFactory.createCompoundBorder(val.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}

	// RETORNA COR DAS BORDAS DOS TEXTFIELD PARA ORIGINAL
	public void setBorderBlack(JTextField val) {

		val.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		val.setBorder(BorderFactory.createCompoundBorder(val.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}

	// CAREEGA CONTEUDO DA TABELA
	public void setCarregaTabelaAluno(String tipo) {

		if (tipo.equals("all")) {
			// cria um ArrayList tipado, que recebe objeto de alunos
			arAlu = new ArrayList<AlunoEntidade>();
			arAlu = new AtendenteControl().setBuscAlunoAll();
			conteudoTabela = new ViewTabelaAluno(arAlu);
			tabela.setModel(conteudoTabela);
			tabela.repaint();
		}
	}

	public void setCarregaTabelaCurso(String tipo) {

		if (tipo.equals("all")) {
			// cria um ArrayList tipado, que recebe objeto de alunos
			arCur = new ArrayList<CursoEntidade>();
			arCur = new AtendenteControl().setBuscCursoAll();
			conteudoTabelaCurso = new ViewTabelaCurso(arCur);
			tabelaCurso.setModel(conteudoTabelaCurso);
			tabelaCurso.repaint();
		}
	}

	public void windowClosing(WindowEvent e) {
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

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}
}