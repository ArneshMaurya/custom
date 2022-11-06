package com.hybris.training.facades.customItemtype;

import com.hybris.training.core.model.CustomItemtypeModel;
import com.hybris.training.core.service.custom.CustomItemTypeService;
import com.hybris.training.facades.user.data.CustomItemTypeData;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomItemTypeFacade {

    @Autowired
    CustomItemTypeService customItemTypeService;

    private Converter<CustomItemtypeModel, CustomItemTypeData> customItemTypeConverter;

    public Converter<CustomItemtypeModel, CustomItemTypeData> getMyCustomItemType()
    {
        return customItemTypeConverter;
    }

    public void setMyCustomItemType(final Converter<CustomItemtypeModel, CustomItemTypeData> customItemTypeConverter)
    {
        this.customItemTypeConverter = customItemTypeConverter;
    }

    public List<CustomItemTypeData> getAllRecds(){
       List<CustomItemtypeModel> customItemtypeModels = customItemTypeService.getAllRecds();
       List<CustomItemTypeData> customItemTypeDatas = new ArrayList<CustomItemTypeData>();
        //customItemTypeDatas = getMyCustomItemType().convertAll(customItemtypeModels);
        return Converters.convertAll(customItemtypeModels, getMyCustomItemType());
    }
}
