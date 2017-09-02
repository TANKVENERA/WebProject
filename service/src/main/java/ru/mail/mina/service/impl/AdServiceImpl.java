package ru.mail.mina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.mail.mina.repository.dao.AdGenericHibernateDao;
import ru.mail.mina.repository.dao.UserGenericHibernateDao;
import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.repository.model.AdEntity;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.dto.AdService;
import ru.mail.mina.service.model.AdDTO;
import ru.mail.mina.service.model.AppUserPrincipal;
import ru.mail.mina.service.util.AdConverter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 16.08.2017.
 */
@Service
public class AdServiceImpl implements AdService {


    private final AdGenericHibernateDao adGenericHibernateDao;
    private final UserGenericHibernateDao userGenericHibernateDao;
    private Environment environment;

    @Autowired
    public AdServiceImpl(AdGenericHibernateDao adGenericHibernateDao, UserGenericHibernateDao userGenericHibernateDao,
                         Environment environment) {
        this.adGenericHibernateDao = adGenericHibernateDao;
        this.userGenericHibernateDao = userGenericHibernateDao;
        this.environment = environment;
    }

    @Override
    @Transactional
    public List<AdDTO> filterAd(String model, String mark, String yearFrom, String yearTo,
                                String priceFrom, String priceTo) {
        List<AdDTO> adDTOList = new ArrayList<>();
        List<Ad> list = adGenericHibernateDao.filter(model, mark, yearFrom, yearTo, priceFrom, priceTo);
        for (Ad element : list) {
            AdDTO adDTO = AdConverter.convert(element);
            adDTOList.add(adDTO);
        }
        return adDTOList;
    }

    @Override
    @Transactional
    public void updateAd(AdDTO adDTO) throws IOException{
        Ad ad = AdConverter.convert(adDTO);
        User user = getUser();
        try {
            ad.setUser(user);
            ad.getAdEntities().add(getAdsEntity(adDTO));
            ad.setDate(getById(adDTO.getId()).getDate());
            adGenericHibernateDao.update(ad);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public List<AdDTO> findAll() {
        List<AdDTO> adDTOList = new ArrayList<>();
        List<Ad> list = adGenericHibernateDao.findAll();
        for (Ad element : list) {
            AdDTO adDTO = AdConverter.convert(element);
            adDTOList.add(adDTO);
        }
        return adDTOList;
    }

    @Override
    @Transactional
    public void saveAd(AdDTO adDTO) throws  IOException{
        Ad ad = AdConverter.convert(adDTO);
        AppUserPrincipal principal = (AppUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userGenericHibernateDao.findById(principal.getUserId());
        AdEntity adEntity = getAdsEntity(adDTO);
        ad.getAdEntities().add(adEntity);
        ad.setUser(user);
        user.getAds().add(ad);
        userGenericHibernateDao.update(user);
    }

    @Override
    @Transactional
    public List<AdDTO> getAdsByUser() {
        List<AdDTO> adDTOList = new ArrayList<>();
        List<Ad> list = getUser().getAds();
        for (Ad element : list) {
            AdDTO adDTO = AdConverter.convert(element);
            adDTOList.add(adDTO);
        }
        return adDTOList;
    }


    @Override
    @Transactional
    public void deleteAd(Integer id) {
        adGenericHibernateDao.delete(id);
    }

    private User getUser() {
        AppUserPrincipal principal = (AppUserPrincipal) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userGenericHibernateDao.findById(principal.getUserId());
    }

    @Override
    @Transactional
    public AdDTO getById(Integer id) {
       Ad ad = adGenericHibernateDao.findById(id);
       AdDTO adDTO = AdConverter.convert(ad);
        return adDTO;
    }

    @Override
    @Transactional
    public List<AdDTO> getAdsByUserName(String userName) {
        List<AdDTO> adDTOList = new ArrayList<>();
        List<Ad> list = adGenericHibernateDao.getAdsByUserName(userName);
        for (Ad element : list) {
            AdDTO adDTO = AdConverter.convert(element);
            adDTOList.add(adDTO);
        }
        return adDTOList;
    }

    @Override
    @Transactional
    public List<AdDTO> getAll(Integer page) {
        List<AdDTO> adDTOList = new ArrayList<>();
        List<Ad> list = adGenericHibernateDao.getAll(page);
        for (Ad element : list) {
            AdDTO adDTO = AdConverter.convert(element);
            adDTOList.add(adDTO);
        }
        return adDTOList;
    }

    private AdEntity getAdsEntity(AdDTO adDTO) throws IOException {
        Integer id = adDTO.getId();
        String date = adDTO.getDate();
        MultipartFile multipartFile = adDTO.getFile();
        String finalPath;
        String fileName = date == null ? getById(id).getDate() : date;
        String fileLocation = environment.getProperty("upload.adsLocation") + fileName + "\\";
        File file = new File(fileLocation);
        if (!file.exists()) {
            AdEntity adEntity = new AdEntity();
            file.mkdirs();
            finalPath = fileLocation + fileName;
            FileCopyUtils.copy(multipartFile.getBytes(), new File(finalPath)); // из переменной MultiPartFile file извлекается картинка
            adEntity.setFilePath(fileLocation);
            adEntity.setFileName(fileName);
            return adEntity;
        } else {
            AdEntity adEntity = getById(id).getAdEntities().get(0);
            if (!multipartFile.isEmpty()) {
                String newFileName = new SimpleDateFormat("dd-MM-yyyy HH-mm").format(new Date());
                finalPath = fileLocation + newFileName;
                FileCopyUtils.copy(multipartFile.getBytes(), new File(finalPath));
                adEntity.setFileName(newFileName);
            }
            return adEntity;
        }
    }
}
