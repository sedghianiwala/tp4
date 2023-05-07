package metier.entité;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;



public class contactdao {    private DataSource dataSource;

public contactdao(DataSource dataSource) {
    this.dataSource = dataSource;
}

// Create
public void addContact(contact contact) throws SQLException {
    String sql = "INSERT INTO contacts (id,nom, prenom, email) VALUES (?, ?, ?,?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
    	 ps.setLong(1, contact.getId());
     ps.setString(2, contact.getNom());
        ps.setString(3, contact.getPrenom());
        ps.setString(4, contact.getEmail());
        ps.executeUpdate();
    }
}

// Read
public List<contact> getAllContacts() throws SQLException {

    String sql = "SELECT * FROM contacts";
    Object contacts;
	try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                contact contact = new contact();
                contact.setId(rs.getLong("id"));
                contact.setNom(rs.getString("nom"));
                contact.setPrenom(rs.getString("prenom"));
                contact.setEmail(rs.getString("email"));
             contact.add();
            }
        }
    }
    return (List<contact>) contacts;
}

// Update
public void updateContact(contact contact) throws SQLException {
    String sql = "UPDATE contacts SET numero=?, prenom=?, email=? WHERE id=?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
       
        ps.setString(2, contact.getPrenom());
        ps.setString(3, contact.getEmail());
        ps.setLong(4, ((metier.entité.contact) contact).getId());
        ps.executeUpdate();
    }
}

// Delete
public void deleteContact(int id) throws SQLException {
    String sql = "DELETE FROM contacts WHERE id=?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    }

}}