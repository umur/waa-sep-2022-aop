package edu.miu.spring.data.service.impl;

import edu.miu.spring.data.entity.Review;
import edu.miu.spring.data.repo.ReviewRepo;
import edu.miu.spring.data.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public void save(Review review) {
    }

    @Override
    public Review getById(int id) {
        return null;
    }

    @Override
    public void update(int id, Review reviewReq) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public List<Review> findAllById(int id) {
        return reviewRepo.findAllById(id);
    }
}
