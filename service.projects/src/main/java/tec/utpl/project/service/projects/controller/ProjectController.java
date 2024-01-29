package tec.utpl.project.service.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.project.service.projects.entity.Category;
import tec.utpl.project.service.projects.entity.Project;
import tec.utpl.project.service.projects.service.ProjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> listProject(@RequestParam(name="categoryId", required = false) Long categoryId){
        List<Project> projects = new ArrayList<>();
        if (null  == categoryId){
            projects = projectService.listAllProjects();
        }else {
            projects = projectService.findByCategory(Category.builder().id(categoryId).build());
        }

        if(projects.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok (projects);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") Long id){
        Project project = projectService.getProject(id);
        if (null == project){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(project);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        Project project1Create = projectService.createProject(project);

        return ResponseEntity.status(HttpStatus.CREATED).body(project1Create);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long id,  @RequestBody Project project){
        project.setId(id);

        Project project1DB = projectService.updateProject(project);

        if (project1DB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(project1DB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long id){
        Project projectDelete = projectService.deleteProject(id);

        if(projectDelete!=null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Proyecto eliminado");
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Project> updateNumProject(@PathVariable("id") Long id,@RequestBody Map<String, Double> requestBody){
        if (!requestBody.containsKey("quantity")) {
            return ResponseEntity.badRequest().build();
        }

        Double quantity = requestBody.get("quantity");

        Project project = projectService.updatenumproject(id, quantity);

        if (project==null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(project);
    }
}