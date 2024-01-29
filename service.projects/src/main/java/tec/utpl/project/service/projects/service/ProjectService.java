package tec.utpl.project.service.projects.service;

import tec.utpl.project.service.projects.entity.Category;
import tec.utpl.project.service.projects.entity.Project;
import java.util.List;

public interface ProjectService {

    public List<Project> listAllProjects();
    public Project getProject(Long id);

    public Project createProject(Project project);
    public Project updateProject(Project project);
    public Project deleteProject(Long id);

    public List<Project>  findByCategory(Category category);
    public Project updatenumproject(Long id, Double quantity);
}
