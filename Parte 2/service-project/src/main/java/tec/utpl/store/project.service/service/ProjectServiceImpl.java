package tec.utpl.project.store.serviceproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.utpl.project.service.projects.entity.Category;
import tec.utpl.project.service.projects.entity.Project;
import tec.utpl.project.service.projects.repository.ProjectRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> listAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        project.setStatus("CREATED");
        project.setCreateAt(new Date());

        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        Project project1DB = getProject(project.getId());

        if (null == project1DB){
            return null;
        }
        project1DB.setName(project.getName());
        project1DB.setDescription(project.getDescription());
        project1DB.setCategory(project.getCategory());
        project1DB.setCost(project.getCost());
        return projectRepository.save(project1DB);
    }
    @Override
    public Project deleteProject(Long id) {
        Project project1DB = getProject(id);

        if (null == project1DB){
            return null;
        }

        projectRepository.delete(project1DB);
        return project1DB;
    }
    @Override
    public List<Project> findByCategory(Category category) {
        return projectRepository.findByCategory(category);
    }

    @Override
    public Project updatenumproject(Long id, Double quantity) {
        Project project1DB = getProject(id);

        if (null == project1DB){
            return null;
        }
        Double numproject = project1DB.getNumproject() + quantity;
        project1DB.setNumproject(numproject);
        return projectRepository.save(project1DB);
    }
}