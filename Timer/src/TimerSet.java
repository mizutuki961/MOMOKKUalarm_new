import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */

/**
 * @author 0H03015 ñkêÏêÖåé
 *
 */
public class TimerSet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField DlgTextField;
	public boolean OkFlag=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TimerSet dialog = new TimerSet();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TimerSet() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel DlgLabel = new JLabel("\u6642\u9593\u3092\u8A2D\u5B9A\u3057\u3066\u304F\u3060\u3055\u3044");
			DlgLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 44));
			contentPanel.add(DlgLabel);
		}
		{
			JLabel DlgLabel_2 = new JLabel("00:00:00(\u534A\u89D2)\u3067\u8A2D\u5B9A\u3057\u3066\u304F\u3060\u3055\u3044");
			DlgLabel_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 30));
			contentPanel.add(DlgLabel_2);
		}
		{
			DlgTextField = new JTextField();
			DlgTextField.setFont(new Font("MS UI Gothic", Font.PLAIN, 40));
			contentPanel.add(DlgTextField);
			DlgTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						OkFlag=true;
						setVisible(false);
					}
				});
				okButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						OkFlag=false;
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
