package com.practice.JobApp;

import com.practice.JobApp.model.JobPost;
import com.practice.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
//Allows it to work with frontend
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobPost jobPost(@PathVariable("id") int id){
        return service.getJob(id);
    }

    @PostMapping("jobPost")
    public void postJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable("id") int id){
        service.deleteJob(id);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        return "success";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.findByKeyword(keyword);
    }

}
