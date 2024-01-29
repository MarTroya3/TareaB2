package tec.utpl.store.serviceproject.service;

import tec.utpl.store.serviceproject.entity.Category;
import tec.utpl.store.serviceproject.entity.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> listAllProjects();
    public Project getProject(Long id);

    public Project createProject(Project project);
    public Project updateProject(Project project);
    public Project deleteProject(Long id);

    public List<Project>  findByCategory(Category category);
    public Project updateStock(Long id, Double quantity);
}
