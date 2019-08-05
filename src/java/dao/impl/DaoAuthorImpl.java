/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoAuthor;
import db.ConnectDB;
import dto.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author carlr
 */
public class DaoAuthorImpl implements DaoAuthor{
    private final ConnectDB db;
    private final StringBuilder sql;

    public DaoAuthorImpl() {
        this.db = new ConnectDB();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Author> getAuthors() {
        this.sql.delete(0, this.sql.length())
                .append("SELECT * FROM t_author");
        
        try (Connection cn = this.db.getConnection();
                PreparedStatement ps = cn.prepareCall(this.sql.toString());
                ResultSet rs = ps.executeQuery()
                ) {
            List<Author> authors = new LinkedList<>();
            while(rs.next()){
                Author author = new Author();
                author.setId(rs.getInt("in_id"));
                author.setName(rs.getString("vc_name"));
                author.setSurname(rs.getString("vc_surname"));
                authors.add(author);                        
            }
            return authors;
        } catch (Exception e) {
            return null;
        }
    }
    
}
