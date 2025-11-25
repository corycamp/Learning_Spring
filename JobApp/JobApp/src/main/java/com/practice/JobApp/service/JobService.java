package com.practice.JobApp.service;

import com.practice.JobApp.model.JobPost;
import com.practice.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {repo.save(jobPost);}

    public List<JobPost> getAllJobs(){return repo.findAll();}

    public JobPost getJob(int jobId) {
        return repo.findById(jobId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }

    public void load(){
            List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                    new JobPost(3, "Test","test",3,new ArrayList<>(Arrays.asList("Test"))),
                    new JobPost(4, "Test","test",4,new ArrayList<>(Arrays.asList("Test")))));
        repo.saveAll(jobs);
    }

    public List<JobPost> findByKeyword(String keyword){
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}