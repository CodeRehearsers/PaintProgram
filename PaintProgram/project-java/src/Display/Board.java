package Display;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import Actions.Select.*;
import Actions.Unselect.UnselectAll;
import Actions.ActionHandler;
import Actions.Copy.Copy;
import Actions.Delete.Delete;
import Actions.Delete.MarkDelete;
import Actions.Draw.ButtonMouseAdapter;
import Actions.Move.Move;
import Actions.Paste.Paste;
import Actions.Resize.Resize;
import ShapesModeling.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class Board {
private static Board b=null;
	private JFrame frame;
	private DrawPanel drawPanel;

	public static Board getInstance()
	{
		if(b==null)
			b=new Board();
		 return b;
	}
	
	public void newScreen() {
		
			b=new Board();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					b = new Board();
					b.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Board() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1293, 593);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		drawPanel = new DrawPanel();
		drawPanel.setBounds(57, 29, 322, 192);
		frame.setContentPane(drawPanel);
		drawPanel.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 0, 0);
		drawPanel.add(btnNewButton);
		drawPanel.setBackground(Color.white);
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(0, 0, 0, 0);
		drawPanel.add(btnNewButton_1);
		ActionHandler actionHandler = new ActionHandler();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBorder(new TitledBorder(null, "Stroke Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 146, 207, 220);
		drawPanel.add(panel);
		panel.setLayout(null);

		JButton innerColor = new JButton("Fill Color");
		innerColor.setFont(new Font("Arial", Font.BOLD, 10));
		innerColor.setBounds(15, 19, 178, 21);
		panel.add(innerColor);
		innerColor.setBackground(new Color(245, 245, 245));

		JButton Colors = new JButton("Stroke Color");
		Colors.setFont(new Font("Arial", Font.BOLD, 9));
		Colors.setBounds(15, 50, 178, 21);
		panel.add(Colors);
		Colors.setBackground(SystemColor.text);

		JCheckBox isFilled = new JCheckBox("Fill Shape");
		isFilled.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				drawPanel.setIsFilled(((JCheckBox)e.getSource()).isSelected());
			}
		});
		isFilled.setFont(new Font("Arial", Font.BOLD, 10));
		isFilled.setBounds(19, 141, 91, 21);
		panel.add(isFilled);
		
		JButton cyanbutton = new JButton("");
		cyanbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPanel.setStrokeColor(Color.cyan);
			}
		});
		
		cyanbutton.setBackground(Color.cyan);
		cyanbutton.setBounds(63, 113, 33, 21);
		panel.add(cyanbutton);
		
		JButton yellowbutton = new JButton("");
		yellowbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPanel.setStrokeColor(Color.yellow);
			}
		});
		

		yellowbutton.setBackground(Color.YELLOW);
		yellowbutton.setBounds(159, 84, 33, 21);
		panel.add(yellowbutton);
		
		JButton whitebutton = new JButton("");
		whitebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPanel.setStrokeColor(Color.white);
			}
		});
		

		whitebutton.setBackground(Color.WHITE);
		whitebutton.setBounds(111, 142, 33, 21);
		panel.add(whitebutton);
		
		JButton graybutton = new JButton("");
		graybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPanel.setStrokeColor(Color.gray);
			}
		});
		

		graybutton.setBackground(Color.GRAY);
		graybutton.setBounds(160, 142, 33, 21);
		panel.add(graybutton);
		
		JButton darkredbutton = new JButton("");
		darkredbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPanel.setStrokeColor(Color.magenta);
			}
		});
		

		darkredbutton.setBackground(Color.MAGENTA);
		darkredbutton.setBounds(111, 84, 33, 21);
		panel.add(darkredbutton);
		
		JButton bluebutton = new JButton("");
		bluebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPanel.setStrokeColor(Color.blue);
			}
		});
		bluebutton.setBounds(111, 113, 33, 21);
		panel.add(bluebutton);
		
		
				bluebutton.setBackground(Color.BLUE);
				
				JButton pinkbutton = new JButton("");
				pinkbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						drawPanel.setStrokeColor(Color.pink);
					}
				});
				pinkbutton.setBounds(15, 113, 33, 21);
				panel.add(pinkbutton);
				pinkbutton.setIcon(new ImageIcon(""));
				
						pinkbutton.setBackground(Color.PINK);
						
						JButton orangebutton = new JButton("");
						orangebutton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								drawPanel.setStrokeColor(Color.orange);
							}
						});
						orangebutton.setBounds(160, 113, 33, 21);
						panel.add(orangebutton);
						orangebutton.setIcon(new ImageIcon(""));
						
								orangebutton.setBackground(Color.ORANGE);
								
								JButton redbutton = new JButton("");
								redbutton.setBounds(15, 84, 33, 21);
								panel.add(redbutton);
								
								
										redbutton.setForeground(Color.RED);
										redbutton.setBackground(new Color(255, 0, 0));
										
										JButton greenbutton = new JButton("");
										greenbutton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												drawPanel.setStrokeColor(Color.green);
											}
										});
										greenbutton.setBounds(63, 84, 33, 21);
										panel.add(greenbutton);
										
										
												greenbutton.setBackground(Color.GREEN);
												
												JSlider slider = new JSlider();
												slider.setValue(1);
												slider.setMinimum(1);
												slider.setMaximum(10);
												slider.addChangeListener(new ChangeListener() {
													public void stateChanged(ChangeEvent e) {
														drawPanel.setStrokeWidth(((JSlider)e.getSource()).getValue());
													}
												});
												slider.setBounds(15, 188, 182, 21);
												panel.add(slider);
												
												JLabel lblNewLabel_1 = new JLabel("Stroke width : ");
												lblNewLabel_1.setBounds(19, 169, 95, 13);
												panel.add(lblNewLabel_1);
										redbutton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												drawPanel.setStrokeColor(Color.red);
											}
										});
		Colors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPanel.setStrokeColor( JColorChooser.showDialog(drawPanel, "pick a color", Color.black));
				}
		});

		innerColor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				drawPanel.setFillColor( JColorChooser.showDialog(drawPanel, "pick a color", Color.black));
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 260, 2, 2);
		drawPanel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Actions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 368, 207, 183);
		drawPanel.add(panel_1);

		JButton SelectAll = new JButton("Select All");
		SelectAll.setFont(new Font("Arial", Font.BOLD, 10));
		SelectAll.setBounds(10, 24, 89, 21);
		panel_1.add(SelectAll);
		SelectAll.setBackground(new Color(245, 245, 245));

		JButton paste = new JButton("Paste");
		paste.setFont(new Font("Arial", Font.BOLD, 10));
		paste.setBounds(10, 55, 89, 21);
		panel_1.add(paste);
		paste.setBackground(SystemColor.inactiveCaptionBorder);

		JButton copy = new JButton("copy");
		copy.setFont(new Font("Arial", Font.BOLD, 10));
		copy.setBounds(105, 55, 89, 21);
		panel_1.add(copy);
		copy.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Copy copyAction;
				try {
					copyAction = new Copy(actionHandler, drawPanel);
				} catch (Exception e1) {
					
					e1.printStackTrace();
					return;
				}
				copyAction.init();
			}
		});
		paste.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Paste pasteAction;
				try {
					pasteAction = new Paste(actionHandler, drawPanel);
				} catch (Exception e1) {
					e1.printStackTrace();
					return;
				}
				pasteAction.init();
			}
		});
		copy.setBackground(SystemColor.inactiveCaptionBorder);

		JButton delete = new JButton("Mark Delete");
		delete.setFont(new Font("Arial", Font.BOLD, 10));
		delete.setBounds(10, 148, 100, 21);
		panel_1.add(delete);
		delete.setBackground(SystemColor.inactiveCaptionBorder);
		JButton unselect = new JButton("Unselect");
		unselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		unselect.setFont(new Font("Arial", Font.BOLD, 10));
		unselect.setBounds(105, 24, 89, 21);
		panel_1.add(unselect);
		unselect.setBackground(new Color(245, 245, 245));

		JButton move = new JButton("Move");
		move.setFont(new Font("Arial", Font.BOLD, 10));
		move.setBounds(10, 86, 89, 21);
		panel_1.add(move);
		move.setBackground(SystemColor.inactiveCaptionBorder);
		JButton Redo = new JButton("Redo");
		Redo.setFont(new Font("Arial", Font.BOLD, 10));
		Redo.setBounds(105, 117, 89, 21);
		panel_1.add(Redo);
		Redo.setBackground(SystemColor.inactiveCaptionBorder);

		JButton Undo = new JButton("Undo");
		Undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Undo.setFont(new Font("Arial", Font.BOLD, 10));
		Undo.setBounds(10, 117, 89, 21);
		panel_1.add(Undo);
		Undo.setBackground(SystemColor.inactiveCaptionBorder);
		JButton resize = new JButton("Resize");
		resize.setFont(new Font("Arial", Font.BOLD, 10));
		resize.setBounds(105, 86, 89, 21);
		panel_1.add(resize);
		resize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		resize.setBackground(SystemColor.inactiveCaptionBorder);
		
		JButton delete_1 = new JButton("Delete");
		delete_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Delete delete;
				try {
					delete = new Delete(actionHandler,drawPanel);
				} catch (Exception e1) {
					e1.printStackTrace();
					return;
				}
				try {
					delete.doAction();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		delete_1.setFont(new Font("Arial", Font.BOLD, 10));
		delete_1.setBackground(SystemColor.inactiveCaptionBorder);
		delete_1.setBounds(115, 148, 79, 21);
		panel_1.add(delete_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Shapes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 32, 207, 111);
		drawPanel.add(panel_3);

		JButton Square = new JButton("Square");
		Square.setFont(new Font("Arial", Font.BOLD, 10));
		Square.setBounds(12, 17, 93, 21);
		panel_3.add(Square);
		Square.setBackground(new Color(255, 255, 255));

		JButton Circle = new JButton("Circle");
		Circle.setFont(new Font("Arial", Font.BOLD, 10));
		Circle.setBounds(104, 17, 93, 21);
		panel_3.add(Circle);
		Circle.setBackground(new Color(255, 255, 255));

		JButton Triangle = new JButton("Triangle");
		Triangle.setFont(new Font("Arial", Font.BOLD, 10));
		Triangle.setBounds(12, 48, 93, 21);
		panel_3.add(Triangle);
		Triangle.setBackground(new Color(255, 255, 255));

		JButton Rectangle = new JButton("Rectangle");
		Rectangle.setFont(new Font("Arial", Font.BOLD, 10));
		Rectangle.setBounds(104, 48, 93, 21);
		panel_3.add(Rectangle);
		Rectangle.setBackground(new Color(255, 255, 255));

		JButton StraightLine = new JButton("StraightLine");
		StraightLine.setFont(new Font("Arial", Font.BOLD, 9));
		StraightLine.setBounds(12, 79, 185, 21);
		panel_3.add(StraightLine);
		StraightLine.setBackground(new Color(255, 255, 255));
		StraightLine.addMouseListener(new ButtonMouseAdapter(actionHandler, drawPanel,StraightLine.class));
		Rectangle.addMouseListener(new ButtonMouseAdapter(actionHandler, drawPanel, Rectangle.class));
		Triangle.addMouseListener(new ButtonMouseAdapter(actionHandler, drawPanel, Triangle.class));
		Circle.addMouseListener(new ButtonMouseAdapter(actionHandler, drawPanel, Circle.class));
		Square.addMouseListener(new ButtonMouseAdapter(actionHandler, drawPanel, Square.class));
		
		JLabel lblNewLabel = new JLabel("Painting Program");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(22, 10, 198, 23);
		drawPanel.add(lblNewLabel);
		resize.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Resize resizeAction;
				try {
					resizeAction = new Resize(actionHandler, drawPanel);
				} catch (Exception e2) {
					
					e2.printStackTrace();
					return;
				}
				try {
					resizeAction.doAction();
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
		});
		Undo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionHandler.undo();
			}
		});
		Redo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionHandler.redo();
			}
		});
		move.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Move moveAction;
				try {
					moveAction = new Move(actionHandler, drawPanel);
				} catch (Exception e2) {
					
					e2.printStackTrace();
					return;
				}
				try {
					moveAction.doAction();
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
		});
		unselect.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				UnselectAll unselectAction;
				try {
					unselectAction = new UnselectAll(actionHandler, drawPanel);
				} catch (Exception e2) {
					
					e2.printStackTrace();
					return;
				}
				unselectAction.init();
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MarkDelete deleteAction;
				try {
					deleteAction = new MarkDelete(actionHandler,drawPanel);
				} catch (Exception e1) {
					
					e1.printStackTrace();
					return;
				}
				try {
					deleteAction.init();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});

		SelectAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectAll selectorAction;
				try {
					selectorAction = new SelectAll(actionHandler, drawPanel);
				} catch (Exception e1) {
					
					e1.printStackTrace();
					return;
				}
				selectorAction.init();
			}
		});

	}

	
}
