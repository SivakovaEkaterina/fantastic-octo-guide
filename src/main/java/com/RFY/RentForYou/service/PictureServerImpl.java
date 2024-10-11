package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.PictureModel;
import com.RFY.RentForYou.models.RoleModel;
import com.RFY.RentForYou.repository.RoleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.PictureRepository;

import java.util.List;

@Service
public class PictureServerImpl implements PictureServer {
    private final PictureRepository pictureRepository;

    public PictureServerImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<PictureModel> findAllPicture(){
        return pictureRepository.findAll(Sort.by("id"));
    }
}
