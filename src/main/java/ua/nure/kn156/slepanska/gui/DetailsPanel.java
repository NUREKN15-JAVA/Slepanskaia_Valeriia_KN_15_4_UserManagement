package ua.nure.kn156.slepanska.gui;

/*import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JPanel;

import ua.nure.kn156.hondak.User;
import ua.nure.kn156.hondak.db.DatabaseException;
import ua.nure.kn156.hondak.gui.AddPanel;
import ua.nure.kn156.hondak.gui.MainFrame;
import ua.nure.kn156.hondak.util.Messages;

public class DetailsPanel extends AddPanel {

	private User user;
	private JButton backButton;

	public DetailsPanel(MainFrame mainFrame) {
		super(mainFrame);
		setName("DetailsPanel"); 
	}

	protected void doAction(ActionEvent e) throws ParseException {
        if ("ok".equalsIgnoreCase(e.getActionCommand())) {
            user.setFirstName(getFirstNameField().getText());
            user.setLastName(getLastNameField().getText());
            DateFormat format = DateFormat.getDateInstance();           
        }
    }

    public void setUser(User user) {
        DateFormat format = DateFormat.getDateInstance();
        this.user = user;
        getFirstNameField().setText(user.getFirstName());
        getFirstNameField().setEditable(false);
        getLastNameField().setText(user.getLastName());
        getLastNameField().setEditable(false);
        getDateOfBirthField().setText(format.format(user.getDate()));
        getDateOfBirthField().setEditable(false);
    }
    
    private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText(Messages.getString("AddPanel.ok")); //$NON-NLS-1$
			okButton.setName("okButton"); //$NON-NLS-1$
			okButton.setActionCommand("ok"); //$NON-NLS-1$
			okButton.addActionListener(this);
		}
		return okButton;
	}
    
    protected JPanel getButtonPanel() {
		if (buttonPanel == null) {
            buttonPanel = new JPanel();
            buttonPanel.add(getOkButton(), null);
        }
        return buttonPanel;
	}
	
    
   
}
*/
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ua.nure.kn156.slepanska.User;
import ua.nure.kn156.slepanska.util.Messages;

/**
 * Panel for extra details about user
 * 
 * @author Valeriia
 *
 */
public class DetailsPanel extends JPanel implements ActionListener {

	private MainFrame parent;
	private JPanel buttonPanel;
	private JPanel fieldPanel;
	private JButton okButton;
	private JLabel dateOfBirthField;
	private JLabel lastNameField;
	private JLabel firstNameField;
	private User user;

	public DetailsPanel(MainFrame frame) {
		parent = frame;
		initialize();
	}

	private void initialize() {
		this.setName("detailsPanel"); //$NON-NLS-1$
		this.setLayout(new BorderLayout());
		this.add(getFieldPanel(), BorderLayout.NORTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
	}

	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getOkButton());
		}
		return buttonPanel;
	}

	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText(Messages.getString("AddPanel.ok")); //$NON-NLS-1$
			okButton.setName("okButton"); //$NON-NLS-1$
			okButton.setActionCommand("ok"); //$NON-NLS-1$
			okButton.addActionListener(this);
		}
		return okButton;
	}

	private JPanel getFieldPanel() {
		if (fieldPanel == null) {
			fieldPanel = new JPanel();
			fieldPanel.setLayout(new GridLayout(3, 2));
			addLabeledField(fieldPanel, Messages.getString("AddPanel.first_name"), getFirstNameField()); //$NON-NLS-1$
			addLabeledField(fieldPanel, Messages.getString("AddPanel.last_name"), getLastNameField()); //$NON-NLS-1$
			addLabeledField(fieldPanel, Messages.getString("AddPanel.date_of_birth"), getDateOfBirthField()); //$NON-NLS-1$
		}
		return fieldPanel;
	}

	private JLabel getDateOfBirthField() {
		if (dateOfBirthField == null) {
			dateOfBirthField = new JLabel();
			dateOfBirthField.setName("dateOfBirthField"); //$NON-NLS-1$
		}
		return dateOfBirthField;
	}

	private JLabel getLastNameField() {
		if (lastNameField == null) {
			lastNameField = new JLabel();
			lastNameField.setName("lastNameField"); //$NON-NLS-1$
		}
		return lastNameField;
	}

	private void addLabeledField(JPanel panel, String labelText, JLabel textField) {
		JLabel label = new JLabel(labelText);
		label.setLabelFor(textField);
		panel.add(label);
		panel.add(textField);

	}

	private JLabel getFirstNameField() {
		if (firstNameField == null) {
			firstNameField = new JLabel();
			firstNameField.setName("firstNameField"); //$NON-NLS-1$
		}
		return firstNameField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Messages.getString("DetailsPanel.0").equalsIgnoreCase(e.getActionCommand())) //$NON-NLS-1$
			this.setVisible(false);
		this.setVisible(false);
		parent.showBrowsePanel();
	}

	public void setUser(User user) {
		DateFormat format = DateFormat.getDateInstance();
		this.user = user;
		getFirstNameField().setText(user.getFirstName());
		getLastNameField().setText(user.getLastName());
		getDateOfBirthField().setText(format.format(user.getDateOfBirth()));
	}
}
