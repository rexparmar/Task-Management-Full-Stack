package com.tm.task_management.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String description;
    private String status;

    public void setId(Long id){
        this.id=id;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getStatus(){
        return status;
    }
}
