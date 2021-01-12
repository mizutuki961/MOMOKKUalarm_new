import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;


public class TimerSet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public boolean OkFlag=false;
	public JSpinner Dlgspinner;

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
		setBounds(100, 100, 450, 174);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel DlgLabel = new JLabel("\u65E5\u6642\u3092\u8A2D\u5B9A\u3057\u3066\u304F\u3060\u3055\u3044");
			DlgLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 44));
			contentPanel.add(DlgLabel);
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
				okButton.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
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
				cancelButton.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			Dlgspinner = new JSpinner();
			Calendar calendar = Calendar.getInstance();
			Date initDate = calendar.getTime();
			getContentPane().add(Dlgspinner, BorderLayout.CENTER);
			Dlgspinner.setModel(new SpinnerDateModel(initDate,null, null, Calendar.DAY_OF_YEAR));
			Dlgspinner.setFont(new Font("MS UI Gothic", Font.BOLD, 40));
		}
	}

}
