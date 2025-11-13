package com.texta84.controller;

import com.texta84.model.Rename;
import com.texta84.ui.UI_Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author @texta84
 */
public class Replace {

    public UI_Principal uiPrincipal;
    private ArrayList<File> files;
    private ArrayList<File> selectedFiles;
    private String finalPath;

    public Replace() {
        this.uiPrincipal = new UI_Principal();
        initComponents();
        this.files = new ArrayList<>();
        this.selectedFiles = new ArrayList<>();
        this.finalPath = "";
        events();
    }

    private void initComponents() {
        this.uiPrincipal.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icono.png"))).getImage());
        this.uiPrincipal.setLocationRelativeTo(null);
        this.uiPrincipal.setTitle("RENOMBRAR ARCHIVOS - @texta84");
        this.uiPrincipal.jButtonReplace.setText("RENOMBRAR");
        this.uiPrincipal.jCheckBoxFolder.setVisible(false);
        Font font = new Font("Dialog", Font.BOLD, 12);
        this.uiPrincipal.jScrollPane.getViewport().setOpaque(false);
        this.uiPrincipal.jTable.getTableHeader().setBorder(javax.swing.BorderFactory.createEtchedBorder(null, null));
        this.uiPrincipal.jTable.getTableHeader().setBackground(new Color(60, 63, 65));
        this.uiPrincipal.jTable.getTableHeader().setForeground(new Color(187, 187, 187));
        this.uiPrincipal.jTable.getTableHeader().setFont(font);
    }

