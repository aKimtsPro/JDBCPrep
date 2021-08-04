package bstorm.akimts.java.data_access;

import bstorm.akimts.java.models.Section;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO implements DAO<Section, Long> {

    @Override
    public Section get(Long aLong) {
        try(
            Connection co = ConnectionFactory.getConnection();
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM section");
        ){
            if(rs.next())
                return extractFromResult(rs);
            return null;
        }
        catch (SQLException ex){
            throw new RuntimeException("couldnt get : " + ex.getMessage());
        }
    }

    @Override
    public List<Section> getAll() {
        try(
            Connection co = ConnectionFactory.getConnection();
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM section");
        ){
            List<Section> list = new ArrayList<>();
            while (rs.next())
                list.add( extractFromResult(rs) );
            return list;
        }
        catch (SQLException ex){
            throw new RuntimeException("couldnt getAll : " + ex.getMessage());
        }
    }

    @Override
    public boolean insert(Section toInsert) {
        try(Connection co = ConnectionFactory.getConnection()){
            Statement stmt = co.createStatement();
            return 1 <= stmt.executeUpdate("INSERT INTO section " +
                    "VALUES " +
                    "("+toInsert.getId()+", "+toInsert.getName()+","+toInsert.getDelegateId()+")");
        }
        catch (SQLException ex){
            throw new RuntimeException("couldnt get : " + ex.getMessage());
        }
    }

    @Override
    public void update(Long aLong, Section toInsert) {

    }

    @Override
    public void delete(Long aLong) {

    }

    private Section extractFromResult(ResultSet rs) throws SQLException {
        Section section = new Section();
        section.setName( rs.getString("section_name") );
        section.setId( rs.getLong("section_id") );
        section.setDelegateId( rs.getLong("delegate_id") );
        return section;
    }
}
