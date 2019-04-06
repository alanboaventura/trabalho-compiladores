package br.trabalhocompiladores.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import br.trabalhocompiladores.utils.NumberedBorder;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1943732405160942512L;
	private boolean arquivoNovo = true;
	private JTextArea editor;
	private JTextArea message;
	private JTextField status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setTitle("Trabalho Compiladores - 2019/1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setMinimumSize(new Dimension(900, 600));
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollEditor = new JScrollPane();
		scrollEditor.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollEditor.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		editor = new JTextArea();
		editor.setBorder(new NumberedBorder());
		scrollEditor.setViewportView(editor);
		contentPane.add(scrollEditor, BorderLayout.CENTER);

		JPanel panelStatus = new JPanel();
		contentPane.add(panelStatus, BorderLayout.SOUTH);
		GridBagLayout gbl_panelStatus = new GridBagLayout();
		gbl_panelStatus.columnWidths = new int[] { 900 };
		gbl_panelStatus.rowHeights = new int[] { 130 };
		gbl_panelStatus.columnWeights = new double[] { 1.0 };
		gbl_panelStatus.rowWeights = new double[] { 0.0, 0.0 };
		panelStatus.setLayout(gbl_panelStatus);

		JScrollPane scrollMensage = new JScrollPane();
		scrollMensage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollMensage.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		message = new JTextArea();
		message.setEditable(false);
		message.setFocusable(false);
		scrollMensage.setViewportView(message);
		GridBagConstraints gbc_scrollMensage = new GridBagConstraints();
		gbc_scrollMensage.fill = GridBagConstraints.BOTH;
		gbc_scrollMensage.gridx = 0;
		gbc_scrollMensage.gridy = 0;
		panelStatus.add(scrollMensage, gbc_scrollMensage);

		status = new JTextField();
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setBackground(Color.LIGHT_GRAY);
		status.setEditable(false);
		status.setFocusable(false);
		status.setColumns(10);
		GridBagConstraints gbc_status = new GridBagConstraints();
		gbc_status.anchor = GridBagConstraints.SOUTH;
		gbc_status.fill = GridBagConstraints.BOTH;
		gbc_status.gridx = 0;
		gbc_status.gridy = 1;
		panelStatus.add(status, gbc_status);

		JPanel panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));

		JPanel buttonPanel = new JPanel();
		panelTop.add(buttonPanel, BorderLayout.WEST);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 100, 100, 100, 100, 100, 100, 100, 100 };
		gbl_buttonPanel.rowHeights = new int[] { 70 };
		buttonPanel.setLayout(gbl_buttonPanel);

		JButton btnNew = new JButton("Novo [ctrl-n]");
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.insets = new Insets(0, 5, 0, 1);
		gbc_btnNew.fill = GridBagConstraints.BOTH;
		gbc_btnNew.gridx = 0;
		gbc_btnNew.gridy = 0;
		buttonPanel.add(btnNew, gbc_btnNew);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newFile();
			}
		});
		btnNew.setFocusable(false);
		btnNew.setIcon(new ImageIcon(getClass().getResource("/br/trabalhocompiladores/icons/new-file.png")));
		btnNew.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNew.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnOpenFile = new JButton("Abrir [ctrl-o]");
		GridBagConstraints gbc_btnOpen = new GridBagConstraints();
		gbc_btnOpen.insets = new Insets(0, 0, 0, 1);
		gbc_btnOpen.fill = GridBagConstraints.BOTH;
		gbc_btnOpen.gridx = 1;
		gbc_btnOpen.gridy = 0;
		buttonPanel.add(btnOpenFile, gbc_btnOpen);
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		
		btnOpenFile.setFocusable(false);
		btnOpenFile.setIcon(new ImageIcon(getClass().getResource("/br/trabalhocompiladores/icons/open-file.png")));
		btnOpenFile.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOpenFile.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnSave = new JButton("Salvar [ctrl-s]");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 1);
		gbc_btnSave.fill = GridBagConstraints.BOTH;
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 0;
		buttonPanel.add(btnSave, gbc_btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		btnSave.setFocusable(false);
		btnSave.setIcon(new ImageIcon(getClass().getResource("/br/trabalhocompiladores/icons/save.png")));
		btnSave.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSave.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnCopy = new JButton("Copiar [ctrl-c]");
		GridBagConstraints gbc_btnCopy = new GridBagConstraints();
		gbc_btnCopy.insets = new Insets(0, 0, 0, 1);
		gbc_btnCopy.fill = GridBagConstraints.BOTH;
		gbc_btnCopy.gridx = 3;
		gbc_btnCopy.gridy = 0;
		buttonPanel.add(btnCopy, gbc_btnCopy);
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy();
			}
		});
		btnCopy.setFocusable(false);
		btnCopy.setIcon(new ImageIcon(getClass().getResource("/br/trabalhocompiladores/icons/copy.png")));
		btnCopy.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCopy.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnPaste = new JButton("Colar [ctrl-v]");
		GridBagConstraints gbc_btnPaste = new GridBagConstraints();
		gbc_btnPaste.insets = new Insets(0, 0, 0, 1);
		gbc_btnPaste.fill = GridBagConstraints.BOTH;
		gbc_btnPaste.gridx = 4;
		gbc_btnPaste.gridy = 0;
		buttonPanel.add(btnPaste, gbc_btnPaste);
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paste();
			}
		});
		btnPaste.setFocusable(false);
		btnPaste.setIcon(new ImageIcon(getClass().getResource("/br/trabalhocompiladores/icons/paste.png")));
		btnPaste.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPaste.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnCut = new JButton("Recortar [ctrl-x]");
		GridBagConstraints gbc_btnCut = new GridBagConstraints();
		gbc_btnCut.insets = new Insets(0, 0, 0, 1);
		gbc_btnCut.fill = GridBagConstraints.BOTH;
		gbc_btnCut.gridx = 5;
		gbc_btnCut.gridy = 0;
		buttonPanel.add(btnCut, gbc_btnCut);
		btnCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cut();
			}
		});
		btnCut.setFocusable(false);
		btnCut.setIcon(new ImageIcon(getClass().getResource("/br/trabalhocompiladores/icons/cut.png")));
		btnCut.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCut.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnCompile = new JButton("Compilar [F9]");
		GridBagConstraints gbc_btnCompile = new GridBagConstraints();
		gbc_btnCompile.insets = new Insets(0, 0, 0, 1);
		gbc_btnCompile.fill = GridBagConstraints.BOTH;
		gbc_btnCompile.gridx = 6;
		gbc_btnCompile.gridy = 0;
		buttonPanel.add(btnCompile, gbc_btnCompile);
		btnCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compile();
			}
		});
		btnCompile.setFocusable(false);
		btnCompile.setIcon(new ImageIcon(getClass().getResource("/br/trabalhocompiladores/icons/play.png")));
		btnCompile.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCompile.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton btnTeam = new JButton("Equipe [F1]");
		GridBagConstraints gbc_btnTeam = new GridBagConstraints();
		gbc_btnTeam.insets = new Insets(0, 0, 0, 1);
		gbc_btnTeam.fill = GridBagConstraints.BOTH;
		gbc_btnTeam.gridx = 7;
		gbc_btnTeam.gridy = 0;
		buttonPanel.add(btnTeam, gbc_btnTeam);
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTeamName();
			}
		});
		btnTeam.setFocusable(false);
		btnTeam.setIcon(new ImageIcon(getClass().getResource("/br/trabalhocompiladores/icons/team.png")));
		btnTeam.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTeam.setHorizontalTextPosition(SwingConstants.CENTER);
		
		/*
		 *  Key listners.
		 */
		editor.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
			    if ((evt.getKeyCode() == KeyEvent.VK_N) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    newFile();
                }
			    if ((evt.getKeyCode() == KeyEvent.VK_O) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    openFile();
                }
			    if ((evt.getKeyCode() == KeyEvent.VK_S) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    saveFile();
                }
			    if ((evt.getKeyCode() == KeyEvent.VK_C) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    copy();
                }
			    if ((evt.getKeyCode() == KeyEvent.VK_V) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    paste();
                }
			    if ((evt.getKeyCode() == KeyEvent.VK_X) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    cut();
                }
				if (evt.getKeyCode() == KeyEvent.VK_F9) {
					compile();
				}
				if (evt.getKeyCode() == KeyEvent.VK_F1) {
					printTeamName();
				}
			}
		});
	}
	
	/*
	 * Operações dos botões.
	 */
	
	private void newFile() {
		limparCampos();
		arquivoNovo = true;
	}
	
	private void openFile() {
		String error = "";
		try {
			error = "abrir a seleção de arquivos";
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Escolha o arquivo...");
			fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
			fileChooser.setApproveButtonText("OK");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int result = fileChooser.showOpenDialog(fileChooser);

			if (result == JFileChooser.APPROVE_OPTION) {
				error = "limpar os campos";
				limparCampos();
				File arquivo = fileChooser.getSelectedFile();
				FileReader file = new FileReader(arquivo);
				BufferedReader buffer = new BufferedReader(file);

				String linha = buffer.readLine();
				String texto = "";

				while (linha != null) {
					if (editor.getText().isEmpty()) {
						texto += "\n";
					}
					texto += linha;
					linha = buffer.readLine();
				}

				status.setText(arquivo.getPath());
				editor.setText(texto);
				file.close();
			}
			
		} catch (Exception erro) {
			System.out.println(
					"Ocorreu o seguinte erro ao " + error + ". Mensagem de erro: " + erro.getMessage());
		}
	}
	
	private void saveFile() {
		String erroAo = "";
		if (arquivoNovo) {
			try {
				erroAo = "abrir a seleção de pastas";
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Salvando arquivo...");
				fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
				fileChooser.setApproveButtonText("OK");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int resultado = fileChooser.showOpenDialog(fileChooser);

				if (resultado == JFileChooser.APPROVE_OPTION) {
					erroAo = "criar um arquivo";
					File pasta = new File(fileChooser.getSelectedFile().getPath());

					erroAo = "adicionar as informações no arquivo";
					FileWriter arquivo = new FileWriter(pasta.getAbsolutePath() + ".txt");
					arquivo.write(editor.getText());
					arquivo.close();
					// PrintWriter pw = new PrintWriter(new BufferedWriter(arquivo));
				}
			} catch (Exception ex) {
				System.out.println(
						"Ocorreu o seguinte erro ao " + erroAo + ". Mensagem de erro: " + ex.getMessage());
			}
		}
	}
	
	private void copy() {
		StringSelection stringSelection = new StringSelection(editor.getSelectedText());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	
	private void paste() {
		try {
			String comando = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			editor.append(comando);
		} catch (HeadlessException | UnsupportedFlavorException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void cut() {
		StringSelection stringSelection = new StringSelection(editor.getSelectedText());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		String texto = editor.getText().substring(0, editor.getSelectionStart());
		texto += editor.getText().substring(editor.getSelectionEnd(), editor.getText().length());
		editor.setText(texto);
	}
	
	private void compile() {
		message.setText("");
		message.setText("Compilação de programas ainda não foi implementada");
	}
	
	private void printTeamName() {
		message.setText("");
		message.setText("Desenvolvedores do compilador\n - Alan Boaventura\n - Gabriel Castellani\n - Gabriel de Souza");
	}

	private void limparCampos() {
		editor.setText("");
		message.setText("");
		status.setText("");
	}
}