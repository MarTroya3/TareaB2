package tec.utpl.store.project.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tec.utpl.store.project.service.entity.Category;
import tec.utpl.store.project.service.entity.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    public List<Project> findByCategory(Category category);
}
