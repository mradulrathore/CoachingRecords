
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * DisplayAll.java
 *
 * Created on Jan, 2018
 */
/**
 *
 * @author mradulrathore
 */
public class DisplayAll extends javax.swing.JFrame {

    Connection con;
    Statement st;
    ResultSet rs;

    /**
      * Creates new form DisplayAll
      */
    
    public DisplayAll() {
        initComponents();
        data();
    }

    void data() {
        try {
            Class.forName("java.sql.DriverManager");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/coachingc", "root", "admin123");
            st = (Statement) con.createStatement();
            String q = "select * from coaching;";
            rs = st.executeQuery(q);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Connection Time" + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tc = new javax.swing.JTable();
        disAll = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admission No.", "Student Name", "Father's Name", "Class", "Mobile No.", "Fees", "Subjects"
            }
        ));
        jScrollPane1.setViewportView(tc);

        disAll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        disAll.setText("Click Me for Display");
        disAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disAllActionPerformed(evt);
            }
        });

        backbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(disAll)
                        .addGap(60, 60, 60)
                        .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disAll, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void disAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disAllActionPerformed
        // coding for displaying all the records
        DefaultTableModel model = (DefaultTableModel) tc.getModel();
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
}//GEN-LAST:event_disAllActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // coding for opening record window
        this.setVisible(false);
        new records().setVisible(true);
}//GEN-LAST:event_backbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayAll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton disAll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tc;
    // End of variables declaration//GEN-END:variables

}
