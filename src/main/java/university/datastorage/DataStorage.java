package university.datastorage;

import lombok.Getter;
import lombok.Setter;
import university.domain.model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DataStorage implements Serializable {
    public List<Admin> admins;
    public List<Employee> employees;
    public List<Teacher> teachers;
    public List<Student> students;
    public List<Manager> managers;
    public List<News> news;
    public List<Course> courses;
    public List<Journal> journals;
    public List<ResearchPaper> researchPapers;
    public List<ResearchProject> researchProjects;


    private static DataStorage instance;

    private DataStorage() {

        List<News> news = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Journal> journals = new ArrayList<>();
        List<ResearchPaper> researchPapers = new ArrayList<>();
        List<ResearchProject> researchProjects = new ArrayList<>();
    }

    public static DataStorage getInstance() {
        if (instance == null) return new DataStorage();
        return instance;
    }

}
