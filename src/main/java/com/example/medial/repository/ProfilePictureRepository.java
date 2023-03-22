package com.example.medial.repository;

import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.ProfilePicture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfilePictureRepository extends CrudRepository<ProfilePicture, Long> {



}
