package com.hybris.training.facades.customItemtype.populators;

import com.hybris.training.core.model.CustomItemtypeModel;
import com.hybris.training.facades.user.data.CustomItemTypeData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class CustomItemTypePopulator implements Populator<CustomItemtypeModel, CustomItemTypeData> {

    @Override
    public void populate(CustomItemtypeModel customItemtypeModel, CustomItemTypeData customItemTypeData) throws ConversionException {
        customItemTypeData.setUid(customItemtypeModel.getUid());
        customItemTypeData.setName(customItemtypeModel.getName());
        customItemTypeData.setAddressString(customItemtypeModel.getAddressString());
    }
}
