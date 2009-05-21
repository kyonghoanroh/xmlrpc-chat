/*
 * ChatForm2.java
 *
 * Created on 18 mai 2009, 19:17
 */
package client;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author  Admin
 */
public class ChatForm extends javax.swing.JFrame {

	/** Creates new form ChatForm2 */
	public ChatForm() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        uiMessages = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        uiMessage = new javax.swing.JTextArea();
        uiSend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        uiUsers = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ChatApplication.class).getContext().getResourceMap(ChatForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        uiMessages.setName("uiMessages"); // NOI18N
        jScrollPane1.setViewportView(uiMessages);

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        uiMessage.setColumns(20);
        uiMessage.setFont(resourceMap.getFont("uiMessage.font")); // NOI18N
        uiMessage.setRows(2);
        uiMessage.setName("uiMessage"); // NOI18N
        jScrollPane3.setViewportView(uiMessage);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(client.ChatApplication.class).getContext().getActionMap(ChatForm.class, this);
        uiSend.setAction(actionMap.get("sendMessage")); // NOI18N
        uiSend.setText(resourceMap.getString("uiSend.text")); // NOI18N
        uiSend.setName("uiSend"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        uiUsers.setName("uiUsers"); // NOI18N
        jScrollPane2.setViewportView(uiUsers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(uiSend, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(uiSend, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void close(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_close
	ChatApplication.getApplication().close();
}//GEN-LAST:event_close

	@Action
	public void sendMessage() {
		try {
            if(!uiMessage.getText().equals("")) {
                ChatApplication.getApplication().sendMessage(uiMessage.getText());
                uiMessage.setText("");
            }
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	public void setUsers(String[] users) {
		uiUsers.setListData(users);
	}

	public void setMessages(String[] messages) {
		if(model == null) {
			model = new DefaultListModel();
			uiMessages.setModel(model);
		}
		for(String s : messages) {
			model.addElement(s);
		}
		int lastIndex = uiMessages.getModel().getSize() - 1;
		if (lastIndex >= 0) {
			uiMessages.ensureIndexIsVisible(lastIndex);
		}
	}

	private DefaultListModel model = null;
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea uiMessage;
    private javax.swing.JList uiMessages;
    private javax.swing.JButton uiSend;
    private javax.swing.JList uiUsers;
    // End of variables declaration//GEN-END:variables
}
