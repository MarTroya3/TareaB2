package tec.utpl.project.service.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tec.utpl.project.service.projects.entity.Category;
import tec.utpl.project.service.projects.entity.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    public List<Project> findByCategory(Category category);
}