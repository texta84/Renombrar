package com.texta84.ui;

import com.texta84.model.ColorButton;

/**
 *
 * @texta84
 */
public class UI_Principal extends javax.swing.JFrame {

    public UI_Principal() {
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBoxCopy = new javax.swing.JCheckBox();
        jCheckBoxFolder = new javax.swing.JCheckBox();
        jButtonSearch = new ColorButton(new java.awt.Color(60, 63, 65), new java.awt.Color(80, 83, 85));
        jButtonReplace = new ColorButton(new java.awt.Color(60, 63, 65), new java.awt.Color(80, 83, 85));
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldReplace = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(60, 63, 65));

        jPanel3.setBackground(new java.awt.Color(60, 63, 65));

        jPanel1.setBackground(new java.awt.Color(60, 63, 65));

        jScrollPane.setBackground(new java.awt.Color(60, 63, 65));
        jScrollPane.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 120, 215)));

        jTable.setBackground(new java.awt.Color(60, 63, 65));
        jTable.setForeground(java.awt.Color.white);
        jTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "LISTA DE ARCHIVOS"
                }
        ));
        jTable.setShowHorizontalLines(false);
        jTable.setShowVerticalLines(false);
        jScrollPane.setViewportView(jTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(60, 63, 65));
        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[]{0};
        jPanel4Layout.rowHeights = new int[]{0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel4.setLayout(jPanel4Layout);

        jPanel2.setBackground(new java.awt.Color(60, 63, 65));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jCheckBoxCopy.setBackground(new java.awt.Color(60, 63, 65));
        jCheckBoxCopy.setForeground(java.awt.Color.white);
        jCheckBoxCopy.setText("COPIAR");
        jCheckBoxCopy.setFocusPainted(false);
        jPanel2.add(jCheckBoxCopy);

        jCheckBoxFolder.setBackground(new java.awt.Color(60, 63, 65));
        jCheckBoxFolder.setForeground(java.awt.Color.white);
        jCheckBoxFolder.setText("CARPETAS");
        jCheckBoxFolder.setFocusPainted(false);
        jCheckBoxFolder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jCheckBoxFolder.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jCheckBoxFolder);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jPanel2, gridBagConstraints);

        jButtonSearch.setBackground(new java.awt.Color(60, 63, 65));
        jButtonSearch.setForeground(java.awt.Color.white);
        jButtonSearch.setMnemonic('B');
        jButtonSearch.setText("BUSCAR");
        jButtonSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.SystemColor.textHighlight));
        jButtonSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonSearch.setFocusPainted(false);
        jButtonSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSearch.setPreferredSize(new java.awt.Dimension(40, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jButtonSearch, gridBagConstraints);

        jButtonReplace.setBackground(new java.awt.Color(60, 63, 65));
        jButtonReplace.setForeground(java.awt.Color.white);
        jButtonReplace.setMnemonic('R');
        jButtonReplace.setToolTipText("");
        jButtonReplace.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.SystemColor.textHighlight));
        jButtonReplace.setFocusPainted(false);
        jButtonReplace.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonReplace.setMaximumSize(new java.awt.Dimension(89, 25));
        jButtonReplace.setMinimumSize(new java.awt.Dimension(89, 25));
        jButtonReplace.setPreferredSize(new java.awt.Dimension(40, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jButtonReplace, gridBagConstraints);

        jLabel1.setBackground(new java.awt.Color(60, 63, 65));
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("BUSCAR:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jLabel1, gridBagConstraints);

        jTextFieldSearch.setBackground(new java.awt.Color(60, 63, 65));
        jTextFieldSearch.setForeground(java.awt.Color.white);
        jTextFieldSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSearch.setToolTipText("");
        jTextFieldSearch.setCaretColor(java.awt.Color.white);
        jTextFieldSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextFieldSearch.setPreferredSize(new java.awt.Dimension(4, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jTextFieldSearch, gridBagConstraints);

        jLabel2.setBackground(new java.awt.Color(60, 63, 65));
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("REEMPLAZAR:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jLabel2, gridBagConstraints);

        jTextFieldReplace.setBackground(new java.awt.Color(60, 63, 65));
        jTextFieldReplace.setForeground(java.awt.Color.white);
        jTextFieldReplace.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldReplace.setCaretColor(java.awt.Color.white);
        jTextFieldReplace.setPreferredSize(new java.awt.Dimension(4, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jTextFieldReplace, gridBagConstraints);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public javax.swing.JButton jButtonSearch;
    public javax.swing.JButton jButtonReplace;
    public javax.swing.JCheckBox jCheckBoxFolder;
    public javax.swing.JCheckBox jCheckBoxCopy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane;
    public javax.swing.JTable jTable;
    public javax.swing.JTextField jTextFieldSearch;
    public javax.swing.JTextField jTextFieldReplace;
}