    private void events() {
        this.uiPrincipal.jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Replace.this.uiPrincipal.jTextFieldSearch.setText("");
                Replace.this.uiPrincipal.jTextFieldReplace.setText("");
                DefaultTableModel defaultTableModel = (DefaultTableModel) Replace.this.uiPrincipal.jTable.getModel();
                defaultTableModel.setRowCount(0);
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                jFileChooser.setMultiSelectionEnabled(true);
                int returnValue = jFileChooser.showOpenDialog(Replace.this.uiPrincipal);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    if (jFileChooser.getSelectedFile().isFile()) {
                        searchFile(jFileChooser, defaultTableModel);
                    } else if (jFileChooser.getSelectedFile().isDirectory()) {
                        if (Replace.this.uiPrincipal.jCheckBoxFolder.isSelected()) {
                            searchFolders(jFileChooser, defaultTableModel);
                        } else {
                            searchFiles(jFileChooser, defaultTableModel);
                        }
                    }
                } else {
                    System.out.println("SELECCIONASTE CANCELAR");
                }
                Replace.this.uiPrincipal.jTable.setModel(defaultTableModel);
            }
        });

        this.uiPrincipal.jButtonReplace.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rows = uiPrincipal.jTable.getSelectedRows();
                String separator = FileSystems.getDefault().getSeparator();
                String message;
                boolean cancel = true;
                if (Replace.this.uiPrincipal.jButtonReplace.getText().startsWith("<")) {
                    message = "COPIAR Y RENOMBRAR";
                } else {
                    message = Replace.this.uiPrincipal.jButtonReplace.getText();
                }
                int election = JOptionPane.showConfirmDialog(Replace.this.uiPrincipal, "¿DESEA " + message + "?", message + " BASE DE DATOS", JOptionPane.YES_NO_OPTION);
                if (election == 0) {
                    if (rows.length > 0) {
                        if (Replace.this.uiPrincipal.jButtonReplace.getText().contains("COPIAR")) {
                            cancel = Save();
                        }
                        if (cancel) {
                            DefaultTableModel defaultTableModel = (DefaultTableModel) Replace.this.uiPrincipal.jTable.getModel();
                            defaultTableModel.setRowCount(0);
                            for (int i = 0; i < getSelectedFiles().size(); i++) {
                                if (
                                        Replace.this.uiPrincipal.jButtonReplace.getText().equals("RENOMBRAR")
                                                && !Replace.this.uiPrincipal.jTextFieldSearch.getText().isEmpty()
                                                && !Replace.this.uiPrincipal.jCheckBoxFolder.isSelected()
                                                && !Replace.this.uiPrincipal.jCheckBoxCopy.isSelected()
                                ) {
                                    File file = Rename.setRenameFile(
                                            getSelectedFiles().get(i),
                                            Replace.this.uiPrincipal.jTextFieldSearch.getText(),
                                            uiPrincipal.jTextFieldReplace.getText()
                                    );
                                    if (file != null) {
                                        defaultTableModel.addRow(new Object[]{file.getName()});
                                    }
                                } else if (
                                        Replace.this.uiPrincipal.jButtonReplace.getText().equals("RENOMBRAR")
                                                && !Replace.this.uiPrincipal.jTextFieldSearch.getText().isEmpty()
                                                && Replace.this.uiPrincipal.jCheckBoxFolder.isSelected()
                                                && !Replace.this.uiPrincipal.jCheckBoxCopy.isSelected()
                                ) {
                                    File file = Rename.setRenameFile(
                                            getSelectedFiles().get(i),
                                            Replace.this.uiPrincipal.jTextFieldSearch.getText(),
                                            Replace.this.uiPrincipal.jTextFieldReplace.getText()
                                    );
                                    if (file != null) {
                                        defaultTableModel.addRow(new Object[]{file.getName()});
                                    }
                                } else if (
                                        Replace.this.uiPrincipal.jCheckBoxCopy.isSelected()
                                                && Replace.this.uiPrincipal.jButtonReplace.getText().equals("COPIAR")
                                                && Replace.this.uiPrincipal.jTextFieldSearch.getText().isEmpty()
                                ) {
                                    File file = Rename.setCopyFile(
                                            getSelectedFiles().get(i).getAbsolutePath(),
                                            getFinalPath() + separator + getSelectedFiles().get(i).getName(),
                                            false
                                    );
                                    if (file != null) {
                                        defaultTableModel.addRow(new Object[]{file.getName()});
                                    }
                                } else if (
                                        Replace.this.uiPrincipal.jCheckBoxCopy.isSelected()
                                                && Replace.this.uiPrincipal.jButtonReplace.getText().equals("<HTML><CENTER>COPIAR<BR>RENOMBRAR</CENTER></HTML>")
                                                && !Replace.this.uiPrincipal.jTextFieldSearch.getText().isEmpty()
                                ) {
                                    Rename.setCopyFile(
                                            getSelectedFiles().get(i).getAbsolutePath(),
                                            getFinalPath() + separator + getSelectedFiles().get(i).getName(),
                                            true
                                    );
                                    File file = Rename.setRenameFile(
                                            new File(getFinalPath() + separator + getSelectedFiles().get(i).getName() + ".fil"),
                                            Replace.this.uiPrincipal.jTextFieldSearch.getText(),
                                            Replace.this.uiPrincipal.jTextFieldReplace.getText()
                                    );
                                    if (file != null) {
                                        defaultTableModel.addRow(new Object[]{file.getName()});
                                    }
                                }
                            }
                            if (defaultTableModel.getRowCount() > 0 || Replace.this.uiPrincipal.jButtonReplace.getText().contains("COPIAR")) {
                                JOptionPane.showMessageDialog(Replace.this.uiPrincipal, "LISTO");
                                System.out.println("LISTO");
                            } else {
                                JOptionPane.showMessageDialog(Replace.this.uiPrincipal, "NO RENOMBRADO(S)", "ERROR", JOptionPane.ERROR_MESSAGE);
                                System.out.println("NO RENOMBRADO(S)");
                            }
                        }
                        //****************************************
                        Replace.this.uiPrincipal.jCheckBoxFolder.setSelected(false);
                        Replace.this.uiPrincipal.jCheckBoxCopy.setSelected(false);
                        Replace.this.uiPrincipal.jTextFieldSearch.setText("");
                        Replace.this.uiPrincipal.jTextFieldReplace.setText("");
                        Replace.this.uiPrincipal.jButtonReplace.setText("RENOMBRAR");
                        Replace.this.uiPrincipal.jTable.clearSelection();
                        //****************************************
                    } else {
                        JOptionPane.showMessageDialog(Replace.this.uiPrincipal, "SELECCIONA AL MENOS UNA OPCIÓN PARA RENOMBRAR");
                        System.out.println("SELECCIONA AL MENOS UNA OPCIÓN PARA RENOMBRAR");
                    }
                } else {
                    System.out.println("SELECCIONASTE LA OPCIÓN NO");
                }
            }
        });

        this.uiPrincipal.jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int[] rows = Replace.this.uiPrincipal.jTable.getSelectedRows();
                String separator = FileSystems.getDefault().getSeparator();
                ArrayList<File> selectedFiles = new ArrayList<>();
                for (int i = 0; i < Replace.this.uiPrincipal.jTable.getRowCount(); i++) {
                    for (int fila : rows) {
                        if (Replace.this.uiPrincipal.jTable.getValueAt(fila, 0).equals(Replace.this.uiPrincipal.jTable.getValueAt(i, 0))) {
                            selectedFiles.add(new File(getListFiles().get(i).getParentFile() + separator + Replace.this.uiPrincipal.jTable.getValueAt(i, 0)));
                        }
                    }
                }
                setSelectedFiles(selectedFiles);
            }
        });

        this.uiPrincipal.jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int[] filas = Replace.this.uiPrincipal.jTable.getSelectedRows();
                String separador = FileSystems.getDefault().getSeparator();
                ArrayList<File> fileSelect = new ArrayList<>();
                for (int i = 0; i < Replace.this.uiPrincipal.jTable.getRowCount(); i++) {
                    for (int fila : filas) {
                        if (Replace.this.uiPrincipal.jTable.getValueAt(fila, 0).equals(Replace.this.uiPrincipal.jTable.getValueAt(i, 0))) {
                            fileSelect.add(new File(getListFiles().get(i).getParentFile() + separador + Replace.this.uiPrincipal.jTable.getValueAt(i, 0)));
                        }
                    }
                }
                setSelectedFiles(fileSelect);
            }
        });

        this.uiPrincipal.jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (Replace.this.uiPrincipal.jCheckBoxCopy.isSelected() && (!Replace.this.uiPrincipal.jTextFieldSearch.getText().isEmpty())) {
                    Replace.this.uiPrincipal.jButtonReplace.setText("<HTML><CENTER>COPIAR<BR>RENOMBRAR</CENTER></HTML>");
                } else if (Replace.this.uiPrincipal.jCheckBoxCopy.isSelected() && (uiPrincipal.jTextFieldSearch.getText().isEmpty())) {
                    Replace.this.uiPrincipal.jButtonReplace.setText("COPIAR");
                }
            }
        });

        this.uiPrincipal.jCheckBoxCopy.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Replace.this.uiPrincipal.jCheckBoxFolder.setSelected(false);
                if (Replace.this.uiPrincipal.jCheckBoxCopy.isSelected() && Replace.this.uiPrincipal.jTextFieldSearch.getText().isEmpty()) {
                    Replace.this.uiPrincipal.jButtonReplace.setText("COPIAR");
                } else if (Replace.this.uiPrincipal.jCheckBoxCopy.isSelected() && !Replace.this.uiPrincipal.jTextFieldSearch.getText().isEmpty()) {
                    Replace.this.uiPrincipal.jButtonReplace.setText("<HTML><CENTER>COPIAR<BR>RENOMBRAR</CENTER></HTML>");
                } else if (!Replace.this.uiPrincipal.jCheckBoxCopy.isSelected()) {
                    Replace.this.uiPrincipal.jButtonReplace.setText("RENOMBRAR");
                }
            }
        });

        this.uiPrincipal.jCheckBoxFolder.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Replace.this.uiPrincipal.jCheckBoxCopy.setSelected(false);
                if (Replace.this.uiPrincipal.jCheckBoxFolder.isSelected()) {
                    Replace.this.uiPrincipal.jButtonReplace.setText("RENOMBRAR");
                }
            }
        });
    }

    private boolean Save() {
        boolean canceled = true;
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = jFileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            setFinalPath(jFileChooser.getSelectedFile().getAbsolutePath());
        } else {
            System.out.println("SELECCIONASTE CANCELAR");
            canceled = false;
        }
        return canceled;
    }

    private void searchFile(JFileChooser jFileChooser, DefaultTableModel defaultTableModel) {
        File[] files = jFileChooser.getSelectedFiles();
        ArrayList<File> fileList = new ArrayList<>();
        if (files != null && files.length > 0) {
            Arrays.sort(files);
            for (File file : files) {
                String path = file.toString();
                fileList.add(new File(path));
                defaultTableModel.addRow(new Object[]{file.getName()});
            }
            setListFiles(fileList);
        }
    }

    private void searchFiles(JFileChooser jFileChooser, DefaultTableModel defaultTableModel) {
        ArrayList<File> fileList = new ArrayList<>();
        String separator = FileSystems.getDefault().getSeparator();
        String initialPath = jFileChooser.getSelectedFile().getAbsolutePath();
        File folderFile = new File(initialPath);
        File[] filesFolder = folderFile.listFiles();
        if (filesFolder != null && filesFolder.length > 0) {
            Arrays.sort(filesFolder);
            for (File file : filesFolder) {
                String path = initialPath + separator + file.getName();
                fileList.add(new File(path));
                defaultTableModel.addRow(new Object[]{file.getName()});
            }
            setListFiles(fileList);
        }
    }

    private void searchFolders(JFileChooser jFileChooser, DefaultTableModel defaultTableModel) {
        ArrayList<File> folderList = new ArrayList<>();
        File[] folders = jFileChooser.getSelectedFiles();
        if (folders != null && folders.length > 0) {
            Arrays.sort(folders);
            for (File folder : folders) {
                for (File file : Objects.requireNonNull(folder.listFiles())) {
                    if (file.isDirectory()) {
                        String path = file.toString();
                        folderList.add(new File(path));
                        defaultTableModel.addRow(new Object[]{file.getName()});
                    }
                }
            }
        }
        setListFiles(folderList);
    }

    private void setListFiles(ArrayList<File> files) {
        this.files = files;
    }

    private ArrayList<File> getListFiles() {
        return this.files;
    }

    private void setSelectedFiles(ArrayList<File> selectedFiles) {
        this.selectedFiles = selectedFiles;
    }

    private ArrayList<File> getSelectedFiles() {
        return this.selectedFiles;
    }

    private void setFinalPath(String finalPath) {
        this.finalPath = finalPath;
    }

    private String getFinalPath() {
        return this.finalPath;
    }
}