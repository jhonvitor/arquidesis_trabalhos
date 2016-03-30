package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.LoginControl;

public class ViewLogin extends JFrame implements ActionListener, MouseListener,
		KeyListener {

	private static final long serialVersionUID = 1L;
	private JFrame janela;
	private JPanel caixa;
	private ImageIcon img, img2, img3, img4, img5;
	private JButton bSair, bMinimize, blogin, bImgBra, bImgUsa, bImgEspa;
	private JLabel ltitle, limg, limgicon, lerro, llogin, lsenha, lusuario;
	private JTextField tlogin;
	private JPasswordField tsenha;
	private JComboBox<String> cbusuario;
	private String opcao[];
	private String language;
	private String pais;
	private ResourceBundle rb = null;

	// Metodo para INTERNACIONALIZACAO
	public void escolhaIdioma(String lingua, String pais) {
		language = lingua;
		this.pais = pais;
		Locale.setDefault(new Locale(lingua, pais));
		Locale locale = Locale.getDefault();
		rb = ResourceBundle.getBundle("properties.Login", locale);

		ltitle.setText(rb.getString("ptelaLogin.label.titulo"));
		lerro.setText(rb.getString("ptelaLogin.label.erro"));
		llogin.setText(rb.getString("ptelaLogin.label.login"));
		lsenha.setText(rb.getString("ptelaLogin.label.senha"));
		lusuario.setText(rb.getString("ptelaLogin.label.usuario"));

		if (lingua.equals("pt")) {
			opcao = new String[] { " Selecione uma opção", " Aluno",
					" Atendente", " Administrador" };
			setComboBox();

		} else if (lingua.equals("en")) {
			opcao = new String[] { " Select an option", " Student",
					" Attendant", " Administrator" };
			setComboBox();

		} else if (lingua.equals("es")) {
			opcao = new String[] { " Seleccione una opción", " Estudiante",
					" Attendant", " Administrator" };
			setComboBox();
		}
	}

	public void setComboBox() {

		caixa.remove(cbusuario);
		cbusuario = new JComboBox<String>(opcao);
		cbusuario.setBounds(140, 200, 170, 35);
		cbusuario.setBackground(new Color(255, 255, 255));
		cbusuario.addKeyListener(this);
		caixa.add(cbusuario);
		caixa.repaint();
	}

	public ViewLogin() {
		this("pt", "BR");
	}

	public ViewLogin(String lingua, String pais) {
		janela = new JFrame("Login");
		caixa = new JPanel(null);
		img = new ImageIcon(this.getClass().getResource("imgs/delete2.png"));
		img2 = new ImageIcon(this.getClass().getResource("imgs/login.png"));
		img3 = new ImageIcon(this.getClass().getResource("imgs/logar1.png"));
		img4 = new ImageIcon(this.getClass().getResource("imgs/cursoIcon.png"));
		img5 = new ImageIcon(this.getClass().getResource("imgs/minimize2.png"));
		bSair = new JButton(img);
		bMinimize = new JButton(img5);
		ltitle = new JLabel("Cursos Presenciais");
		lerro = new JLabel("Entre com os dados para login");
		limg = new JLabel(img2);
		limgicon = new JLabel(img4);
		llogin = new JLabel("Login:");
		lsenha = new JLabel("Senha:");
		lusuario = new JLabel("Usuário:");
		tsenha = new JPasswordField();
		blogin = new JButton(img3);
		bImgBra = new JButton();

		bImgBra.setIcon(new ImageIcon(getClass().getResource("imgs/br.png")));

		bImgUsa = new JButton();
		bImgUsa.setIcon(new ImageIcon(getClass().getResource("imgs/eua.png")));

		bImgEspa = new JButton();
		bImgEspa.setIcon(new ImageIcon(getClass().getResource("imgs/es.png")));

		tlogin = new JTextField() {
			private static final long serialVersionUID = 1L;
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};

		opcao = new String[] { " Selecione uma opção", " Aluno", " Atendente",
				" Administrador" };
		cbusuario = new JComboBox<String>(opcao);

		language = lingua;

		// ++ ESTILO ++//
		janela.setResizable(false);
		janela.setUndecorated(true);
		janela.setSize(400, 430);
		janela.setLocationRelativeTo(null);
		janela.setIconImage(new ImageIcon(getClass().getResource(
				"imgs/logo2.png")).getImage());
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		caixa.setBounds(0, 0, 400, 430);
		// altera cor de fundo (FRAME) para Cinza
		caixa.setBackground(Color.decode("#F0FFFF"));

		bSair.setBounds(367, 10, 22, 22);
		bSair.setFocusable(false);
		bSair.setBackground(new Color(238, 238, 238));
		bSair.setBorder(null);

		bMinimize.setBounds(335, 10, 22, 22);
		bMinimize.setFocusable(false);
		bMinimize.setBackground(new Color(238, 238, 238));
		bMinimize.setBorder(null);

		ltitle.setBounds(45, 0, 300, 40);
		ltitle.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 15));
		ltitle.setForeground(new Color(65, 105, 225));

		limgicon.setBounds(5, 5, 30, 30);

		limg.setBounds(25, 60, 50, 50);

		lerro.setBounds(110, 65, 400, 30);
		lerro.setFont(new Font("CordiaUPC", Font.BOLD, 15));
		lerro.setForeground(new Color(65, 105, 225));

		llogin.setBounds(60, 120, 80, 30);
		llogin.setFont(new Font("CordiaUPC", Font.PLAIN, 20));

		lsenha.setBounds(60, 160, 80, 30);
		lsenha.setFont(new Font("CordiaUPC", Font.PLAIN, 20));

		lusuario.setBounds(60, 200, 80, 30);
		lusuario.setFont(new Font("CordiaUPC", Font.PLAIN, 20));

		tlogin.setBounds(140, 120, 170, 35);
		tlogin.setBorder(BorderFactory
				.createLineBorder(new Color(255, 255, 255)));
		tlogin.setBorder(BorderFactory.createCompoundBorder(tlogin.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tlogin.setBackground(new Color(176, 196, 222));
		// tlogin.requestFocus();
		// tlogin.grabFocus();
		tlogin.addKeyListener(this);

		tsenha.setBounds(140, 160, 170, 35);
		tsenha.setEchoChar('*');
		tsenha.setBorder(BorderFactory
				.createLineBorder(new Color(255, 255, 255)));
		tsenha.setBorder(BorderFactory.createCompoundBorder(tsenha.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tsenha.setBackground(new Color(176, 196, 222));
		tsenha.addKeyListener(this);

		opcao = new String[] { " Selecione uma opção", " Aluno", " Atendente",
				" Administrador" };
		cbusuario = new JComboBox<String>(opcao);
		cbusuario.setBounds(140, 200, 170, 35);

		blogin.setBounds(205, 295, 100, 30);
		blogin.setBorder(null);

		// Botao icone Bandeira Brasil
		bImgBra.setBounds(20, 360, 60, 60);
		bImgBra.setToolTipText("Português");
		bImgBra.setBorderPainted(false);
		bImgBra.setContentAreaFilled(false);
		bImgBra.setFocusPainted(false);
		bImgBra.setOpaque(false);
		bImgBra.addMouseListener(this);

		// Botao icone Bandeira Estados Unidos
		bImgUsa.setBounds(80, 360, 60, 60);
		bImgUsa.setToolTipText("Inglês");
		bImgUsa.setBorderPainted(false);
		bImgUsa.setContentAreaFilled(false);
		bImgUsa.setFocusPainted(false);
		bImgUsa.setOpaque(false);
		bImgUsa.addMouseListener(this);

		// Botao icone Bandeira Espanha
		bImgEspa.setBounds(140, 360, 60, 60);
		bImgEspa.setToolTipText("Espanhol");
		bImgEspa.setBorderPainted(false);
		bImgEspa.setContentAreaFilled(false);
		bImgEspa.setFocusPainted(false);
		bImgEspa.setOpaque(false);
		bImgEspa.addMouseListener(this);

		// ADICIONANDO AO FRAME//
		janela.add(caixa);
		caixa.add(bSair);
		caixa.add(bMinimize);
		caixa.add(ltitle);
		caixa.add(lerro);
		caixa.add(limg);
		caixa.add(limgicon);
		caixa.add(llogin);
		caixa.add(lsenha);
		caixa.add(lusuario);
		caixa.add(tlogin);
		caixa.add(tsenha);
		caixa.add(cbusuario);
		caixa.add(blogin);
		caixa.add(bImgBra);
		caixa.add(bImgUsa);
		caixa.add(bImgEspa);

		// caixa.getRootPane().setDefaultButton(blogin);
		// blogin.requestFocus();

		// ADICIONANDO O ACTIONLISTENER//
		bSair.addActionListener(this);
		bSair.addMouseListener(this);
		bMinimize.addActionListener(this);
		bMinimize.addMouseListener(this);
		blogin.addActionListener(this);

		escolhaIdioma(lingua, pais);

	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == bSair) {
			System.exit(0);
		} else if (evt.getSource() == blogin) {
			setValidarLogin();
		} else if (evt.getSource() == bMinimize) {
			janela.setExtendedState(ICONIFIED);
		}
	}

	public static void vibrar(JFrame frame) {
		final int TAMANHO = 7;
		final int VELOCIDADE = 4;

		try {
			final int originalX = frame.getLocationOnScreen().x;
			final int originalY = frame.getLocationOnScreen().y;
			for (int i = 0; i < TAMANHO; i++) {
				Thread.sleep(10);
				frame.setLocation(originalX, originalY + VELOCIDADE);
				Thread.sleep(10);
				frame.setLocation(originalX, originalY - VELOCIDADE);
				Thread.sleep(10);
				frame.setLocation(originalX + VELOCIDADE, originalY);
				Thread.sleep(10);
				frame.setLocation(originalX, originalY);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == bImgBra) {
			escolhaIdioma("pt", "BR");
		} else if (arg0.getSource() == bImgUsa) {
			escolhaIdioma("en", "US");
		} else if (arg0.getSource() == bImgEspa) {
			escolhaIdioma("es", "ES");
		}
		repaint();
	}

	public void mouseEntered(MouseEvent arg1) {
		if (arg1.getSource() == bImgBra) {
			bImgBra.setIcon(new ImageIcon(getClass().getResource(
					"imgs/brHover.png")));
		} else if (arg1.getSource() == bImgEspa) {
			bImgEspa.setIcon(new ImageIcon(getClass().getResource(
					"imgs/esHover.png")));
		} else if (arg1.getSource() == bImgUsa) {
			bImgUsa.setIcon(new ImageIcon(getClass().getResource(
					"imgs/euaHover.png")));
		}

		if (arg1.getSource() == bSair) {
			bSair.setBounds(367, 15, 22, 22);

		} else if (arg1.getSource() == bMinimize) {
			bMinimize.setBounds(335, 15, 22, 22);
		}
		repaint();
	}

	public void mouseExited(MouseEvent arg2) {
		if (arg2.getSource() == bImgBra) {
			bImgBra.setIcon(new ImageIcon(getClass().getResource("imgs/br.png")));
		} else if (arg2.getSource() == bImgEspa) {
			bImgEspa.setIcon(new ImageIcon(getClass()
					.getResource("imgs/es.png")));
		} else if (arg2.getSource() == bImgUsa) {
			bImgUsa.setIcon(new ImageIcon(getClass()
					.getResource("imgs/eua.png")));
		}

		if (arg2.getSource() == bSair) {
			bSair.setBounds(367, 10, 22, 22);
			repaint();
		} else if (arg2.getSource() == bMinimize) {
			bMinimize.setBounds(335, 10, 22, 22);
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
		repaint();
	}

	public void keyPressed(KeyEvent arg5) {
		if (arg5.getKeyCode() == KeyEvent.VK_ENTER) {
			setValidarLogin();
		}

	}

	public void keyReleased(KeyEvent arg6) {
		if (arg6.getKeyCode() == KeyEvent.VK_ENTER) {
			setValidarLogin();
		}
	}

	public void keyTyped(KeyEvent arg7) {
		if (arg7.getKeyCode() == KeyEvent.VK_ENTER) {
			setValidarLogin();
		}
	}

	public void setValidarLogin() {

		String login = tlogin.getText();
		String password = new String(tsenha.getPassword());
		String user = "";

		if (cbusuario.getSelectedIndex() == 1) {
			user = "Aluno";
		} else if (cbusuario.getSelectedIndex() == 2) {
			user = "Atendente";
		} else if (cbusuario.getSelectedIndex() == 3) {
			user = "Administrador";
		}

		if (login.equals("") || password.equals("")) {

			if (language.equals("pt")) {
				lerro.setText("Dados incompletos");
			} else if (language.equals("es")) {
				lerro.setText("Datos incompletos");
			} else if (language.equals("en")) {
				lerro.setText("Incomplete dates");
			}

			lerro.setForeground(Color.red);

		} else {// valida login
			String l = null;
			try {
				l = new LoginControl().setUserLogin(login, password, user);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (l.equals("alu")) {
				janela.dispose();
				janela.setVisible(false);
				new ViewAluno(language, pais);
			} else if (l.equals("ate")) {
				janela.dispose();
				janela.setVisible(false);
				new ViewAtendente(language, pais);
			} else if (user.equals("Administrador")) {
				if (language.equals("pt")) {
					lerro.setText("Sistema ADM em Construção");
				} else if (language.equals("es")) {
					lerro.setText("Sistema ADM en construcción");
				} else if (language.equals("en")) {
					lerro.setText("ADM system under construction");
				}

				lerro.setForeground(Color.green);
			} else {

				if (language.equals("pt")) {
					lerro.setText("Acesso Negado");
				} else if (language.equals("es")) {
					lerro.setText("Acceso denegado");
				} else if (language.equals("en")) {
					lerro.setText("Access denied");
				}

				lerro.setForeground(Color.red);
				vibrar(janela);
			}
		}
	}

}