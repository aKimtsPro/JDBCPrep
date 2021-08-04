package bstorm.akimts.java;

import bstorm.akimts.java.data_access.SectionDAO;
import bstorm.akimts.java.models.Section;

public class Program {

    public static void main(String[] args) {

        SectionDAO dao = new SectionDAO();

        System.out.println("--- GET ONE ---");
        Section s = dao.get(1L);
        showSection(s);

        System.out.println("--- GET ALL ---");
        dao.getAll().forEach(Program::showSection);

        System.out.println("--- DELETE ---");


    }

    public static void showSection(Section s){
        System.out.println("-- SECTION --");
        System.out.println("\tid: " + s.getId());
        System.out.println("\tname: " + s.getName());
        System.out.println("\tdelegate: " + s.getDelegateId());
    }
}
