package com.hybris.training.core.service.custom;

import com.hybris.training.core.customItemType.dao.impl.CustomItemTypeDao;
import com.hybris.training.core.model.CustomItemtypeModel;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class CustomItemTypeService {

    @Autowired
    private CustomItemTypeDao customItemTypeDao;
    @Autowired
    private ModelService modelService;
    
    public List<CustomItemtypeModel> getAllRecds(){
        List<CustomItemtypeModel> allRecds = customItemTypeDao.getAllRecds();
        return allRecds;
    }
}
