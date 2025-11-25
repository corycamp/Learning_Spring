package com.practice.JobApp.repo;

import com.practice.JobApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

//    public List<JobPost> getAllJobs(){return jobs;}
//
//    public void addJob(JobPost job){
//        jobs.add(job);
//    }
//
//    public JobPost getJob(int jobId) {
//        for(JobPost job : jobs){
//            if(job.getPostId() == jobId) {
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost jobPost) {
//
//        for(JobPost jobPost1 : jobs){
//            if(jobPost1.getPostId() == jobPost.getPostId()){
//                jobPost1.setPostId(jobPost.getPostId());
//                jobPost1.setPostProfile(jobPost.getPostProfile());
//            }
//        }
//    }
//
//    public void deleteJob(int id){
//        for(JobPost job : jobs){
//            if(job.getPostId() == id){
//                jobs.remove(job);
//            }
//
//        }
//    }

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}
