package Vistas;

import Controlador.EnumDepartamento;
import Controlador.EnumTipoCalle;
import Controlador.EnumZona;
import Modelo.Conexion;
import Modelo.TipoDocumentoEnum;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserMenu extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados, contenidoTablaDepartamento;
    ComboBoxModel enumDepartamentos, enumZonas, enumTipoCalles;

    public UserMenu() {
        enumDepartamentos = new DefaultComboBoxModel(EnumDepartamento.values());
        enumZonas = new DefaultComboBoxModel(EnumZona.values());
        enumTipoCalles = new DefaultComboBoxModel(EnumTipoCalle.values());

        initComponents();
        setLocationRelativeTo(null);
        listarEmpleados();
        listarDepartamentos();
    }

    private void listarEmpleados() {

        String nombre = jTextField1.getText();
        if (nombre.isEmpty()) {

            String queryConsulta = "SELECT * FROM empleado";
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryConsulta);
                Object[] empleados = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
                while (rs.next()) {
                    empleados[0] = rs.getInt("idEmp");
                    empleados[1] = rs.getString("nombreEmp");
                    empleados[2] = rs.getString("apellidos");
                    empleados[3] = rs.getString("tipoDocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correo");
                    contenidoTablaEmpleados.addRow(empleados);
                    System.out.println("id: "
                            + empleados[0] + " nombre: "
                            + empleados[1] + " tipoDocumento "
                            + empleados[2] + " Documento: "
                            + empleados[3] + " correo "
                            + empleados[4]);
                    tblEmpleados.setModel(contenidoTablaEmpleados);
                }
            } catch (SQLException e) {
                System.out.println("Error");
            }
        } else {
            String query = "SELECT * FROM empleado WHERE nombreEmp LIKE '%" + nombre + "%' OR apellidos LIKE '%" + nombre + "%';";
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Object[] empleados = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
                while (rs.next()) {
                    empleados[0] = rs.getInt("idEmp");
                    empleados[1] = rs.getString("nombreEmp");
                    empleados[2] = rs.getString("apellidos");
                    empleados[3] = rs.getString("tipoDocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correo");
                    contenidoTablaEmpleados.addRow(empleados);
                    System.out.println("id: "
                            + empleados[0] + " nombre: "
                            + empleados[1] + " tipoDocumento "
                            + empleados[2] + " Documento: "
                            + empleados[3] + " correo "
                            + empleados[4]);
                    tblEmpleados.setModel(contenidoTablaEmpleados);
                }
            } catch (SQLException e) {
                System.out.println("Error");
            }
        }

    }

    private void borrarDatosTabla() {
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            contenidoTablaEmpleados.removeRow(i);
            i -= 1;
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbDepartament = new javax.swing.JComboBox<>();
        cbZona = new javax.swing.JComboBox<>();
        cbCalle = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumero1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNumero2 = new javax.swing.JTextField();
        txtNumero3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        txtNumero4 = new javax.swing.JTextField();
        btnAddEmpleado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        cbDepartament.setModel(enumDepartamentos);

        cbZona.setModel(enumZonas);

        cbCalle.setModel(enumTipoCalles);

        jLabel3.setText("Departamento");

        jLabel4.setText("Zona");

        jLabel5.setText("Tipo Calle");

        jLabel6.setText("#");

        txtNumero3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumero3ActionPerformed(evt);
            }
        });

        jLabel7.setText("-");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/confirmIcon.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(413, 413, 413))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbDepartament, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDepartament, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sucursal", "Departamento"
            }
        ));
        jScrollPane2.setViewportView(tblDepartamentos);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnListar.setText("Ver sucursales");

        btnAddEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img2.png"))); // NOI18N
        btnAddEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtNumero4, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAddEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnAddEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumero4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("", jPanel3);

        jTabbedPane1.addTab("Sucursales", jTabbedPane2);
        jTabbedPane2.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Tipo documento", "CorrDocumentoeo", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img2.png"))); // NOI18N
        btnAddUser.setText("Crear empelado");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        jButton2.setText("Consultar");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMACIÓN EMPLEADOS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed

        AddUserForm addUserF = new AddUserForm(this, rootPaneCheckingEnabled);
        addUserF.setVisible(rootPaneCheckingEnabled);
        borrarDatosTabla();
        listarEmpleados();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int row = tblEmpleados.getSelectedRow();
        System.out.println(row);
        System.out.println("Fila Seleccionada" + row);
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado.", "", JOptionPane.WARNING_MESSAGE);
        } else {
            int id = Integer.parseInt(tblEmpleados.getValueAt(row, 0).toString());
            String nombre = (String) tblEmpleados.getValueAt(row, 1);
            String apellidos = (String) tblEmpleados.getValueAt(row, 2);
            String tipoDocumento = (String) tblEmpleados.getValueAt(row, 3);
            String documento = (String) tblEmpleados.getValueAt(row, 4);
            String correo = (String) tblEmpleados.getValueAt(row, 5);
            System.out.println("Id:" + id + ", empleado: " + nombre + "" + apellidos
                    + ", tipo documento: " + tipoDocumento + ", numero: " + documento + ", correo: " + correo);
            ShowUserForm showUserForm = new ShowUserForm(this, true);
            showUserForm.recibeDatos(id, nombre, apellidos, documento, tipoDocumento, correo);
            showUserForm.setVisible(true);
            borrarDatosTabla();
            listarEmpleados();
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String departamentoOption = cbDepartament.getSelectedItem().toString();
        String zonaOption = cbZona.getSelectedItem().toString();
        String tipoCalleOption = cbCalle.getSelectedItem().toString();
        String numero1 = txtNumero1.getText();
        String numero2 = txtNumero1.getText();
        String numero3 = txtNumero1.getText();
        String queryDireccion = "INSERT INTO `direccion`( `zona`, `tipoCalle`, `numero1`,"
        + " `numero2`, `numero3`, `nombreDepartamento`) VALUES ('" + zonaOption + "',"
        + "'" + tipoCalleOption + "','" + numero1 + "','" + numero2 + "',"
        + "'" + numero3 + "','" + departamentoOption + "');";
        try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            st.executeUpdate(queryDireccion);
            System.out.println(queryDireccion);
            SucursalForm sucurlasForm = new SucursalForm(this, true);
            sucurlasForm.setVisible(true);
            String queryIdDireccion = "SELECT  idDireccion FROM `direccion` WHERE nombreDepartamento = '" + departamentoOption + "' AND zona = '" + zonaOption + "' AND tipoCalle ='"
            + tipoCalleOption + "' AND numero1='" + numero1 + "' AND numero2='" + numero2 + "' AND numero3='" + numero3 +  "';";
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryIdDireccion);
                int idDireccion;

                while (rs.next()) {
                    int direccion =rs.getInt("idDireccion");
                    sucurlasForm.recibeDatosDireccion(direccion);
                }
                borrarDatosTablasDepartamentos();
                listarDepartamentos();
            } catch (SQLException e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(this, "Sucursal creada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "no se pudo crear la sucursal", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNumero3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumero3ActionPerformed

    }//GEN-LAST:event_txtNumero3ActionPerformed

    private void btnAddEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmpleadoActionPerformed
        int nroFila =tblDepartamentos.getSelectedRow();
        if (nroFila != -1) {
            String sucursal = tblDepartamentos.getValueAt(nroFila, 0).toString();
            String departamento = tblDepartamentos.getValueAt(nroFila, 1).toString();
            System.out.println("Sucursal: "+sucursal+", departamento: "+departamento);
            String query ="SELECT idSucursal FROM `sucursal` WHERE nombreSucursal = '" + sucursal + "';";
            System.out.println(query);
            
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
                EmpleadosLista empLista = new EmpleadosLista(this,true);
                empLista.setVisible(true);
                while (rs.next()) {
                    int idSucursal =rs.getInt("idSucurlas");
                    empLista.recibirIdSucursal(idSucursal);
                }
                
            } catch (SQLException e) {
                System.out.println(e);
            }
            
            
        }else{
        JOptionPane.showMessageDialog(this, "Para añadir un empleado debes de seleccionar una sucursal a la cual pertenece","", JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_btnAddEmpleadoActionPerformed

    public void listarDepartamentos() {
        String query = "SELECT nombreSucursal, nombreDepartamento FROM sucursal INNER JOIN direccion ON FK_idDireccion = idDireccion GROUP BY nombreDepartamento, nombreSucursal ORDER BY nombreDepartamento;";
        System.out.println("Entro al método de listarDepartamentos");
        try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Object[] departamento = new Object[2];
            contenidoTablaDepartamento = (DefaultTableModel) tblDepartamentos.getModel();
            while (rs.next()) {
                departamento[0] = rs.getString("sucursal.nombreSucursal");
                departamento[1] = rs.getString("direccion.nombreDepartamento");
                System.out.println("sucursal: " + departamento[0] + ", departamentos: " + departamento[1]);
                contenidoTablaDepartamento.addRow(departamento);
                tblDepartamentos.setModel(contenidoTablaDepartamento);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void borrarDatosTablasDepartamentos() {
        for (int i = 0; i < tblDepartamentos.getRowCount(); i++) {
            contenidoTablaDepartamento.removeRow(i);
            i = i - 1;
        }

    }

 
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmpleado;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<String> cbCalle;
    private javax.swing.JComboBox<String> cbDepartament;
    private javax.swing.JComboBox<String> cbZona;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtNumero1;
    private javax.swing.JTextField txtNumero2;
    private javax.swing.JTextField txtNumero3;
    private javax.swing.JTextField txtNumero4;
    // End of variables declaration//GEN-END:variables
}
